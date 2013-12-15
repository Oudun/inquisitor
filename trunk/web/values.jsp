<%@ include file="top.jsp"%>
<%
    Dao dao = new DaoImpl();
    if ("delete".equals(request.getParameter("action"))) {
        dao.deletePropertyValue(request.getParameter("value"));
    } else if("save".equals(request.getParameter("action"))){
        dao.savePropertyValue(request.getParameter("value"), request.getParameter("property"), request.getParameter("name"));
    }
    Property property = dao.getProperty(request.getParameter("property"));
    Theme theme = dao.getTheme(String.valueOf(property.getThemeId()));
    List<PropertyValue> values = dao.getPropertyValues(request.getParameter("property"));
%>
<h1><a href="properties.jsp?theme=<%=theme.getId()%>"><%=theme.getName()%></a>&nbsp;&gt;&nbsp;
<a href="values.jsp?property=<%=property.getId()%>"><%=property.getName()%></a>&nbsp;&gt;&nbsp;Values</h1>
<table>
    <%
        for (PropertyValue value : values) {
    %>
    <tr>
        <td><b><%=value.getName()%></b></td>
        <td><a href="values.jsp?action=delete&value=<%=value.getId()%>&property=<%=value.getPropertyId()%>">
            Delete</a>
        </td>
        <td><a href="values.jsp?value=<%=value.getId()%>">
            View Values</td>
        <td><a href="value_create.jsp?property=<%=value.getPropertyId()%>&value=<%=value.getId()%>">
            Edit value</a></td>

    </tr>
    <%
        }
    %>
    <td><a href="value_create.jsp?property=<%=request.getParameter("property")%>">Create new value</a></td>
    <td colspan="3">&nbsp;</td>
</table>