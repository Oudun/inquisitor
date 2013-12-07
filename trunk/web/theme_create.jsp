<%@ page import="org.helico.inquisitor.impl.DaoImpl" %>
<%@ page import="org.helico.inquisitor.Dao" %>
<%@ include file="top.jsp"%>
<h1>Create New Theme</h1>
<form action="themes.jsp">
    <input type="hidden" name="theme" value="<%=request.getParameter("theme")%>">
    <table>
        <tr><td>Name</td><td><input type="text" name="name"></td></tr>
        <tr><td>&nbsp;</td><td><input type="submit"name="action" value="save"></td></tr>
    </table>
</form>
