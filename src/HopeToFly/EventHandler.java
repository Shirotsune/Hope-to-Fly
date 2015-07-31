/*
Author: Tiamo Laitakari 
Tiamo.Laitakari@cs.helsinki.fi
Copyright (c) 2015 - All rights reserved.
 */

package HopeToFly;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class EventHandler implements KeyListener {
    
    MouseHandler mouse;
    
    public EventHandler()
            {
             this.mouse = new MouseHandler();   
            }
    
    void getMouse(MouseHandler mouse)
    {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        
    }
    
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        
    }

    @Override
    public void keyTyped(KeyEvent ke)
    {

    }

}
