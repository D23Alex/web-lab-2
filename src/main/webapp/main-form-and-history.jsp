<%@ page import="com.d23alex.areacheckapp.io.views.models.MainFormAndHistoryViewModel" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<% MainFormAndHistoryViewModel viewModel = (MainFormAndHistoryViewModel) request.getAttribute("view-model");%>

<!DOCTYPE html>
<html>
<head>
    <title>webh sarvar varses application sarvar</title>
    <meta charset="utf-8">
    <title></title>
    <meta name="author" content="">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="css/style.css" rel="stylesheet" type="text/css">
    <script src="js/validation.js"></script>
</head>
<body>
<header>
    <div class="header-content">
        <div class="header-wrapper">
            <div class="main-h1-wrapper">
                <h1 class="main-header-text">WOLFRAM <span>BETA</span></h1>
            </div>
            <hr>
            <div class="main-h2-wrapper">
                <h2>Made By Aleksei Dormorezov from P32111 (11400) without any warranty but with <span>best&nbsp;wishes</span></h2>
            </div>
        </div>
    </div>
</header>
<div id="area" style="width: 300px; height: 300px;">
    <img src="xy-axis-lab2-width-and-height-ratio-to-2r-is-2.svg" style="width: inherit; height: inherit">
</div>
<form action="AreaCheckServlet" name="main-form" method="get" id="main-form" onsubmit="submitButtonPressed()">
    <div class="user-input" id="x-input">
        <div class="inputs">
            <p>X</p>
            <select class="x-select" id="x-select" name="x" value="0">
                <option selected>1</option>
                <option>2</option>
            </select>

        </div>
        <div class="validation-result" id="x-validation-result">

        </div>

    </div>

    <div class="user-input" id="y-input">
        <div class="inputs">
            <label for="y-text-input">Y</label>
            <input class="y-text-input" type="text" id="y-text-input" name="y" value="0">
        </div>
        <div class="validation-result" id="y-validation-result">

        </div>

    </div>

    <div class="user-input" id="r-input">
        <div class="inputs">
            <p>R</p>
            <input type="radio" id="r-equals-1-radio" name="r" value="1">
            <br>
            <input type="radio" id="r-equals-1.5-radio" name="r" value="1.5">
            <br>
            <input type="radio" id="r-equals-2-radio" name="r" value="2">
            <br>
        </div>
        <div class="validation-result" id="r-validation-result">

        </div>

    </div>
    <div class="submit-button">
        <button id="submit-button">Check!</button>
    </div>

    <input type="text" id="real-x" name="real-x" value="0" style="display: none">

</form>
<%=viewModel.getFormattedHistory()%>
<footer>
    <div class="footer-content">
        <div class="footer-line">Aleksei Dormorezov, web programming lab 1.</div>
        <div class="footer-line">No copyright. Free software. Source code available on <a href="https://www.github.com/d23alex/web-lab-1">GitHub.</a></div>
    </div>
</footer>
</body>
</html>
<script type="text/javascript" src="js/event-listeners.js"></script>
<script type="text/javascript" src="js/validation.js"></script>