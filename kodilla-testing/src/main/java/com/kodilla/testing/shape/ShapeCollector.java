package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        if (!shapes.isEmpty() && shapes.contains(shape)) {
            shapes.remove(shape);
            return true;
        }
        return false;
    }

    public Shape getFigure(int n) {
        if (!shapes.isEmpty()) {
            return shapes.get(n);
        }
        return null;
    }

    public String showFigures() {
        String shapeNames = "";
        for (Shape shape : shapes) {
            shapeNames += shape.getShapeName();
        }
        return shapeNames;
    }
}
