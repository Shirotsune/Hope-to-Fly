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
import HopeToFly.Math.*;

public class RendingManager extends JPanel {

    PlayerObject Player;
    ArrayList<WishObject> Wishes;
    ArrayList<StarObject> Stars;
    ArrayList<FearObject> Fears;
    int background_y = -1760;
    int tittle_y = 100;
    int ground_y = 680;
    Movement motion;
    int cursor_pos = 0;
    int cursor_y_pos = 0;
    boolean right = true;
    Image FoxState;

    boolean drawmenu = true;
    boolean menuinitflag = false;
    boolean play = false;

    ClassLoader cl = getClass().getClassLoader();
    URL Background_imageURL = cl.getResource("HopeToFly/Assets/bg.jpg");
    Image Background = Toolkit.getDefaultToolkit().createImage(Background_imageURL); //Background -> y values: 0 - (-1760)

    URL tittletextURL = cl.getResource("HopeToFly/Assets/hope_to_fly.png");
    Image tittletext = Toolkit.getDefaultToolkit().createImage(tittletextURL);

    URL Ground_imageURL = cl.getResource("HopeToFly/Assets/maa.png");
    Image Ground = Toolkit.getDefaultToolkit().createImage(Ground_imageURL); //Background -> y values: 0 - (-1760)

    URL Fox_Sitting_imageURL = cl.getResource("HopeToFly/Assets/kettu_istuu.png");
    Image SittingFox = Toolkit.getDefaultToolkit().createImage(Fox_Sitting_imageURL);

    URL Wish_imageURL = cl.getResource("HopeToFly/Assets/kivi_iso.png");
    Image Wish = Toolkit.getDefaultToolkit().createImage(Wish_imageURL);

    URL Fox_UR = cl.getResource("HopeToFly/Assets/kettu_up_r.png");
    Image FoxUpR = Toolkit.getDefaultToolkit().createImage(Fox_UR);

    URL Fox_UL = cl.getResource("HopeToFly/Assets/kettu_up_l.png");
    Image FoxUpL = Toolkit.getDefaultToolkit().createImage(Fox_UL);

    URL FoxJR_URL = cl.getResource("HopeToFly/Assets/kettu_hyppy_r.png");
    Image FoxJR = Toolkit.getDefaultToolkit().createImage(FoxJR_URL);

    URL FoxJL_URL = cl.getResource("HopeToFly/Assets/kettu_hyppy_l.png");
    Image FoxJL = Toolkit.getDefaultToolkit().createImage(FoxJL_URL);

    URL FoxFR_URL = cl.getResource("HopeToFly/Assets/kettu_putoo_r.png");
    Image FoxFR = Toolkit.getDefaultToolkit().createImage(FoxFR_URL);

    URL FoxFL_URL = cl.getResource("HopeToFly/Assets/kettu_putoo_l.png");
    Image FoxFL = Toolkit.getDefaultToolkit().createImage(FoxFL_URL);

    URL play1_URL = cl.getResource("HopeToFly/Assets/play.png");
    Image play1 = Toolkit.getDefaultToolkit().createImage(play1_URL);

    URL play2_URL = cl.getResource("HopeToFly/Assets/play_2.png");
    Image play2 = Toolkit.getDefaultToolkit().createImage(play2_URL);

    public RendingManager(ObjectManager Object) {
        // Object manager passes it's objects for graphic rendering so that the classes may Inter-operate.
        this.Player = Object.Player;
        this.Wishes = Object.Wishes;
        this.Stars = Object.Stars;
        this.Fears = Object.Fears;
        this.motion = Object.pattern;

    }

    void paintIngame(Graphics graphics) { //Ingame rendering.
        graphics.drawImage(Background, 0, background_y, this);
        // graphics.drawImage(tittletext, 0, tittle_y, this);
        graphics.drawImage(Ground, 0, ground_y, this);

        //Player object at Start of game.
        // graphics.drawImage(SittingFox, 260, foxstart_y, this);
        // Drawing Wishes.
        for (int i = 0; i < 8; i++) {
            Wishes.get(i).add_y(motion.getMotion());

            graphics.drawImage(Wish, Wishes.get(i).ret_x(), Wishes.get(i).ret_y(), this);
        }

        if (Player.getX() < cursor_pos - 100) {
            Player.addX(cursor_pos);
            right = true;

        } else if (Player.getX() > cursor_pos - 100) {
            Player.reduceX(cursor_pos);
            right = false;

        }
        if (right) {
            if (Player.status() == false) {
                FoxState = FoxUpR;
            } else {
                FoxState = FoxFR;
            }
            graphics.drawImage(FoxState, Player.getX(), Player.getY(), this);
        } else {
            if (Player.status() == false) {
                FoxState = FoxUpL;
            } else {
                FoxState = FoxFL;
            }
            graphics.drawImage(FoxState, Player.getX(), Player.getY(), this);
        }

        //graphics.drawImage(FoxUpR, Player.getX(), 300, this);
    }

    public void manageState() {
        if (drawmenu == true) {
            this.drawmenu = false;
        } else {
            this.drawmenu = true;
        }
    }

    public void newGame() {
        this.drawmenu = true;
        this.menuinitflag = true;
    }

    public boolean initFlag() {
        return menuinitflag;
    }

    void paintMenu(Graphics graphics) {
        graphics.drawImage(Background, 0, background_y, this);
        graphics.drawImage(tittletext, 0, tittle_y, this);
        graphics.drawImage(Ground, 0, ground_y, this);
        graphics.drawImage(SittingFox, 280, (ground_y - 80), this);

        // XXX propably can be done better... :P
        if ((327 > cursor_pos) && (cursor_pos > 245) && (481 < cursor_y_pos) && (cursor_y_pos < 597)) {
            play = true;
        } else {
            play = false;
        }

        if (play == true) {
            graphics.drawImage(play2, 200, 460, this);
        } else {
            graphics.drawImage(play1, 200, 460, this);
        }

    }

    @Override
    protected void paintComponent(Graphics graphics) {

        if (drawmenu == true) {
            paintMenu(graphics);
        } else {
            paintIngame(graphics); //Ingame rendering.
        }
    }

    public void pass(int number) {
        this.cursor_pos = number;
    }

    public void passMenu(int number) {
        this.cursor_y_pos = number;
    }

    public void passClick(boolean state) {
        if (state == true) {

            if ((play == true) && drawmenu == true) {
                manageState();
            }
        }
    }

}
