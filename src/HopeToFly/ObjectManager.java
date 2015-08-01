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
    int spawnheight = 720;
    int gravityframe = 0;
    boolean ascending = false;

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
        for (int i = 0; i < 8; i++) {
            pattern.setMotion(motion);
            int temp = Wishes.get(i).ret_y();
            Wishes.get(i).respawn(spawnheight);
            spawnheight -= 120;
        }
    }

    public void refresh() {
        for (int i = 0; i < 8; i++) {
            if ((Wishes.get(i).ret_y() > 799) || (Wishes.get(i).PlayerCollision(Player.getX(), Player.getY()) == true)) {

                // See, if a collision happened.
                if (Wishes.get(i).PlayerCollision(Player.getX(), Player.getY()) == true) {
                    if(jump == 0){
                    jump = 1;}
                    ascending = true;
                }
                // Respawn wish afterwards.
                Wishes.get(i).respawn(spawnheight);
                spawnheight -= 120;
            }

        }
        if (gravityframe == 0) {
            jump = pattern.jump(jump, ascending);
            if (jump == 12) {
                ascending = false;
            }
        }
        gravityframe++;

        motion = jump + 2;

        pattern.setMotion(motion);
        spawnheight += motion;
        if (gravityframe == 4) {
            gravityframe = 0;
        }
    }
}
