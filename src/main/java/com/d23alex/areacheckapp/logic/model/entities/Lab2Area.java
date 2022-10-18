package com.d23alex.areacheckapp.logic.model.entities;

import com.d23alex.areacheckapp.logic.model.datatypes.Point;

public class Lab2Area implements Area {

    private AreaContainsPointStrategy topRightStrategy;
    private AreaContainsPointStrategy topLeftStrategy;
    private AreaContainsPointStrategy bottomRightStrategy;
    private AreaContainsPointStrategy bottomLeftStrategy;

    public Lab2Area(AreaContainsPointStrategy topRightStrategy, AreaContainsPointStrategy topLeftStrategy, AreaContainsPointStrategy bottomRightStrategy, AreaContainsPointStrategy bottomLeftStrategy) {
        this.topRightStrategy = topRightStrategy;
        this.topLeftStrategy = topLeftStrategy;
        this.bottomRightStrategy = bottomRightStrategy;
        this.bottomLeftStrategy = bottomLeftStrategy;
    }

    public boolean containsPoint(Point point, float r) {
        if (point.getX() > 0 && point.getY() > 0)
            return topRightStrategy.contains(point, r);
        else if (point.getX() < 0 && point.getY() > 0)
            return topLeftStrategy.contains(point, r);
        else if (point.getX() > 0 && point.getY() < 0)
            return bottomRightStrategy.contains(point, r);
        else if (point.getX() < 0 && point.getY() < 0)
            return bottomLeftStrategy.contains(point, r);
        return false;
        
    }



    public AreaContainsPointStrategy getTopRightStrategy() {
        return topRightStrategy;
    }

    public void setTopRightStrategy(AreaContainsPointStrategy topRightStrategy) {
        this.topRightStrategy = topRightStrategy;
    }

    public AreaContainsPointStrategy getTopLeftStrategy() {
        return topLeftStrategy;
    }

    public void setTopLeftStrategy(AreaContainsPointStrategy topLeftStrategy) {
        this.topLeftStrategy = topLeftStrategy;
    }

    public AreaContainsPointStrategy getBottomRightStrategy() {
        return bottomRightStrategy;
    }

    public void setBottomRightStrategy(AreaContainsPointStrategy bottomRightStrategy) {
        this.bottomRightStrategy = bottomRightStrategy;
    }

    public AreaContainsPointStrategy getBottomLeftStrategy() {
        return bottomLeftStrategy;
    }

    public void setBottomLeftStrategy(AreaContainsPointStrategy bottomLeftStrategy) {
        this.bottomLeftStrategy = bottomLeftStrategy;
    }
}
