package main;

import main.klassen.Buddy;
import main.klassen.Angriff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;


public class GUI extends JFrame{

    JFrame frame = new JFrame("Buddyworld");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel chatPanel;
    private JTextArea chatLog;

    private JLabel gegnerInfo = new JLabel();
    private JLabel gegnerBild = new JLabel();
    private JLabel eigenesBild = new JLabel();
    private JLabel eigeneInfo = new JLabel();

    private CountDownLatch latch = new CountDownLatch(1);
    static int gedrueckterButton;

    //Hier bitte den Pfad angeben, wo die Bilder, welche durchs Repository geholt wurden, sind
    String pfad = "C:/Users/kseno/Desktop/Schule/2. Jahr/Buddyworld/Buddyworld/img/";

    public GUI(Buddy b1, Buddy b2){

        Angriff[] angriffe = b1.getAngriffe();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500, 1080));

        chatPanel = new JPanel(new BorderLayout());
        chatLog = new JTextArea();
        chatLog.setEditable(false);
        chatLog.setLineWrap(true);
        chatLog.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(chatLog);
        chatPanel.add(scrollPane, BorderLayout.CENTER);
        chatPanel.setPreferredSize(new Dimension(200, 0));

        addChatMessage(b1.getName() + " gegen " + b2.getName());

        frame.getContentPane().add(chatPanel, BorderLayout.WEST);

        panel1.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.DARK_GRAY);

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        JPanel gridPanel = new JPanel(new GridLayout(2,2,20,70));
        gridPanel.setBackground(Color.LIGHT_GRAY);
        gridPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,20));

        gegnerInfo.setText("<html>" + b2.getName() +
                "<br>" + "lvl " + b2.getLvl() +
                "<br>" +
                "<br>" + "HP" +
                "<br>" + b2.getHp() + " / " + b2.getMaxHp() +
                "<br>" + b2.getStatusEffekt().getName() +
                "</html>");

        Random random = new Random();

        setImage("C:/Users/kseno/Desktop/Schule/2. Jahr/Buddyworld/Buddyworld/img/" + (random.nextInt(5) + 6) + ".png",gegnerBild);
        gegnerBild.setToolTipText("<html>" + "ATK: " + b2.getStatAenderung(1) +
                "<br>" + "DEF: " + b2.getStatAenderung(2) +
                "<br>" + "SpA: " + b2.getStatAenderung(3) +
                "<br>" + "SpD: " + b2.getStatAenderung(4) +
                "<br>" + "SPE: " + b2.getStatAenderung(5) +
                "</html>");

        setImage("C:/Users/kseno/Desktop/Schule/2. Jahr/Buddyworld/Buddyworld/img/" + (random.nextInt(5) + 1) + ".png",eigenesBild);
        eigenesBild.setToolTipText("<html>" + "ATK: " + b1.getStatAenderung(1) +
                "<br>" + "DEF: " + b1.getStatAenderung(2) +
                "<br>" + "SpA: " + b1.getStatAenderung(3) +
                "<br>" + "SpD: " + b1.getStatAenderung(4) +
                "<br>" + "SPE: " + b1.getStatAenderung(5) +
                "</html>");

        eigeneInfo.setText("<html>" + b1.getName() +
                "<br>" + "lvl " + b1.getLvl() +
                "<br>" +
                "<br>" + "HP" +
                "<br>" + b1.getHp() + " / " + b1.getMaxHp() +
                "<br>" + b1.getStatusEffekt().getName() +
                "</html>");


        gridPanel.add(gegnerInfo);
        gridPanel.add(gegnerBild);
        gridPanel.add(eigenesBild);
        gridPanel.add(eigeneInfo);

        panel1.add(gridPanel);

        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        panel2.add(Box.createRigidArea(new Dimension(0, 60)));

        JPanel gridPanel2 = new JPanel(new GridLayout(2,2,20,70));
        gridPanel2.setBackground(Color.DARK_GRAY);
        gridPanel2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,20));

        JButton button2_1 = erstelleButton(angriffe[0].getName(),0);
        button2_1.setToolTipText("<html>" + "Typ: " + angriffe[0].getTyp().getName() +
                "<br>" + "DMG: " + angriffe[0].getPower() +
                "<br>" + "ACC: " + angriffe[0].getGenauigkeit() + "%" +
                "<br>" + "CAT: " + angriffe[0].getKategorieString() +
                "</html>");

        JButton button2_2 = erstelleButton(angriffe[1].getName(),1);
        button2_2.setToolTipText("<html>" + "Typ: " + angriffe[1].getTyp().getName() +
                "<br>" + "DMG: " + angriffe[1].getPower() +
                "<br>" + "ACC: " + angriffe[1].getGenauigkeit() + "%" +
                "<br>" + "CAT: " + angriffe[1].getKategorieString() +
                "</html>");

        JButton button2_3 = erstelleButton(angriffe[2].getName(),2);
        button2_3.setToolTipText("<html>" + "Typ: " + angriffe[2].getTyp().getName() +
                "<br>" + "DMG: " + angriffe[2].getPower() +
                "<br>" + "ACC: " + angriffe[2].getGenauigkeit() + "%" +
                "<br>" + "CAT: " + angriffe[2].getKategorieString() +
                "</html>");

        JButton button2_4 = erstelleButton(angriffe[3].getName(),3);
        button2_4.setToolTipText("<html>" + "Typ: " + angriffe[3].getTyp().getName() +
                "<br>" + "DMG: " + angriffe[3].getPower() +
                "<br>" + "ACC: " + angriffe[3].getGenauigkeit() + "%" +
                "<br>" + "CAT: " + angriffe[3].getKategorieString() +
                "</html>");

        gridPanel2.add(button2_1);
        gridPanel2.add(button2_2);
        gridPanel2.add(button2_3);
        gridPanel2.add(button2_4);

        panel2.add(gridPanel2, BorderLayout.CENTER);

        panel2.add(Box.createRigidArea(new Dimension(0, 60)));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel1, panel2);
        splitPane.setDividerLocation(540);
        splitPane.setResizeWeight(0.5);
        splitPane.setEnabled(false);
        splitPane.setPreferredSize(new Dimension(500, 1080));
        splitPane.setMinimumSize(new Dimension(500, 1080));

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(splitPane, gbc);

        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public void update(Buddy b1, Buddy b2){


        gegnerInfo.setText("<html>" + b2.getName() +
                "<br>" + "lvl " + b2.getLvl() +
                "<br>" +
                "<br>" + "HP" +
                "<br>" + b2.getHp() + " / " + b2.getMaxHp() +
                "<br>" + b2.getStatusEffekt().getName() +
                "</html>");

        gegnerBild.setToolTipText("<html>" + "ATK: " + b2.getStatAenderung(1) +
                "<br>" + "DEF: " + b2.getStatAenderung(2) +
                "<br>" + "SpA: " + b2.getStatAenderung(3) +
                "<br>" + "SpD: " + b2.getStatAenderung(4) +
                "<br>" + "SPE: " + b2.getStatAenderung(5) +
                "</html>");

        eigenesBild.setToolTipText("<html>" + "ATK: " + b1.getStatAenderung(1) +
                "<br>" + "DEF: " + b1.getStatAenderung(2) +
                "<br>" + "SpA: " + b1.getStatAenderung(3) +
                "<br>" + "SpD: " + b1.getStatAenderung(4) +
                "<br>" + "SPE: " + b1.getStatAenderung(5) +
                "</html>");

        eigeneInfo.setText("<html>" + b1.getName() +
                "<br>" + "lvl " + b1.getLvl() +
                "<br>" +
                "<br>" + "HP" +
                "<br>" + b1.getHp() + " / " + b1.getMaxHp() +
                "<br>" + b1.getStatusEffekt().getName() +
                "</html>");
    }

    private JButton erstelleButton(String text, int buttonIndex) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed(buttonIndex);
            }
        });
        return button;
    }

    private void buttonPressed(int buttonIndex) {
        gedrueckterButton = buttonIndex;
        latch.countDown();

        for (Component component : panel2.getComponents()) {
            component.setEnabled(false);
            component.setVisible(false);
        }

        revalidate();
        repaint();

        new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Component component : panel2.getComponents()) {
                    component.setEnabled(true);
                    component.setVisible(true);
                }
                revalidate();
                repaint();
            }
        }).start();
    }

    public int getLastPressedButton() throws InterruptedException {
        latch = new CountDownLatch(1);
        latch.await();
        return gedrueckterButton;
    }

    public void addChatMessage(String message) {
        chatLog.append(message + "\n");
        chatLog.setCaretPosition(chatLog.getDocument().getLength());
    }

    public void setImage(String imagePath, JLabel jlabel) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath)); // Read the image file
            ImageIcon imageIcon = new ImageIcon(originalImage); // Create ImageIcon from BufferedImage

            // Resize the ImageIcon to fit within the bounds of imageLabel while maintaining aspect ratio
            Image scaledImage = originalImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            jlabel.setIcon(imageIcon); // Set the ImageIcon to the imageLabel
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void damageImageSet(){
        Random random = new Random();

        setImage(pfad + (random.nextInt(5) + 11) + ".png",eigenesBild);
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setImage(pfad + (random.nextInt(5) + 1) + ".png",eigenesBild);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void damageImageSetGegner(){
        Random random = new Random();

        setImage(pfad + (random.nextInt(5) + 16) + ".png", gegnerBild);
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setImage(pfad + (random.nextInt(5) + 6) + ".png", gegnerBild);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void death(boolean buddy1){
        //buddy1 ? true -> eigenes Buddy gestorben
        Random random = new Random();

        if(buddy1) {
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setImage(pfad + (random.nextInt(5) + 11) + ".png",eigenesBild);
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
        else {
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setImage(pfad + (random.nextInt(5) + 16) + ".png",gegnerBild);
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    public void panel2Loeschen(Buddy b1, Buddy b2){

        if(b1.getHp() == 0 && b2.getHp() == 0) {
            death(true);
            death(false);
        } else if(b1.getHp()  == 0) {
            death(true);
        }
        else {
            death(false);
        }

        panel2.removeAll();
        panel2.revalidate();
        panel2.repaint();
    }

}