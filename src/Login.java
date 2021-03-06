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
    public List<User> users = new ArrayList<>(Arrays.asList(new User("admin", "bigboss"), new User("Vasya", "qwerty"), new User ("OchobaWilliams", "nobodylovesme"),
            new User("Glebanya", "thesmallerthebetter"), new User("car_washer666", "washdatbitch"), new User("idontwannasignup", "qwerty123")));
    List<String> logins = new ArrayList<>(Arrays.asList("admin", "Vasya", "Ochoba Williams", "Glebanya", "car_washer666", "idontwannasignup"));
    List<String> passwords = new ArrayList<>(Arrays.asList("bigboss", "qwerty", "nobodylovesme", "thesmallerthebetter", "washdatbitch", "qwerty123"));
    public List<String> items = new ArrayList<>(Arrays.asList("Ordinary car wash", "Car wash PRO", "Chocolates and coffee"));
    public List<Integer> itemsPrices = new ArrayList<>(Arrays.asList(20, 35, 15));
    public List<String> offers = new ArrayList<>(Arrays.asList("First wash free", "Ochoba wash"));
    public List<Integer> offersPrices = new ArrayList<>(Arrays.asList(0, 666));

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
                            int count = logins.indexOf(loginField.getText());
                            users.get(count).showWin(loginObj);
                            frame.setVisible(false);
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
        panel.add(reg);
        panel.add(out);
        
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
