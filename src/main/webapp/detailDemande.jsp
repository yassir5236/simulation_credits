<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.credit.model.CreditDemande" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.credit.model.Etat" %>
<%@ page import="java.util.Set" %>

<%
    // Récupérer l'attribut "demande" depuis la requête
    CreditDemande demande = (CreditDemande) request.getAttribute("demande");
%>
<html>
<head>
    <title>Détails de la demande</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/detail.css">
</head>
<body>
<h2>Détails de la demande</h2>

<p><strong>Numéro de la demande:</strong> <%= demande.getNumero() %></p>
<p><strong>Projet:</strong> <%= demande.getProjet() %></p>
<p><strong>Montant:</strong> <%= demande.getMontant() %> DH </p>
<p><strong>Durée:</strong> <%= demande.getDuree() %> mois</p>
<p><strong>Nom du client:</strong> <%= demande.getNom() %> <%= demande.getPrenom() %></p>

<h3>Historique des états</h3>
<table border="1">

    <thead>
    <tr>
        <th>État</th>
        <th>Date de modification</th>
    </tr>
    </thead>
    <tbody>
    <%
        Set<Etat> etats = demande.getEtats();
        if (etats != null && !etats.isEmpty()) {
            for (Etat etat : etats) {
    %>
    <tr>
        <td><%= etat.getEtat() %></td>
        <td><%= etat.getDateModife() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2">Aucun état trouvé.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<br>
<a href="<%= request.getContextPath() %>/listeDemande2.jsp">Retour à la liste</a>
</body>
</html>
