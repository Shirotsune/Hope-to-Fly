/*
Author: Tiamo Laitakari 
Tiamo.Laitakari@cs.helsinki.fi
Copyright (c) 2015 - All rights reserved.
 */

package HopeToFly;
import HopeToFly.Objects.*;
import java.util.ArrayList;

public class ObjectManager {
    
    PlayerObject Player;
    ArrayList<WishObject> Wishes;
    ArrayList<StarObject> Stars;
    ArrayList<FearObject> Fears;
    
    public ObjectManager(){
        this.Player = new PlayerObject();
        this.Wishes = new ArrayList<WishObject>();
        this.Stars = new ArrayList<StarObject>();
        this.Fears = new ArrayList<FearObject>();
        
        // We have to do with 8 objects of each type. To help with performance.
        // Although stars and wishesh are linked I'd like to keep the two completely
        // seperated from one another.
        for(int i = 0; i<8; i++)
        {
        Wishes.add(new WishObject());
        Stars.add(new StarObject());
        Fears.add(new FearObject());
        }
    }
    
}
