package com.d23alex.areacheckapp.logic.model.datastructures;

import com.d23alex.areacheckapp.logic.model.datastructures.UserAreaCheckHistory;
import com.d23alex.areacheckapp.logic.model.datatypes.AreaCheckAttempt;

import java.util.ArrayList;
import java.util.List;

public class UserAreaCheckHistoryByList implements UserAreaCheckHistory {

    private List<AreaCheckAttempt> history = new ArrayList<AreaCheckAttempt>();

    public UserAreaCheckHistoryByList() {}
    public UserAreaCheckHistoryByList(List<AreaCheckAttempt> history) {
        this.history = history;
    }

    @Override
    public void add(AreaCheckAttempt attempt) {
        history.add(attempt);
    }

    @Override
    public AreaCheckAttempt getLast() {
        return history.get(history.size() - 1);
    }

    @Override
    public List<AreaCheckAttempt> getAll() {
        return history;
    }


    public List<AreaCheckAttempt> getHistory() {
        return history;
    }

    public void setHistory(List<AreaCheckAttempt> history) {
        this.history = history;
    }
}
