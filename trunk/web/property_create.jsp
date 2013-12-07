<%@ include file="top.jsp"%>
<%
    Property property;
    String propertyName = "";
    if (request.getParameter("property")!=null) {
        Dao dao = new DaoImpl();
        property = dao.getProperty(request.getParameter("property"));
        propertyName = property.getName();
    }
%>
<h1>Create New Property</h1>
<form action="properties.jsp">
    <input type="hidden" name="theme" value="<%=request.getParameter("theme")%>">
    <input type="hidden" name="property" value="<%=request.getParameter("property")%>">
    <table>
        <tr><td>Name</td><td><input type="text" name="name" value="<%=propertyName%>"></td></tr>
        <tr><td>&nbsp;</td><td><input type="submit" name="action" value="save"></td></tr>
        <tr><td>&nbsp;</td><td><input type="submit" name="action" value="cancel"></td></tr>
    </table>
</form>