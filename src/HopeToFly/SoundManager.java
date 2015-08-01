/*
 Author: Tiamo Laitakari 
 Tiamo.Laitakari@cs.helsinki.fi
 Copyright (c) 2015 - All rights reserved.
 */
package HopeToFly;

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
import HopeToFly.Math.*;
import javax.sound.sampled.*;
import java.io.*;

public class SoundManager {

    public void Play() {
        try {
            ClassLoader cl = getClass().getClassLoader();
            URL Music = cl.getResource("HopeToFly/Assets/lumimusa-v1.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(Music);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            // clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            //  clip Music = clip.open(AudioSystem.getAudioInputStream(
            // new BufferedInputStream(getClass().getResourceAsStream("HopeToFly/Assets/lumimusa-v1.wav"))));

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
