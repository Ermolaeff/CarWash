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
        JMenuItem viewPrices = new JMenuItem("View price");
        JMenuItem changePrices = new JMenuItem("Change prices");
        JMenuItem addPrice = new JMenuItem("Add new item");
        JMenuItem viewOffers = new JMenuItem("View offer");
        JMenuItem addOffer = new JMenuItem("Add new offer");
        JMenuItem deleteAccount = new JMenuItem("Delete account");

        JLabel welcome = new JLabel("Welcome to your kingdom, your highness " + name);
        JButton back = new JButton("Back to login screen");
        JButton exit = new JButton("Exit to desktop");

        deleteAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = JOptionPane.showInputDialog(panel, "Type in username");
                if (login.logins.contains(username)) {
                    int answer = JOptionPane.showConfirmDialog(panel, "Are you sure?", "Confirmation message", JOptionPane.YES_NO_OPTION);
                    if (answer == 0) {
                        int count = login.logins.indexOf(username);
                        if (count != 0) {
                            login.users.remove(count);
                            login.logins.remove(count);
                            login.passwords.remove(count);
                            JOptionPane.showMessageDialog(panel, "Success. Account deleted.", "Success message", JOptionPane.DEFAULT_OPTION);
                        } else {
                            JOptionPane.showMessageDialog(panel, "Error. You cannot delete admin.", "Error message", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Error. No such user.", "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        viewOffers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(panel, "Type in the name of the offer", null);
                if(login.offers.contains(name)) {
                    JOptionPane.showMessageDialog(panel, "The price of " + name + " is " + login.offersPrices.get(login.offers.indexOf(name)) + "$",
                            "Success message", JOptionPane.DEFAULT_OPTION);
                } else {
                    JOptionPane.showMessageDialog(panel, "Error. No such offer.", "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addOffer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(panel, "Type in the name of the new offer", null);
                if (login.offers.contains(name)) {
                    JOptionPane.showMessageDialog(panel, "Error. This offer already exists.", "Error message", JOptionPane.ERROR_MESSAGE);
                } else {
                    String price = JOptionPane.showInputDialog(panel, "Type in th price", null);
                    if (login.isNumeric(price)) {
                        int priceInt = Integer.parseInt(price);
                        login.offers.add(name);
                        login.offersPrices.add(priceInt);
                        JOptionPane.showMessageDialog(panel, "Succes. New offer added.", "Success message", JOptionPane.DEFAULT_OPTION);
                    } else {
                        JOptionPane.showMessageDialog(panel, "Error. You did not enter a number.", "Error message", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        viewPrices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = JOptionPane.showInputDialog(panel, "Type in the name of the item", null);
                if (login.items.contains(item)) {
                    int count = login.items.indexOf(item);
                    JOptionPane.showMessageDialog(panel, "The price of " + item + " is " + login.itemsPrices.get(count) + "$", "Success message", JOptionPane.DEFAULT_OPTION);
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
                        login.itemsPrices.add(count, priceInt);
                        login.itemsPrices.remove(count + 1);
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
                        login.itemsPrices.add(priceInt);
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