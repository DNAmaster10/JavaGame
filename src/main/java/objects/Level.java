package objects;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.stream.Stream;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Level {
    public static Jaylib.Color bgColor;
    public static Jaylib.Color plColor;
    public static float gravity;
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
            Level.plColor = new Jaylib.Color(parseInt(plColourArray[0]), parseInt(plColourArray[1]), parseInt(plColourArray[2]), parseInt(plColourArray[3]));

            while (reader.ready()) {
                String line = reader.readLine();
                System.out.println(line);
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
