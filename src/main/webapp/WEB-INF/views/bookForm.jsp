<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html><body>
<h1>Create Book</h1>
<form method="post">
Title:<input name="title"/><br/>
ISBN:<input name="isbn"/><br/>
Author:<select name="authorId">
<c:forEach var="a" items="${authors}">
<option value="${a.id}">${a.name}</option>
</c:forEach>
</select><br/>
<button type="submit">Save</button>
</form>
</body></html>