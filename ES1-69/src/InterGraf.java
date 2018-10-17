import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JInternalFrame;

public class InterGraf {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterGraf window = new InterGraf();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterGraf() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 469, 5, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnSearch = new JButton("Search");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 0;
		gbc_btnSearch.gridy = 0;
		frame.getContentPane().add(btnSearch, gbc_btnSearch);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Facebook");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 1;
		frame.getContentPane().add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JCheckBox chckbxTwitter = new JCheckBox("Twitter");
		GridBagConstraints gbc_chckbxTwitter = new GridBagConstraints();
		gbc_chckbxTwitter.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxTwitter.gridx = 0;
		gbc_chckbxTwitter.gridy = 2;
		frame.getContentPane().add(chckbxTwitter, gbc_chckbxTwitter);
		
		JCheckBox chckbxEmail = new JCheckBox("Email");
		GridBagConstraints gbc_chckbxEmail = new GridBagConstraints();
		gbc_chckbxEmail.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxEmail.gridx = 0;
		gbc_chckbxEmail.gridy = 3;
		frame.getContentPane().add(chckbxEmail, gbc_chckbxEmail);
		
		JTextPane textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.insets = new Insets(0, 0, 0, 5);
		gbc_textPane.gridheight = 7;
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 1;
		gbc_textPane.gridy = 1;
		frame.getContentPane().add(textPane, gbc_textPane);
	}

}
