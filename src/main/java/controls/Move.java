package controls;

import objects.Player;

import static com.raylib.Raylib.*;

public class Move {
    public static void handleInputs() {
        if (Player.onGround) {
            if (IsKeyDown(KEY_SPACE)) {
                System.out.println("Jumped!");
                Player.onGround = false;
                Player.addVelocityY(-100);
            }
            if (IsKeyDown(KEY_A)) {
                Player.addVelocityX(-30);
            }
            if (IsKeyDown(KEY_D)) {
                Player.addVelocityX(30);
            }
        }
        else {
            if (IsKeyDown(KEY_A)) {
                Player.addVelocityX(-5);
            }
            if (IsKeyDown(KEY_D)) {
                Player.addVelocityX(5);
            }
        }
    }
}
