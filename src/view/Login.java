package view; 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Window.Type;
import org.eclipse.wb.swing.FocusTraversalOnArray;


import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dialog.ModalityType;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField loginField;
	private JPasswordField passwordField;
	private JPanel buttonPane;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	

	
	
	private String login;
	private String senha;
	private boolean ss = false;
	
	public String getLogin() {
		return login;
	}
	
	public boolean session() {
		return ss;
	}
	public void setSession() {
		ss = !(ss);
	}
	
	
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		getContentPane().setName("dialogLogin.contentPane");
		setName("dialogLogin");
		setModal(true);
		setResizable(false);
		setTitle("Login");
		setType(Type.UTILITY);
		
		
		
		
		
			
		// MINHA PALETA
		Color primary = new Color(30, 35, 54);
		Color fundo = new Color(40, 51, 80);
		Color roxoclaro = new Color(113, 113, 151);
		Color verde = new Color(38, 178, 127);
		Color roxoclaro2 = new Color(153, 154, 167);
		Color roxoclaro3 = new Color(165, 153, 203);
		Color roxoclaro4 = new Color(207, 209, 213);
		Color roxovermelho = new Color(201, 167, 181);

		setBounds(100, 100, 297, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(fundo);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("Login:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(29, 71, 41, 17);
		contentPanel.add(label);
		
		loginField = new JTextField();
		loginField.setColumns(10);
		loginField.setBounds(75, 70, 176, 26);
		contentPanel.add(loginField);
		
		JLabel label_1 = new JLabel("Senha:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(27, 127, 43, 17);
		contentPanel.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(75, 126, 176, 26);
		contentPanel.add(passwordField);
		{
			buttonPane = new JPanel();
			buttonPane.setBounds(0, 184, 291, 33);
			contentPanel.add(buttonPane);
			buttonPane.setBackground(fundo);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			{
				okButton = new JButton("Entrar");
				okButton.addActionListener(new ActionListener() {
					//TODO ENTRAR
					public void actionPerformed(ActionEvent e) {
						if( auth(loginField.getText(), new String(passwordField.getPassword())) ) {
							//JOptionPane.showMessageDialog(null, "OK");
							
							login = loginField.getText();
							senha = new String(passwordField.getPassword());
							
							setSession();
							
							loginField.setText("");
							passwordField.setText("");
							
							dispose();
							
						}else JOptionPane.showMessageDialog(null, "Dados Inválidos","Atenção",0);
					}
				});
				okButton.setBorderPainted(false);
				okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getContentPane(), contentPanel, label, loginField, label_1, passwordField, buttonPane, okButton}));
	}
	
	public boolean auth(String login, String senha) {
		String l= "gerente";
		String s = "123";
		
		return login.equals(l) && senha.equals(s);
		
	}
}
