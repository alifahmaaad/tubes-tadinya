package jeghemabetik;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import java.awt.Color;
import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UIlogin extends JFrame{


	Connection con;
	Statement stat;
	ResultSet rs;
	String sql;
	JFrame frame;
	public JTextField txtEmail;
	private JPasswordField pwdPassword;


	/**
	 * Create the application.
	 */
	public UIlogin() {
		Koneksi DB = new Koneksi();
		DB.config();
		con = DB.con;
		stat = (Statement) DB.stm;



		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(0, 0, 456, 328);
		frame.getContentPane().setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(26, 174, 159,160));
		panel_4.setBounds(78, 0, 372, 300);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(UIlogin.class.getResource("/resources/icons8-contacts-20.png")));
		label_2.setBounds(15, 125, 20, 20);
		panel_4.add(label_2);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(UIlogin.class.getResource("/resources/icons8-lock-20.png")));
		lblNewLabel_2.setBounds(15, 166, 20, 20);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("Sign in");
		lblNewLabel.setBounds(15, 43, 141, 45);
		panel_4.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Blackadder ITC", Font.ITALIC, 35));
		lblNewLabel.setForeground(Color.WHITE);

		JLabel label = new JLabel("_________________");
		label.setBounds(38, 57, 307, 45);
		panel_4.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(232, 218, 63, 25);
		panel_4.add(panel_1);
		panel_1.setForeground(new Color(100, 149, 237));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);

		JLabel label_1 = new JLabel("Log in");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				sql = "SELECT * FROM akun WHERE username='"+txtEmail.getText()+"' AND password='"+pwdPassword.getText()+"'";
				try {
					rs = ((java.sql.Statement) stat).executeQuery(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if(rs.next()){
						try {
							if(txtEmail.getText().equals(rs.getString("username")) && pwdPassword.getText().equals(rs.getString("password"))){
								JOptionPane.showMessageDialog(null, "berhasil login");
								new home2().setVisible(true);
								UIlogin.this.frame.setVisible(false);
								UIlogin.this.frame.dispose();
							}
						} catch (HeadlessException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else{
						JOptionPane.showMessageDialog(null, "username atau password salah");
					}
				} catch (HeadlessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_1.setBackground(new Color(30, 60, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panel_1.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panel_1.setBackground(new Color(30, 60, 60));
			}
		});
		label_1.setToolTipText("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(32, 178, 170));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBackground(Color.BLACK);
		label_1.setAlignmentX(0.5f);
		label_1.setBounds(0, 0, 63, 25);
		panel_1.add(label_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 125, 285, 20);
		panel_4.add(panel_2);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);



		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(102, 102, 102));
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEmail.getText().equals("Enter Email")) {
					txtEmail.setText("");
				}else {
					txtEmail.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEmail.getText().equals("")) {
					txtEmail.setText("Enter Email");
				}
			}
		});
		txtEmail.setBorder(null);

		txtEmail.setText("Enter Email");
		txtEmail.setBounds(30, 0, 255, 20);
		panel_2.add(txtEmail);
		txtEmail.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 166, 285, 20);
		panel_4.add(panel_3);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);

		pwdPassword = new JPasswordField();
		pwdPassword.setForeground(new Color(102, 102, 102));
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(pwdPassword.getText().equals("Enter Password")) {
					pwdPassword.setEchoChar('*');
					pwdPassword.setText("");
				}else {
					pwdPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdPassword.getText().equals("")) {
					pwdPassword.setText("Enter Password");
					pwdPassword.setEchoChar((char)0);
				}
			}
		});
		pwdPassword.setText("Enter Password");
		pwdPassword.setBorder(null);
		pwdPassword.setEchoChar((char)0);
		pwdPassword.setBounds(30, 0, 255, 20);
		panel_3.add(pwdPassword);

		JLabel guestLoginLink = new JLabel("No Acoount? Login As Guest");
		guestLoginLink.setForeground(Color.WHITE);

		guestLoginLink.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent mouseEvent) {
				super.mouseClicked(mouseEvent);
				JOptionPane.showMessageDialog(null, "Selamat datang");
				new home2().setVisible(true);
				UIlogin.this.frame.setVisible(false);
				UIlogin.this.frame.dispose();
			}
			public void mousePressed(MouseEvent e) {
				guestLoginLink.setForeground(Color.GRAY);
			}

		});
		guestLoginLink.setBounds(29, 221, 141, 16);
		panel_4.add(guestLoginLink);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(128, 128, 128));
		panel.setBorder(new LineBorder(new Color(128, 128, 128), 2));
		panel.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIconTextGap(2);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblNewLabel_1.setBounds(1, 1, 448, 298);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(UIlogin.class.getResource("/resources/back.jpeg")));
	}

	public JTextField getTxtEmail() {
		final JTextField txtEmail = this.txtEmail;
		return txtEmail;
	}
}