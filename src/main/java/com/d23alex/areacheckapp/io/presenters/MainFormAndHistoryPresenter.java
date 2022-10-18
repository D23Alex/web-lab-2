package com.d23alex.areacheckapp.io.presenters;

import com.d23alex.areacheckapp.io.views.models.MainFormAndHistoryViewModel;
import com.d23alex.areacheckapp.logic.model.datastructures.UserAreaCheckHistory;
import com.d23alex.areacheckapp.logic.model.datatypes.AreaCheckAttempt;
import com.d23alex.areacheckapp.logic.model.responses.AreaCheckHistoryResponseModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MainFormAndHistoryPresenter implements Presenter {
    private String viewName;
    private final HttpServletRequest httpServletRequest;
    private final HttpServletResponse httpServletResponse;
    private final AreaCheckHistoryResponseModel responseModel;

    private final MainFormAndHistoryViewModel viewModel = new MainFormAndHistoryViewModel();

    public MainFormAndHistoryPresenter(String viewName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AreaCheckHistoryResponseModel responseModel) {
        this.viewName = viewName;
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
        this.responseModel = responseModel;
    }


    @Override
    public void present() {
        constructViewModel();
        passViewModelToView();
        forwardRequestToJSP();
    }

    private void forwardRequestToJSP() {
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(viewName);
        try {
            requestDispatcher.forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void passViewModelToView() {
        httpServletRequest.setAttribute("view-model", viewModel);
    }

    private void constructViewModel() {
        UserAreaCheckHistory history = responseModel.getHistory();
        List<AreaCheckAttempt> checkAttempts = history.getAll();
        String formattedHistory = renderHistoryAsHTML(checkAttempts);
        viewModel.setFormattedHistory(formattedHistory);
    }

    private String renderHistoryAsHTML(List<AreaCheckAttempt> checkAttempts) {
        StringBuilder historyAsHTML = new StringBuilder();
        historyAsHTML.append("<div class='history'>");
        checkAttempts.forEach(attempt -> historyAsHTML.append(areaCheckAttemptToHTML(attempt)));
        historyAsHTML.append("</div>");
        return historyAsHTML.toString();
    }

    //TODO: does that belong to this class?
    private String areaCheckAttemptToHTML(AreaCheckAttempt attempt) {
        return "<div class='area-check-attempt'>" +
                surroundWithDivBlockOfClass("point: " + attempt.getPoint().toString(), "point") +
                surroundWithDivBlockOfClass("r: " + attempt.getR() + "", "r") +
                surroundWithDivBlockOfClass("result: " + (attempt.isAreaContainsPoint() ? "did contain" : "didn't contain"), "result") +
                surroundWithDivBlockOfClass("date: " + attempt.getRequestDate().toString(), "request-date") +
                surroundWithDivBlockOfClass("calc time: less than 1ms", "calculation-time") +
                "</div>";
    }

    private String surroundWithDivBlockOfClass(String string, String divClassname) {
        return "<div class='" + divClassname + "'>" + string + "</div>";
    }
}
