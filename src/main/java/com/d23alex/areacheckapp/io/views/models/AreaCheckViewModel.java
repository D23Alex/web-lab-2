package com.d23alex.areacheckapp.io.views.models;

import java.io.Serializable;

public class AreaCheckViewModel implements Serializable {
    private String point = "(0, 0)";
    private String r = "0";
    private String requestDate = "yesterday";
    private String calculationTime = "1 second";
    private String resultPhrase = "area doesn't contain point";
    private String statusPhase = "failure";


    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getCalculationTime() {
        return calculationTime;
    }

    public void setCalculationTime(String calculationTime) {
        this.calculationTime = calculationTime;
    }

    public String getResultPhrase() {
        return resultPhrase;
    }

    public void setResultPhrase(String resultPhrase) {
        this.resultPhrase = resultPhrase;
    }

    public String getStatusPhase() {
        return statusPhase;
    }

    public void setStatusPhase(String statusPhase) {
        this.statusPhase = statusPhase;
    }
}
