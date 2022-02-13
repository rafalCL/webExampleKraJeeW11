<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>JSP2</title>
</head>
<body>
<p>Numbers:</p>
    <c:if test="${not empty start}">
        <c:forEach begin="${start}" end="${end}" var="idx">
            <div>${idx}</div>
        </c:forEach>
    </c:if>
</body>
</html>
