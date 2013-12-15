<%@ include file="top.jsp"%>
<%

            Quiz quiz = new Quiz();
            List<ItemPropertyValue> questions = quiz.getQuestions(5, "2");
            Dao dao = new DaoImpl();

%>
<h1>Quiz</h1>
<form>
<table>
<% for (ItemPropertyValue question : questions) {
    Long itemId = question.getItemId();
    Item item = dao.getItem(String.valueOf(itemId));
    PropertyValue propertyValue = dao.getPropertyValue(String.valueOf(question.getPropertyValueId()));
    Property property = dao.getProperty(String.valueOf(propertyValue.getPropertyId()));
%>
<tr>
<td><input type="checkbox" name="<%=question.getItemId()%>" value="<%=question.getPropertyValueId()%>"></td>
<td>
&nbsp;<%=property.getName()%>&nbsp;
OF
&nbsp;<%=item.getName()%>&nbsp;
IS
&nbsp;<%=propertyValue.getName()%>&nbsp;
</td>
</tr>
<% } %>
</table>
<input type="submit" value="Check">
</form>