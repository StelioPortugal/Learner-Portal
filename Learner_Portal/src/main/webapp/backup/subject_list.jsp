<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject List</title>
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
            <h1>Subject List</h1>
            <a href="SubjectServlet?action=add">Add Subject</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Subject Name</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="subject" items="${subjectList}">
                    <tr>
                        <td>${subject.id}</td>
                        <td>${subject.subjectName}</td>
                        <td>
                            <a href="SubjectServlet?action=edit&id=${subject.id}">Edit</a>
                            <a href="SubjectServlet?action=delete&id=${subject.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </section>
</body>
</html>