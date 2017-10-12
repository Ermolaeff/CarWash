import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ultrabook on 10.10.2017.
 */
public class User {
    String name = "user";
    String password = "user";

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void showWin(Login login) {
        JFrame frame = new JFrame("User panel");
        JPanel panel = new JPanel();
        //BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        //panel.setLayout(layout);

        JMenuBar mebuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem delete = new JMenuItem("Delete my account");

        JLabel welceome = new JLabel("Welcome to car wash, " + this.name);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int answer = JOptionPane.showConfirmDialog(panel, "Are you sure?", "Confirmation message", JOptionPane.YES_NO_OPTION);
                if (answer == 0) {
                    JOptionPane.showMessageDialog(panel, "Okay. Never wanted to work with you anyways.", "Goodbye message", JOptionPane.WARNING_MESSAGE);
                    int count = login.logins.indexOf(User.this.name);
                    login.logins.remove(count);
                    login.passwords.remove(count);
                    login.users.remove(count);
                    System.out.println("Back to login screen");
                    frame.setVisible(false);
                    login.showWin(login);
                } else {
                    JOptionPane.showMessageDialog(panel, "What a pleasure, you are still here:)", "Fuuuhh", JOptionPane.DEFAULT_OPTION);
                }
            }
        });

        menu.add(delete);
        mebuBar.add(menu);

        panel.add(mebuBar);
        panel.add(welceome, BorderLayout.CENTER);

        frame.setContentPane(panel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
