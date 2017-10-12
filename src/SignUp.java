import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ermol on 10/6/2017.
 */
public class SignUp {
    public void showWindow(Login log) {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Car Wash");
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        JLabel login = new JLabel("Enter your login");
        JTextField loginField = new JTextField();
        JLabel pass = new JLabel("Enter your password");
        JPasswordField passwordField = new JPasswordField();
        JLabel pass2 = new JLabel("Repeat your password");
        JPasswordField passwordField2 = new JPasswordField();

        JButton submit = new JButton("Submit");
        JButton exit = new JButton("Back");

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (log.logins.contains(loginField.getText())) {
                    JOptionPane.showMessageDialog(panel, "Error. This nickname already exists.", "Error Message", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Error. This nickname already exists.");
                } else if (!passwordField.getText().equals(passwordField2.getText())) {
                    JOptionPane.showMessageDialog(panel, "Error. Passwords you entered are not the same.", "Error Message", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Error. Passwords you entered are not the same.");
                } else if (loginField.getText().length() == 0 || passwordField.getText().length() == 0) {
                    JOptionPane.showMessageDialog(panel, "Error. Enter login and password", "Error Message", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Error. Enter login and password");
                } else {
                    log.users.add(new User(loginField.getText(), passwordField.getText()));
                    log.logins.add(loginField.getText());
                    log.passwords.add(passwordField.getText());
                    JOptionPane.showMessageDialog(panel, "Success. New account created.", "Success Message", JOptionPane.DEFAULT_OPTION);
                    System.out.println("Success. New account created.");
                    frame.setVisible(false);
                    log.showWin(log);
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Back to login screen");
                frame.setVisible(false);
                log.showWin(log);
            }
        });

        panel.add(login);
        panel.add(loginField);
        panel.add(pass);
        panel.add(passwordField);
        panel.add(pass2);
        panel.add(passwordField2);
        panel.add(submit);
        panel.add(exit);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}