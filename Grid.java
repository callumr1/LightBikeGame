import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Grid extends JPanel implements ActionListener {

    private int width = 550;
    private int height = 550;
    private int gridHeight = 500;
    private int gridWidth = 500;
    private int maxPlayers;
    private int minPlayers;
    private final int dot_size = 10;
    private final int total_dots = 2500;
    private int x[] = new int[total_dots];
    private int y[] = new int[total_dots];
    private int trailX[] = new int[total_dots];
    private int trailY[] = new int[total_dots];
    private int dots;
    private int DELAY = 140;
    private Color playerColour = Color.RED;
    private String playerName = "Player 1";
    private int score = 0;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;
    private boolean boostOn = false;
    private Timer timer;

    Grid(){
        maxPlayers = 20;
        minPlayers = 3;
        addKeyListener(new TAdapter());
        setFocusable(true);
        setPreferredSize(new Dimension(width, height));
        //startGame();
    }

    void startGame(){
        dots = 3;
        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        timer = new Timer(DELAY, this);
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g){
        if (inGame) {
            paintGrid(g);
            paintBike(g);
        }
        else{
            gameOver(g);
            paintScore(g);
        }
    }

    private void paintBike(Graphics bike) {

        for (int z = 0; z < dots; z++) {
            if (z == 0) {
                //draw the bike
                bike.setColor(playerColour);
                bike.fillRect(x[z], y[z], 10, 10);
            }
            else {
                //draw trail
                bike.setColor(playerColour);
                bike.fillRect(x[z], y[z], 10, 10);
            }
        }

    }

    private void paintGrid(Graphics g) {
        //draws the grid
        g.setColor(Color.WHITE);
        for (int x = 10; x <= gridHeight; x += 10)
            for (int y = 10; y <= gridWidth; y += 10)
                g.drawRect(x, y, 10, 10);
    }

    private void gameOver(Graphics g) {
        //Displays "Game Over"
        String msg = "Game Over";
        Font big = new Font("Helvetica", Font.BOLD, 30);
        FontMetrics metr = getFontMetrics(big);

        g.setColor(Color.white);
        g.setFont(big);
        g.drawString(msg, (width - metr.stringWidth(msg)) / 2, height / 2);
    }

    private void paintScore(Graphics g){
        String scoreString = Integer.toString(score);
        String message = (playerName + ": " + scoreString + " points");
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(message, (width - metr.stringWidth(message)) / 2, (height / 2) + 50);
    }

    private void move() {

        if(boostOn){
            score += 2;
        }

        else if (!boostOn){
            score += 1;
        }


        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        //remembers where the trail is so that collisions can be done
        for (int i = 0; i < 500; i++){
            trailX[i] = x[0];
            trailY[i] = y[0];
        }


        if (leftDirection) {
            x[0] -= dot_size;
        }

        if (rightDirection) {
            x[0] += dot_size;
        }

        if (upDirection) {
            y[0] -= dot_size;
        }

        if (downDirection) {
            y[0] += dot_size;
        }
    }

    private void checkCollision() {

        for (int z = gridWidth; z > 0; z--) {
            //System.out.println(z);
            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }
        for (int i = 0; i < trailX.length; i++){
            if ((x[0] == trailX[i]) && (y[0] == trailY[i])){
                inGame = false;
            }
        }

       /* for (int i = 0; i < 500; i += 10){
            System.out.println(x[i]);
            System.out.println(x[0]);
            if ((x[i] == x[0]) && (y[i] == y[0]))
                inGame = false;
        }*/

        /*for (int z = dots; z < y.length; z++){
            if ((z > 4) && (y[z] == y[0]))
                inGame = false;
        }*/

        if (y[0] >= gridHeight) {
            inGame = false;
        }

        if (y[0] < 20) {
            inGame = false;
        }

        if (x[0] >= gridWidth) {
            inGame = false;
        }

        if (x[0] < 20) {
            inGame = false;
        }

        if(!inGame) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            checkCollision();
            move();
        }
        revalidate();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        //checks to see which key has been pressed, and does not let the bike "back track on itself"

        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
            //left key
            leftDirection = true;
            upDirection = false;
            downDirection = false;
        }

        if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
            //right key
            rightDirection = true;
            upDirection = false;
            downDirection = false;
        }

        if ((key == KeyEvent.VK_UP) && (!downDirection)) {
            //up key
            upDirection = true;
            rightDirection = false;
            leftDirection = false;
        }

        if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
            //down key
            downDirection = true;
            rightDirection = false;
            leftDirection = false;
        }

        if (key == KeyEvent.VK_SPACE) {
            //speeds up the bike
            if (boostOn){
                DELAY = 140;
                timer.setDelay(DELAY);
                boostOn = false;
            }
            else {
                DELAY = 70;
                timer.setDelay(DELAY);
                boostOn = true;
            }
        }
        }
    }

    void setPlayerColour(Color colour){
        //Allows the user to change the colour of their bike
        this.playerColour = colour;
    }

    void setPlayerName(String playerName) {
        //Allow the player to set/change their name
        this.playerName = playerName;
    }

    String getPlayerName() {
        return playerName;
    }

    int getPlayerScore(){
        return score;
    }

    void setWidth(int width) {
        //Allows the user to change the width of the grid
        this.width = width;
        System.out.println("The width of the Grid is now set to " + width);
    }

    public int getWidth() {
        return width;
    }

    void setHeight(int height) {
        //Allows the user to change the height of the grid
        this.height = height;
        System.out.println("The height of the Grid is now set to " + height);
    }

    public int getHeight() {
        return height;
    }

    void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        System.out.println("The maximum number of players is now set to " + maxPlayers);
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
