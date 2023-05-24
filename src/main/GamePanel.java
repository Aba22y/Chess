package main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import pieces.Pawn;
import pieces.Piece;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{
    //SCREEN SETTINGS
    final int originalTile = 16; //16x16 tile
    final int scale = 3; //account for modern screens

    public final int tileSize = originalTile * scale; //48x48 tile
    final int maxScreenCol = 8;
    final int maxScreenRow = 8;

    //A chessboard is 8x8 cells large
    final int screenWidth = tileSize * maxScreenCol; //392 pixels wide
    final int screenLength = tileSize * maxScreenRow;//392 pixels long

    //FPS
    int FPS = 10;

    MouseHandler mouseH = new MouseHandler();
    Thread gameThread;
    Piece[][] board = new Piece[8][8];
    public Piece selected = null;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenLength));
        this.setBackground(Color.blue);
        this.setDoubleBuffered(true);
        this.addMouseListener(mouseH);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(this, this.mouseH, i, 1);
            board[6][i] = new Pawn(this, this.mouseH, i, 6);
            board[2][i] = null;
            board[3][i] = null;
            board[4][i] = null;
            board[5][i] = null;
        }
    }

    //runs the game thread
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    //when an object contains a a thread attribute 
    //this function acts as the process in which the thread is run once
    //once start() is called.

    //Additionally, it aims to satisfy two requirements at each fram
    //1. Update: Ensures that the information is correctly updated.
    //2. Animate: Represent that information on the screen.
    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;//time before each frame
        double drawNext = System.nanoTime() + drawInterval;//calculate next frame time

        //these two variables are used to calculate FPS (not that it really matters in a 10fps game)
        /*int drawCount = 0;
        long lastTime = System.nanoTime();
        long timer = 0;
        long currentTime;
        */
        /*for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.println(board[i][j]);
            }
            System.out.println("\n");;
        }*/

        while(gameThread != null) {
            //currentTime = System.nanoTime();
            update();
            repaint();
            //add the nano-seconds using timer to obtain fps
            /*timer += (currentTime - lastTime);
            lastTime = currentTime;
            drawCount++;

            if (timer > 1000000000) {
                System.out.println(drawCount);
                drawCount = 0;
                timer = 0;
            }*/

            try {
                double remainingTime = drawNext - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime); 
                drawNext += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void update() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    board[i][j].update();
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage boardImage = board();
        g.drawImage(boardImage, 0, 0, maxScreenRow * tileSize, maxScreenCol * tileSize, null);
        Graphics2D g2d = (Graphics2D)g;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    board[i][j].draw(g2d);
                }
            }
        }
        g2d.dispose();
    }

    public BufferedImage board() {
        try {
            return ImageIO.read(getClass().getResourceAsStream("/res/board/board.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
