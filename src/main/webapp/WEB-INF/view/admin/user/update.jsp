F
<form:input type="text" class="form-control " id="id" placeholder="id" path="id" />

</div>
<div class="mb-3 col-12 col-md-6">
  <label for="email" class="form-label">Email address</label>
  <c:set var="emailHasBindError">
    <form:errors path="email" />
  </c:set>
  <form:input type="text" class="form-control ${not empty emailHasBindError ? 'is-invalid' : ''}" id="email"
    placeholder="email@example.com" path="email" />
  <form:errors path="email" cssClass="invalid-feedback" />
</div>



<div class="mb-3 col-12 col-md-6">
  <label for="phone" class="form-label">Phone Number</label>
  <c:set var="phoneHasBindError">
    <form:errors path="phone" />
  </c:set>
  <form:input type="text" class="form-control ${not empty phoneHasBindError ? 'is-invalid' : ''}" id="phone"
    placeholder="0839696120" path="phone" />
  <form:errors path="phone" cssClass="invalid-feedback" />
</div>

<div class="mb-3 col-12 col-md-6">
  <label for=" fullName" class="form-label">Full Name</label>
  <c:set var="fullNameHasBindError">
    <form:errors path="fullName" />
  </c:set>
  <form:input type="text" class="form-control ${not empty fullNameHasBindError ? 'is-invalid' : ''}" id="fullName"
    placeholder="Lê Ngọc Hải" path="fullName" />
  <form:errors path="fullName" cssClass="invalid-feedback" />
</div>

<div class="mb-3">
  <label for="address" class="form-label">Address</label>
  <c:set var="addressHasBindError">
    <form:errors path="address" />
  </c:set>
  <form:input type="text" class="form-control ${not empty addressHasBindError ? 'is-invalid' : ''}" id="address"
    placeholder="Address" path="address" />
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
  <input class="form-control" type="file" id="avatarFile" name="fileName" multiple accept=".png, .jpg, .jpeg" />
</div>

<div class="col-12 col-md-6">
  <img style="max-width: 250px; display: none" alt="avatar" id="avatarPreview" />
</div>

<div class="col-12">
  <button type="submit" class="btn btn-primary">Update Product</button>
</div>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="/assets/demo/chart-area-demo.js"></script>
<script src="/assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
  crossorigin="anonymous"></script>
<script src="/js/datatables-simple-demo.js"></script>
</body>

</html>