//GitHub Repository: https://github.com/callumr1/CP2406-Assignment1
import java.util.Scanner;

public class LightCycles {

    private static Player Player1 = new Player();
    private static Grid GameGrid = new Grid();
    private static Bike PlayerBike = new Bike();


    public static void main(String args[])
    {
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