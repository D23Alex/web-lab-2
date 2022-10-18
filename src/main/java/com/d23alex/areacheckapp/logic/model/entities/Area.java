package com.d23alex.areacheckapp.logic.model.entities;

import com.d23alex.areacheckapp.logic.model.datatypes.AreaCheckAttempt;
import com.d23alex.areacheckapp.logic.model.datatypes.Point;

public interface Area {
    boolean containsPoint(Point point, float r);
}
