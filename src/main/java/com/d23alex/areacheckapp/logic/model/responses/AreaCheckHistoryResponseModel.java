package com.d23alex.areacheckapp.logic.model.responses;

import com.d23alex.areacheckapp.logic.model.datastructures.UserAreaCheckHistory;
import com.d23alex.areacheckapp.logic.model.datastructures.UserAreaCheckHistoryByList;

public class AreaCheckHistoryResponseModel {
    private UserAreaCheckHistory history = new UserAreaCheckHistoryByList();


    public UserAreaCheckHistory getHistory() {
        return history;
    }

    public void setHistory(UserAreaCheckHistory history) {
        this.history = history;
    }
}
