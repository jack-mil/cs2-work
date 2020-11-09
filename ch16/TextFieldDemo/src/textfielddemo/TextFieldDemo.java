
package textfielddemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Jackson Miller
// COSC2103 Computer Science 2
// 2020-11-08
// Chapter 16 Assignment: Demonstrate TextField properties

public class TextFieldDemo extends Application {

    @Override
    public void start(Stage stage) {

        // Create text field and label. Format will be controlled by the radio buttons
        TextField tf1 = new TextField("Example Text");
        Label lbTextField = new Label("Text Field", tf1);
        lbTextField.setContentDisplay(ContentDisplay.RIGHT);

        // Create Radio buttons and group them together
        ToggleGroup rbGroup = new ToggleGroup();
        RadioButton rbLeft = new RadioButton("Left");
        RadioButton rbCenter = new RadioButton("Center");
        RadioButton rbRight = new RadioButton("Right");

        rbLeft.setSelected(true);

        rbLeft.setToggleGroup(rbGroup);
        rbCenter.setToggleGroup(rbGroup);
        rbRight.setToggleGroup(rbGroup);

        // Register events to update the text field format
        rbLeft.setOnAction(e -> tf1.setAlignment(Pos.CENTER_LEFT));
        rbCenter.setOnAction(e -> tf1.setAlignment(Pos.CENTER));
        rbRight.setOnAction(e -> tf1.setAlignment(Pos.CENTER_RIGHT));

        // The spinner (with label) selects the column width of the text field
        Spinner<Integer> spSize = new Spinner<>(1, 50, 12);
        spSize.setMaxWidth(65);
        spSize.setEditable(true);
        
        // The change listener updates the text field with new values
        spSize.valueProperty().addListener((ov, oldVal, newVal) -> tf1.setPrefColumnCount(newVal));
        Label lb1 = new Label("Column Size", spSize);
        lb1.setContentDisplay(ContentDisplay.RIGHT);

        // Put the control options together horizontally
        HBox controls = new HBox(rbLeft, rbCenter, rbRight, lb1);
        controls.setAlignment(Pos.CENTER);
        controls.setSpacing(10);

        // Put the text field and controls vertically
        VBox vb = new VBox(10, lbTextField, controls);
        vb.setPadding(new Insets(10));
        vb.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(vb));
        stage.setTitle("Assignment 16: Text Field Demo");

        stage.show();

        // Remove default focus from the text field
        rbLeft.requestFocus();
    }

    // Mandatory main method
    public static void main(String[] args) {
        Application.launch(args);
    }

}
