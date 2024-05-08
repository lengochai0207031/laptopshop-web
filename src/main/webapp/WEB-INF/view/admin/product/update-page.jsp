<%@page contentType="text/html" pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@taglib
uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Update-page</title>
    <!-- Latest compiled and minified CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- <link href="/css/demo.css" rel="stylesheet"> -->
  </head>

  <body>
    <div class="container mt-5">
      <div class="row">
        <div class="col-md-6 col-12 mx-auto">
          <h3>Update-page ${id}</h3>
          <hr />
          <form:form
            method="post"
            action="/admin/product/update-page"
            modelAttribute="product"
          >
            <div class="mb-3">
              <label class="form-label">Id:</label>
              <form:input
                type="text"
                class="form-control"
                path="id"
                value="${id}"
              />
            </div>
            <div class="mb-3">
              <label class="form-label">Name:</label>
              <form:input type="password" class="form-control" path="name" />
            </div>
            <div class="mb-3">
              <label class="form-label">Age:</label>
              <form:input type="text" class="form-control" path="age" />
            </div>

            <button type="submit" class="btn btn-primary">Update</button>
          </form:form>
        </div>
      </div>
    </div>
  </body>
</html>
