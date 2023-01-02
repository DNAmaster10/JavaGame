package physics;

import com.raylib.Jaylib;
import objects.Level;
import objects.Player;

public class Default {
    public static void calculate() {
        float frameDelta = Jaylib.GetFrameTime();

        //Calculate player gravity
        float gravity = Level.gravity;
        Player.addVelocityY((gravity * frameDelta) * -1);

        //Set new player position based on velocity
        Player.addX(Player.velocity[0]);
        Player.addY(Player.velocity[1]);

        //Check collisions and move player and change velocity depending on collision
        //First, get a bool on whether the player is colliding with anything at all
        //Platforms
        for (int i = 0; i < Level.platforms.size(); i++) {

        }
    }
}
