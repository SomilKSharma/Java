<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html><body>
<h1>Edit Book</h1>
<form method="post">
Title:<input name="title" value="${book.title}"/><br/>
ISBN:<input name="isbn" value="${book.isbn}"/><br/>
Author:<select name="authorId">
<c:forEach var="a" items="${authors}">
<option value="${a.id}" <c:if test="${book.author.id==a.id}">selected</c:if>>${a.name}</option>
</c:forEach>
</select><br/>
<button type="submit">Update</button>
</form>
</body></html>