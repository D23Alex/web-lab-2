package com.d23alex.areacheckapp.logic.model.datastructures;

import com.d23alex.areacheckapp.logic.model.datastructures.UserAreaCheckHistory;
import com.d23alex.areacheckapp.logic.model.datatypes.AreaCheckAttempt;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

public class UserAreaCheckHistoryBySession implements UserAreaCheckHistory {

    private HttpSession httpSession;

    public UserAreaCheckHistoryBySession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @Override
    public void add(AreaCheckAttempt attempt) {
        List<AreaCheckAttempt> history = (List<AreaCheckAttempt>) httpSession.getAttribute("area-check-history");
        history.add(attempt);
        httpSession.setAttribute("area-check-history", history);
    }

    @Override
    public AreaCheckAttempt getLast() {
        List<AreaCheckAttempt> history = (List<AreaCheckAttempt>) httpSession.getAttribute("area-check-history");
        return history.get(history.size() - 1);
    }

    //TODO: is this a good fix?
    @Override
    public List<AreaCheckAttempt> getAll() {
        if (httpSession.getAttribute("area-check-history") == null)
            return new ArrayList<>();
        return (List<AreaCheckAttempt>) httpSession.getAttribute("area-check-history");
    }
}
