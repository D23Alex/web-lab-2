<%@ page import="com.d23alex.areacheckapp.io.views.models.AreaCheckViewModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% AreaCheckViewModel viewModel = (AreaCheckViewModel) request.getAttribute("view-model");%>

<html>
<head>
    <title>Title</title>
</head>
<body style="display: flex; flex-direction: column">

<div>status: <%=viewModel.getStatusPhase()%></div>
<div>point: <%=viewModel.getPoint()%></div>
<div>radius: <%=viewModel.getR()%></div>
<div>result: <%=viewModel.getResultPhrase()%></div>
<div>request date: <%=viewModel.getRequestDate()%></div>
<div>calculation time: <%=viewModel.getCalculationTime()%></div>

</body>
</html>
