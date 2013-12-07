<%@ include file="top.jsp"%>
<h1>Items</h1>
<%
    Dao dao = new DaoImpl();
    if ("delete".equals(request.getParameter("action"))) {
        dao.deleteItem(request.getParameter("item"));
    } else if("save".equals(request.getParameter("action"))){
        dao.saveItem(request.getParameter("item"), request.getParameter("theme"), request.getParameter("name"));
    }
    List<Item> items = dao.getItems(request.getParameter("theme"));
%>
<table>
    <%
        for (Item item : items) {
    %>
    <tr>
        <td><b><%=item.getName()%></b></td>
        <td><a href="items.jsp?action=delete&item=<%=item.getId()%>&theme=<%=item.getThemeId()%>">
            Delete</a>
        </td>
        <td><a href="item_create.jsp?theme=<%=item.getThemeId()%>&item=<%=item.getId()%>">
            Edit item</a></td>

    </tr>
    <%
        }
    %>
    <td><a href="item_create.jsp?theme=<%=request.getParameter("theme")%>">Create new item</a></td>
    <td colspan="2">&nbsp;</td>
</table>