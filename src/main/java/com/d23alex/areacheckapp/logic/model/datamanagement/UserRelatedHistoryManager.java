package com.d23alex.areacheckapp.logic.model.datamanagement;

import com.d23alex.areacheckapp.logic.model.datastructures.UserAreaCheckHistory;
import com.d23alex.areacheckapp.logic.model.datatypes.AreaCheckAttempt;

public interface UserRelatedHistoryManager {
    void add(AreaCheckAttempt attempt);
    UserAreaCheckHistory getHistory();
}
