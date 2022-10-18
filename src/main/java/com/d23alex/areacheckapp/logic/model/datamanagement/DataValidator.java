package com.d23alex.areacheckapp.logic.model.datamanagement;

import com.d23alex.areacheckapp.logic.model.datatypes.AreaCheckInput;
import com.d23alex.areacheckapp.logic.model.datatypes.ValidationResult;

import java.util.Optional;

public class DataValidator implements AreaCheckDataValidator {

    private String defaultProblemPhrase;

    private FloatValidationStrategy xValidationStrategy;
    private FloatValidationStrategy yValidationStrategy;
    private FloatValidationStrategy rValidationStrategy;

    public DataValidator(String defaultProblemPhrase, FloatValidationStrategy xValidationStrategy, FloatValidationStrategy yValidationStrategy, FloatValidationStrategy rValidationStrategy) {
        this.defaultProblemPhrase = defaultProblemPhrase;
        this.xValidationStrategy = xValidationStrategy;
        this.yValidationStrategy = yValidationStrategy;
        this.rValidationStrategy = rValidationStrategy;
    }

    @Override
    public ValidationResult validateAndGiveResponse(AreaCheckInput input) {
        ValidationResult xValidationResult = xValidationStrategy.validate(input.getR());
        ValidationResult yValidationResult = yValidationStrategy.validate(input.getR());
        ValidationResult rValidationResult = rValidationStrategy.validate(input.getR());

        if (!xValidationResult.isDataValid())
            return constructValidationResultForFloat(xValidationResult, "x");
        if (!yValidationResult.isDataValid())
            return yValidationResult;
        if (!rValidationResult.isDataValid())
            return rValidationResult;

        return new ValidationResult(true, Optional.empty());
    }

    private ValidationResult constructValidationResultForFloat(ValidationResult validationResult, String inputName) {
        if (validationResult.getProblem().isPresent()) {
            String problemMessage = defaultProblemPhrase + " - " + inputName + " is invalid - " + validationResult.getProblem().get();
            return new ValidationResult(false, Optional.of(problemMessage));
        } else
            return new ValidationResult(true, Optional.empty());
    }

    public FloatValidationStrategy getXValidationStrategy() {
        return xValidationStrategy;
    }

    public void setXValidationStrategy(FloatValidationStrategy xValidationStrategy) {
        this.xValidationStrategy = xValidationStrategy;
    }

    public FloatValidationStrategy getYValidationStrategy() {
        return yValidationStrategy;
    }

    public void setYValidationStrategy(FloatValidationStrategy yValidationStrategy) {
        this.yValidationStrategy = yValidationStrategy;
    }

    public FloatValidationStrategy getRValidationStrategy() {
        return rValidationStrategy;
    }

    public void setRValidationStrategy(FloatValidationStrategy rValidationStrategy) {
        this.rValidationStrategy = rValidationStrategy;
    }

    public String getDefaultProblemPhrase() {
        return defaultProblemPhrase;
    }

    public void setDefaultProblemPhrase(String defaultProblemPhrase) {
        this.defaultProblemPhrase = defaultProblemPhrase;
    }
}
