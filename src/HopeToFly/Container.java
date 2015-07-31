/*
 Author: Tiamo Laitakari 
 Tiamo.Laitakari@cs.helsinki.fi
 Copyright (c) 2015 - All rights reserved.
 */
package HopeToFly;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Container implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Hope to Fly");
        frame.setPreferredSize(new Dimension(640, 800));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Create(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void Create(java.awt.Container container) {

    }

    public JFrame getFrame() {
        return frame;
    }

    public void refresh() {

    }

}
