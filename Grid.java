import java.util.Scanner;

public class Grid {

    private int width;
    private int height;

    Grid(){
        width = 20;
        height = 20;
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
}
