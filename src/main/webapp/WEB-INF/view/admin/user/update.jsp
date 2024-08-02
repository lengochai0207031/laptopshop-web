<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"
          integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl7/4pb4H4PRnp56AZW4NEfT8pKcHggcUE50In/3fZ"
          crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script>
          $(document).ready(function () {
            $("#avatarFile").change(function (e) {
              const imgURL = URL.createObjectURL(e.target.files[0]);
              $("#avatarPreview").attr("src", imgURL).css({ display: "block" });
            });
          });
        </script>
      </head>

      <body class="sb-nav-fixed">
        <jsp:include page="../playout/header.jsp" />
        <div id="layoutSidenav">
          <jsp:include page="../playout/sidebar.jsp" />
          <div id="layoutSidenav_content">
            <main>
              <div class="container-fluid px-4">
                <h1 class="mt-4">Manage Users</h1>
                <ol class="breadcrumb mb-4">
                  <li class="breadcrumb-item"><a href="">Dashboard</a></li>
                  <li class="breadcrumb-item active">Users</li>
                </ol>
                <form:form class="row g-3" method="post" action="/admin/user/update" modelAttribute="newUser"
                  enctype="multipart/form-data">
                  <div class="mb-3 col-12 col-md-6">
                    <label for="Id" class="form-label">Id</label>
                    <c:set var="passwordHasBindError">
                      <form:errors path="id" />
                    </c:set>
                    <form:input type="text" class="form-control ${not empty passwordHasBindError ? 'is-invalid' : ''}"
                      id="password" path="id" />

                  </div>
                  <div class="mb-3 col-12 col-md-6">
                    <label for="email" class="form-label">Email address</label>
                    <c:set var="emailHasBindError">
                      <form:errors path="email" />
                    </c:set>
                    <form:input type="text" class="form-control ${not empty emailHasBindError ? 'is-invalid' : ''}"
                      id="email" placeholder="email@example.com" path="email" />
                    <form:errors path="email" cssClass="invalid-feedback" />
                  </div>



                  <div class="mb-3 col-12 col-md-6">
                    <label for="phone" class="form-label">Phone Number</label>
                    <c:set var="phoneHasBindError">
                      <form:errors path="phone" />
                    </c:set>
                    <form:input type="text" class="form-control ${not empty phoneHasBindError ? 'is-invalid' : ''}"
                      id="phone" placeholder="0839696120" path="phone" />
                    <form:errors path="phone" cssClass="invalid-feedback" />
                  </div>

                  <div class="mb-3 col-12 col-md-6">
                    <label for="fullName" class="form-label">Full Name</label>
                    <c:set var="fullNameHasBindError">
                      <form:errors path="fullName" />
                    </c:set>
                    <form:input type="text" class="form-control ${not empty fullNameHasBindError ? 'is-invalid' : ''}"
                      id="fullName" placeholder="Lê Ngọc Hải" path="fullName" />
                    <form:errors path="fullName" cssClass="invalid-feedback" />
                  </div>

                  <div class="mb-3">
                    <label for="address" class="form-label">Address</label>
                    <c:set var="addressHasBindError">
                      <form:errors path="address" />
                    </c:set>
                    <form:input type="text" class="form-control ${not empty addressHasBindError ? 'is-invalid' : ''}"
                      id="address" placeholder="Address" path="address" />
                    <form:errors path="address" cssClass="invalid-feedback" />
                  </div>

                  <div class="mb-3 col-12 col-md-6">
                    <label class="form-label">Role:</label>
                    <form:select class="form-select" path="role.name">
                      <form:option value="ADMIN">ADMIN</form:option>
                      <form:option value="USER">USER</form:option>
                    </form:select>
                  </div>

                  <div class="mb-3 col-12 col-md-6">
                    <label for="avatarFile" class="form-label">Avatar</label>
                    <input class="form-control" type="file" id="avatarFile" name="fileName" multiple
                      accept=".png, .jpg, .jpeg" />
                  </div>

                  <div class="col-12 col-md-6">
                    <img style="max-width: 250px; display: none" alt="avatar" id="avatarPreview" />
                  </div>

                  <div class="col-12">
                    <button type="submit" class="btn btn-primary">Update User</button>
                  </div>
                </form:form>

              </div>
          </div>
        </div>
        </main>
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