package sketch.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import sketch.components.Drawable;

public class FileGenerator {
    private static String version = "0.1";

    public static void generate(ArrayList<Drawable> drawables, String exportLocation) {
        try {
            if (!exportLocation.substring(exportLocation.length()-3).equals(".gs")) {
                exportLocation += ".gs";
            }

            String exportString = exportString(drawables);
            FileWriter file = new FileWriter(exportLocation);

            file.write(exportString);

            file.close();
            System.out.println("wrote to file");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("unable to export file");
        } 
    }

    public static String exportString(ArrayList<Drawable> drawables) {
        StringBuilder exportString = new StringBuilder();
        exportString.append("version-" + version + "\n");
        exportString.append(drawables.get(0).getStart().x + " " + drawables.get(0).getStart().y + ";");
        for (Drawable d : drawables) {
            exportString.append(genCoord(d));
        }

        exportString.append("\nEND");

        return exportString.toString();

    }

    private static String genCoord(Drawable item) {
        return  item.getEnd().x + " " + item.getEnd().y + "-";
    } 
} 
