package se.iths.lum.javafx;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.function.UnaryOperator;

public class HelloController {

    Model model;

    public TextField textField1;
    public Canvas canvas;
    @FXML
    private Label welcomeText;
    @FXML
    private CheckBox checkBox1;

    public void initialize() {
        model = new Model();
        model.textProperty().bindBidirectional(textField1.textProperty());
        welcomeText.textProperty().bind(model.textProperty());

        textField1.disableProperty().bind(checkBox1.selectedProperty().not());
    }

    @FXML
    protected void onHelloButtonClick() {
        model.setText("Button pressed");
    }
    @FXML
    public void onCheckBoxChecked() {

    }

    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getX() + ":" + mouseEvent.getY());
        System.out.println(mouseEvent.getSceneX() + ":" + mouseEvent.getSceneY());
        System.out.println(mouseEvent.getScreenX() + ":" + mouseEvent.getScreenY());
    }

    public void keyTyped(KeyEvent keyEvent) {
//        System.out.println(keyEvent.getCharacter());
//        String text = textField1.getText();
//        if (text.length() > 5)
//            textField1.setText(text.substring(0, text.length() - 1));
    }

    public void canvasClicked(MouseEvent event) {
        System.out.println("Clicked on canvas");
        var context = canvas.getGraphicsContext2D();
        context.fillOval(event.getX(),event.getY(),25,25);
    }
}