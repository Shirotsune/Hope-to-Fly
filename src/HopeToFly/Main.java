/*
 Author: Tiamo Laitakari 
 Tiamo.Laitakari@cs.helsinki.fi
 Copyright (c) 2015 - All rights reserved.
 */
package HopeToFly;

public class Main {

    // Java-Runtime bug seems to exsist. (Corruption resulting in virtual machine crash.)
    // Netbeans debug seems to have occasionally issues, bugs might not be java runtime related?
    public static void main(String[] args) {

        // Initialize the game by loading one by one the assets.
        ObjectManager Objects = new ObjectManager(); // Responsible of all objects.
        EventHandler Listener = new EventHandler(); // Responsible of the controls.
        RendingManager Render = new RendingManager(Objects); // Responsible of drawing all game assets.
        SoundManager Sound = new SoundManager(); // Responsible of the sounds.
       // SoundManager does not work in ubuntu, if drivers are not updated.
        Container container = new Container(Render, Listener); // Eats all objects.

        container.run();
        // Start game loop.
        int x = 0;
        int start = 0;
        Boolean y = true;

        Objects.Init();
      //  Sound.Play(); // >> Does not work in Ubuntu, if drivers are not updated.
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

                if (Objects.Player.status() == false) {
                    Render.background_y++;
                } else {
                    Render.background_y--;
                    x--;
                }
              //  Render.foxstart_y++;
              //  Render.ground_y++;
            }
            //        Render.wish_y+=2;
        }

    }

}
