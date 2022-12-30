package objects;

import com.raylib.Jaylib;

import java.io.InputStream;

public class Level {
    public static Jaylib.Color bgColour;
    public static void load(String levelName) {
        InputStream is = Level.class.getClassLoader().getResourceAsStream(levelName + ".txt");
        
    }
}
