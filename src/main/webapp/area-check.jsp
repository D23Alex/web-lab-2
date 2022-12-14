<%@ page import="com.d23alex.areacheckapp.io.views.models.AreaCheckViewModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% AreaCheckViewModel viewModel = (AreaCheckViewModel) request.getAttribute("view-model");%>

<html>
<head>
    <title>webh sarvar varses application sarvar</title>
    <meta charset="utf-8">
    <title></title>
    <meta name="author" content="">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body style="display: flex; flex-direction: column">
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
<div class="area-check-attempt">
    <div>status: <%=viewModel.getStatusPhase()%></div>
    <div>point: <%=viewModel.getPoint()%></div>
    <div>radius: <%=viewModel.getR()%></div>
    <div>result: <%=viewModel.getResultPhrase()%></div>
    <div>request date: <%=viewModel.getRequestDate()%></div>
    <div>calculation time: <%=viewModel.getCalculationTime()%></div>
</div>
<a href="/area-check-app-1.0-SNAPSHOT/">Go back</a>


</body>
</html>
