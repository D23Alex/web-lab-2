const AREA_WIDTH_TO_2R_RATIO = 2
const AREA_HEIGHT_TO_2R_RATIO = 2

let currentAreaWidth = 0;
let currentAreaHeight = 0;

let currentR = 0;

let area = document.getElementById("area");

area.addEventListener('click', areaClicked);

function rSetAndValid() {
    //TODO: implement
    return true;
}

function warnAboutUnsetR() {
}

function readCurrentR() {
    currentR = parseFloat(document.forms["main-form"]["r"].value);
}

function calculateAreaHeightAreaWidth() {
    currentAreaHeight = currentR * AREA_HEIGHT_TO_2R_RATIO;
    currentAreaWidth = currentR * AREA_WIDTH_TO_2R_RATIO
}

function calculateXY(xClickCoordinate, yClickCoordinate, areaTopLeftCornerXCoordinate, areaTopLeftCornerYCoordinate, areaWidthInPx, areaHeightInPx) {
    calculateAreaHeightAreaWidth();
    let centerCoordinateY = areaTopLeftCornerYCoordinate - (areaHeightInPx / 2);
    let centerCoordinateX = areaTopLeftCornerXCoordinate + (areaWidthInPx / 2);
    let centerAndClickWidthDifferencePx = xClickCoordinate - centerCoordinateX;
    let centerAndClickHeightDifferencePx = yClickCoordinate - centerCoordinateY;
    let yOut = (centerAndClickHeightDifferencePx * 2 / areaHeightInPx) * currentAreaHeight;
    let xOut = (centerAndClickWidthDifferencePx * 2 / areaWidthInPx) * currentAreaWidth;
    return {
        x: xOut,
        y: yOut
    }

}

function getXYInputFromAreaClickAndSubmitForm(xClick, yClick) {
    readCurrentR();
    let area = document.getElementById("area");
    let xClickCoordinate = xClick;
    let yClickCoordinate = yClick;
    let areaTopLeftCornerXCoordinate = getOffset(area).left;
    let areaTopLeftCornerYCoordinate = -1 * getOffset(area).top;
    let areaWidthInPx = area.offsetWidth;
    let areaHeightInPx = area.offsetHeight;
    let x = calculateXY(xClickCoordinate, yClickCoordinate, areaTopLeftCornerXCoordinate, areaTopLeftCornerYCoordinate, areaWidthInPx, areaHeightInPx).x;
    let y = calculateXY(xClickCoordinate, yClickCoordinate, areaTopLeftCornerXCoordinate, areaTopLeftCornerYCoordinate, areaWidthInPx, areaHeightInPx).y;

    document.getElementById("real-x").value = x;
    document.getElementById("y-text-input").value = y;
    document.getElementById("main-form").submit();

}

function areaClicked(e) {
    if (!rSetAndValid())
        warnAboutUnsetR();
    else {
        let xClick = e.clientX;
        let yClick = -1 * e.clientY;
        getXYInputFromAreaClickAndSubmitForm(xClick, yClick);
    }
}

function getOffset(el) {
    const rect = el.getBoundingClientRect();
    return {
        left: rect.left + window.scrollX,
        top: rect.top + window.scrollY
    };
}


function submitButtonPressed(e) {
    e.preventDefault();
    let result = validateMainForm();
    if (result === true) {
        document.getElementById("main-form").submit();
    }
}

// clicking "submit form" button
document.getElementById("submit-button").addEventListener('click', submitButtonPressed)