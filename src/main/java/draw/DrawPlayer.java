package draw;

import objects.Player;

import static com.raylib.Jaylib.BLACK;
import static com.raylib.Raylib.DrawRectangle;

public class DrawPlayer {
    public static void draw() {
        DrawRectangle(Math.round(Player.x), Math.round(Player.y), Player.width, Player.height, Player.plColour);
    }
}
