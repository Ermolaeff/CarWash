import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ermol on 10/7/2017.
 */
public class Admin {
    public void showWindow(Login login, String name) {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Admin panel");
        //BoxLayout layout = new BoxLayout(panel, BoxLayout.);
        //panel.setLayout(layout);

        JMenuBar menuBar = new JMenuBar();
        JMenu prices = new JMenu("Prices");
        JMenu offers = new JMenu("Special offers");
        JMenu accounts = new JMenu("Account management");
        JMenuItem viewPrices = new JMenuItem("View prices");
        JMenuItem changePrices = new JMenuItem("Change prices");
        JMenuItem addPrice = new JMenuItem("Add new item");
        JMenuItem viewOffers = new JMenuItem("View offers");
        JMenuItem addOffer = new JMenuItem("Add new offer");
        JMenuItem viewAccounts = new JMenuItem("View Accounts");
        JMenuItem deleteAccount = new JMenuItem("Delete account");

        JLabel welcome = new JLabel("Welcome to your kingdom, your highness, " + name);
        JButton back = new JButton("Back to login screen");
        JButton exit = new JButton("Exit to desktop");

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Back to login screen");
                frame.setVisible(false);
                login.showWin(login);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting...");
                System.exit(1);
            }
        });

        prices.add(viewPrices);
        prices.add(changePrices);
        prices.add(addPrice);
        offers.add(viewOffers);
        offers.add(addOffer);
        accounts.add(viewAccounts);
        accounts.add(deleteAccount);
        menuBar.add(prices);
        menuBar.add(offers);
        menuBar.add(accounts);

        panel.add(menuBar);
        panel.add(welcome, BorderLayout.CENTER);
        panel.add(back);
        panel.add(exit);

        frame.setContentPane(panel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
