import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class task2 {

    public static Circle circle;
    public static List<Point> points = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide 2 argument's with paths to required files");
            return;
        }

        processInput(args);
        
        // Findig results
        for (Point point : points) {
            double distance = Math.sqrt(Math.pow(point.x - circle.x, 2) +
                                        Math.pow(point.y - circle.y, 2));
            
            
            if (distance == 0) System.out.println(0);
            else if (distance < circle.radius) System.out.println(1);
            else System.out.println(2);
        }

        // Debug, bruh =)
        // System.out.println("Circle Coordinates are: " + circle.x + " " + circle.y);
        // System.out.println("Circle radius is: " + circle.radius);
        // for (Point point : points) {
        //     System.out.println("Point coordinates: " + point.x + " " + point.y);
        // }
    }

    public static void processInput(String[] args) {
        try {
            circle = new Circle(Files.readAllLines(Paths.get(args[0])));
        } catch (IOException e) {
            System.out.println("Issue parsing cirlce path: " + args[0]);
        }
    
        try {
            List<String> pointsData = Files.readAllLines(Paths.get(args[1]));
            for (String pointLine : pointsData) {
                points.add(new Point(pointLine));
            }
        } catch (IOException e) {
            System.out.println("Trouble parsing points path");
        }
    }

    public static class Circle {
        public double x;
        public double y;
        public double radius;

        public Circle(List<String> circleData) {
            String[] circleCoords = circleData.get(0).split(" ");
            x = Double.parseDouble(circleCoords[0]);
            y = Double.parseDouble(circleCoords[1]);
            radius = Double.parseDouble(circleData.get(1));
        }
    }

    public static class Point {
        public double x;
        public double y;
    
        public Point(String pointData) {
            String[] pointCoords = pointData.split(" ");
            x = Double.parseDouble(pointCoords[0]);
            y = Double.parseDouble(pointCoords[0]);
        }
    }
}
