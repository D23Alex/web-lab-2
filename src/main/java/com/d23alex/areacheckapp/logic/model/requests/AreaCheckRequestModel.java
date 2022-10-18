package com.d23alex.areacheckapp.logic.model.requests;

import com.d23alex.areacheckapp.logic.model.datamanagement.UserRelatedHistoryManager;
import com.d23alex.areacheckapp.logic.model.datatypes.AreaCheckInput;
import com.d23alex.areacheckapp.logic.model.datatypes.Point;
import com.d23alex.areacheckapp.logic.model.datatypes.UserInfo;
import jakarta.servlet.http.HttpSession;

import java.util.Date;

public class AreaCheckRequestModel {

    private UserRelatedHistoryManager userRelatedHistoryManager;

    private AreaCheckInput inputData = new AreaCheckInput(new Point(0, 0), 0);
    private Date requestDate = new Date();

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public AreaCheckInput getInputData() {
        return inputData;
    }

    public void setInputData(AreaCheckInput inputData) {
        this.inputData = inputData;
    }

    public UserRelatedHistoryManager getUserRelatedHistoryManager() {
        return userRelatedHistoryManager;
    }

    public void setUserRelatedHistoryManager(UserRelatedHistoryManager userRelatedHistoryManager) {
        this.userRelatedHistoryManager = userRelatedHistoryManager;
    }
}
