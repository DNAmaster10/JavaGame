package physics;

import com.raylib.Jaylib;
import objects.Level;
import objects.Platform;
import objects.Player;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Default {
    public static void calculate() {
        float frameDelta = Jaylib.GetFrameTime();
        System.out.println("Pre physics vel: " + Player.velocity[1]);
        //Calculate player gravity
        float gravity = Level.gravity;
        Player.addVelocityY(gravity);

        //Limit x speed
        if (Level.limitX && Math.abs(Player.velocity[0]) > Level.xSpeedLimit) {
            if (Player.velocity[0] > 0) {
                Player.velocity[0] = Level.xSpeedLimit;
            }
            else {
                Player.velocity[0] = -Level.xSpeedLimit;
            }
        }
        //Limit y speed
        if (Level.limitY && Math.abs(Player.velocity[1]) > Level.ySpeedLimit) {
            if (Player.velocity[1] > 0) {
                Player.velocity[1] = Level.ySpeedLimit;
            }
            else {
                Player.velocity[1] = -Level.ySpeedLimit;
            }
        }

        //Set new player position based on velocity
        Player.addX(Player.velocity[0] * frameDelta);
        Player.addY(Player.velocity[1] * frameDelta);

        //Check collisions and move player and change velocity depending on collision
        //First, get a bool on whether the player is colliding with anything at all
        //Platforms
        Jaylib.Rectangle playerRect = new Jaylib.Rectangle(Player.x, Player.y, Player.width, Player.height);
        List<Integer> collidingPlatforms = CheckCollision.checkPlatformCollision(playerRect);
        while (collidingPlatforms.get(0).equals(1)) {
            playerRect = new Jaylib.Rectangle(Player.x, Player.y, Player.width, Player.height);
            Platform platform = Level.platforms.get(collidingPlatforms.get(1));
            Jaylib.Rectangle platformRect = new Jaylib.Rectangle(platform.x, platform.y, platform.width, platform.height);
            int collisionSide = GetCollision.rectangle(playerRect, platformRect);
            if (collisionSide == 1) {
                //Move player to top of platform
                Player.setY(platform.y - Player.height);
                //Calculate bounce effect
                if (platform.bounce != 0) {
                    System.out.println("Prebounce y vel: " + Player.velocity[1]);
                    Player.setVelocityY((Player.velocity[1]) * ((platform.bounce / 100f) * -1f));
                    System.out.println("Afterbounce y vel: " + Player.velocity[1]);
                }
                else {
                    Player.setVelocityY(0);
                    Player.onGround = true;
                }
                if (Player.velocity[1] < 0.01f) {
                    Player.setVelocityY(0f);
                }
                //Calculate friction effect
                Player.setVelocityX((Player.velocity[0]) * ((100f - platform.friction) / 100f));
                if (Player.velocity[0] < 0.01f) {
                    Player.setVelocityX(0f);
                }
            }
            else if (collisionSide == 2) {
                //Move player to right of platform
                Player.setX(platform.x + platform.width);
                //Calculate bounce effect
                Player.setVelocityX((Player.velocity[0]) * ((platform.bounce / 100f) * -1f));
                if (Player.velocity[0] < 0.01f) {
                    Player.setVelocityX(0f);
                }
            }
            else if (collisionSide == 3) {
                //Move player to the bottom of the platform
                Player.setY(platform.y + platform.height);
                //Calculate bounce
                Player.setVelocityY((Player.velocity[1]) * ((platform.bounce / 100f) * -1f));
            }
            else if (collisionSide == 4){
                //Move player to left of platform
                Player.setX(platform.x);
                //Calculate bounce effect
                Player.setVelocityX((Player.velocity[0]) * ((platform.bounce / 100f) * -1f));
                if (Player.velocity[0] < 0.01f) {
                    Player.setVelocityX(0f);
                }
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //After this calculation is done, check again that the player isn't colliding with any other shapes
            collidingPlatforms = CheckCollision.checkPlatformCollision(playerRect);
        }
    }
}
