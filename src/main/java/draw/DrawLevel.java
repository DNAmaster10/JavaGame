package draw;

import com.raylib.Jaylib;
import objects.Level;
import objects.Platform;

import static com.raylib.Raylib.ClearBackground;

public class DrawLevel {
    public static void draw() {
        //Non-object stuff
        ClearBackground(Level.bgColor);

        //Objects (Platforms e.t.c)
        //Draw platforms
        for (int i = 0; i < Level.platforms.size(); i++) {
            Platform currentPlatform = Level.platforms.get(i);
            Jaylib.DrawRectangle(Math.round(currentPlatform.x), Math.round(currentPlatform.y), currentPlatform.width, currentPlatform.height, currentPlatform.color);
        }
    }
}
