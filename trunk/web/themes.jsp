<%@ include file="top.jsp"%>
<h1>Themes</h1>
<%
    Dao dao = new DaoImpl();
    if ("delete".equals(request.getParameter("action"))) {
        dao.deleteTheme(request.getParameter("theme"));
    } else if("save".equals(request.getParameter("action"))){
        dao.saveTheme(request.getParameter("theme"), request.getParameter("name"));
    }
    List<Theme> themes = dao.getThemes();
%>
<table>
    <%
        for (Theme theme : themes) {
    %>
    <tr>
        <td><b><%=theme.getName()%></b></td>
        <td><a href="themes.jsp?action=delete&theme=<%=theme.getId()%>">Delete</a></td>
        <td><a href="properties.jsp?theme=<%=theme.getId()%>">View Properties</td>
        <td><a href="items.jsp?theme=<%=theme.getId()%>">View Items</td>
    </tr>
    <%
        }
    %>
    <td><a href="theme_create.jsp">Create new theme</a></td>
    <td colspan="3">&nbsp;</td>
</table>
