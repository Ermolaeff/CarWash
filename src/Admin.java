import jdk.nashorn.internal.scripts.JO;

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

        JLabel welcome = new JLabel("Welcome to your kingdom, your highness " + name);
        JButton back = new JButton("Back to login screen");
        JButton exit = new JButton("Exit to desktop");

        viewPrices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = JOptionPane.showInputDialog(panel, "Type in the name of the item", null);
                if (login.items.contains(item)) {
                    int count = login.items.indexOf(item);
                    JOptionPane.showMessageDialog(panel, "The price of " + item + " is " + login.prices.get(count) + "$", "Success message", JOptionPane.DEFAULT_OPTION);
                } else {
                    JOptionPane.showMessageDialog(panel, "Error. No such item.", "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        changePrices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = JOptionPane.showInputDialog(panel, "Type in name of the item to change", null);
                if (login.items.contains(item)) {
                    String price = JOptionPane.showInputDialog(panel, "Type in new price for item " + item, null);
                    if (login.isNumeric(price)) {
                        int count = login.items.indexOf(item);
                        int priceInt = Integer.parseInt(price);
                        login.prices.add(count, priceInt);
                        login.prices.remove(count + 1);
                        JOptionPane.showMessageDialog(panel, "Success. The price is changed.", "Success message", JOptionPane.DEFAULT_OPTION);
                    } else {
                        JOptionPane.showMessageDialog(panel, "Error. You did not enter a number.", "Error message", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Error. No such item.", "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = JOptionPane.showInputDialog(panel, "Type in new item name", null);
                if (login.items.contains(item)) {
                    JOptionPane.showMessageDialog(panel, "Error. This item already exists.", "Error message", JOptionPane.ERROR_MESSAGE);
                } else {
                    String price = JOptionPane.showInputDialog(panel, "Type in price", null);
                    if (login.isNumeric(price)) {
                        int priceInt = Integer.parseInt(price);
                        login.items.add(item);
                        login.prices.add(priceInt);
                        JOptionPane.showMessageDialog(panel, "Success. New item added.", "Success message", JOptionPane.DEFAULT_OPTION);
                    } else {
                        JOptionPane.showMessageDialog(panel, "Error. You did not enter a number.", "Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

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
