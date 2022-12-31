import com.raylib.Jaylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;
import java.awt.Color;

import com.raylib.Raylib;
import draw.DrawPlayer;
import draw.DrawUi;
import objects.Player;
import objects.Level;

public class Main {
    public static void main(String args[]) {
        InitWindow(800, 800, "Game");
        SetTargetFPS(30);

        Player player = new Player();
        player.x = 100;
        player.y = 100;



        objects.Level.load("level-1");
        Jaylib.Color test = new Jaylib.Color(150,10,20,255);

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
            ClearBackground(test);
            DrawPlayer.draw(player);
            DrawUi.draw();
            EndDrawing();
        }
    }
}