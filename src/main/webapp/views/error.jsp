<%@ page import="jakarta.validation.ConstraintViolation" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Erreur</title>
</head>
<body>
<h1>Erreur</h1>
<h2>Erreur lors de la soumission du formulaire</h2>
<ul>
    <%
        // Récupérer les violations passées en attribut depuis la servlet
        Set<jakarta.validation.ConstraintViolation> violations = (Set<ConstraintViolation>) request.getAttribute("violations");

        // Parcourir les violations et les afficher
        if (violations != null && !violations.isEmpty()) {
            for (jakarta.validation.ConstraintViolation violation : violations) {
    %>
    <li><%= violation.getPropertyPath() %>: <%= violation.getMessage() %></li>
    <%
            }
        }
    %>
</ul>
<p>${error}</p>
<a href="/demandes">Retour aux demandes</a>
</body>
</html>
