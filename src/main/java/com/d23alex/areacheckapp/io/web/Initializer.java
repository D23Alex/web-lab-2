package com.d23alex.areacheckapp.io.web;

import com.d23alex.areacheckapp.io.controllers.AreaCheckController;
import com.d23alex.areacheckapp.io.presenters.DefaultPresenterConstructor;
import com.d23alex.areacheckapp.logic.model.datamanagement.DataValidator;
import com.d23alex.areacheckapp.logic.model.datamanagement.FloatInRangeValidationStrategy;
import com.d23alex.areacheckapp.logic.model.entities.Lab2Area;
import com.d23alex.areacheckapp.logic.model.interactors.DefaultAreaCheckInteractorConstructor;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class Initializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // ENTITIES LAYER
        // initialize real business objects a.k.a entities
        Lab2Area area = new Lab2Area(
                (point, r) -> point.getY() + point.getX() <= r,
                (point, r) -> point.getX() >= -1 * r && point.getY() <= r / 2,
                (point, r) -> (point.getY() == 0 && point.getX() <= r) || (point.getX() == 0 && point.getY() > -1 * r / 2),
                (point, r) -> Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2) <= Math.pow(r / 2, 2)
                );

        // INTERACTORS LAYER
        // initialize areaCheckDataValidators
        FloatInRangeValidationStrategy areaCheckXValidationStrategy = new FloatInRangeValidationStrategy(-5, 5);
        FloatInRangeValidationStrategy areaCheckYValidationStrategy = new FloatInRangeValidationStrategy(-3, 3);
        FloatInRangeValidationStrategy areaCheckRValidationStrategy = new FloatInRangeValidationStrategy(0, 4);
        DataValidator areaCheckDataValidator = new DataValidator("invalid data",
                areaCheckXValidationStrategy, areaCheckYValidationStrategy, areaCheckRValidationStrategy);

        // initialize interactor constructors
        DefaultAreaCheckInteractorConstructor defaultAreaCheckInteractorsConstructor = new DefaultAreaCheckInteractorConstructor(areaCheckDataValidator, area);

        // PRESENTERS LAYER
        // initialize presenter constructors
        DefaultPresenterConstructor defaultPresenterConstructor = new DefaultPresenterConstructor();

        // CONTROLLERS LAYER
        // initialize controllers
        AreaCheckController areaCheckController = new AreaCheckController(defaultAreaCheckInteractorsConstructor, defaultPresenterConstructor);

        // OTHER WEB RELATED STUFF???
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("area-check-controller", areaCheckController);
    }
}
