<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Coupon</title>
</head>
<body>
    <h1>Create Coupon!</h1>
    <form action="coupons" method="post">
        Code: <input type="text" name="code"><br>
        Discount: <input type="text" name="discount"><br>
        ExpDate: <input type="text" name="expDate"><br>
        <input type="hidden" name="action" value="create">
        <input type="submit" value="create">
    </form>
</body>
</html>