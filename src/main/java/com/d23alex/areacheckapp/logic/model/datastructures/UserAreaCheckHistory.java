package com.d23alex.areacheckapp.logic.model.datastructures;

import com.d23alex.areacheckapp.logic.model.datatypes.AreaCheckAttempt;

import java.util.List;

public interface UserAreaCheckHistory {
    void add(AreaCheckAttempt attempt);
    AreaCheckAttempt getLast();

    List<AreaCheckAttempt> getAll();
}
