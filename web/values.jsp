<%@ include file="top.jsp"%>
<h1>Values</h1>
<%
    Dao dao = new DaoImpl();
    if ("delete".equals(request.getParameter("action"))) {
        dao.deletePropertyValue(request.getParameter("value"));
    } else if("save".equals(request.getParameter("action"))){
        dao.savePropertyValue(request.getParameter("value"), request.getParameter("property"), request.getParameter("name"));
    }
    List<PropertyValue> values = dao.getPropertyValues(request.getParameter("property"));
%>
<table>
    <%
        for (PropertyValue value : values) {
    %>
    <tr>
        <td width="480"><b><%=value.getName()%></b></td>
        <td><a href="values.jsp?action=delete&value=<%=value.getId()%>&property=<%=value.getPropertyId()%>">
            Delete</a>
        </td>
        <td><a href="values.jsp?value=<%=value.getId()%>">
            View Values</td>
        <td><a href="value_create.jsp?theme=<%=value.getPropertyId()%>&value=<%=value.getId()%>">
            Edit value</a></td>

    </tr>
    <%
        }
    %>
    <td><a href="value_create.jsp?property=<%=request.getParameter("property")%>">Create new value</a></td>
    <td colspan="3">&nbsp;</td>
</table>