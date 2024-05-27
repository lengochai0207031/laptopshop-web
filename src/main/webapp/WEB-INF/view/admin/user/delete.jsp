<%@ page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
          <meta charset="utf-8" />
          <meta http-equiv="X-UA-Compatible" content="IE=edge" />
          <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
          <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
          <meta name="author" content="Hỏi Dân IT" />
          <title>Dashboard - Hỏi Dân IT</title>
          <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
          <link href="/css/styles.css" rel="stylesheet" />
          <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        </head>

        <body class="sb-nav-fixed">
          <jsp:include page="../playout/header.jsp" />
          <div id="layoutSidenav">
            <jsp:include page="../playout/sidebar.jsp" />
            <div id="layoutSidenav_content">
              <main>
                <div class="container mt-5">
                  <div class="row">
                    <div class="col-md-6 col-12 mx-auto">
                      <h3>Delete a user</h3>
                      <hr />


                      <div class="alert alert-danger">
                        are you sure to delete this user
                      </div>
                      <form:form method="post" modelAttribute="newUser" action="/admin/user/delete">
                        <table class="table" style="width: 300px;">
                          <thead>
                            <tr>
                              <td> ID:
                                <form:input type="text" class="form-control" path="id" value="${id}" />
                              </td>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td>${user.fullName}</td>
                            </tr>
                            <tr>
                              <td>${user.role.name}</td>
                            </tr>
                            <tr>
                              <td>
                                <img src="/images/avatar/${user.avatar}" alt="images"
                                  style="width: 150px; height: 150px;">
                              </td>
                            </tr>
                            <tr>
                              <td>${user.address}</td>
                            </tr>
                          </tbody>
                        </table>
                        <button class="btn - btn-danger">Confirm</button>
                      </form:form>
                    </div>
                  </div>
                </div>
              </main>
              <jsp:include page="../playout/footer.jsp" />
            </div>
          </div>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
          <script src="/js/scripts.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
            crossorigin="anonymous"></script>
          <script src="/assets/demo/chart-area-demo.js"></script>
          <script src="/assets/demo/chart-bar-demo.js"></script>
          <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
            crossorigin="anonymous"></script>
          <script src="/js/datatables-simple-demo.js"></script>
        </body>

        </html>