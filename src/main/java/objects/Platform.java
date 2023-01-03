package objects;

import com.raylib.Jaylib;

public class Platform {
    public String id;
    public float x;
    public float y;
    public int width;
    public int height;
    public Jaylib.Color color;
    public boolean shouldCollide;
    public String triggerAction;
    public int bounce;
    public int friction;
}
