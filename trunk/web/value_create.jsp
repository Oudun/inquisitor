<%@ include file="top.jsp"%>
<%
    PropertyValue propertyValue;
    String propertyValueName = "";
    if (request.getParameter("value")!=null) {
        Dao dao = new DaoImpl();
        propertyValue = dao.getPropertyValue(request.getParameter("value"));
        propertyValueName = propertyValue.getName();
    }
%>
<h1>Create New Value</h1>
<form action="values.jsp">
    <input type="hidden" name="property" value="<%=request.getParameter("property")%>">
    <input type="hidden" name="value" value="<%=request.getParameter("value")%>">
    <table>
        <tr><td>Name</td><td><input type="text" name="name" value="<%=propertyValueName%>"></td></tr>
        <tr><td>&nbsp;</td><td><input type="submit" name="action" value="save"></td></tr>
        <tr><td>&nbsp;</td><td><input type="submit" name="action" value="cancel"></td></tr>
    </table>
</form>