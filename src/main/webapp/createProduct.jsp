<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<h1>Create Product!</h1>
<form action="products" method="post">
    Name: <input type="text" name="name"><br>
    Description: <input type="text" name="description"><br>
    Price: <input type="text" name="price"><br>
    Coupon Code: <input type="text" name="coupon"><br>
    <input type="submit" value="Create Product">
</form>
</body>
</html>