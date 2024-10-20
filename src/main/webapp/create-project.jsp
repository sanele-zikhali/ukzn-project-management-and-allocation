<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="user.User" %>
<%@page import="java.sql.*"%>
<%
  User user = (User) session.getAttribute("user");
  if(user == null){
    response.sendRedirect("login.jsp");
  }
%>
<html>
<head>
  <title>Projects | New</title>
  <%@include file="components/styles.jspf"%>
</head>
<body>
<div class="main__wrapper">
  <%@ include file="components/sidebar.jspf" %>
  <!--Main Content-->
  <div class="main-content">
    <%@ include file="components/navigation.jspf" %>
    <main>
      <p class="page-title">Create Project</p>
      <p class="page-subtitle">Create new project.</p>
      <div class="content-wrapper">
        <form action="create-project" method="post" enctype="multipart/form-data">
          <div class="form-group">
            <label for="moduleName" class="form-label">Module Name:</label>
            <input type="text" autocomplete="off" name="moduleName" id="moduleName" required placeholder="Information System"  class="form-control">
          </div>
          <div class="form-group">
            <label for="projectDoc" class="form-label">Project Doc (PDF Only):</label>
            <input type="file" autocomplete="off" name="projectDoc" accept="application/pdf" required id="projectDoc" multiple class="form-control">
          </div>
          <div class="form-group">
            <label for="description">Project Description:</label>
            <textarea name="description" placeholder="Project Description" required id="description" cols="30" rows="5" class="form-control"></textarea>
          </div>
          <button type="submit" class="btn btn-primary mt-3">
            <i class="fas fa-plus btn-icon"></i>
            Submit Project Data
          </button>
        </form>
      </div>
    </main>
  </div>
</div>
<%@include file="components/scripts.jspf"%>
</body>
</html>
