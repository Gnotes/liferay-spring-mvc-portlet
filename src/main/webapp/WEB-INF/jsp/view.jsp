<%@ include file="/WEB-INF/jsp/init.jsp" %>

<portlet:renderURL var="addUrl">
<portlet:param name="action" value="add"/>
</portlet:renderURL>

<a href="${addUrl}">Add</a>
