/*
 Author: Tiamo Laitakari 
 Tiamo.Laitakari@cs.helsinki.fi
 Copyright (c) 2015 - All rights reserved.
 */
package HopeToFly;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventHandler implements KeyListener {

    MouseHandler mouse;

    public EventHandler() {
        this.mouse = new MouseHandler();
        
    }

    public int ask() {
        return mouse.getMouse();
    }
    
    public int askMenu() {
        return mouse.getMouseMenu();
    }
    
    public boolean askClick(){
        return mouse.mouseClick();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

}
