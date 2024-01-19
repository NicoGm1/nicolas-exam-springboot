<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="CityDex"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container main">
    <h1 class="m-5">Bienvenue sur La Centrafake !</h1>
    <div class="bg-dark p-3 rounded">
        <h2 class="my-5">Les dernières listing</h2>
        <div class="row">
            <c:forEach items="${gamesReleased}" var="game">
                <a class="col-md-4 mt-2 main-game-card" href="${WebUrlRoute.URL_GAME}/${game.slug}">
                    <div class="game-card">
                        <div class="game-card-img">
                            <img alt="${game.name}" src="${game.thumbnailCover}">
                        </div>
                        <div class="d-flex justify-content-between">
                            <p>${game.name}</p>
                            <p>${game.price}€</p>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
