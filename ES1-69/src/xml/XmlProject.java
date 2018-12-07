package xml;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class XmlProject {

	//File inputFile;
	static File inputFile = new File("config.xml");
	static DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	//static DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	private static Document doc;
	static boolean aux = false;
	static String userN="1";
	//Integer i = Integer.parseInt(userN);
	Integer i = 1;
	
	public static void ligarXml(){
		try {	
			//File inputFile = new File("config.xml");
			File iF = inputFile;
			//DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilderFactory db = dbFactory;
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			//DocumentBuilder dB = dBuilder;
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();         
			System.out.println("\n----- Search the XML document with xpath queries -----");  
			// Query 1 
			//System.out.println("Query 1: ");
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expr = xpath.compile("/XML/Service/@*");
			NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nl.getLength(); i++) {
				System.out.print(nl.item(i).getNodeName()  + ": ");
				System.out.println(nl.item(i).getFirstChild().getNodeValue());
			}
			// Query 2
			//System.out.println("\nQuery 2: ");         
			expr = xpath.compile("/XML/Paths/docPath");
			String str = (String) expr.evaluate(doc, XPathConstants.STRING);

			System.out.println("docPath: " + str);

			// Save XML document
			System.out.println("\nSave XML document.");
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
			DOMSource source = new DOMSource(doc);
			transformer.transform(source, result);
		} catch (Exception e) { e.printStackTrace(); }
	}

	public static void acrescentarUser(String mailA, String passA) {
		ligarXml();
		String mail = mailA;
		String pass = passA;
		
		
		Integer i = Integer.parseInt(userN);
		String a = i.toString();
		
		try {	
		// Adding new element Service with attributes to the XML document (root node)

		System.out.println("\n----- Adding new element <Service> with attributes to the XML document -----");
		
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		
		Document doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize(); 

		Element newElement1 = doc.createElement("Utilizador");
		newElement1.setAttribute("Mail", mail);
		newElement1.setAttribute("Password", pass);

		// Add new nodes to XML document (root element)
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());         
		Node n = doc.getDocumentElement();
		n.appendChild(newElement1);	
		
		// Save XML document
		System.out.println("\nSave XML document.");
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);
	} catch (Exception e) { 
		e.printStackTrace(); 

	}
	
	}
	//lerXml()
	public static void verificaUtilizador(String utilizadorP, String passP) {
	//public static void main(String[] args) {
		
		
		
		String userMail;
//		String userPass;
		
		//String a = "jmvfa@iscte-iul.pt";
		//String b = "1996";
		
		//ligarXml(); 
		
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();   
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Utilizador");
			//NOdeList nList = doc.getElementsByTagName();
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				System.out.println("Current Element :"+ nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element e = (Element)nNode;

					//System.out.println("Mail : " + e.getElementsByTagName("Mail").item(0).getTextContent());
					System.out.println(e.getAttribute("Mail").toString());
					userMail = e.getAttribute("Mail").toString();
					
					
					System.out.println(e.getAttribute("Password"));
//					userPass = e.getAttribute("Password").toString();
					
					System.out.println("");
					//System.out.println("Pass : " + e.getElementsByTagName("Password").item(0).getTextContent());
		
					if(utilizadorP.equals(userMail)) {
						//System.out.println(a + b);
						aux=true;
						//acrescentarUser(utilizadorP, passP);
						break;
						
					}else{
						acrescentarUser(utilizadorP, passP);
						//break;
					}
					
				}
			}
			
//			System.out.println("\nSave XML document.");
//			Transformer transformer = TransformerFactory.newInstance().newTransformer();
//			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//			StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
//			DOMSource source = new DOMSource(doc);
//			transformer.transform(source, result);
			
		} catch (Exception e) {
			e.printStackTrace();
	    }
	}
	

	public void main(String user, String pass) {
		
		String verificarMail = "oii@iscte-iul.pt";
		String verificarPass = "1John2Zola1996";
		ligarXml();
		verificaUtilizador(verificarMail, verificarPass);
		//acrescentarUser(verificarMail, verificarPass);

	}

	public boolean getAux() {
		// TODO Auto-generated method stub
		return false;
	}

}