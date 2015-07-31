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
        RendingManager Render = new RendingManager(Objects); // Responsible of drawing all game assets.
        SoundManager Sound = new SoundManager(); // Responsible of the sounds.
        Container container = new Container(Render, Listener); // Eats all objects.

        container.run();
        // Start game loop.
        int x = 0;
        Boolean y = true;
        for (;;) {

            /* Temporary! */
            try {
                Thread.sleep(20); /* Defines FPS */

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            container.refresh();
            if (y) {
                x += 4;
            } else {
                x -= 4;

            }
            if (x > 1750) {
                y = false;
            }
            if (x < 20) {
                y = true;
            }

            if (y == true) {
                Render.background_y += 4;
                Render.ground_y += 4;
            } else {
                Render.background_y -= 4;
                Render.ground_y -= 4;
            }

        }

    }

}
