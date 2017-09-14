import java.util.Scanner;

public class Grid {

    private int width;
    private int height;
    private int maxPlayers;
    private int minPlayers;

    Grid(){
        width = 500;
        height = 500;
        maxPlayers = 20;
        minPlayers = 3;
    }

    void setWidth(int width) {
        //Allows the user to change the width of the grid
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    void setHeight(int height) {
        //Allows the user to change the height of the grid
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void displayGrid(int width, int height){
        //displays the GUI for the grid
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }
}
