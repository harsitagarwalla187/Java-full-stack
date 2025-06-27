

<html>
<head></head>
<body>
<h1>Hello Buddy!</h1>
<% String name = (String)request.getAttribute("name"); %>
<h1>Welcome <%= name %></h1>
</body>
</html>