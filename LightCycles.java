import javafx.scene.effect.Light;

import java.util.Scanner;

public class LightCycles {

    private static Player Player1 = new Player();
    private static Grid GameGrid = new Grid();
    private static Bike PlayerBike = new Bike();
    public static void main(String args[])
    {

        System.out.println("Welcome to LightCycles!");
        System.out.println("Choose from one of the following");
        System.out.println("1 - Change your Name");
        System.out.println("2 - Change your Colour");
        System.out.println("3 - Change the size of the Grid");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if (choice == 1)
        {
            //Allow the user to set their new name
            setPlayerName();
        }
        if (choice == 2)
        {
            //Allow the user to set their new colour
            setPlayerColour();
        }

        if (choice == 3)
        {
            //Allow the user to change the size of the grid
            setGridSize();
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
}