/*
 Author: Tiamo Laitakari 
 Tiamo.Laitakari@cs.helsinki.fi
 Copyright (c) 2015 - All rights reserved.
 */
package HopeToFly;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class MouseHandler extends JPanel implements MouseMotionListener {

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
    
    public void mousePressed(MouseEvent e) {
        this.clicked = true;
        
    }
 
    public void mouseReleased(MouseEvent e){
        this.clicked = false;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {

    }
    

    public int getMouse() {
        return x;
    }
    
    public int getMouseMenu(){
        return y;
    }
    
    public boolean mouseClick(){
        return clicked;
    }
}
