
    <link rel="stylesheet" href="styles.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<style>
    /* Your style code */
</style>
<link rel="stylesheet" href="styles.css">
</head>
<body>
    <div style="display: flex; justify-content: center; align-items: center; height: 100vh;">
        <form action="AdminServlet" method="post">
            <input type="hidden" name="action" value="login">
            <h1>Admin Login</h1>
            <label for="username">Username:</label>
            <input type="text" name="username" id="username" required>
            <br>
            <label for="password">Password:</label>
            <input type="password" name="password" id="password" required>
            <br>
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
