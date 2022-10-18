package com.d23alex.areacheckapp.logic.model.datamanagement;

import com.d23alex.areacheckapp.logic.model.datatypes.ValidationResult;

@FunctionalInterface
public interface FloatValidationStrategy {
    ValidationResult validate(float number);
}
