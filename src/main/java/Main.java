import com.raylib.Jaylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

import com.raylib.Raylib;
import controls.Move;
import draw.DrawLevel;
import draw.DrawPlayer;
import draw.DrawUi;
import objects.Platform;
import objects.Player;
import objects.Level;
import physics.Default;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        InitWindow(800, 800, "Game");
        SetTargetFPS(30);

        Player.x = 100;
        Player.y = 100;

        objects.Level.load("level-1");

        while (!WindowShouldClose()) {
            if (IsKeyDown(KEY_UP)) {
                Player.y = Player.y - 1;
            }
            if (IsKeyDown(KEY_DOWN)) {
                Player.y = Player.y + 1;
            }
            if (IsKeyDown(KEY_RIGHT)) {
                Player.x = Player.x + 1;
            }
            if (IsKeyDown(KEY_LEFT)) {
                Player.x = Player.x - 1;
            }
            BeginDrawing();
            Move.handleInputs();
            Default.calculate();
            DrawLevel.draw();
            DrawPlayer.draw();
            DrawUi.draw();
            EndDrawing();
        }
    }
}