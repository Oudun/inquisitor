<%@ include file="top.jsp"%>
<%
    Dao dao = new DaoImpl();
    if ("delete".equals(request.getParameter("action"))) {
        dao.deleteProperty(request.getParameter("property"));
    } else if("save".equals(request.getParameter("action"))){
        dao.saveProperty(request.getParameter("property"), request.getParameter("theme"), request.getParameter("name"));
    }
    List<Property> properties = dao.getProperties(request.getParameter("theme"));
    Theme theme = dao.getTheme(request.getParameter("theme"));
%>
<h1><a href="properties.jsp?theme=<%=theme.getId()%>"><%=theme.getName()%></a>&nbsp;&gt;&nbsp;Properties</h1>
<table>
    <%
        for (Property property : properties) {
    %>
    <tr>
        <td><b><%=property.getName()%></b></td>
        <td><a href="properties.jsp?action=delete&property=<%=property.getId()%>&theme=<%=property.getThemeId()%>">
            Delete</a>
        </td>
        <td><a href="values.jsp?property=<%=property.getId()%>">
            View Values</td>
        <td><a href="property_create.jsp?theme=<%=property.getThemeId()%>&property=<%=property.getId()%>">
            Edit property</a></td>

    </tr>
    <%
        }
    %>
    <td><a href="property_create.jsp?theme=<%=request.getParameter("theme")%>">Create new property</a></td>
    <td colspan="3">&nbsp;</td>
</table>