package jeghemabetik;


import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.Font;


import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.time.LocalDate;

import static jeghemabetik.UIlogin.*;

public class UIFormUnggahan extends JFrame {
	Connection con;
	java.sql.Statement stat;
	ResultSet rs;
	String sql;
	JFrame frame;
	private JPanel contentPane;
	private JTextField txtDeskripsi;
	private JTextField txtJudul;
	private JTextField txtTanggalDitemukan;
	private JTextField txtLokasiPenemuan;
	private JTextField txtAlamatGambar;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UIFormUnggahan frame = new UIFormUnggahan();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UIFormUnggahan() throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 350, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Koneksi DB = new Koneksi();
		DB.config();
		con = DB.con;
		stat = (Statement) DB.stm;

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 344, 421);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(26, 174, 159, 160));
		panel_1.setBounds(0, 0, 343, 421);
		panel.add(panel_1);

		JLabel lblFormUnggahan = new JLabel("Form Unggahan");
		lblFormUnggahan.setForeground(Color.WHITE);
		lblFormUnggahan.setFont(new Font("Blackadder ITC", Font.ITALIC, 35));
		lblFormUnggahan.setBounds(10, 11, 219, 45);
		panel_1.add(lblFormUnggahan);

		JLabel label_4 = new JLabel("_________________");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		label_4.setBounds(36, 22, 307, 45);
		panel_1.add(label_4);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(96, 143, 225, 20);
		panel_1.add(panel_3);

		txtDeskripsi = new JTextField();
		txtDeskripsi.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtDeskripsi.getText().equals("Deskripsi")) {
					txtDeskripsi.setText("");
				}else {
					txtDeskripsi.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtDeskripsi.getText().equals("")) {
					txtDeskripsi.setText("Deskripsi");
				}
			}
		});
		txtDeskripsi.setText("Deskripsi");
		txtDeskripsi.setForeground(new Color(102, 102, 102));
		txtDeskripsi.setColumns(10);
		txtDeskripsi.setBorder(null);
		txtDeskripsi.setBounds(30, 0, 195, 20);
		panel_3.add(txtDeskripsi);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(96, 100, 225, 20);
		panel_1.add(panel_2);

		txtJudul = new JTextField();
		txtJudul.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtJudul.getText().equals("Judul")) {
					txtJudul.setText("");
				}else {
					txtJudul.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtJudul.getText().equals("")) {
					txtJudul.setText("Judul");
				}
			}

		});
		txtJudul.setText("Judul");
		txtJudul.setForeground(new Color(102, 102, 102));
		txtJudul.setColumns(10);
		txtJudul.setBorder(null);
		txtJudul.setBounds(30, 0, 195, 20);
		panel_2.add(txtJudul);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(96, 185, 225, 20);
		panel_1.add(panel_4);

		txtTanggalDitemukan = new JTextField();
		txtTanggalDitemukan.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtTanggalDitemukan.getText().equals("Tanggal Penemuan/kehilangan")) {
					txtTanggalDitemukan.setText("");
				}else {
					txtTanggalDitemukan.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTanggalDitemukan.getText().equals("")) {
					txtTanggalDitemukan.setText("Tanggal Penemuan/kehilangan");
				}
			}
		});
		txtTanggalDitemukan.setText("Tanggal Penemuan/Kehilangan");
		txtTanggalDitemukan.setForeground(new Color(102, 102, 102));
		txtTanggalDitemukan.setColumns(10);
		txtTanggalDitemukan.setBorder(null);
		txtTanggalDitemukan.setBounds(30, 0, 195, 20);
		panel_4.add(txtTanggalDitemukan);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(96, 226, 225, 20);
		panel_1.add(panel_5);

		txtLokasiPenemuan = new JTextField();
		txtLokasiPenemuan.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtLokasiPenemuan.getText().equals("Lokasi Penemuan")) {
					txtLokasiPenemuan.setText("");
				}else {
					txtLokasiPenemuan.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtLokasiPenemuan.getText().equals("")) {
					txtLokasiPenemuan.setText("Lokasi Penemuan");
				}
			}
		});
		txtLokasiPenemuan.setText("Lokasi Penemuan");
		txtLokasiPenemuan.setForeground(new Color(102, 102, 102));
		txtLokasiPenemuan.setColumns(10);
		txtLokasiPenemuan.setBorder(null);
		txtLokasiPenemuan.setBounds(30, 0, 195, 20);
		panel_5.add(txtLokasiPenemuan);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(96, 267, 225, 20);
		panel_1.add(panel_6);

		txtAlamatGambar = new JTextField();
		txtAlamatGambar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtAlamatGambar.getText().equals("Alamat Gambar")) {
					txtAlamatGambar.setText("");
				}else {
					txtAlamatGambar.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAlamatGambar.getText().equals("")) {
					txtAlamatGambar.setText("Alamat Gambar");
				}
			}
		});
		txtAlamatGambar.setText("Alamat Gambar");
		txtAlamatGambar.setForeground(new Color(102, 102, 102));
		txtAlamatGambar.setColumns(10);
		txtAlamatGambar.setBorder(null);
		txtAlamatGambar.setBounds(30, 0, 195, 20);
		panel_6.add(txtAlamatGambar);

		JLabel lblNewLabel = new JLabel("Judul");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(21, 100, 65, 20);
		panel_1.add(lblNewLabel);

		JLabel lblDeskripsi = new JLabel("Deskripsi");
		lblDeskripsi.setForeground(Color.WHITE);
		lblDeskripsi.setBounds(21, 143, 65, 20);
		panel_1.add(lblDeskripsi);

		JLabel lblTanggalDitemukan = new JLabel("Tanggal ");
		lblTanggalDitemukan.setForeground(Color.WHITE);
		lblTanggalDitemukan.setBounds(21, 185, 75, 20);
		panel_1.add(lblTanggalDitemukan);

		JLabel lblLokasi = new JLabel("Lokasi");
		lblLokasi.setForeground(Color.WHITE);
		lblLokasi.setBounds(21, 226, 65, 20);
		panel_1.add(lblLokasi);

		JLabel lblUrlGAmbar = new JLabel("URL G\r\nambar");
		lblUrlGAmbar.setForeground(Color.WHITE);
		lblUrlGAmbar.setBounds(21, 267, 75, 20);
		panel_1.add(lblUrlGAmbar);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setForeground(new Color(100, 149, 237));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(178, 326, 144, 25);
		panel_1.add(panel_7);

		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jeghema_betik?serverTimezone=UTC", "root", "");
		JLabel lblUnggah = new JLabel("Unggah");
		lblUnggah.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LocalDate date_nemu = LocalDate.parse(txtTanggalDitemukan.getText());
				LocalDate date_ung = LocalDate.now();
				sql = " INSERT INTO unggahan (judul, deskripsi, status, tgl_ditemukan, tgl_unggah, lokasi_penemuan, alamat_gambar, username) " + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement st = null;
				try {
					st = con.prepareStatement(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					assert st != null;
					st.setString(1, txtJudul.getText());


				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {

					st.setString(2,txtDeskripsi.getText());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {

					st.setString(3,"Aktif");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {

					st.setDate(4, Date.valueOf(date_nemu));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {

					st.setDate(5, Date.valueOf(date_ung));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {

					st.setString(6,txtLokasiPenemuan.getText());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {

					st.setString(7,txtAlamatGambar.getText());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					st.setString(8, "ahmad");
				} catch (SQLException e) {
					e.printStackTrace();
				}
//				try {
//
//					st.setInt(9,);
//
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
				try {
				st.executeUpdate();
					JOptionPane.showMessageDialog(null, "berhasil Unggah");
					setVisible(false);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catcsqqh block
					e1.printStackTrace();
				}

			}

			public void mouseEntered(MouseEvent arg0) {
				panel_7.setBackground(new Color(30, 60, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_7.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panel_7.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panel_7.setBackground(new Color(30, 60, 60));
			}
		});
		lblUnggah.setToolTipText("");
		lblUnggah.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnggah.setForeground(new Color(32, 178, 170));
		lblUnggah.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUnggah.setBackground(Color.BLACK);
		lblUnggah.setAlignmentX(0.5f);
		lblUnggah.setBounds(0, 0, 144, 25);
		panel_7.add(lblUnggah);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setForeground(new Color(100, 149, 237));
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(24, 326, 144, 25);
		panel_1.add(panel_8);

		JLabel lblCancel = new JLabel("Cancel");
		lblCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				dispose();
			}
			public void mouseEntered(MouseEvent arg0) {
				panel_8.setBackground(new Color(30, 60, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_8.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panel_8.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panel_8.setBackground(new Color(30, 60, 60));
			}
		});
		lblCancel.setToolTipText("");
		lblCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancel.setForeground(new Color(32, 178, 170));
		lblCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCancel.setBackground(Color.BLACK);
		lblCancel.setAlignmentX(0.5f);
		lblCancel.setBounds(0, 0, 144, 25);
		panel_8.add(lblCancel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(UIFormUnggahan.class.getResource("/resources/back.jpeg")));
		label.setIconTextGap(2);
		label.setFont(new Font("Tahoma", Font.PLAIN, 99));
		label.setBounds(0, 0, 343, 421);
		panel.add(label);
	}
}
