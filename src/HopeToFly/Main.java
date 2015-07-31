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

        Objects.Init();
        for (;;) {

            /* Temporary! */
            try {
                Thread.sleep(20); /* Defines FPS */

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Objects.refresh();
            container.refresh();

            if (x < 1750) {
                x++;
                Render.background_y++;
            }
            //        Render.wish_y+=2;
        }

    }

}
