import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ermol on 10/5/2017.
 */
public class Login {
    public static void main(String[] args) {
        Login login = new Login();
        login.showWin();
    }

    public void showWin() {
        String[] logins = {"admin", "Vasya", "Ochoba Williams", "Glebanya", "car_washer666", "idontwannasignup"};
        String[] passwords = {"bigboss", "qwerty", "nobodylovesme", "thesmallerthebetter", "washdatbitch", "qwerty123"};

        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Car Wash");
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        JLabel login = new JLabel("Enter login");
        JTextField loginField = new JTextField();
        JLabel pass = new JLabel("Enter password");
        JPasswordField passwordField = new JPasswordField();

        JButton in = new JButton("Login");
        JButton out = new JButton("Exit");

        in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < logins.length; i++) {
                    if (loginField.getText().equals(logins[i]) && passwordField.getText().equals(passwords[i])) {
                        if (loginField.getText().equals(logins[0])) {
                            //Admin admin = new Admin();
                            //admin.showWindow();
                            //frame.setVisible(false);
                            System.out.println("Logged in as admin.");
                            break;
                        } else {
                            //User user = new User();
                            //user.showWindow();
                            //frame.setVisible(false);
                            System.out.println("Logged in as user.");
                            break;
                        }
                    } else if (i == logins.length - 1) {
                        System.out.println("Error");
                    }
                }
            }
        });

        out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        panel.add(login);
        panel.add(loginField);
        panel.add(pass);
        panel.add(passwordField);
        panel.add(in);
        panel.add(out);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
