<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Search : ${search}"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container">
    <h1 class="text-center mt-3">Resultat de la recherche : ${search}</h1>

    <h2 class="my-5">Les dernières sorties</h2>
    <div class="row">
        <c:forEach items="${gamesSearch}" var="game">

        </c:forEach>
    </div>
</div>

<%@ include file="../footer.jsp" %>