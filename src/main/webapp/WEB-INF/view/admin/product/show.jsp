<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
      </head>

      <body class="sb-nav-fixed">
        <jsp:include page="../playout/header.jsp" />
        <div id="layoutSidenav">
          <jsp:include page="../playout/sidebar.jsp" />
          <div id="layoutSidenav_content">
            <main>
              <div class="container-fluid px-4">
                <h1 class="mt-4">Manage Product</h1>
                <ol class="breadcrumb mb-4">
                  <li class="breadcrumb-item"><a href="">Dashboard</a></li>
                  <li class="breadcrumb-item active">Product</li>
                </ol>
                <div class="mt-5">
                  <div class="row">
                    <div class="col-12 mx-auto">
                      <div class="d-flex justify-content-between">
                        <h3>Table Product</h3>
                        <a href="/admin/product/create" class="btn btn-primary">Create a Product</a>
                      </div>

                      <hr />

                      <table class="table table-bordered table-hover">
                        <thead>
                          <tr>
                            <th>ID</th>
                            <th> Name Product</th>
                            <th>Price</th>
                            <th>Image Product</th>
                            <th>DetailDesc</th>
                            <th>ShortDesc</th>
                            <th>Quantity</th>
                            <th>Sold</th>
                            <th>Factory</th>
                            <th>Target</th>
                          </tr>
                        </thead>
                        <tbody>
                          <c:forEach var="product" items="${products}">
                            <tr>
                              <td>${product.id}</td>
                              <td>${product.name}</td>
                              <td>${product.price}</td>
                              <td><img src="/images/product/${product.image}" alt="Product item" class="img-fluid"></td>
                              <td>${product.detailDesc}</td>
                              <td>${product.shortDesc}</td>
                              <td>${product.quantity}</td>
                              <td>${product.sold}</td>
                              <td>${product.factory}</td>
                              <td>${product.target}</td>
                              <td>
                                <a href="/admin/product/detail/${product.id}">
                                  <button class="btn btn-success">View</button></a>
                                <a href="/admin/product/update/${product.id}">
                                  <button class="btn btn-warning mx-2">Update</button></a>
                                <a href="/admin/product/delete/${product.id}">
                                  <button class="btn btn-danger">Delete</button></a>
                              </td>
                            </tr>
                          </c:forEach>
                        </tbody>
                      </table>

                      <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                          <li class="page-item disabled">
                            <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                          </li>
                          <c:forEach begin="0" end="${totalPage -1}" varStatus="loop">
                            <li class="page-item"><a class="page-link" href="/admin/product?page=${loop.index + 1}">
                                ${loop.index + 1}
                              </a></li>
                          </c:forEach>
                          <li class="page-item">
                            <a class="page-link" href="#">Next</a>
                          </li>
                        </ul>
                      </nav>
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