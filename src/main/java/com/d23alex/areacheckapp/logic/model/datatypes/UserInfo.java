package com.d23alex.areacheckapp.logic.model.datatypes;

import com.d23alex.areacheckapp.logic.model.datastructures.UserAreaCheckHistory;
import com.d23alex.areacheckapp.logic.model.datastructures.UserAreaCheckHistoryByList;

public class UserInfo {


    private UserAreaCheckHistory areaCheckHistory = new UserAreaCheckHistoryByList();

    public UserInfo(UserAreaCheckHistory areaCheckHistory) {
        this.areaCheckHistory = areaCheckHistory;
    }

    public UserInfo() {
        this.areaCheckHistory = new UserAreaCheckHistoryByList();
    }


    public UserAreaCheckHistory getAreaCheckHistory() {
        return areaCheckHistory;
    }

    public void setAreaCheckHistory(UserAreaCheckHistory areaCheckHistory) {
        this.areaCheckHistory = areaCheckHistory;
    }
}
