package objects;

import com.raylib.Jaylib;

public class Player {
    public static float x;
    public static float y;
    public static float[] velocity = new float[2];
    public static Jaylib.Color plColour;

    public static void addVelocityY (float velocity) {
        Player.velocity[1] = Player.velocity[1] + velocity;
    }

    public static void addVelocityX (float velocity) {
        Player.velocity[0] = Player.velocity[0] + velocity;
    }

    public static void setVelocityX (float velocity) {
        Player.velocity[0] = velocity;
    }

    public static void setVelocityY (float velocity) {
        Player.velocity[1] = velocity;
    }

    public static void setX (float x) {
        Player.x = x;
    }

    public static void setY (float y) {
        Player.y = y;
    }

    public static void addX (float x) {
        Player.x = Player.x + x;
    }

    public static void addY (float y) {
        Player.y = Player.y + y;
    }
}
