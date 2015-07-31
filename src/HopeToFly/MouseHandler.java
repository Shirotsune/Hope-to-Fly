/*
 Author: Tiamo Laitakari 
 Tiamo.Laitakari@cs.helsinki.fi
 Copyright (c) 2015 - All rights reserved.
 */
package HopeToFly;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class MouseHandler extends JPanel implements MouseMotionListener {

    int x = 0;

    public MouseHandler() {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.x = e.getX();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    public int getMouse() {
        return x;
    }
}
