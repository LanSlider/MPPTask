<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Testers Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Bug Report List</h1>

<c:if test="${!empty listBugReports}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name Project</th>
            <th width="120">Description</th>
            <th width="120">Priority</th>
            <th width="120">Actual result</th>
            <th width="120">Expected result</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listBugReports}" var="bugReport">
            <tr>
                <td>${bugReport.id}</td>
                <td>${bugReport.nameProject}</td>
                <td>${bugReport.bugDescription}</td>
                <td>${bugReport.priority}</td>
                <td>${bugReport.actualResult}</td>
                <td>${bugReport.expectedResult}</td>
                <td><a href="<c:url value='bugreport/edit/${bugReport.id}'/>">Edit</a></td>
                <td><a href="<c:url value='bugreport/remove/${bugReport.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Bug Report</h1>

<c:url var="addAction" value="/bugreports/add"/>

<form:form action="${addAction}" commandName="bugReport">
    <table>
        <c:if test="${!empty bugReport.nameProject}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="NameProject">
                    <spring:message text="Name project"/>
                </form:label>
            </td>
            <td>
                <form:input path="nameProject"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="BugDescription">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="bugDescription"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="Priority">
                    <spring:message text="Priority"/>
                </form:label>
            </td>
            <td>
                <form:input path="priority"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="ActualResult">
                    <spring:message text="Actual result"/>
                </form:label>
            </td>
            <td>
                <form:input path="actualResult"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="ExpectedResult">
                    <spring:message text="Expected result"/>
                </form:label>
            </td>
            <td>
                <form:input path="expectedResult"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty bugReport.nameProject}">
                    <input type="submit"
                           value="<spring:message text="Edit Bug Report"/>"/>
                </c:if>
                <c:if test="${empty bugReport.nameProject}">
                    <input type="submit"
                           value="<spring:message text="Add Bug Report"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
