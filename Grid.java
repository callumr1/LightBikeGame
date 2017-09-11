import java.util.Scanner;

public class Grid {

    private int width;
    private int height;

    public Grid(){
        width = 20;
        height = 20;
    }

    public void setWidth(int width) {
        //Allows the user to change the width of the grid
        Scanner w = new Scanner(System.in);
        System.out.print("Enter your player name >>> ");
        this.width = w.nextInt();
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        //Allows the user to change the height of the grid
        Scanner h = new Scanner(System.in);
        System.out.print("Enter your player name >>> ");
        this.height = h.nextInt();
    }

    public int getHeight() {
        return height;
    }

    public void displayGrid(int width, int height){
        //displays the GUI for the grid
    }
}
