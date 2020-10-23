// Jackson Miller
// COSC2103 Computer Science 2
// 2020-10-23
// Chapter 13 Programing Exercise: Sum Areas
package geometricobject;

import java.util.Scanner;

/*
(Sum the areas of geometric objects) Write a method that sums the areas of all the geometric objects in an array. The method signature is:public static double sumArea(GeometricObject[] a)Write a test program that creates an array of four objects (two circles and two rectangles) and computes their total area using the sumArea method
*/

public abstract class GeometricObject {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        GeometricObject[] objects = new GeometricObject[4];

        // Prompt the user for sizes of circles
        String p1 = "Enter the radius of the %s circle: ";
        System.out.printf(p1, "first");
        objects[0] = new Circle(input.nextDouble());
        System.out.printf(p1, "second");
        objects[1] = new Circle(input.nextDouble());

        // Prompt the user for sizes of rectangles
        String p2 = "Enter the length and width of the %s rectangle: ";
        System.out.printf(p2, "first");
        objects[2] = new Rectangle(input.nextDouble(), input.nextDouble());
        System.out.printf(p2, "second");
        objects[3] = new Rectangle(input.nextDouble(), input.nextDouble());

        // Calculate and display the total area
        System.out.printf("The total area is: %.5f units²\n", sumArea(objects));

        input.close();
    }

    /**
     * Add the total area of many geometric shapes
     * 
     * @param a An array of Geometric Objects
     * @return The total area of all objects in a
     */
    public static double sumArea(GeometricObject[] a) {
        double sum = 0;
        for (GeometricObject shape : a) {
            sum += shape.getArea();
        }

        return sum;
    }

    /** Abstract Area method to be implemented in subclasses */
    public abstract double getArea();
}
