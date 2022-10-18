package com.d23alex.areacheckapp.logic.model.interactors;

import com.d23alex.areacheckapp.logic.model.datamanagement.AreaCheckDataValidator;
import com.d23alex.areacheckapp.logic.model.entities.Area;
import com.d23alex.areacheckapp.logic.model.requests.AreaCheckRequestModel;
import com.d23alex.areacheckapp.logic.model.requests.AreaCheckHistoryRequestModel;
import com.d23alex.areacheckapp.logic.model.responses.AreaCheckHistoryResponseModel;
import com.d23alex.areacheckapp.logic.model.responses.AreaCheckResponseModel;

public class DefaultAreaCheckInteractorConstructor implements AreaCheckInteractorsConstructor {

    private AreaCheckDataValidator dataValidator;
    private Area area;

    public DefaultAreaCheckInteractorConstructor(AreaCheckDataValidator dataValidator, Area area) {
        this.dataValidator = dataValidator;
        this.area = area;
    }

    @Override
    public Interactor constructInteractor(AreaCheckRequestModel requestModel, AreaCheckResponseModel responseModel) {
        return new AreaCheckInteractor(requestModel, responseModel, dataValidator, area);
    }

    @Override
    public Interactor constructInteractor(AreaCheckHistoryRequestModel requestModel, AreaCheckHistoryResponseModel responseModel) {
        return new AreaCheckHistoryInteractor(requestModel, responseModel);
    }
}
