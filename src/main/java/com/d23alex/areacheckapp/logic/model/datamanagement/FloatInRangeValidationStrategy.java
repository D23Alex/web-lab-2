package com.d23alex.areacheckapp.logic.model.datamanagement;

import com.d23alex.areacheckapp.logic.model.datatypes.ValidationResult;

import java.util.Optional;

public class FloatInRangeValidationStrategy implements FloatValidationStrategy {

    private float low;
    private float high;

    public FloatInRangeValidationStrategy(float low, float high) {
        this.low = low;
        this.high = high;
    }

    @Override
    public ValidationResult validate(float number) {
        if (number < high || number > low)
            return new ValidationResult(true, Optional.empty());
        if (number > high)
            return new ValidationResult(false, Optional.of("the value of number (" + number +
                    ") is greater than highest allowed value in range (" + low + ", " + high + ")"));
        if (number < low)
            return new ValidationResult(false, Optional.of("the value of number (" + number +
                    ") is lower than lowest allowed value in range (" + low + ", " + high + ")"));
        return  new ValidationResult(false, Optional.empty());
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }
}
