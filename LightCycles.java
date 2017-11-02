//GitHub Repository: https://github.com/callumr1/CP2406-Assignment1
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;

public class LightCycles extends JFrame implements ActionListener {

    private static Player Player1 = new Player();
    private static Grid GameGrid = new Grid();
    private static Bike PlayerBike = new Bike();
    private JButton playGame = new JButton("Play Game");
    private JButton exitGame = new JButton("Exit");
    private JButton red = new JButton("     ");
    private JButton blue = new JButton("     ");
    private JButton green = new JButton("     ");
    private JButton yellow = new JButton("     ");
    private final static String MENU = "Main Menu";
    private final static String OPTIONS = "Options";
    private final static String INSTRUCTIONS = "Instructions";
    private final Font bigFont = new Font("Arial", Font.PLAIN, 30);
    private final Font smallFont = new Font("Calibri", Font.BOLD, 15);
    private JTextField nameField = new JTextField(GameGrid.getPlayerName(), 20);

    private LightCycles()
    {
        playGame.addActionListener(this);
        exitGame.addActionListener(this);

        red.setBackground(Color.RED);
        red.addActionListener(this);

        blue.setBackground(Color.BLUE);
        blue.addActionListener(this);

        green.setBackground(Color.GREEN);
        green.addActionListener(this);

        yellow.setBackground(Color.YELLOW);
        yellow.addActionListener(this);

        nameField.addActionListener(this);
    }

    public static void main(String args[]) throws IOException {
        //Create and set up the content pane
        LightCycles mainFrame = new LightCycles();
        mainFrame.setSize(500, 300);
        mainFrame.addComponentToPane(mainFrame.getContentPane());
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
    }

    private void addComponentToPane(Container pane) throws IOException {
        //creating the instructions image
        BufferedImage img = ImageIO.read(new File("instructions.jpg"));
        Image dimg = img.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        JLabel instruct = new JLabel(new ImageIcon(dimg));
        instruct.setSize(500, 300);

        BufferedImage img2 = ImageIO.read(new File("title.PNG"));
        Image aimg = img2.getScaledInstance(300, 80, Image.SCALE_SMOOTH);
        JLabel title = new JLabel(new ImageIcon(aimg));
        instruct.setSize(300, 80);

        //creates the tabbed pane which everything will be on
        JTabbedPane tabbedpane = new JTabbedPane();

        //creates the menu card
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
        menu.setBackground(Color.BLACK);
        menu.setPreferredSize(super.getSize());
        playGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        playGame.setFont(bigFont);
        exitGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitGame.setFont(bigFont);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        menu.add(Box.createRigidArea(new Dimension(0,20))); //adds space between the elements
        menu.add(title);
        menu.add(Box.createRigidArea(new Dimension(0,20))); //adds space between the elements
        menu.add(playGame);
        menu.add(Box.createRigidArea(new Dimension(0,40))); //adds space between the elements
        menu.add(exitGame);

        //creates the options card
        JPanel options = new JPanel();
        options.setBackground(Color.BLACK);
        options.setLayout(new BoxLayout(options, BoxLayout.PAGE_AXIS));
        options.add(Box.createRigidArea(new Dimension(0,50))); //adds space between the elements

        Container colourCon = new Container();
        colourCon.setLayout(new FlowLayout());
        options.add(colourCon);
        JLabel colourLabel = new JLabel("Pick your Bike Colour:");
        colourLabel.setFont(smallFont);
        colourLabel.setForeground(Color.WHITE);
        colourCon.add(colourLabel);
        colourCon.add(red);
        colourCon.add(blue);
        colourCon.add(green);
        colourCon.add(yellow);

        Container nameCon = new Container();
        nameCon.setLayout(new FlowLayout());
        options.add(nameCon);
        JLabel nameLabel = new JLabel("Pick your Name: ");
        nameLabel.setFont(smallFont);
        nameLabel.setForeground(Color.WHITE);
        nameField.setFont(smallFont);
        nameCon.add(nameLabel);
        nameCon.add(nameField);


        //creates the instructions card
        JPanel instructions = new JPanel();
        instructions.add(instruct);
        instructions.setBackground(Color.BLACK);

        //adds the cards as tabs to the tabbedpane
        tabbedpane.addTab(MENU, menu);
        tabbedpane.addTab(OPTIONS, options);
        tabbedpane.addTab(INSTRUCTIONS, instructions);

        pane.add(tabbedpane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == exitGame) {
            //exits the game
            System.exit(0);
        }
        else if(source == playGame){
            //loads the light cycles game
            startGame();
        }

        //lets the user change the colour of their bike
        else if(source == red){
            GameGrid.setPlayerColour(red.getBackground()); //sets the bike colour to red
        }

        else if(source == blue){
            GameGrid.setPlayerColour(blue.getBackground()); //sets the bike colour to blue
        }

        else if(source == green){
            GameGrid.setPlayerColour(green.getBackground()); //sets the bike colour to green
        }

        else if(source == yellow){
            GameGrid.setPlayerColour(yellow.getBackground()); //sets the bike colour to yellow
        }

        else if(source == nameField){
            String name = nameField.getText();
            GameGrid.setPlayerName(name);
        }

    }

    private static void startGame(){
        JFrame gameFrame = new JFrame();
        gameFrame.setSize(550, 600);
        gameFrame.setVisible(true);
        gameFrame.add(GameGrid, BorderLayout.CENTER);
        gameFrame.setBackground(Color.BLACK);

        gameFrame.setResizable(false);

        gameFrame.setTitle("LightCycles");
        gameFrame.setLocationRelativeTo(null);
        GameGrid.startGame();
    }
}