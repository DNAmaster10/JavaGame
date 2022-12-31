import com.raylib.Jaylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

import com.raylib.Raylib;
import draw.DrawLevel;
import draw.DrawPlayer;
import draw.DrawUi;
import objects.Platform;
import objects.Player;
import objects.Level;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        InitWindow(800, 800, "Game");
        SetTargetFPS(30);

        Player player = new Player();
        player.x = 100;
        player.y = 100;

        List<Platform> list = new ArrayList<Platform>();
        list.add(new Platform());
        list.add(new Platform());
        list.get(0).bounce = 1;
        list.get(1).bounce = 10;

        objects.Level.load("level-1");

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
            DrawLevel.draw();
            DrawPlayer.draw(player);
            DrawUi.draw();
            EndDrawing();
        }
    }
}