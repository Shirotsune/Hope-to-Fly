/*
Author: Tiamo Laitakari 
Tiamo.Laitakari@cs.helsinki.fi
Copyright (c) 2015 - All rights reserved.
 */

package HopeToFly;

import HopeToFly.Objects.*;

import java.util.ArrayList;

/**
 *
 * @author Blackstorm
 */
public class RendingManager {
    
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
    
}
