<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
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
            <a href="class_list.jsp">Classes</a>
            <a href="SubjectServlet?action=list">Subjects</a>
            <a href="TeacherServlet?action=list">Teachers</a>
            <a href="StudentServlet?action=list">Students</a>
        </div>
        <div class="content">
            <h1>Student List</h1>
            <a href="add_student.jsp">Add Student</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Class</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="student" items="${studentList}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.classroom.className}</td>
                        <td>
                            <a href="edit_student.jsp">Edit</a>
                            <a href="StudentServlet?action=delete&id=${student.id}">Delete</a>
						</td>
						</tr>
						</c:forEach>
						</table>
						</div>
						</section>
						
						</body>
						</html>
