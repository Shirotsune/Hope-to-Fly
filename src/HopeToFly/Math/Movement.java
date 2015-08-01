/*
 Author: Tiamo Laitakari 
 Tiamo.Laitakari@cs.helsinki.fi
 Copyright (c) 2015 - All rights reserved.
 */
package HopeToFly.Math;

import java.util.Random;

public class Movement {

    static int motion = 0;

    Random randomGenerator = new Random();

    public int getMotion() {
        return motion;
    }

    public void setMotion(int number) {
        this.motion = number;
    }
   
    public int jump(int number, boolean ascending, int boost){
        if (number == 0){
            return 0;
        }
        if(ascending){
        for(int i = 0; i < 20-(3-boost); i++)
        {
            if(number==i){
                return number+1;
            }
        }
        }
        
        for (int i = 0; i < 25; i++){
            if(number==i){
                return number-1;
            }
        }
        return number;
    }

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
