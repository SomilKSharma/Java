<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html><body>
<h1>Books</h1>
<c:if test="${not empty success}"><div>${success}</div></c:if>
<c:if test="${not empty error}"><div>${error}</div></c:if>
<a href="books/create">Create Book</a>
<table border="1">
<tr><th>ID</th><th>Title</th><th>ISBN</th><th>Author</th><th>Action</th></tr>
<c:forEach var="b" items="${books}">
<tr>
<td>${b.id}</td><td>${b.title}</td><td>${b.isbn}</td><td>${b.author.name}</td>
<td><a href="books/edit/${b.id}">Edit</a></td>
</tr>
</c:forEach>
</table>
</body></html>