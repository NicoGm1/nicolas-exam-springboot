<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="CentraFake"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container main">
    <h1 class="m-5 main-title">Bienvenue sur La Centrafake !</h1>
    <div class="bg-dark p-3 rounded">
        <h2 class="my-5">Les dernières listing :</h2>
        <div class="row">
            <c:forEach items="${listingReleased}" var="listing">
                <a class="col-md-4 mt-2 main-game-card" href="${WebUrlRoute.URL_LISTING}/${listing.slug}">
                    <div class="listing-card mb-5">
                        <div class="listing-card-img">
                            <img alt="${listing.title}" src="${listing.image}">
                        </div>
                        <div class="d-flex justify-content-between">
                            <p>${listing.title}</p>
                            <p>${listing.price/100}€</p>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
