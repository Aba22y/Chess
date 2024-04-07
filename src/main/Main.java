package main;

//container which inherits the java.awt.Frame class
//JFrame works like the main window or GUI
//Unlike Frame, JFrame has the option to hide or close the window
//Imagine this at the html page and the panel as the canvas
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("2D Chess");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}
