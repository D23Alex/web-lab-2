package com.d23alex.areacheckapp.logic.model.datamanagement;

import com.d23alex.areacheckapp.logic.model.datastructures.UserAreaCheckHistory;
import com.d23alex.areacheckapp.logic.model.datastructures.UserAreaCheckHistoryByList;
import com.d23alex.areacheckapp.logic.model.datatypes.AreaCheckAttempt;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

public class UserRelatedHistoryManagerBySession implements UserRelatedHistoryManager {

    private HttpSession session;
    private String historyAttributeName = "area-check-history";


    public UserRelatedHistoryManagerBySession(HttpSession session, String historyAttributeName) {
        this.session = session;
        this.historyAttributeName = historyAttributeName;
        if (session.getAttribute(historyAttributeName) == null)
            session.setAttribute(historyAttributeName, new ArrayList<AreaCheckAttempt>());
    }

    @Override
    public void add(AreaCheckAttempt attempt) {
        List<AreaCheckAttempt> checkAttempts = (List<AreaCheckAttempt>) session.getAttribute(historyAttributeName);
        checkAttempts.add(attempt);
        session.setAttribute(historyAttributeName, checkAttempts);
    }

    @Override
    public UserAreaCheckHistory getHistory() {
        return new UserAreaCheckHistoryByList((List<AreaCheckAttempt>) session.getAttribute(historyAttributeName));
    }
}
