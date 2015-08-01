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
    boolean falling;
    
   public void fall(boolean falling){
        this.falling = falling;
    }
    
   public boolean status(){
        return falling;
    }
    
    public PlayerObject()
    {
        this.x = 320;
        this.y = 500;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
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
    
    public void addY(){
        this.y++;
    }
    public void redcY(){
        this.y--;
    }
    
}
