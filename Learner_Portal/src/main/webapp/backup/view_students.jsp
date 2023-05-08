<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Student</title>
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
    <nav>
        <div class="logo">Admin Portal</div>
        <div class="other">
            <a href="dashboard.jsp">Dashboard</a>
        </div>
        <div class="profile">Welcome, Admin</div>
    </nav>
    <section>
        <div class="sidenav">
            <a href="ClassServlet?action=list">Classes</a>
            <a href="SubjectServlet?action=list">Subjects</a>
            <a href="TeacherServlet?action=list">Teachers</a>
            <a href="StudentServlet?action=list">Students</a>
        </div>
        <div class="content">
            <h1>View Student</h1>
            <table>
                <tr>
                    <th>ID</th>
                    <td>${student.id}</td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td>${student.name}</td>
                </tr>
                <tr>
                    <th>Class</th>
                    <td>${student.classroom.className}</td>
                </tr>
            </table>
            <a href="StudentServlet?action=edit&id=${student.id}">Edit</a>
            <a href="StudentServlet?action=delete&id=${student.id}">Delete</a>
        </div>
    </section>
	</body>
	</html>
