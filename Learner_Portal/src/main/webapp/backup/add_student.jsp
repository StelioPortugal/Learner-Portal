<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<style>
    * {
        margin:0;
        box-sizing:border-box;
        font-family:verdana;
    }
    body {
        height:100vh;
        width:100vw;
    }
    nav {
        width:100%;
        display:flex;
        justify-content:center;
        align-items:center;
        padding:10px;
        background:#333;
        color:#eee;
    }
    a {
        text-decoration:none;
        color:#eee;
    }
    a:hover {
        text-decoration:underline;
    }
    .logo {
        flex:1 0 0;
    }
    .other,.profile {
        display:flex;
        align-items:center;
    }
    .other a {
        margin-right:10px;
    }
    .profile {
        background:#eee;
        color:#333;
        padding:10px;
    }
    section {
        display:flex;
        height:100%;
    }
    .sidenav {
        width:20vw;
        display:flex;
        flex-direction:column;
        align-items:center;
        background:#1a2b3c;
    }
    .sidenav a {
        margin:10px;
    }
    iframe {
        width:80vw;
        border:none;
    }
</style>
</head>
<body>
    <h1>Add Student</h1>
    <form action="student?action=add" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" id="firstName" required><br>
        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" id="lastName" required><br>
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" required><br>
        <input type="submit" value="Add Student">
    </form>
    <a href="student?action=list">Back to student list</a>
</body>
</html>
