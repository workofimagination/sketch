package sketch.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import sketch.components.Coordinate;
import sketch.components.Drawable;
import sketch.components.Line;

public class GSParser {
    public static ArrayList<Drawable> parse(String filePath) throws FileNotFoundException {
        // .gs parser v1 Carter R.

        ArrayList<Drawable> drawables = new ArrayList<Drawable>();
        
        File file = new File(filePath);
        Scanner reader = new Scanner(file);

        ArrayList<String> parts = new ArrayList<String>();

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            parts.add(line);
        }

        reader.close();

        String[] points = parts.get(1).split("-|;");
        Coordinate prevPoint = toCord(points[0]);

        for(int i = 1; i < points.length; i++) {
            Coordinate current = toCord(points[i]);
            Line line = new Line(prevPoint, current);
            drawables.add(line);
            prevPoint = current;
        }

        return drawables;
    }

    private static Coordinate toCord(String point) {
        String[] doubles = point.split(" ");

        return new Coordinate(Double.parseDouble(doubles[0]), Double.parseDouble(doubles[1]));
    }
}
