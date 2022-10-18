package com.d23alex.areacheckapp.io.presenters;

import com.d23alex.areacheckapp.io.views.models.AreaCheckViewModel;
import com.d23alex.areacheckapp.logic.model.responses.AreaCheckResponseModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.DecimalFormat;

public class AreaCheckPresenter implements Presenter {

    private String viewName;

    private final HttpServletRequest httpServletRequest;
    private final HttpServletResponse httpServletResponse;
    private final AreaCheckResponseModel responseModel;
    private AreaCheckViewModel viewModel = new AreaCheckViewModel();

    public AreaCheckPresenter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AreaCheckResponseModel responseModel, String viewName) {
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
        this.responseModel = responseModel;
        this.viewName = viewName;
        this.viewModel = new AreaCheckViewModel();
    }

    @Override
    public void present() {
        constructViewModel();
        passViewModelToView();
        forwardRequestToJSP();
    }

    private void passViewModelToView() {
        httpServletRequest.setAttribute("view-model", viewModel);
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

    private void constructViewModel() {
        viewModel.setStatusPhase("success");
        viewModel.setR(new DecimalFormat("#.##").format(responseModel.getAreaCheckAttempt().getR()) + "");
        viewModel.setResultPhrase(responseModel.getAreaCheckAttempt().isAreaContainsPoint() ? "contains" : "doesn't contain");
        viewModel.setPoint(responseModel.getAreaCheckAttempt().getPoint().toString());
        viewModel.setRequestDate(responseModel.getAreaCheckAttempt().getRequestDate().toString());
        viewModel.setCalculationTime("less than 1ms");
    }

}
