<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Liste des Demandes de Crédit</title>
</head>
<body>

<h2>Liste des Demandes de Crédit</h2>

<!-- Formulaire pour soumettre une requête pour obtenir les données -->
<form action="${pageContext.request.contextPath}/submitForm" method="get">
    <button type="submit">Charger les Demandes</button>
</form>

</body>
</html>
