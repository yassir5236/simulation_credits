<%@ page import="org.example.credit.model.CreditDemande" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Liste des Demandes de Crédit</title>
</head>
<body>

<h2>Liste des Demandes de Crédit</h2>

<!-- Formulaire pour soumettre une requête pour obtenir les données -->
<form action="<%= request.getContextPath() %>/submitForm" method="get">
    <button type="submit">Charger les Demandes</button>
</form>

<!-- Tableau des demandes -->
<table border="1">
    <%
        List<CreditDemande> demandes = (List<org.example.credit.model.CreditDemande>) request.getAttribute("demandes");
        if (demandes != null && !demandes.isEmpty()) {
    %>
    <tr>
        <th>Numéro</th>
        <th>CIN</th>
        <th>Civilité</th>
        <th>Date de Naissance</th>
        <th>Durée</th>
        <th>Email</th>
        <th>Mensualité</th>
        <th>Montant</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Profession</th>
        <th>Revenus</th>
        <th>Téléphone</th>
    </tr>
    <%
        for (org.example.credit.model.CreditDemande demande : demandes) {
    %>
    <tr>
        <td><%= demande.getNumero() %></td>
        <td><%= demande.getCin() %></td>
        <td><%= demande.getCivilite() %></td>
<%--        <td><%= demande.getCoutTotal() %></td>--%>
        <td><%= demande.getDateNaissance() %></td>
        <td><%= demande.getDuree() %></td>
        <td><%= demande.getEmail() %></td>
        <td><%= demande.getMensualite() %></td>
        <td><%= demande.getMontant() %></td>
        <td><%= demande.getNom() %></td>
        <td><%= demande.getPrenom() %></td>
        <td><%= demande.getProfession() %></td>
        <td><%= demande.getRevenus() %></td>
        <td><%= demande.getTelephone() %></td>
    </tr>
    <%
        }
    %>
    <%
    } else {
    %>
    <tr>
        <td colspan="14">Aucune demande trouvée.</td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
