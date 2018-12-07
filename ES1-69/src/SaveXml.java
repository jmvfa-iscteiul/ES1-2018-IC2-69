


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileOutputStream;

public class SaveXml {

   public static void main(String argv[]) {

      try {
    	// File input = new File("data.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.newDocument();
         
         // root element
         Element rootElement = doc.createElement("conta");
         doc.appendChild(rootElement);

         // conta element
         Element conta = doc.createElement("utilizador");
         rootElement.appendChild(conta);

         // setting attribute to element
         Attr attr1 = doc.createAttribute("mail");
         attr1.setValue("jmvfa@iscte-iul.pt");
         conta.setAttributeNode(attr1);

         Attr attr2 = doc.createAttribute("password");
         attr2.setValue("1John2Zola1996");
         conta.setAttributeNode(attr2);

         // write the content into xml file
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         
         // Output to console for testing
         StreamResult consoleResult = new StreamResult(System.out);
         transformer.transform(source, consoleResult);
         
         
         System.out.println("\nSave XML document.");
         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
         StreamResult result = new StreamResult(new FileOutputStream("data.xml"));
         transformer.transform(source, result);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}