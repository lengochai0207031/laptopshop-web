<%@page contentType="text/html" pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
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
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl7/4pb4H4PRnp56AZW4NEfT8pKcHggcUE50In/3fZ"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
      crossorigin="anonymous"
    ></script>
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
            <h1 class="mt-4">Manage Product</h1>
            <ol class="breadcrumb mb-4">
              <li class="breadcrumb-item"><a href="">Dashboard</a></li>
              <li class="breadcrumb-item active">Update</li>
            </ol>
            <div class="container mt-5">
              <div class="row">
                <div class="col-md-6 col-12 mx-auto">
                  <h3>Update a Product</h3>
                  <hr />
                  <form:form
                    class="row g-3"
                    method="post"
                    action="/admin/product/update"
                    modelAttribute="product"
                    enctype="multipart/form-data"
                  >
                    <div class="mb-3 col-12 col-md-6" style="display: none">
                      <label for="id" class="form-label">ID Product</label>
                      <form:input
                        type="text"
                        class="form-control"
                        id="id"
                        placeholder=" id product"
                        path="id"
                      />
                    </div>
                    <div class="mb-3 col-12 col-md-6">
                      <label for="name" class="form-label">Name Product</label>
                      <form:input
                        type="text"
                        class="form-control"
                        id="name"
                        placeholder="Product Name"
                        path="name"
                      />
                    </div>
                    <div class="mb-3 col-12 col-md-6">
                      <label for="price" class="form-label"
                        >Price Product</label
                      >
                      <form:input
                        type="text"
                        class="form-control"
                        id="price"
                        placeholder="Price Product"
                        path="price"
                      />
                    </div>
                    <div class="mb-3 col-12 col-md-6">
                      <label for="factory" class="form-label">Factory</label>
                      <form:input
                        type="text"
                        class="form-control"
                        id="factory"
                        placeholder="Factory"
                        path="factory"
                      />
                    </div>
                    <div class="mb-3 col-12 col-md-6">
                      <label for="quantity" class="form-label">Quantity</label>
                      <form:input
                        type="text"
                        class="form-control"
                        id="quantity"
                        placeholder="Quantity"
                        path="quantity"
                      />
                    </div>
                    <div class="mb-3">
                      <label for="detailDesc" class="form-label"
                        >DetailDesc Products</label
                      >
                      <form:textarea
                        class="form-control"
                        id="detailDesc"
                        rows="3"
                        path="detailDesc"
                      ></form:textarea>
                    </div>
                    <div class="mb-3">
                      <label for="shortDesc" class="form-label"
                        >ShortDesc Products</label
                      >
                      <form:textarea
                        class="form-control"
                        id="shortDesc"
                        rows="3"
                        path="shortDesc"
                      ></form:textarea>
                    </div>
                    <div class="mb-3 col-12 col-md-6">
                      <label for="sold" class="form-label">Sold</label>
                      <form:input
                        type="text"
                        class="form-control"
                        id="sold"
                        placeholder="Sold"
                        path="sold"
                      />
                    </div>
                    <div class="mb-3 col-12 col-md-6">
                      <label for="formFileMultiple" class="form-label"
                        >Images Product</label
                      >
                      <input
                        class="form-control"
                        type="file"
                        id="avatarFile"
                        name="fileName"
                        multiple
                        accept=".png, .jpg, .jpeg"
                        path="image"
                      />
                    </div>
                    <div class="col-12 col-md-6">
                      <c:if test="${not empty product.image}">
                        <img
                          src="resources/images/product/${product.image}"
                          style="max-width: 250px"
                          alt="images"
                          id="avatarPreview"
                        />
                      </c:if>
                    </div>
                    <div class="mb-3">
                      <label for="target" class="form-label"
                        >Target Products</label
                      >
                      <form:textarea
                        class="form-control"
                        id="target"
                        rows="3"
                        path="target"
                      ></form:textarea>
                    </div>
                    <div class="col-12">
                      <button type="submit" class="btn btn-primary">
                        Sign in
                      </button>
                    </div>
                  </form:form>
                </div>
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
    <script src="/js/dashboard.js"></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
      crossorigin="anonymous"
    ></script>
    <script src="/assets/demo/chart-area-demo.js"></script>
    <script src="/assets/demo/chart-bar-demo.js"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
      crossorigin="anonymous"
    ></script>
    <script src="/js/datatables-simple-demo.js"></script>
  </body>
</html>
