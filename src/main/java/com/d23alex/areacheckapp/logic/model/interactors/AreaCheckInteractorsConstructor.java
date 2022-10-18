package com.d23alex.areacheckapp.logic.model.interactors;

import com.d23alex.areacheckapp.logic.model.requests.AreaCheckRequestModel;
import com.d23alex.areacheckapp.logic.model.requests.AreaCheckHistoryRequestModel;
import com.d23alex.areacheckapp.logic.model.responses.AreaCheckHistoryResponseModel;
import com.d23alex.areacheckapp.logic.model.responses.AreaCheckResponseModel;

public interface AreaCheckInteractorsConstructor {
    Interactor constructInteractor(AreaCheckRequestModel requestModel, AreaCheckResponseModel responseModel);

    Interactor constructInteractor(AreaCheckHistoryRequestModel requestModel, AreaCheckHistoryResponseModel responseModel);
}
