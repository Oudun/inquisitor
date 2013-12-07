<%@ include file="top.jsp"%>
<h1>Properties</h1>
<%
    Dao dao = new DaoImpl();
    if ("delete".equals(request.getParameter("action"))) {
        dao.deleteProperty(request.getParameter("property"));
    } else if("save".equals(request.getParameter("action"))){
        dao.saveProperty(request.getParameter("property"), request.getParameter("theme"), request.getParameter("name"));
    }
    List<Theme> properties = dao.getProperties(request.getParameter("theme"));
%>
<table>
    <%
        for (Theme property : properties) {
    %>
    <tr>
        <td><b><%=property.getName()%></b></td>
        <td><a href="properties.jsp?action=delete&property=<%=property.getId()%>">Delete</a></td>
        <td><a href="values.jsp?property=<%=property.getId()%>">View Values</td>
    </tr>
    <%
        }
    %>
    <td><a href="property_create.jsp">Create new property</a></td>
    <td colspan="3">&nbsp;</td>
</table>