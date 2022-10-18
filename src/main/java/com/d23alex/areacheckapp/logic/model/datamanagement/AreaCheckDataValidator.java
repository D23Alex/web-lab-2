package com.d23alex.areacheckapp.logic.model.datamanagement;

import com.d23alex.areacheckapp.logic.model.datatypes.AreaCheckInput;
import com.d23alex.areacheckapp.logic.model.datatypes.ValidationResult;

public interface AreaCheckDataValidator {
    ValidationResult validateAndGiveResponse(AreaCheckInput input);
}
