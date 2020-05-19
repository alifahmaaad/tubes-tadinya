package jeghemabetik;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class home2 extends JFrame {
    static Connection con;
    static Statement stat;
    ResultSet Rs;
    String sql;
    private JPanel rootJPanel;
    private JButton cariBarangButton;
    private JButton notifButton;
    private JButton helpButton;
    private JButton chatButton;
    private JButton tentang;
    private JPanel contentPane;
    private JTable table =new JTable();
    String header[] = {"Kode Barang","Nama Barang","Jenis Barang","WDAa","dfsds"};
    public static DefaultTableModel model;
    private JTable table_1 =new JTable();
    private JTextField txtEnterSeacrh;;


    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    home2 fa = new home2();
//                    fa.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });
//    }

    /**
     * Create the frame.
     * @throws SQLException
     */
    public home2() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent arg0) {
                try {
                    TampilData();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        setBounds(0, 0, 800, 650);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(26, 174, 159));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(216, 0, 578, 621);
        contentPane.add(mainPanel);
        mainPanel.setLayout(null);
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        //add panel

        JPanel homePanel = new JPanel();
        homePanel.setBounds(0, 0, 578, 621);
        mainPanel.add(homePanel);
        homePanel.setBackground(Color.WHITE);
        homePanel.setLayout(null);

        JLabel label = new JLabel("Lapor Temuan Barang");
        label.addMouseListener(new MouseAdapter() {
           @Override
          public void mouseClicked(MouseEvent e) {
               try {
                  new UIFormUnggahan().setVisible(true);
               } catch (SQLException ex) {
                    ex.printStackTrace();
               }

           }
      });
        label.setForeground(new Color(0, 128, 128));
        label.setBounds(10, 11, 140, 20);
        homePanel.add(label);

        JLabel label_1 = new JLabel("Lapor Kehilangan Barang");
        label_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    new UIFormUnggahan().setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        label_1.setForeground(new Color(0, 128, 128));
        label_1.setBounds(160, 11, 148, 20);
        homePanel.add(label_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 117, 558, 457);
        homePanel.add(scrollPane);
        scrollPane.setViewportView(table);

        JLabel lblNewLabel_5 = new JLabel("DAFTAR PENGUMUMAN");
        lblNewLabel_5.setForeground(new Color(26, 174, 159));
        lblNewLabel_5.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel_5.setBounds(200, 76, 218, 14);
        homePanel.add(lblNewLabel_5);



        JPanel PencarianPanel = new JPanel();
        PencarianPanel.setBounds(0, 0, 578, 621);
        mainPanel.add(PencarianPanel);
        PencarianPanel.setBackground(Color.WHITE);
        PencarianPanel.setLayout(null);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(21, 232, 547, 96);
        PencarianPanel.add(scrollPane_1);


        scrollPane_1.setViewportView(table_1);

        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon(home2.class.getResource("/resources/back.jpeg")));
        lblNewLabel_2.setBounds(0, 0, 578, 127);
        PencarianPanel.add(lblNewLabel_2);

        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBackground(Color.WHITE);
        panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(26, 174, 159), null, null, null));
        panel_2.setBounds(148, 169, 314, 30);
        PencarianPanel.add(panel_2);

        JLabel label_3 = new JLabel("New label");
        label_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    TampilData2(txtEnterSeacrh.getText());
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            @Override
            public void mouseEntered(MouseEvent arg0) {
                label_3.setBackground(new Color(30, 60, 60));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label_3.setBackground(new Color(255, 255, 255));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                label_3.setBackground(new Color(60, 80, 80));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                label_3.setBackground(new Color(30, 60, 60));
            }
        });
        label_3.setIcon(new ImageIcon(home2.class.getResource("/resources/loupe.png")));
        label_3.setBounds(285, 3, 25, 25);
        panel_2.add(label_3);

        txtEnterSeacrh = new JTextField();
        txtEnterSeacrh.setText("Enter Seacrh");
        txtEnterSeacrh.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(txtEnterSeacrh.getText().equals("Enter Seacrh")) {
                    txtEnterSeacrh.setText("");
                }else {
                    txtEnterSeacrh.selectAll();
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(txtEnterSeacrh.getText().equals("")) {
                    txtEnterSeacrh.setText("Enter Seacrh");
                }
            }
        });
        txtEnterSeacrh.setForeground(new Color(102, 102, 102));
        txtEnterSeacrh.setColumns(10);
        txtEnterSeacrh.setBorder(null);
        txtEnterSeacrh.setBounds(10, 2, 269, 26);
        panel_2.add(txtEnterSeacrh);;

        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setForeground(new Color(100, 149, 237));
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 155, 196, 25);
        contentPane.add(panel);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(home2.class.getResource("/resources/bell.png")));
        lblNewLabel_1.setBounds(15, 0, 25, 25);
        panel.add(lblNewLabel_1);


        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setForeground(new Color(100, 149, 237));
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(10, 200, 196, 25);
        contentPane.add(panel_1);

        JLabel lblPencarian = new JLabel("                 Home");
        lblPencarian.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainPanel.removeAll();
                mainPanel.repaint();
                mainPanel.revalidate();
                //add panel
                mainPanel.add(homePanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }

            public void mouseEntered(MouseEvent arg0) {
                panel.setBackground(new Color(30, 60, 60));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(new Color(255, 255, 255));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                panel.setBackground(new Color(60, 80, 80));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panel.setBackground(new Color(30, 60, 60));
            }
        });
        lblPencarian.setToolTipText("");
        lblPencarian.setHorizontalAlignment(SwingConstants.LEFT);
        lblPencarian.setForeground(new Color(32, 178, 170));
        lblPencarian.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPencarian.setBackground(Color.BLACK);
        lblPencarian.setAlignmentX(0.5f);
        lblPencarian.setBounds(0, 0, 196, 25);
        panel.add(lblPencarian);

        JLabel label_6 = new JLabel("New label");
        label_6.setIcon(new ImageIcon(home2.class.getResource("/resources/loupe.png")));
        label_6.setBounds(15, 0, 25, 25);
        panel_1.add(label_6);

        JLabel lblPencarian_1 = new JLabel("                 Pencarian\r\n");
        lblPencarian_1.setToolTipText("");
        lblPencarian_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblPencarian_1.setForeground(new Color(32, 178, 170));
        lblPencarian_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPencarian_1.setBackground(Color.BLACK);
        lblPencarian_1.setAlignmentX(0.5f);
        lblPencarian_1.setBounds(0, 0, 196, 25);
        panel_1.add(lblPencarian_1);

        lblPencarian_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainPanel.removeAll();
                mainPanel.repaint();
                mainPanel.revalidate();
                //add panel
                mainPanel.add(PencarianPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }

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


        JPanel panel_4 = new JPanel();
        panel_4.setLayout(null);
        panel_4.setForeground(new Color(100, 149, 237));
        panel_4.setBackground(Color.WHITE);
        panel_4.setBounds(10, 245, 196, 25);
        contentPane.add(panel_4);

        JLabel label_10 = new JLabel("New label");
        label_10.setIcon(new ImageIcon(home2.class.getResource("/resources/information.png")));
        label_10.setBounds(15, 0, 25, 25);
        panel_4.add(label_10);

        JLabel lblTentangAplikasi = new JLabel("                 Tentang Aplikasi");
        lblTentangAplikasi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainPanel.removeAll();
                mainPanel.repaint();
                mainPanel.revalidate();
                //add panel
                JPanel aboutPanel = new JPanel();
                aboutPanel.setBounds(0, 0, 578, 621);
                mainPanel.add(aboutPanel);
                aboutPanel.setBackground(Color.WHITE);
                aboutPanel.setLayout(null);
                JLabel label_2 = new JLabel("<html><h1>Tentang Aplikasi</h1><p>Aplikasi ini bernama JeghemaBetik sebagai sistem informasi pelaporan Barang Hilang lingkup ITERA<br> Dibangun dengan spesifikasi umum, yaitu memuat konsep OOP, GUI, dan terkoneksi database.</p> <p>GUI yang digunakan adalah Java Swing <br> Untuk database menggunakan DBMS MySQL.</p> <p>Beberapa fitur utamanya adalah<br></p> <ol> <li>Mencari dan melihat informasi barang hilang yang terlaporkan<br></li> <li>Daftar (pengumuman) barang hilang di linimasa atau landing page<br></li> <li>Form untuk pembuatan pengumuman penemuan barang hilang<br></li> <li>Form Login<br> </ol> <br> <p><p>Setiap pengguna (<em>civitas academica</em> ITERA) akan didaftarkan oleh administrator.</p></html>");
                label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
                label_2.setBounds(33, 0, 491, 435);
                aboutPanel.add(label_2);
                mainPanel.repaint();
                mainPanel.revalidate();
            }

            public void mouseEntered(MouseEvent arg0) {
                panel_4.setBackground(new Color(30, 60, 60));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel_4.setBackground(new Color(255, 255, 255));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                panel_4.setBackground(new Color(60, 80, 80));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panel_4.setBackground(new Color(30, 60, 60));
            }
        });
        lblTentangAplikasi.setToolTipText("");
        lblTentangAplikasi.setHorizontalAlignment(SwingConstants.LEFT);
        lblTentangAplikasi.setForeground(new Color(32, 178, 170));
        lblTentangAplikasi.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTentangAplikasi.setBackground(Color.BLACK);
        lblTentangAplikasi.setAlignmentX(0.5f);
        lblTentangAplikasi.setBounds(0, 0, 196, 25);
        panel_4.add(lblTentangAplikasi);

        JLabel lblJeghema = new JLabel("Jeghema Betik");
        lblJeghema.setForeground(Color.WHITE);
        lblJeghema.setFont(new Font("Blackadder ITC", Font.ITALIC, 35));
        lblJeghema.setBounds(12, 12, 208, 45);
        contentPane.add(lblJeghema);

        JLabel lblNewLabel = new JLabel("Cari Barang Anda yang\r\n");
        lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 13));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(10, 76, 210, 14);
        contentPane.add(lblNewLabel);

        JLabel lblDitemukanOlehOrang = new JLabel("ditemukan oleh Orang Baik");
        lblDitemukanOlehOrang.setForeground(Color.WHITE);
        lblDitemukanOlehOrang.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 13));
        lblDitemukanOlehOrang.setBounds(37, 92, 210, 14);
        contentPane.add(lblDitemukanOlehOrang);

        JLabel label_2 = new JLabel("_________________");
        label_2.setForeground(Color.WHITE);
        label_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        label_2.setBounds(44, 31, 173, 45);
        contentPane.add(label_2);

        JPanel panel_5 = new JPanel();
        panel_5.setBounds(0, 114, 218, 4);
        contentPane.add(panel_5);
    }
    private void TampilData () throws SQLException {
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Judul");
        model.addColumn("Deskripsi");
        model.addColumn("Status");
        model.addColumn("Tanggal Temuan");
        model.addColumn("Tanggal Unggah");
        model.addColumn("Tempat");
        model.addColumn("URL");
        model.addColumn("Username");

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jeghema_betik?serverTimezone=UTC", "root", "");
        String sql = "SELECT * FROM `unggahan` ";
        stat = con.createStatement();
        ResultSet Rs = stat.executeQuery(sql);
        while (Rs.next()) {
            Object obj[] = new Object[9];
            obj[0] = Rs.getString(1);
            obj[1] = Rs.getString(2);
            obj[2] = Rs.getString(3);
            obj[3] = Rs.getString(4);
            obj[4] = Rs.getString(5);
            obj[5] = Rs.getString(6);
            obj[6] = Rs.getString(7);
            obj[7] = Rs.getString(8);
            obj[8] = Rs.getString(9);
            model.addRow(obj);

        }
        Rs.close();
        stat.close();
        con.close();

        this.table.setModel(model);
        this.table.setAutoResizeMode(0);
        this.table.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.table.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.table.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.table.getColumnModel().getColumn(3).setPreferredWidth(35);
        this.table.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.table.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.table.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.table.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.table.getColumnModel().getColumn(8).setPreferredWidth(120);

    }
    private void TampilData2 (String a) throws SQLException {
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Judul");
        model.addColumn("Deskripsi");
        model.addColumn("Status");
        model.addColumn("Tanggal Temuan");
        model.addColumn("Tanggal Unggah");
        model.addColumn("Tempat");
        model.addColumn("URL");
        model.addColumn("Username");

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jeghema_betik?serverTimezone=UTC", "root", "");
        String sql = "SELECT * FROM `unggahan` WHERE judul LIKE '"+a+"%'" ;
        stat = con.createStatement();
        ResultSet Rs = stat.executeQuery(sql);
        while (Rs.next()) {
            Object obj[] = new Object[9];
            obj[0] = Rs.getString(1);
            obj[1] = Rs.getString(2);
            obj[2] = Rs.getString(3);
            obj[3] = Rs.getString(4);
            obj[4] = Rs.getString(5);
            obj[5] = Rs.getString(6);
            obj[6] = Rs.getString(7);
            obj[7] = Rs.getString(8);
            obj[8] = Rs.getString(9);
            model.addRow(obj);

        }
        Rs.close();
        stat.close();
        con.close();

        this.table_1.setModel(model);
        this.table_1.setAutoResizeMode(0);
        this.table_1.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.table_1.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.table_1.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.table_1.getColumnModel().getColumn(3).setPreferredWidth(35);
        this.table_1.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.table_1.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.table_1.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.table_1.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.table_1.getColumnModel().getColumn(8).setPreferredWidth(120);

    }
}