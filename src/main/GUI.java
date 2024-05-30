package main;

import main.klassen.Buddy;
import main.klassen.Angriff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI {

    public GUI(Buddy b1, Buddy b2){

        JFrame frame = new JFrame("Buddyworld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500, 1080));
        Angriff angriffe[] = b1.getAngriffe();
        String angriffeString[] = new String[4];

        for(int i = 0; i < angriffe.length; i++){
            angriffeString[i] = angriffe[i].getName();
        }

        // Create two panels
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.DARK_GRAY);

        // Customize panel1 with labels and buttons
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        JPanel gridPanel = new JPanel(new GridLayout(2,2,20,70));
        gridPanel.setBackground(Color.LIGHT_GRAY);
        gridPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,20));

        JLabel buddy2 = new JLabel("<html>" + b2.getName() +
                "<br>" + "lvl " + b2.getLvl() +
                "<br>" +
                "<br>" + "HP" +
                "<br>" + b2.getHp() + " / " + b2.getMaxHp() +
                "<br>" + b2.getStatusEffekt().getName() +
                "</html>");

        JLabel buddy = new JLabel("test");

        JLabel buddy3 = new JLabel("test");

        JLabel buddy1 = new JLabel("<html>" + b1.getName() +
                "<br>" + "lvl " + b1.getLvl() +
                "<br>" +
                "<br>" + "HP" +
                "<br>" + b1.getHp() + " / " + b1.getMaxHp() +
                "<br>" + b1.getStatusEffekt().getName() +
                "</html>");


        gridPanel.add(buddy2);
        gridPanel.add(buddy);
        gridPanel.add(buddy3);
        gridPanel.add(buddy1);

        panel1.add(gridPanel);

        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        panel2.add(Box.createRigidArea(new Dimension(0, 60)));

        // First part of panel2: 2 rows of 2 buttons each
        JPanel gridPanel2 = new JPanel(new GridLayout(2,2,20,70));
        gridPanel2.setBackground(Color.DARK_GRAY);
        gridPanel2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,20));

        JButton button2_1 = new JButton(angriffeString[0]);
        button2_1.setToolTipText("<html>" + "Typ: " + angriffe[0].getTyp().getName() +
                "<br>" + "DMG: " + angriffe[0].getPower() +
                "<br>" + "PP:  " + angriffe[0].getPp() +
                "<br>" + "ACC: " + angriffe[0].getGenauigkeit() + "%" +
                "<br>" + "CAT: " + angriffe[0].getKategorieString() +
                "</html>");

        JButton button2_2 = new JButton(angriffeString[1]);
        button2_2.setToolTipText("<html>" + "Typ: " + angriffe[1].getTyp().getName() +
                "<br>" + "DMG: " + angriffe[1].getPower() +
                "<br>" + "PP:  " + angriffe[1].getPp() +
                "<br>" + "ACC: " + angriffe[1].getGenauigkeit() + "%" +
                "<br>" + "CAT: " + angriffe[1].getKategorieString() +
                "</html>");

        JButton button2_3 = new JButton(angriffeString[2]);
        button2_3.setToolTipText("<html>" + "Typ: " + angriffe[2].getTyp().getName() +
                "<br>" + "DMG: " + angriffe[2].getPower() +
                "<br>" + "PP:  " + angriffe[2].getPp() +
                "<br>" + "ACC: " + angriffe[2].getGenauigkeit() + "%" +
                "<br>" + "CAT: " + angriffe[2].getKategorieString() +
                "</html>");

        JButton button2_4 = new JButton(angriffeString[3]);
        button2_4.setToolTipText("<html>" + "Typ: " + angriffe[3].getTyp().getName() +
                "<br>" + "DMG: " + angriffe[3].getPower() +
                "<br>" + "PP:  " + angriffe[3].getPp() +
                "<br>" + "ACC: " + angriffe[3].getGenauigkeit() + "%" +
                "<br>" + "CAT: " + angriffe[3].getKategorieString() +
                "</html>");

        gridPanel2.add(button2_1);
        gridPanel2.add(button2_2);
        gridPanel2.add(button2_3);
        gridPanel2.add(button2_4);

        // Add grid and flow panels to panel2
        panel2.add(gridPanel2, BorderLayout.CENTER);

        panel2.add(Box.createRigidArea(new Dimension(0, 60)));

        // Create a split pane and add the panels
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel1, panel2);
        splitPane.setDividerLocation(540); // Split at half of 1080 height
        splitPane.setResizeWeight(0.5); // Evenly divide space between the two panels
        splitPane.setEnabled(false); // Disable the ability to move the divider
        splitPane.setPreferredSize(new Dimension(500, 1080));
        splitPane.setMinimumSize(new Dimension(500, 1080));

        // Create a panel with GridBagLayout to center the split pane
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(splitPane, gbc);

        // Add the center panel to the frame
        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);

        // Display the window
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window
        frame.setVisible(true);

        button2_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disableAllComponents(panel2);
            }
        });
    }
    private static void enableAllComponents(Container container) {
        for (Component component : container.getComponents()) {
            component.setEnabled(true);
            component.setVisible(true);
            if (component instanceof Container) {
                enableAllComponents((Container) component);
            }
        }
    }

    private static void disableAllComponents(Container container) {
        for (Component component : container.getComponents()) {
            component.setEnabled(false);
            component.setVisible(false);
            if (component instanceof Container) {
                disableAllComponents((Container) component);
            }
        }
    }

}
