import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.restfb.Facebook;

import Facebook.searchFacebook;
import Mail.Mail;
import Twitter.searchTwitter;
import twitter4j.Twitter;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Checkbox;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;

public class InterGraf extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextField textField;
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	private searchTwitter twitter;
	private Facebook face;
	private Mail mail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterGraf frame = new InterGraf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterGraf() {
		setBackground(UIManager.getColor("EditorPane.inactiveForeground"));
		setForeground(Color.WHITE);
		setTitle("ISCTE_APP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 627);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBackground(SystemColor.inactiveCaptionBorder);
		scrollbar.setBounds(983, 125, 21, 346);
		contentPane.add(scrollbar);
		
		txtSearch = new JTextField();
		txtSearch.setText("\r\n");
		txtSearch.setBackground(SystemColor.inactiveCaptionBorder);
		txtSearch.setToolTipText("Search");
		txtSearch.setBounds(552, 66, 425, 25);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		textField = new JTextField();
		textField.setToolTipText("Search");
		textField.setText("\r\n");
		textField.setColumns(10);
		textField.setBackground(SystemColor.inactiveCaptionBorder);
		textField.setBounds(552, 506, 425, 25);
		contentPane.add(textField);
		
		ArrayList<JToggleButton> tougle = new ArrayList<>();
		
		JToggleButton twitter = new JToggleButton("Twitter");
		twitter.setBounds(57, 125, 379, 91);
		contentPane.add(twitter);
		twitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(twitter.isSelected()) {
					tougle.add(twitter);
					System.out.println("twitter");
				}
				else{
					tougle.remove(twitter);
				}
			}
		});
		contentPane.add(twitter);
	
		JToggleButton facebook = new JToggleButton("Facebook");
		facebook.setBounds(57, 245, 379, 100);
		facebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(facebook.isSelected()) {
					System.out.println("Facebook");
					tougle.add(facebook);
				}
				else{
					tougle.remove(facebook);
				}
			}
		});
		contentPane.add(facebook);
		
		JToggleButton mail = new JToggleButton("Mail");
		mail.setBounds(57, 374, 379, 91);
		mail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mail.isSelected()) {
					tougle.add(mail);
				}
				else{
					tougle.remove(mail);
				}
			}
		});
		contentPane.add(mail);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(57, 66, 379, 25);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(JToggleButton j : tougle) {
					if(j.equals(mail)) {
						String user = JOptionPane.showInputDialog("User:");
						System.out.println(user);
						String pass = JOptionPane.showInputDialog("Password:");
						System.out.println(pass);
						listModel.addElement("User: " + user + " Pass: " + pass);
						//Aceder à informação dos botoes selecionados
					}
					if(j.equals(facebook)) {
						for(String s : searchFacebook.getSearchFacebook()) {
							listModel.addElement(s);
						}
					}
					if(j.equals(twitter)) {
						for(String s : searchTwitter.getSearch()) {
							listModel.addElement(s);
						}
					}
				}	
			}
		});
		contentPane.add(btnSearch);
		
		JButton btnNewButton_3 = new JButton("Post");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(JToggleButton j : tougle) {
					if(j.equals(mail)) {
						String user = JOptionPane.showInputDialog("User:");
						System.out.println(user);
						String pass = JOptionPane.showInputDialog("Password:");
						System.out.println(pass);
						String to = JOptionPane.showInputDialog("To:");
						System.out.println(to);
						String subj = JOptionPane.showInputDialog("Subject:");
						System.out.println(subj);
						
						
						//Aceder à informação dos botoes selecionados
					}
					if(j.equals(facebook)) {
						System.out.println("Fode-te");
					}
					if(j.equals(twitter)) {
						System.out.println("Puta");
					}
				}
			}
		});
		btnNewButton_3.setBounds(57, 505, 379, 25);
		contentPane.add(btnNewButton_3);
		
		JList<String> list = new JList<>(listModel);
		list.setBounds(552, 125, 415, 346);
		list.setBackground(SystemColor.inactiveCaptionBorder);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
			}
			
		});
//		
		contentPane.add(list);
		
	}
}