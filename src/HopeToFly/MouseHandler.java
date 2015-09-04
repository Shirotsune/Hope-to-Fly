/*
 Author: Tiamo Laitakari 
 Tiamo.Laitakari@cs.helsinki.fi
 Copyright (c) 2015 - All rights reserved.
 */
package HopeToFly;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {

    int x = 0;
    int y = 0;
    boolean clicked = false;

    public MouseHandler() {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
 }

    @Override
    public void mousePressed(MouseEvent e) {
        this.clicked = true;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.clicked = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    public int getMouse() {
        return x;
    }

    public int getMouseMenu() {
        return y;
    }

    public boolean mouseClick() {
        return clicked;
    }
}
