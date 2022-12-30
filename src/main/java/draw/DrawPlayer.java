package draw;

import objects.Player;

import static com.raylib.Jaylib.BLACK;
import static com.raylib.Raylib.DrawRectangle;

public class DrawPlayer {
    public static void draw(Player player) {
        DrawRectangle(player.x, player.y, 100, 150, BLACK);
    }
}
