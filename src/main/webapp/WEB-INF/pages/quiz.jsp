<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
</head>
<body>
<c:url var="getQuestion" value="/getQuestion"/>
<form:form action="${getQuestion}" commandName="question">
    <input type="submit" value="<spring:message text="Получить новую загадку"/>"/>
</form:form>
<h2>${question}</h2>
<c:url var="checkAnswer" value="/checkAnswer"/>
<form:form action="${checkAnswer}" commandName="answer">
    <input name="guess"/>
        <input type="submit" value="<spring:message text="Проверить ответ"/>"/>
    <h2>
        ${answer}
    </h2>
</form:form>
</body>
</html>
