package shapedistance;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.scene.shape.Line;

/**
 * The MeasureLine class is a Line with special derived properties for length
 * and midpoint
 */
public class MeasureLine extends Line {

    // Readonly Length property, calculated in `getLength()`
    private final ReadOnlyDoubleWrapper length;
    
    private final ReadOnlyIntegerWrapper midX;
    private final ReadOnlyIntegerWrapper midY;
    
    
    public MeasureLine(double startX, double startY, double endX, double endY) {
        // Call Line superclass constructor
        super(startX, startY, endX, endY);

        // Create ReadOnlyProperties
        this.length = new ReadOnlyDoubleWrapper();
        // Track endpoints and update length property value according to getLength method
        this.length.bind(Bindings.createDoubleBinding(() -> getLength(), 
                            startXProperty(), startYProperty(), endXProperty(), endYProperty()));
        
        this.midX = new ReadOnlyIntegerWrapper();
        this.midY = new ReadOnlyIntegerWrapper();
        
        // Track endpoints and update midX and Y properties according to midPoint method
        this.midX.bind(Bindings.createIntegerBinding(() -> midPoint(getStartX(), getEndX()), 
                             startXProperty(), endXProperty()));
        this.midY.bind(Bindings.createIntegerBinding(() -> midPoint(getStartY(), getEndY()), 
                            startYProperty(), endYProperty()));
    }
    
    /** @return The length of the line property */
    public ReadOnlyDoubleProperty lengthProperty() { return this.length.getReadOnlyProperty(); }
    /** @return The Midpoint X value property */
    public ReadOnlyIntegerProperty midXProperty() { return this.midX.getReadOnlyProperty(); }
    /** @return The Midpoint Y value property */
    public ReadOnlyIntegerProperty midYProperty() { return this.midY.getReadOnlyProperty(); }

    /**
     * Get the length of this line, from endpoint to endpoint
     * Use `lengthProperty` for binding
     * @return length of line
     */
    public double getLength() {
        return Math.sqrt(Math.pow(getStartX() - getEndX(), 2) + 
                     Math.pow((getStartY() - getEndY()), 2));
    }

    /**
     * Private helper method for calculating midpoint properties
     * @param start point
     * @param end point
     * @return positional midpoint
     */
    private int midPoint(double start, double end) {
        return (int) (Math.min(start, end) + Math.abs(start - end) / 2);
    }


}
