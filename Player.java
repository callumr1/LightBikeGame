import java.util.Scanner;

public class Player {

    private int playerID;
    private String playerName;
    private String playerColour;

    public Player(){
        playerID = 1;
        playerName = "Player" + playerID;
        playerColour = "Red";
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        //Allow the player to set/change their name
        Scanner n = new Scanner(System.in);
        System.out.print("Enter your player name >>> ");
        this.playerName = n.nextLine();
    }

    public String getPlayerColour() {
        return playerColour;
    }

    public void setPlayerColour(String playerColour) {
        //Allow the player to change the colour of their player and bike
        Scanner c = new Scanner(System.in);
        System.out.print("What colour would you like your character to be (Red, Blue, Green, Yellow) >>> ");
        this.playerColour = c.nextLine();
    }
}
