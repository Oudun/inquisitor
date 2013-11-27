<%@ page import="org.helico.inquisitor.Dao" %>
<%@ page import="org.helico.inquisitor.impl.DaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="org.helico.inquisitor.model.Theme" %><%

    Dao dao = new DaoImpl();
    List<Theme> themes = dao.getThemes();
    for (Theme theme : themes) {
%>
<%=theme.getId()%>
<%=theme.getName()%>
<%
    }

%>