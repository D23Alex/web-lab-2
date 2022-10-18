package com.d23alex.areacheckapp.logic.model.interactors;

import com.d23alex.areacheckapp.logic.model.datastructures.UserAreaCheckHistory;
import com.d23alex.areacheckapp.logic.model.requests.AreaCheckHistoryRequestModel;
import com.d23alex.areacheckapp.logic.model.responses.AreaCheckHistoryResponseModel;

public class AreaCheckHistoryInteractor implements Interactor {

    private AreaCheckHistoryRequestModel requestModel;
    private AreaCheckHistoryResponseModel responseModel;


    public AreaCheckHistoryInteractor(AreaCheckHistoryRequestModel requestModel, AreaCheckHistoryResponseModel responseModel) {
        this.requestModel = requestModel;
        this.responseModel = responseModel;
    }

    @Override
    public void executeRequestModifyResponse() {
        UserAreaCheckHistory history = requestModel.getUserRelatedHistoryManager().getHistory();
        responseModel.setHistory(history);
    }
}
