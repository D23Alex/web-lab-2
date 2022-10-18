package com.d23alex.areacheckapp.logic.model.responses;

import com.d23alex.areacheckapp.logic.model.datatypes.AreaCheckAttempt;
import com.d23alex.areacheckapp.logic.model.datatypes.ValidationResult;

public class AreaCheckResponseModel {
    private AreaCheckAttempt areaCheckAttempt = new AreaCheckAttempt();
    private ValidationResult inputDataValidationResult;

    public AreaCheckAttempt getAreaCheckAttempt() {
        return areaCheckAttempt;
    }

    public void setAreaCheckAttempt(AreaCheckAttempt areaCheckAttempt) {
        this.areaCheckAttempt = areaCheckAttempt;
    }

    public ValidationResult getInputDataValidationResult() {
        return inputDataValidationResult;
    }

    public void setInputDataValidationResult(ValidationResult inputDataValidationResult) {
        this.inputDataValidationResult = inputDataValidationResult;
    }
}
