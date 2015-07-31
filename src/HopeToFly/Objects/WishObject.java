/*
 Author: Tiamo Laitakari 
 Tiamo.Laitakari@cs.helsinki.fi
 Copyright (c) 2015 - All rights reserved.
 */
package HopeToFly.Objects;

public class WishObject {

    private int x;
    private int y;

    public int ret_x() {
        return this.x;
    }

    public int ret_y() {
        return this.y;
    }
    
    public void respawn(int number){
        this.y = 0;
        this.y += number;
    }
    
    public void add_y(int number){
        this.y += number;
    }
}
