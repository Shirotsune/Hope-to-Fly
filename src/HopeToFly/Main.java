/*
Author: Tiamo Laitakari 
Tiamo.Laitakari@cs.helsinki.fi
Copyright (c) 2015 - All rights reserved.
 */

package HopeToFly;


public class Main {

    public static void main(String[] args) {

        // Initialize the game by loading one by one the assets.
        ObjectManager Objects = new ObjectManager(); // Responsible of all objects.
        EventHandler Listener = new EventHandler(); // Responsible of the controls.
        RendingManager GUI = new RendingManager(Objects); // Responsible of drawing all game assets.
        SoundManager Sound = new SoundManager(); // Responsible of the sounds.
        Container container = new Container(); // Eats all objects.
        
        // Start game loop.
        for(;;){
            
            
            
        }
        
        
    }
    
}
