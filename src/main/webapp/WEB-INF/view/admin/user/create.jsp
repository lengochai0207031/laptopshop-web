<%@page contentType="text/html" pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@taglib
uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
    <meta name="author" content="Hỏi Dân IT" />
    <title>Dashboard - Hỏi Dân IT</title>
    <link
      href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
      rel="stylesheet"
    />
    <link href="/css/dashboard.css" rel="stylesheet" />

    <script
      src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
      crossorigin="anonymous"
    ></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
      $(document).ready(() => {
        const avatarFile = $("#avatarFile");
        avatarFile.change(function (e) {
          const imgURL = URL.createObjectURL(e.target.files[0]);
          $("#avatarPreview").attr("src", imgURL);
          $("#avatarPreview").css({ display: "block" });
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
          <div class="container mt-5">
            <div class="row">
              <div class="col-md-6 col-12 mx-auto">
                <h3>Create a user</h3>
                <hr />
                <form class="row g-3">
                  <div class="mb-3 col-12 col-md-6">
                    <label for="exampleFormControlInput1" class="form-label"
                      >Email address</label
                    >
                    <input
                      type="text"
                      readonly
                      class="form-control"
                      id="staticEmail2"
                      value="email@example.com"
                      path="email"
                    />
                  </div>
                  <div class="mb-3 col-12 col-md-6">
                    <label for="inputPassword2" class="form-label"
                      >Password</label
                    >
                    <input
                      type="password"
                      class="form-control"
                      id="inputPassword2"
                      placeholder="Password"
                      path="passWord"
                    />
                  </div>
                  <div class="mb-3 col-12 col-md-6">
                    <label for="staticEmail2" class="form-label"
                      >Phone Number</label
                    >
                    <input
                      type="text"
                      readonly
                      class="form-control"
                      id="staticEmail2"
                      value="0839696120"
                      path="phone"
                    />
                  </div>
                  <div class="mb-3 col-12 col-md-6">
                    <label for="inputPassword2" class="form-label"
                      >Full Name</label
                    >
                    <input
                      type="text"
                      class="form-control"
                      id="inputPassword2"
                      placeholder="Lê Ngọc Hải"
                      path="fullName"
                    />
                  </div>
                  <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">
                      Address</label
                    >
                    <input
                      type="text"
                      class="form-control"
                      id="exampleFormControlInput1"
                      placeholder="Address"
                      path="address"
                    />
                  </div>
                  <div class="mb-3 col-12 col-md-6">
                    <label class="form-label">Role:</label>
                    <select
                      class="form-select"
                      aria-label="Default select example"
                      path="role"
                    >
                      <option value="ADMIN">ADMIN</option>
                      <option value="USER">USER</option>
                    </select>
                  </div>
                  <div class="mb-3 col-12 col-md-6">
                    <label for="formFileMultiple" class="form-label"
                      >Multiple files input example</label
                    >
                    <input
                      class="form-control"
                      type="file"
                      id="avatarFile"
                      multiple
                      accept=".png, .jpg, .jpeg"
                    />
                  </div>
                  <div class="col-12 col-md-6">
                    <img
                      style="max-width: 250px; display: none"
                      alt="avatar"
                      id="avatarPreview"
                    />
                  </div>
                  <div class="col-12">
                    <button type="submit" class="btn btn-primary">
                      Sign in
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </main>
        <jsp:include page="../playout/footer.jsp" />
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      crossorigin="anonymous"
    ></script>
    <script src="js/dashboard.js"></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
      crossorigin="anonymous"
    ></script>
    <script src="assets/demo/chart-area-demo.js"></script>
    <script src="assets/demo/chart-bar-demo.js"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
      crossorigin="anonymous"
    ></script>
    <script src="js/datatables-simple-demo.js"></script>
  </body>
</html>
