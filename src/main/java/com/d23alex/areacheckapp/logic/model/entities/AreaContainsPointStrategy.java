package com.d23alex.areacheckapp.logic.model.entities;

import com.d23alex.areacheckapp.logic.model.datatypes.Point;

@FunctionalInterface
public interface AreaContainsPointStrategy {
    public boolean contains(Point point, float r);
}
