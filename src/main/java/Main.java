import com.raylib.Jaylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;
import java.awt.Color;

import draw.DrawPlayer;
import draw.DrawUi;
import objects.Player;

public class Main {
    public static void main(String args[]) {
        InitWindow(800, 800, "Game");
        SetTargetFPS(30);

        Player player = new Player();
        player.x = 100;
        player.y = 100;



        while (!WindowShouldClose()) {
            if (IsKeyDown(KEY_UP)) {
                player.y = player.y - 1;
            }
            if (IsKeyDown(KEY_DOWN)) {
                player.y = player.y + 1;
            }
            if (IsKeyDown(KEY_RIGHT)) {
                player.x = player.x + 1;
            }
            if (IsKeyDown(KEY_LEFT)) {
                player.x = player.x - 1;
            }
            BeginDrawing();
            ClearBackground(WHITE);
            DrawPlayer.draw(player);
            DrawUi.draw();
            EndDrawing();
        }
    }
}
class Level {
    int gravity;

}