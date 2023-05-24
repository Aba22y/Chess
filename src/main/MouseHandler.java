package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener{
    public boolean mousePressed = false;
    public int x = 0;
    public int y = 0;

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.mousePressed = true;
        this.x = e.getX()/48;
        this.y = e.getY()/48;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.mousePressed = false;
        this.x = 0;
        this.y = 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
