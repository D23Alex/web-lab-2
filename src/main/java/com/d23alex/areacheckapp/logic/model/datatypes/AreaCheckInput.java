package com.d23alex.areacheckapp.logic.model.datatypes;

public class AreaCheckInput {
    private Point point;
    private float r;

    public AreaCheckInput(Point point, float r) {
        this.point = point;
        this.r = r;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }
}
