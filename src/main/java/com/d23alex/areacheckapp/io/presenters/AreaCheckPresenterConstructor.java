package com.d23alex.areacheckapp.io.presenters;

import com.d23alex.areacheckapp.logic.model.responses.AreaCheckHistoryResponseModel;
import com.d23alex.areacheckapp.logic.model.responses.AreaCheckResponseModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AreaCheckPresenterConstructor {
    Presenter constructAreaCheckPresenter(HttpServletRequest httpServletRequest,
                                          HttpServletResponse httpServletResponse, AreaCheckResponseModel areaCheckResponseModel);
    Presenter constructMainFormAndHistoryPresenter(HttpServletRequest httpServletRequest,
                                                   HttpServletResponse httpServletResponse,
                                                   AreaCheckHistoryResponseModel areaCheckHistoryResponseModel);

}
