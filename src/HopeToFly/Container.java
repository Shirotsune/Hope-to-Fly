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
    int cursor_x;
    
    
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
        container.add(render);
        frame.addKeyListener(listener);
        frame.addMouseMotionListener(listener.mouse);
        frame.addMouseListener(listener.mouse);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void refresh() {
        render.pass(listener.ask());
        render.passMenu(listener.askMenu());
        render.passClick(listener.askClick());
        render.repaint();
    }

}
