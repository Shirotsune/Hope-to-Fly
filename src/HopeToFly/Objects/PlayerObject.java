/*
Author: Tiamo Laitakari 
Tiamo.Laitakari@cs.helsinki.fi
Copyright (c) 2015 - All rights reserved.
 */
package HopeToFly.Objects;


public class PlayerObject {
    
    int x;
    int y;
    int redc = 0;
    int add = 0;
    
    public PlayerObject()
    {
        this.x = 320;
        this.y = 50;
    }
    
    public int getX(){
        return this.x;
    }
    public void addX(int cursor){
        cursor -=100;
        redc = 0;
        if(add < 10){
        add++;
        }
        x+=add;
        if(x > cursor){
            x = cursor;
        }
    }
    
    public void reduceX(int cursor){
         cursor -=100;
        add = 0;
        if(redc < 10){
        redc++;
        }
        x-=redc;
         if(x < cursor){
            x = cursor;
        }
       
    }
    
}
