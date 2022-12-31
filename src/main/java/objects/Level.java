package objects;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Level {
    public static Jaylib.Color bgColor;
    public static Jaylib.Color plColor;
    public static float gravity;
    public static List<Platform> platforms = new ArrayList<Platform>();
    private static HashMap<String, Integer> platformsIdMap = new HashMap<>();
    public static void load(String levelName) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream(levelName + ".txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            //Load gravity
            String gravityString = reader.readLine();
            String[] gravityStringArray = gravityString.split(": ");
            gravityString = gravityStringArray[1];
            Level.gravity = parseFloat(gravityString);
            
            //Load background colour
            String bgColour = reader.readLine();
            String[] bgColourArray = bgColour.split(": ");
            bgColour = bgColourArray[1];
            bgColourArray = bgColour.split("#");
            Level.bgColor = new Jaylib.Color(parseInt(bgColourArray[0]), parseInt(bgColourArray[1]), parseInt(bgColourArray[2]), parseInt(bgColourArray[3]));

            //Load player colour
            String plColour = reader.readLine();
            String[] plColourArray = plColour.split(": ");
            plColour = plColourArray[1];
            plColourArray = plColour.split("#");
            Jaylib.Color playerColour = new Jaylib.Color(parseInt(plColourArray[0]), parseInt(plColourArray[1]), parseInt(plColourArray[2]), parseInt(plColourArray[3]));
            Level.plColor = playerColour;
            Player.plColour = playerColour;

            //Load player position
            String plPosition = reader.readLine();
            String[] plPositionArray = plPosition.split(": ");
            plPosition = plPositionArray[1];
            plPositionArray = plPosition.split(",");
            Player.x = parseInt(plPositionArray[0]);
            Player.y = parseInt(plPositionArray[1]);
            Player.velocity[0] = 0f;
            Player.velocity[1] = 0f;

            reader.readLine();
            reader.readLine();

            //Load level objects, such as platforms and triggers

            String[] objectArray;

            while (reader.ready()) {
                String line = reader.readLine();
                objectArray = line.split(",");
                //Rectangle
                if (objectArray[1].equals("platform")) {

                }

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
