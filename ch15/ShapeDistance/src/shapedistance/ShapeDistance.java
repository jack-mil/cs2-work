package shapedistance;


import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// Jackson Miller
// COSC2103 Computer Science 2
// 2020-11-07
// Chapter 15.16 Two Movable Vertices. 
// This program displays two movable shapes and displays the distance between them

public class ShapeDistance extends Application {

    private MeasureLine line;
    private Circle shape1;
    private Ellipse shape2;
    private Pane canvas;

    @Override
    public void start(Stage stage) {
        canvas = new Pane();

        // Shape 1, Circle
        shape1 = new Circle(40, 40, 10, Color.web("#EBBD2F")); // x, y, radius, fill (yellow)
        // Register mouse dragged event to private method below
        shape1.setOnMouseDragged(e -> moveShape(e));

        // Using listeners to update the line because this chapter is about that
        // Binding would probably be better normally
        shape1.centerXProperty().addListener(ov -> updateLine());
        shape1.centerYProperty().addListener(ov -> updateLine());

        // Shape 2, Ellipse
        shape2 = new Ellipse(120, 150, 8, 15); // x, y, radiusX, radiusY
        shape2.setFill(Color.web("#EBBD2F")); // Yellow
        shape2.setOnMouseDragged(e -> moveShape(e));
        shape2.centerXProperty().addListener(ov -> updateLine());
        shape2.centerYProperty().addListener(ov -> updateLine());

        // The line between both shapes
        // It has special properties length and midpoint to display in the text label
        line = new MeasureLine(shape1.getCenterX(), shape1.getCenterY(), shape2.getCenterX(), shape2.getCenterY());
        line.setStroke(Color.web("#96BB26")); // Green

        Text distance = new Text();
        distance.setFill(Color.web("#FB3D36")); // Red
        distance.setFont(Font.font("Consolas", FontWeight.BOLD, 16.0));
        
        // Text is kept updated with line length (distance between shapes) and 
        // midpoint position
        distance.textProperty().bind(Bindings.format("%.0f", line.lengthProperty()));
        distance.xProperty().bind(line.midXProperty());
        distance.yProperty().bind(line.midYProperty());

        canvas.getChildren().addAll(line, shape1, shape2, distance);

        Scene scene = new Scene(canvas, 400, 400, Color.web("#1D2021")); // Grey background
        stage.setScene(scene);

        stage.show();
    }

    /**
     * Move the line endpoints to the center of each shape
     */
    private void updateLine() {
        line.setStartX(shape1.getCenterX());
        line.setStartY(shape1.getCenterY());

        line.setEndX(shape2.getCenterX());
        line.setEndY(shape2.getCenterY());
    }

    /**
     * Move a shape around by dragging the mouse on it
     * @param e The mouse event that fired
     */
    private void moveShape(MouseEvent e) {
        Object s = e.getSource();
        
        // Get mouse cursor position, constrained to canvas size
        double x = Math.min(Math.max(e.getX(), 0), canvas.getWidth());
        double y = Math.min(Math.max(e.getY(), 0), canvas.getHeight());

        // Move the shape to the mouse cursor
        if (s instanceof Ellipse) {
            ((Ellipse) s).setCenterX(x);
            ((Ellipse) s).setCenterY(y);
        } else {
            ((Circle) s).setCenterX(x);
            ((Circle) s).setCenterY(y);
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
