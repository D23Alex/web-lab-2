package com.d23alex.areacheckapp.logic.model.interactors;

import com.d23alex.areacheckapp.logic.model.datatypes.AreaCheckAttempt;
import com.d23alex.areacheckapp.logic.model.datatypes.Point;
import com.d23alex.areacheckapp.logic.model.datatypes.ValidationResult;
import com.d23alex.areacheckapp.logic.model.entities.Area;
import com.d23alex.areacheckapp.logic.model.datamanagement.AreaCheckDataValidator;
import com.d23alex.areacheckapp.logic.model.requests.AreaCheckRequestModel;
import com.d23alex.areacheckapp.logic.model.responses.AreaCheckResponseModel;

public class AreaCheckInteractor implements Interactor {

    private AreaCheckRequestModel requestModel;

    private AreaCheckResponseModel responseModel;

    private AreaCheckDataValidator dataValidator;


    private Area area;

    public AreaCheckInteractor(AreaCheckRequestModel requestModel, AreaCheckResponseModel responseModel,
                               AreaCheckDataValidator dataValidator,
                               Area area) {
        this.requestModel = requestModel;
        this.responseModel = responseModel;
        this.dataValidator = dataValidator;
        this.area = area;
    }

    @Override
    public void executeRequestModifyResponse() {
        ValidationResult validationResult = dataValidator.validateAndGiveResponse(requestModel.getInputData());
        responseModel.setInputDataValidationResult(validationResult);
        if (validationResult.isDataValid())
            responseModel.setAreaCheckAttempt(checkArea());
    }

    private AreaCheckAttempt checkArea() {
        AreaCheckAttempt check = new AreaCheckAttempt();
        // this doesn't violate the law of Demeter cause requestModel is just a POJO, a datatype
        check.setR(requestModel.getInputData().getR());
        check.setPoint(requestModel.getInputData().getPoint());
        check.setRequestDate(requestModel.getRequestDate());
        addAreaCheckResult(check);
        addCalculationTime(check);
        requestModel.getUserRelatedHistoryManager().add(check);
        return check;
    }

    private void addCalculationTime(AreaCheckAttempt check) {
        //TODO: calculate time
    }

    private void addAreaCheckResult(AreaCheckAttempt check) {
        Point point = requestModel.getInputData().getPoint();
        float r = requestModel.getInputData().getR();
        boolean areaContainsPoint = area.containsPoint(point, r);
        check.setAreaContainsPoint(areaContainsPoint);
    }


}
