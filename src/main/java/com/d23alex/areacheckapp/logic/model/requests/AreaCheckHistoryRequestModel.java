package com.d23alex.areacheckapp.logic.model.requests;

import com.d23alex.areacheckapp.logic.model.datamanagement.UserRelatedHistoryManager;
import com.d23alex.areacheckapp.logic.model.datatypes.UserInfo;

public class AreaCheckHistoryRequestModel {
    private UserRelatedHistoryManager userRelatedHistoryManager;

    public UserRelatedHistoryManager getUserRelatedHistoryManager() {
        return userRelatedHistoryManager;
    }

    public void setUserRelatedHistoryManager(UserRelatedHistoryManager userRelatedHistoryManager) {
        this.userRelatedHistoryManager = userRelatedHistoryManager;
    }
}
