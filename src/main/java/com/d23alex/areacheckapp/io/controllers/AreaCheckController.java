package com.d23alex.areacheckapp.io.controllers;

import com.d23alex.areacheckapp.io.presenters.Presenter;
import com.d23alex.areacheckapp.io.presenters.AreaCheckPresenterConstructor;
import com.d23alex.areacheckapp.logic.model.datamanagement.UserRelatedHistoryManager;
import com.d23alex.areacheckapp.logic.model.datamanagement.UserRelatedHistoryManagerBySession;
import com.d23alex.areacheckapp.logic.model.datastructures.UserAreaCheckHistory;
import com.d23alex.areacheckapp.logic.model.datastructures.UserAreaCheckHistoryBySession;
import com.d23alex.areacheckapp.logic.model.datatypes.AreaCheckInput;
import com.d23alex.areacheckapp.logic.model.datatypes.Point;
import com.d23alex.areacheckapp.logic.model.datatypes.UserInfo;
import com.d23alex.areacheckapp.logic.model.interactors.Interactor;
import com.d23alex.areacheckapp.logic.model.interactors.AreaCheckInteractorsConstructor;
import com.d23alex.areacheckapp.logic.model.requests.AreaCheckRequestModel;
import com.d23alex.areacheckapp.logic.model.requests.AreaCheckHistoryRequestModel;
import com.d23alex.areacheckapp.logic.model.responses.AreaCheckResponseModel;
import com.d23alex.areacheckapp.logic.model.responses.AreaCheckHistoryResponseModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.BadRequestException;

import java.util.Date;

public class AreaCheckController implements CheckAreaController, MainFormAndHistoryController {

    private AreaCheckInteractorsConstructor areaCheckInteractorConstructor;
    private AreaCheckPresenterConstructor presenterConstructor;

    public AreaCheckController(AreaCheckInteractorsConstructor interactorConstructor, AreaCheckPresenterConstructor presenterConstructor) {
        this.areaCheckInteractorConstructor = interactorConstructor;
        this.presenterConstructor = presenterConstructor;
    }

    @Override
    public void checkArea(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            processAreaCheckRequest(httpServletRequest, httpServletResponse);
        } catch (BadRequestException e) {
            processInvalidAreaCheckRequest(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    public void getMainFormAndHistory(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        AreaCheckHistoryRequestModel request = constructAreaCheckHistoryRequestModel(httpServletRequest);
        AreaCheckHistoryResponseModel response = new AreaCheckHistoryResponseModel();
        Interactor interactor = areaCheckInteractorConstructor.constructInteractor(request, response);
        Presenter presenter = presenterConstructor.constructMainFormAndHistoryPresenter(httpServletRequest, httpServletResponse, response);
        interactor.executeRequestModifyResponse();
        presenter.present();
    }

    private void processAreaCheckRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        AreaCheckRequestModel request = constructAreaCheckRequestModel(httpServletRequest);
        AreaCheckResponseModel response = new AreaCheckResponseModel();
        Interactor interactor = areaCheckInteractorConstructor.constructInteractor(request, response);
        Presenter presenter = presenterConstructor.constructAreaCheckPresenter(httpServletRequest, httpServletResponse, response);
        interactor.executeRequestModifyResponse();
        presenter.present();
    }

    private void processInvalidAreaCheckRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        //TODO: redirect user to a page that says "Sorry, bad request"
    }

    private AreaCheckRequestModel constructAreaCheckRequestModel(HttpServletRequest httpServletRequest) {
        AreaCheckRequestModel requestModel = new AreaCheckRequestModel();
        AreaCheckInput areaCheckInput = parseInputDataOrThrowBadRequestException(httpServletRequest);
        requestModel.setInputData(areaCheckInput);
        requestModel.setUserRelatedHistoryManager(new UserRelatedHistoryManagerBySession(httpServletRequest.getSession(), "area-check-history"));
        requestModel.setRequestDate(new Date());
        return requestModel;
    }


    private AreaCheckHistoryRequestModel constructAreaCheckHistoryRequestModel(HttpServletRequest httpServletRequest) {
        AreaCheckHistoryRequestModel requestModel = new AreaCheckHistoryRequestModel();
        requestModel.setUserRelatedHistoryManager(new UserRelatedHistoryManagerBySession(httpServletRequest.getSession(), "area-check-history"));
        return requestModel;
    }

    private AreaCheckInput parseInputDataOrThrowBadRequestException(HttpServletRequest request) {
        try {
            return parseInputData(request);
        } catch (Exception e) {
            throw new BadRequestException(e);
        }
    }

    private AreaCheckInput parseInputData(HttpServletRequest request) {
        float x = Float.parseFloat(request.getParameter("x"));
        float y = Float.parseFloat(request.getParameter("y"));
        float r = Float.parseFloat(request.getParameter("r"));
        float realX = Float.parseFloat(request.getParameter("real-x"));

        if (realX > 0.001 || realX < -0.001)
            x = realX;

        Point point = new Point(x, y);
        return new AreaCheckInput(point, r);
    }


}
