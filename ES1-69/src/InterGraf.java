import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.ActionListener;

public class InterGraf extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;

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
		setBounds(100, 100, 476, 342);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBackground(SystemColor.inactiveCaptionBorder);
		scrollbar.setBounds(390, 83, 21, 186);
		contentPane.add(scrollbar);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBackground(SystemColor.inactiveCaptionBorder);
		scrollPane.setBounds(158, 83, 226, 186);
		contentPane.add(scrollPane);
		
		txtSearch = new JTextField();
		txtSearch.setText("\r\n");
		txtSearch.setBackground(SystemColor.inactiveCaptionBorder);
		txtSearch.setToolTipText("Search");
		txtSearch.setBounds(158, 42, 226, 22);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Post");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inputValue = JOptionPane.showInputDialog("User:");
				String inputValue1 = JOptionPane.showInputDialog("Password:");
				String inputValue2 = JOptionPane.showInputDialog("To:");
				String inputValue3 = JOptionPane.showInputDialog("Subject");
				String inputValue4 = JOptionPane.showInputDialog("Message");
			}
		});
		btnNewButton_3.setBounds(46, 244, 97, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Facebook");
		btnNewButton.setBounds(46, 83, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Twitter");
		btnNewButton_1.setBounds(46, 121, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Email");
		btnNewButton_2.setBounds(46, 159, 97, 25);
		contentPane.add(btnNewButton_2);
	}
}
