package physics;

import com.raylib.Jaylib;

public class GetCollision {
    public static int rectangle(Jaylib.Rectangle rectangle1, Jaylib.Rectangle rectangle2) {
        //Returns which side of rectangle2 rectangle1 is most likely colliding with. returns 1 for top, and then 4 for left. Goes clockwise for sides.

        if (rectangle1.y() < rectangle2.y()) {
            return 1;
        }
        else if (rectangle1.y() + rectangle1.height() > rectangle2.y() + rectangle2.height()) {
            return 3;
        }
        else if (rectangle1.x() > rectangle2.x()) {
            return 4;
        }
        else if (rectangle1.x() + rectangle1.width() > rectangle2.x() + rectangle2.width()) {
            return 2;
        }
        else {
            return 5;
        }
    }
}
