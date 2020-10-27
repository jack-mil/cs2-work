package smileyface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

// Jackson Miller
// COSC2103 Computer Science 2
// 2020-10-27
// Exercise 14.11: Draws a static Smiley face with JavaFX

/* In order for NetBeans to run this project, I had to manually add the JavaFX
*  library because it is no-longer included in the JDK past Java 11
*  to the compile classpath and run module path, as well as set VM args
*  --add-modules javafx.controls
*  These changes will be set in the project files, however I don't know if they 
*  work on other machines, because of difference JavaFX install locations
*  
*  Manual compilation worked the best for me honestly
*  $> javac --module-path $PATH_TO_FX --add-modules javafx.controls -d . src/smileyface/SmileyFace.java
*  $> java --module-path $PATH_TO_FX --add-modules javafx.controls smileyface.SmileyFace
*/
public class SmileyFace extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Set up a 600x600 scene with a single Smile Pane
        Scene scene = new Scene(new Smile(), 600, 600);
        scene.setFill(Color.rgb(29, 32, 33));

        primaryStage.setTitle("Chapter 14 Exercise");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);

        // Display the window
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

class Smile extends Pane {

    public Smile() {
        // Create a head
        Circle head = new Circle(300, 300, 200);
        head.setFill(Color.BLUEVIOLET);

        // Create two eyes
        Circle eye1 = new Circle(150, 180, 80);
        Circle eye2 = new Circle(450, 180, 80);
        eye1.setFill(Color.GREEN);
        eye2.setFill(Color.GREEN);

        // Create a smile
        Arc smile = new Arc(300, 380, 75, 100, 180, 180);

        // Create a nose
        double[] p = { 300, 250, 360, 320, 240, 320 };
        Polygon nose = new Polygon(p);
        nose.setFill(Color.GREEN);

        // Add all the components to this Pane
        getChildren().addAll(head, smile, eye1, eye2, nose);
    }
}