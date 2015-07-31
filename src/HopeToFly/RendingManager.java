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
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.*;

public class RendingManager extends JPanel {
    
    PlayerObject Player;
    ArrayList<WishObject> Wishes;
    ArrayList<StarObject> Stars;
    ArrayList<FearObject> Fears;

    
    public RendingManager(ObjectManager Object)
    {
        // Object manager passes it's objects for graphic rendering so that the classes may Inter-operate.
        this.Player = Object.Player;
        this.Wishes = Object.Wishes;
        this.Stars = Object.Stars;
        this.Fears = Object.Fears;
 }
      @Override
    protected void paintComponent(Graphics graphics) {
       
    }

    
}
