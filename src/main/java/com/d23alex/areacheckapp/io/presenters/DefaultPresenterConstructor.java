package com.d23alex.areacheckapp.io.presenters;

import com.d23alex.areacheckapp.logic.model.responses.AreaCheckHistoryResponseModel;
import com.d23alex.areacheckapp.logic.model.responses.AreaCheckResponseModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DefaultPresenterConstructor implements AreaCheckPresenterConstructor {

    public DefaultPresenterConstructor() {
    }

    @Override
    public Presenter constructAreaCheckPresenter(HttpServletRequest httpServletRequest,
                                                 HttpServletResponse httpServletResponse,
                                                 AreaCheckResponseModel areaCheckResponseModel) {
        return new AreaCheckPresenter(httpServletRequest, httpServletResponse, areaCheckResponseModel,
                "area-check.jsp");
    }

    @Override
    public Presenter constructMainFormAndHistoryPresenter(HttpServletRequest httpServletRequest,
                                                          HttpServletResponse httpServletResponse,
                                                          AreaCheckHistoryResponseModel areaCheckHistoryResponseModel) {
        return new MainFormAndHistoryPresenter("main-form-and-history.jsp",
                httpServletRequest, httpServletResponse, areaCheckHistoryResponseModel);
    }
}
