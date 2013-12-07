<%@ include file="top.jsp"%>
<%
    Item item;
    String itemName = "";
    Dao dao = new DaoImpl();
    if (request.getParameter("item")!=null) {
        item = dao.getItem(request.getParameter("item"));
        itemName = item.getName();
    }
    List<Property> properties = dao.getProperties(request.getParameter("theme"));
%>
<h1>Create New Item</h1>
<form action="items.jsp">
    <input type="hidden" name="theme" value="<%=request.getParameter("theme")%>">
    <input type="hidden" name="item" value="<%=request.getParameter("item")%>">
    <table>
        <tr><td>Name</td><td><input type="text" name="name" value="<%=itemName%>"></td></tr>
    <% for (Property property : properties) { %>
        <tr>
            <td><%=property.getName()%></td><td>
                <select name="property_<%=property.getId()%>"><%
            List<PropertyValue> values = dao.getPropertyValues(String.valueOf(property.getId()));
            for (PropertyValue value : values) {
                    %><option value=<%=value.getId()%>><%=value.getName()%></option><% } %>
                </select>
            </td>
        </tr>
    <% } %>
        <tr><td>&nbsp;</td><td><input type="submit" name="action" value="save"></td></tr>
        <tr><td>&nbsp;</td><td><input type="submit" name="action" value="cancel"></td></tr>
    </table>
</form>