package jeghemabetik;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                Startup startup = new Startup();
//                startup.setVisible(true);
                UIlogin window = new UIlogin();
                window.frame.setLocationRelativeTo(null);
                window.frame.setVisible(true);
            }
        });
    }
}
