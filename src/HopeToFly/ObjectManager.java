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
    int motion = 0;
    int spawnheight = 0;
    
    public ObjectManager(){
        this.Player = new PlayerObject();
        this.Wishes = new ArrayList<WishObject>();
        this.Stars = new ArrayList<StarObject>();
        this.Fears = new ArrayList<FearObject>();
        this.pattern = new Movement();
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
    
    public void Init(){
       for(int i = 0; i < 8; i++)
       {
        pattern.setMotion(1);   
        int temp = Wishes.get(i).ret_y(); 
        Wishes.get(i).add_y(spawnheight);
        spawnheight -=120;
       }
 }
    
    public void refresh(){
      for(int i = 0; i < 8; i++)
      {
          if(Wishes.get(i).ret_y() > 800 ){
              Wishes.get(i).respawn(spawnheight); 
              spawnheight -=120;
          }
      }
        spawnheight++;
       }
}
