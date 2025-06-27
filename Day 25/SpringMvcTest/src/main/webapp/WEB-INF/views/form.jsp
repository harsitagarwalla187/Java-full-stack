<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<form action="save" method="POST">
  <div class="form-group">
    <label for="Email">Email address</label>
    <input type="email" name="email" id="Email" placeholder="Enter email">
  </div>
  <div class="form-group">
    <label for="Password">Password</label>
    <input type="password" name="password" id="Password" placeholder="Password">
  </div>
  <button type="submit">Submit</button>
</form>
</body>
</html>
