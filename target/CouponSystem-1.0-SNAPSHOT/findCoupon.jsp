<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Coupon</title>
</head>
<body>
<h1>Find  Coupon!</h1>
<form action="coupons" method="post">
    Code: <input type="text" name="code"><br>
    <input type="hidden" name="action" value="find">
    <input type="submit" value="find">
</form>
</body>
</html>