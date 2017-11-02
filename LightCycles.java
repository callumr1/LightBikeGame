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


        System.out.println("Welcome to LightCycles!");
        String menu ="\nChoose from one of the following: \n" +
                "1 - Change your Name \n" +
                "2 - Change your Colour \n" +
                "3 - Change the size of the Grid \n" +
                "4 - Change the Controls \n" +
                "5 - Change the Player Limit \n" +
                "6 - Quit Light Cycles";
        int choice = 0;
        while (choice != 6)
        {
            //Loops through the menu while the users choice is not 6
            System.out.println(menu);
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            if (choice == 1) {
                //Allow the user to set their new name
                setPlayerName();
            }
            if (choice == 2) {
                //Allow the user to set their new colour
                setPlayerColour();
            }

            if (choice == 3) {
                //Allow the user to change the size of the grid
                setGridSize();
            }

            if (choice == 4) {
                //Allow the user to change their controls
                setPlayerControls();
            }

            if (choice == 5) {
                //Allow the user to change the maximum number of players allowed to play (under 20)
                setPlayerLimit();
            }

            if (choice == 6)
            {
                //Quits the game
                System.out.println("Thanks for playing Light Cycles");
            }
        }
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
        JTextField nameField = new JTextField("Player 1", 20);
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
            System.exit(0);
        }
        else if(source == playGame){
            //loads the light cycles game
            startGame();
        }

        //lets the user change the colour of their bike
        else if(source == red){
            GameGrid.setPlayerColour(red.getBackground());
        }

        else if(source == blue){
            GameGrid.setPlayerColour(blue.getBackground());
        }

        else if(source == green){
            GameGrid.setPlayerColour(green.getBackground());
        }

        else if(source == yellow){
            GameGrid.setPlayerColour(yellow.getBackground());
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

    private static void setPlayerName()
    {
        //Prompt the user for a new name for their player, and change the players name to the new name
        Scanner n = new Scanner(System.in);
        System.out.print("Enter your player name >>> ");
        String newName = n.nextLine();
        Player1.setPlayerName(newName);
    }

    private static void setPlayerColour()
    {
        //Prompt the user for what colour they would like, and change playerColour and bikeColour to the new colour
        Scanner c = new Scanner(System.in);
        System.out.print("Enter your player colour >>> ");
        String newColour = c.nextLine();
        Player1.setPlayerColour(newColour);
        PlayerBike.setBikeColour(newColour);

    }

    private static void setGridSize()
    {
        //Prompt the user for a width and height, and set the grid size to the new variables
        Scanner h = new Scanner(System.in);
        System.out.print("Enter the Height of the grid >>> ");
        int newHeight = h.nextInt();

        Scanner w = new Scanner(System.in);
        System.out.print("Enter the Width of the grid >>> ");
        int newWidth = w.nextInt();
        GameGrid.setHeight(newHeight);
        GameGrid.setWidth(newWidth);

    }

    private static void setPlayerControls()
    {
        //Prompt the user for their new controls

        //Prompts the user what they would like to change speed up to
        Scanner up = new Scanner(System.in);
        System.out.print("What would you like to change Speed Up to >>> ");
        char newSpeedUp = up.nextLine().charAt(0);

        //Prompts the user what they would like to change slow down to
        Scanner down = new Scanner(System.in);
        System.out.print("What would you like to change Slow Down to >>> ");
        char newSpeedDown = down.nextLine().charAt(0);

        //Prompts the user what they would like to change move left to
        Scanner left = new Scanner(System.in);
        System.out.print("What would you like to change Move Left to >>> ");
        char newMoveLeft = left.nextLine().charAt(0);

        //Prompts the user what they would like to change move right to
        Scanner right = new Scanner(System.in);
        System.out.print("What would you like to change Move Right to >>> ");
        char newMoveRight = right.nextLine().charAt(0);

        //Prompts the user what they would like to change the jetwall toggle to
        Scanner jet = new Scanner(System.in);
        System.out.print("What would you like to change Move Right to >>> ");
        char newJetWall = jet.nextLine().charAt(0);

        //Changes the players specific controls
        Player1.setPlayerControls(newSpeedUp, newSpeedDown, newMoveLeft, newMoveRight, newJetWall);
    }

    private static void setPlayerLimit()
    {
        //Prompt the user for the maximum number of players that can join the game
        Scanner max = new Scanner(System.in);
        System.out.println("What would you like to set the maximum number of players to (it has to be less than 20) >>> ");
        int newMaxPlayers = max.nextInt();

        //Prompts the user for a new number while their input is greater than 20
        while (newMaxPlayers > 20)
        {
            System.out.println("The maximum number of players has to be less than 20");
            Scanner m = new Scanner(System.in);
            System.out.println("What would you like to set the maximum number of players to >>> ");
            newMaxPlayers = m.nextInt();
        }
        GameGrid.setMaxPlayers(newMaxPlayers);
    }
}