/*
 Author: Tiamo Laitakari 
 Tiamo.Laitakari@cs.helsinki.fi
 Copyright (c) 2015 - All rights reserved.
 */
package HopeToFly.Objects;

import java.util.Random;

public class WishObject {

    private int x;
    private int y;
    private Random randomGenerator = new Random();

    private int random_x() {
       
        return randomGenerator.nextInt(600);
    }

    public WishObject() {
        this.x = random_x();
    }

    public int ret_x() {
        return this.x;
    }

    public int ret_y() {
        return this.y;
    }

    public void respawn(int number) {
        this.x = random_x();
        this.y = 0;
        this.y += number;
    }

    public void add_y(int number) {
        this.y += number;
    }
}
