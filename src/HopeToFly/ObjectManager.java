/*
 Author: Tiamo Laitakari 
 Tiamo.Laitakari@cs.helsinki.fi
 Copyright (c) 2015 - All rights reserved.
 */
package HopeToFly;

import HopeToFly.Objects.*;
import HopeToFly.Math.*;
import java.util.ArrayList;

public class ObjectManager {

    PlayerObject Player;
    ArrayList<WishObject> Wishes;
    ArrayList<StarObject> Stars;
    ArrayList<FearObject> Fears;
    Movement pattern;
    int motion = 2;
    int jump = 0;
    int spawnheight = 0;
    int gravityframe = 0;
    int fall = 0;
    boolean ascending = false;

    int score = 0; // Score 

    int newGame = 0; // TEMP TEST
    int lostGame = 0;

    public ObjectManager() {
        this.Player = new PlayerObject();
        this.Wishes = new ArrayList<WishObject>();
        this.Stars = new ArrayList<StarObject>();
        this.Fears = new ArrayList<FearObject>();
        this.pattern = new Movement();
        // We have to do with 8 objects of each type. To help with performance.
        // Although stars and wishesh are linked I'd like to keep the two completely
        // seperated from one another.
        for (int i = 0; i < 8; i++) {
            Wishes.add(new WishObject());
            Stars.add(new StarObject());
            Fears.add(new FearObject());
        }
    }

    public void Init() {
        spawnheight = 0;
        for (int i = 0; i < 8; i++) {
            pattern.setMotion(motion);
            int temp = Wishes.get(i).ret_y();
            Wishes.get(i).respawn(spawnheight);
            spawnheight -= 120;
        }
    }
    public int getState(){
        if(lostGame == 1){
            lostGame = 0;
            Init();
            return 1;
        }
        
        if(newGame == 0){
            return 0;
        }
        return -1;
    }

    public void refresh() {
        for (int i = 0; i < 8; i++) {
            if ((Wishes.get(i).ret_y() > 799) || (Wishes.get(i).PlayerCollision(Player.getX(), Player.getY()) == true)) {

                // See, if a collision happened.
                if (Wishes.get(i).PlayerCollision(Player.getX(), Player.getY()) == true) {
                    //  if (jump == 0) {
                    jump = 15;
                    // }
                    ascending = true;
                    score++;
                    System.out.println("Current score: " + score);
                    Player.fall(false);
                    fall = 0; // Black-magic gravity.
                    newGame = 1;
                }
                // Respawn wish afterwards.
                Wishes.get(i).respawn(spawnheight);
                spawnheight -= 120;
            }

        }
        if (gravityframe == 0) {
            jump = pattern.jump(jump, ascending);

            if (jump >= 17) {
                ascending = false;
            }

            if ((ascending == false) && jump == 0) {
                fall += 2;
                Player.fall(true);
            }
        }
        gravityframe++;

        /* new game condition */
        if (Wishes.get(0).ret_y() < -1800) {
            newGame = 0;
            lostGame = 1;
            jump = 0;
            score = 0;
        }

        if (newGame == 0) {
            motion = jump + 2;
        } else {
            motion = jump - fall;
        }

        pattern.setMotion(motion);
        spawnheight += motion;
        // Defines speed to remain more constant for human eye.
        if (gravityframe == 4) {
            gravityframe = 0;
        }

    }
}
