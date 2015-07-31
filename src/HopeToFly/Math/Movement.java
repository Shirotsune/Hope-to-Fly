/*
 Author: Tiamo Laitakari 
 Tiamo.Laitakari@cs.helsinki.fi
 Copyright (c) 2015 - All rights reserved.
 */
package HopeToFly.Math;

import java.util.Random;

public class Movement {

    Random randomGenerator = new Random();

    public int floating_x() {
        int rand = randomGenerator.nextInt(2);

        switch (rand) {

            case 0:
                return -1;
             
            case 1:
                return 0;
               
            case 2:
                return 1;
            default:
                return 0;
        }
    }
}
