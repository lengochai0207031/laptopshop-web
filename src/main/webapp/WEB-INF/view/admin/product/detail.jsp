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
          <link href="/css/dashboard.css" rel="stylesheet" />
          <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
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
              <div class="container mt-5">
                <div class="row">
                  <div class="col-12 mx-auto">
                    <div class="d-flex justify-content-between">
                      <h3>Details Users</h3>
                    </div>
                    <hr>
                    <div class="card" style="width: 30rem;margin-left: 400px;">
                      <div class="card-header">Featured</div>
                      <ul class="list-group list-group-flush">
                        <li class="list-group-item">${product.id}</li>
                        <li class="list-group-item">${product.name}</li>
                        <li class="list-group-item">${product.price}</li>
                        <li class="list-group-item">
                          <img src="/images/product/${product.image}" alt="" class="img-fluid" />
                        </li>
                        <li class="list-group-item">${product.detailDesc}</li>
                        <li class="list-group-item">${product.shortDesc}</li>
                        <li class="list-group-item">${product.quantity}</li>
                        <li class="list-group-item">${product.sold}</li>
                        <li class="list-group-item">${product.factory}</li>
                        <li class="list-group-item">${product.target}</li>
                      </ul>
                    </div>
                  </div>
                </div>
                <a href="/admin/product" class="btn btn-primary"> Table Product</a>

                <jsp:include page="../playout/footer.jsp" />
              </div>

            </div>
          </div>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
          <script src="/js/dashboard.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
            crossorigin="anonymous"></script>
          <script src="/assets/demo/chart-area-demo.js"></script>
          <script src="/assets/demo/chart-bar-demo.js"></script>
          <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
            crossorigin="anonymous"></script>
          <script src="/js/datatables-simple-demo.js"></script>
        </body>

        </html>