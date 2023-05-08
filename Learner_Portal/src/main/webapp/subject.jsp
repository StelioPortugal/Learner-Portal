<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Subjects</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Subjects</h1>
    <!-- Add subject form -->
    <form action="SubjectServlet" method="post">
        <input type="hidden" name="action" value="add">
        <label for="subjectName">Subject Name:</label>
        <input type="text" name="subjectName" id="subjectName" required>
        <button type="submit">Add Subject</button>
    </form>

    <!-- Subject list -->
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Subject Name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%-- Iterate over subjects and populate the table --%>
            <%-- Add server-side code here --%>
        </tbody>
    </table>
</body>
</html>
