import processing.core.*;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class drawPoints extends PApplet {

	public void settings() {
    size(500, 500);
	}
  
	public void setup() {
    	background(180);
    	noLoop();
  	}

  	public void draw() {

   	double x, y;
   
   	String[] lines = loadStrings("newPoints.txt");
   	println("there are " + lines.length);
  		for (int i=0; i < lines.length; i++){
      	if (lines[i].length() > 0 ) {
        		String[] words= lines[i].split(",");
        		x = Double.parseDouble(words[0]);
        		y = Double.parseDouble(words[1]);
        		println("xy: " + x + " " + y);
        		ellipse((int)x, (int)y, 1, 1);
      	}
  		}
  	}

  	public static void main(String args[]) {
		List<Point> thePoints = new ArrayList<>();

		readInPoints(thePoints);

		List<Point> TranslatedPoints =
				thePoints.stream()

						.map(p -> new Point(p.getX() * 0.5,
								p.getY() * 0.5,
								p.getZ()))
						.map(p -> new Point(p.getX() - 150,
								p.getY() - 37,
								p.getZ()))

						.filter(p -> p.getZ() <= 2.0)
						.collect(Collectors.toList());
		writePoints(TranslatedPoints);

		PApplet.main("drawPoints");
   }

	public static void readInPoints(List<Point> students)
	{
		try
		{
			Scanner sc = new Scanner(new File("positions.txt"));
			while (sc.hasNext())
			{
				String line = sc.nextLine();
				String [] nums = line.split(",");

				students.add(new Point(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]), Double.parseDouble(nums[2])));
			}
		}
		catch (Exception e)
		{
			System.out.println("Can't open input file.");
		}

	}
	public static void writePoints(List<Point>  Points)
	{
		try
		{
			PrintStream ps = new PrintStream("newPoints.txt");

			for (Point p : Points)
			{
				ps.println(p.getX() + ", " + p.getY() + ", " + p.getZ());
			}
		}
		catch (Exception e)
		{
			System.out.println("Can't open output file.");
		}
	}
}
