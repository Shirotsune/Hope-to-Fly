/*
 Author: Tiamo Laitakari 
 Tiamo.Laitakari@cs.helsinki.fi
 Copyright (c) 2015 - All rights reserved.
 */
package HopeToFly;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Container extends JPanel implements Runnable  {

    private JFrame frame;
    RendingManager render;
    EventHandler listener;
    
    @Override
    public void run() {
        frame = new JFrame("Hope to Fly");
        frame.setPreferredSize(new Dimension(640, 800));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Create(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public Container(RendingManager render, EventHandler listener)
    {
         this.listener = listener;
         this.render = render;
    }
    
    private void Create(java.awt.Container container) {
        
        frame.addKeyListener(listener);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void refresh() {

    }

}
