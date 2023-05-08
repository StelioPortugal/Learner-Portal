<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Admin Dashboard</h1>
        <p>Welcome, <%= session.getAttribute("admin") %>!</p>
        <p><a href="subject">Manage Subjects</a></p>
        <p><a href="teacher">Manage Teachers</a></p>
        <p><a href="student">Manage Students</a></p>
        <p><a href="class">Manage Classes</a></p>
        <p><a href="logout">Logout</a></p>
    </div>
</body>
</html>
