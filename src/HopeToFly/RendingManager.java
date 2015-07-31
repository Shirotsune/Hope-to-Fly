/*
Author: Tiamo Laitakari 
Tiamo.Laitakari@cs.helsinki.fi
Copyright (c) 2015 - All rights reserved.
 */

package HopeToFly;

/* Currently using this for rending, a different aspect might be chosen later on. */
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import javax.swing.SwingUtilities;
/* End of javax.swing*/

import HopeToFly.Objects.*;

import java.util.ArrayList;


public class RendingManager implements Runnable {
    
    PlayerObject Player;
    ArrayList<WishObject> Wishes;
    ArrayList<StarObject> Stars;
    ArrayList<FearObject> Fears;
    private JFrame frame;
    
    public RendingManager(ObjectManager Object)
    {
        // Object manager passes it's objects for graphic rendering so that the classes may Inter-operate.
        this.Player = Object.Player;
        this.Wishes = Object.Wishes;
        this.Stars = Object.Stars;
        this.Fears = Object.Fears;
    
        this.run();
        
        }
    
    @Override
    public void run() 
    {
        frame = new JFrame("Hope to Fly");
        frame.setPreferredSize(new Dimension(640, 800));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Create(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
        private void Create(Container container) 
    {
       // container.add(); 
        
        //
    }

    public JFrame getFrame() 
    {
        return frame;
    }

    public void refresh()
    {
       
    }
    
}
