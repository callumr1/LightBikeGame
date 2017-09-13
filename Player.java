import java.util.Scanner;

public class Player {

    private int playerID;
    private String playerName;
    private String playerColour;

    Player(){
        playerID = 1;
        playerName = "Player" + playerID;
        playerColour = "Red";
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID)
    {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    void setPlayerName(String playerName) {
        //Allow the player to set/change their name
        this.playerName = playerName;
        System.out.println("You have changed your name to " + this.playerName);
    }

    public String getPlayerColour() {
        return playerColour;
    }

    void setPlayerColour(String playerColour) {
        //Allow the player to change the colour of their player and bike
        this.playerColour = playerColour;
        System.out.println("You have changed your colour to " + this.playerColour);
    }
}
