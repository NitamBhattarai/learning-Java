<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 4/12/2026
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="/components/header.jsp" />

<form>
    <input type="text" name="id" value = "${topic-id} randomly">
    <input type="text" name="topic-named" value = "${topic-name} ">
    <button>Update</button>
</form>

<jsp:include page="/components/footer.jsp" />

