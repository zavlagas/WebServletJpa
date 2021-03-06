<%-- 
    Document   : editSalesmanFamilyForm
    Created on : 11 Οκτ 2020, 8:42:49 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Family Member</title>
        <link rel="stylesheet" href="../styling/styling.css" />
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>Edit Family Member</h2>
            <form class="form" action="${pageContext.request.contextPath}/salesman/editFamilyMember" method="POST" >
                <input type="hidden" name="sid" value="${salesmanId}"/>
                <label for="mid">Id</label>
                <input id="mid" type="number" name="mid" readonly value="${member.fid}"/>
                <label for="fname">Name</label>
                <input id="fname" type="text" name="name" value="${member.fname}"/>
                <label for="relation">Relationship</label>
                <input id="relation" type="text" name="relation" value="${member.frelationship}"/>
                <label for="dob">Date Of Birth</label>
                <input id="dob" type="date" name="dob" value="${member.dob}"/>
                <input class="btn" type="submit" value="Submit"/>
            </form>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
