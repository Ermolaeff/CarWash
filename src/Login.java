import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ermol on 10/5/2017.
 */
public class Login {
    public List<String> logins = new ArrayList<String>(Arrays.asList("admin", "Vasya", "Ochoba Williams", "Glebanya", "car_washer666", "idontwannasignup"));
    public List<String> passwords = new ArrayList<String>(Arrays.asList("bigboss", "qwerty", "nobodylovesme", "thesmallerthebetter", "washdatbitch", "qwerty123"));

    public static void main(String[] args) {
        Login login = new Login();
        login.showWin(login);
    }

    public void showWin(Login loginObj) {
        /*
        *for (int i = 0; i < logins.size(); i++) {
        *    System.out.println(logins.get(i));
        *    System.out.println(passwords.get(i));
        *}
        */
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
        JButton reg = new JButton("Sign up");

        in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < logins.size(); i++) {
                    if (loginField.getText().equals(logins.get(i)) && passwordField.getText().equals(passwords.get(i))) {
                        if (loginField.getText().equals(logins.get(0))) {
                            System.out.println("Logged in as admin.");
                            Admin admin = new Admin();
                            admin.showWindow(loginObj, logins.get(i));
                            frame.setVisible(false);
                            break;
                        } else {
                            System.out.println("Logged in as user.");
                            //User user = new User();
                            //user.showWindow();
                            //frame.setVisible(false);
                            break;
                        }
                    } else if (i == logins.size() - 1) {
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

        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp sign = new SignUp();
                sign.showWindow(loginObj);
                frame.setVisible(false);
                System.out.println("Move to another window");
            }
        });

        panel.add(login);
        panel.add(loginField);
        panel.add(pass);
        panel.add(passwordField);
        panel.add(in);
        panel.add(out);
        panel.add(reg);
        
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
