<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>

        <div class="container">
            <security:authorize access="!isAuthenticated()">
            <h1 class="text-center mt-5 mb-1">User Login</h1>

            <div class="form-group ${error != null ? 'has-error' : ''}">
                <span>${message}</span>
                <div class=" justify-content-md-center">
                    <form method="POST" action="${WebUrlRoute.URL_LOGIN}"
                        class="form-signin p-5 col-lg-6 col-md-8 col-sm-12 mx-auto">
                        <div class="mb-3 row">
                            <input name="name" type="text" class="form-control" placeholder="Name"
                                autofocus="true" />
                        </div>
                        <div class="mb-3 row">
                            <input name="password" type="password" class="form-control" placeholder="Password" />
                        </div>
                        <p class="invalid-feedback">${error}</p>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <div class="row">
                            <div class="col-md-4 mb-3">
                                <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                            </div>
                            <div class="col-md-8 mt-3 text-md-end">
                                <h5>
                                    <a href="${WebUrlRoute.URL_REGISTER}" class="btn-link">
                                        Create an account
                                    </a>
                                </h5>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </security:authorize>
        <security:authorize access="isAuthenticated()">
            <h1 class="text-center mt-5 mb-1">User Already Login =)</h1>
        </security:authorize>
        </div>

<%@ include file="../footer.jsp" %>