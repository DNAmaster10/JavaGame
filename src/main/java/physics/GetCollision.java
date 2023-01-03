package physics;

import com.raylib.Jaylib;

public class GetCollision {
    public static int rectangle(Jaylib.Rectangle rectangle1, Jaylib.Rectangle rectangle2) {
        //Returns which side of rectangle2 rectangle1 is most likely colliding with. returns 1 for top, and then 4 for left. Goes clockwise for sides.

        float r1CenterX = (rectangle1.x() + rectangle1.width()) / 2;
        float r1CenterY = (rectangle1.y() + rectangle1.height()) / 2;
        float r2CenterX = (rectangle2.x() + rectangle2.width()) / 2;
        float r2CenterY = (rectangle2.y() + rectangle2.height()) / 2;

        float dx = Math.abs(r1CenterX - r2CenterX);
        float dy = Math.abs(r1CenterY - r2CenterY);

        float width = (rectangle1.width() / 2) + (rectangle2.width() / 2);
        float height = (rectangle1.height() / 2) + (rectangle2.height() / 2);

        if (dx > width && dy <= height) {
            if (r1CenterY < r2CenterY) {
                return (1);
            }
            else {
                return  (3);
            }
        }
        else if (dx <= width && dy > height) {
            if (r1CenterX < r2CenterX) {
                return (4);
            }
            else {
                return (2);
            }
        }
        else {
            return (5);
        }
    }
}
