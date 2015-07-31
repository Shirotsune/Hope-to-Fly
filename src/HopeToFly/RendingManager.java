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
import java.awt.Image;
import java.net.URL; 
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
    int background_y = -1760;
    int ground_y = 680;
    
    ClassLoader cl = getClass().getClassLoader();
    URL Background_imageURL = cl.getResource("HopeToFly/Assets/bg.jpg");
    Image Background = Toolkit.getDefaultToolkit().createImage(Background_imageURL); //Background -> y values: 0 - (-1760)
    
    URL Ground_imageURL = cl.getResource("HopeToFly/Assets/maa.png");
    Image Ground = Toolkit.getDefaultToolkit().createImage(Ground_imageURL); //Background -> y values: 0 - (-1760)
    
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
       // super.paintComponent(graphics);
        graphics.drawImage(Background, 0, background_y, this);
        graphics.drawImage(Ground, 0, ground_y, this);
       
    }

    
}
