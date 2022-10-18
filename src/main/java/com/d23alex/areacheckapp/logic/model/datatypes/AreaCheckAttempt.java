package com.d23alex.areacheckapp.logic.model.datatypes;

import java.sql.Time;
import java.util.Date;

public class AreaCheckAttempt {
    private float r = 0;
    private Point point = new Point(0, 0);
    private Date requestDate = new Date(0);
    private boolean areaContainsPoint = false;
    private Time calculationTime = new Time(0);

    private UserInfo userInfo = new UserInfo();


    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public Point getPoint() {
        return point;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public boolean isAreaContainsPoint() {
        return areaContainsPoint;
    }

    public void setAreaContainsPoint(boolean areaContainsPoint) {
        this.areaContainsPoint = areaContainsPoint;
    }

    public Time getCalculationTime() {
        return calculationTime;
    }

    public void setCalculationTime(Time calculationTime) {
        this.calculationTime = calculationTime;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
