package physics;

import com.raylib.Jaylib;
import objects.Level;
import objects.Platform;

import java.util.ArrayList;
import java.util.List;

public class CheckCollision {
    public static List<Integer> checkPlatformCollision(Jaylib.Rectangle rectangle) {
        //Checks which platforms the rectangle is colliding with. The first item in the returned list is 1 or 0, whether the rectangle is colliding with any rectangles. After that, all items are integers referring to the array location in platforms of the platforms which the rectangle is colliding with.
        List<Integer> collisionList = new ArrayList<Integer>();
        collisionList.add(0, 0);
        boolean collides = false;
        for (int i = 0; i < Level.collisionListPlatforms.size(); i++) {
            Platform currentPlatform = Level.platforms.get(Level.collisionListPlatforms.get(i));
            Jaylib.Rectangle platformRect = new Jaylib.Rectangle(currentPlatform.x, currentPlatform.y, currentPlatform.width, currentPlatform.height);
            if (Jaylib.CheckCollisionRecs(rectangle, platformRect)) {
                collides = true;
                collisionList.add(Level.collisionListPlatforms.get(i));
            }
        }
        if (collides) {
            collisionList.set(0, 1);
        }
        return (collisionList);
    }
}
