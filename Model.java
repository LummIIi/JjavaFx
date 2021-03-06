package se.iths.lum.javafx;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Model  {

    private final StringProperty text;
    private final BooleanProperty inColor;
    private final ObjectProperty<Color> color;
    private final Polygon polygon;

    ObservableList<String> observableList =
            FXCollections.observableArrayList();

    List<Shape> shapes = new ArrayList<>();

    public Model() {
        this.polygon = new Polygon();
        this.text = new SimpleStringProperty();
        this.inColor = new SimpleBooleanProperty();
        this.color = new SimpleObjectProperty<>();
        this.shapes = new ArrayList<>();
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public boolean isInColor() {
        return inColor.get();
    }

    public BooleanProperty inColorProperty() {
        return inColor;
    }

    public void setInColor(boolean inColor) {
        this.inColor.set(inColor);
    }

    public String getText() {
        return text.getValue();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    public StringProperty textProperty() {
        return text;
    }

}







