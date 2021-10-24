package se.iths.lum.javafx;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;


public class HelloController {

    Circle circle;
    Model model;

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField brushSize;

    @FXML
    private Button button;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private CheckBox eraser;

    @FXML
    private TextField textField1;


    public void initialize() {
        GraphicsContext g = canvas.getGraphicsContext2D();

        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(brushSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;

            if (eraser.isSelected()) {
                g.clearRect(x, y, size, size);
            } else
                g.setFill(colorPicker.getValue());
            g.fillRect(x, y, size, size);
        });



    }


    private void draw() {
        GraphicsContext f = canvas.getGraphicsContext2D();
        f.fillOval(brushSize.getHeight(),brushSize.getHeight(), brushSize.getWidth(), brushSize.getWidth());

    }



    private void draw2() {
        var f = canvas.getGraphicsContext2D();
        f.fillRect(brushSize.getWidth(), brushSize.getHeight(), brushSize.getWidth(), brushSize.getHeight());

    }
    private void draw3() {
        var f = canvas.getGraphicsContext2D();
        f.fillRect(brushSize.getHeight(), brushSize.getHeight(), brushSize.getWidth(), brushSize.getWidth());
    }


    public void onSave() {
        try {
            WritableImage snapshot = canvas.snapshot(null, null);

            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", new File("Paint.png"));
        } catch (Exception e) {
            System.out.println("Failed to  save Image" + e);
        }


    }

    public void onExit() {
        Platform.exit();
    }

    public void onButton(MouseEvent event) {
       draw();


    }




    public void onButton1(MouseEvent event) {
      draw2();


    }

    public void onButton2(MouseEvent event) {
        draw3();
       }



    }











