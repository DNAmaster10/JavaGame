package draw;

import objects.Level;

import static com.raylib.Raylib.ClearBackground;

public class DrawLevel {
    public static void draw() {
        ClearBackground(Level.bgColor);
    }
}
