package com.d23alex.areacheckapp.logic.model.datatypes;

import java.util.Optional;

public class ValidationResult {
    private boolean dataValid = false;
    private Optional<String> problem;

    public ValidationResult(boolean dataValid, Optional<String> problem) {
        this.dataValid = dataValid;
        this.problem = problem;
    }
    public boolean isDataValid() {
        return dataValid;
    }

    public void setDataValid(boolean dataValid) {
        this.dataValid = dataValid;
    }

    public Optional<String> getProblem() {
        return problem;
    }

    public void setProblem(Optional<String> problem) {
        this.problem = problem;
    }
}
