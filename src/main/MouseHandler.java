package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener{
    public boolean mousePressed = false;
    public int x = 0;
    public int y = 0;

    @Override
    public void mouseClicked(MouseEvent e) {
        this.mousePressed = mousePressed==false?true:false;
        this.x = e.getX()/64;
        this.y = e.getY()/64;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
