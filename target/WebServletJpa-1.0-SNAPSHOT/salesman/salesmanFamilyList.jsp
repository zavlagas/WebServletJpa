<%-- 
    Document   : salesmanFamilyList
    Created on : 11 Οκτ 2020, 3:26:08 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styling/styling.css" />
        <title>Family Members</title>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>Family Members Of ${salesman.sname}</h2>
            <div class="btn-area">
                <a  class="btn" href="${pageContext.request.contextPath}/salesman/createSalesmanFamily?id=${salesman.scode}">Create A New Family Member</a>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Relationship</th>
                        <th>Birth Date</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <c:choose>
                    <c:when test="${salesman.salesmanHasAFamily()}">
                        <tbody>
                            <c:forEach  items="${salesman.getMembers()}" var="m">
                                <tr>
                                    <td>${m.fid}</td>
                                    <td>${m.fname}</td>
                                    <td>${m.frelationship}</td>
                                    <td>${m.dob}</td>
                                    <td class="buttontd"><a class="btn" href="${pageContext.request.contextPath}/salesman/editFamilyMember?mid=${m.fid}&sid=${salesman.scode}">Edit</a></td>
                                    <td class="buttontd"><a class="btn" href="${pageContext.request.contextPath}/salesman/deleteFamilyMember?mid=${m.fid}&sid=${salesman.scode}">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:when>
                    <c:otherwise>
                        </br>
                    </c:otherwise>
                </c:choose>


                ${param.message}

            </table>
        </section>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
