
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.credit.model.CreditDemande" %>
<%@ page import="org.example.credit.model.CreditDemandeEtat" %>
<%@ page import="java.util.List" %>

<%
    CreditDemande demande = (CreditDemande) request.getAttribute("demande");
    List<CreditDemandeEtat> etatsTries = (List<CreditDemandeEtat>) request.getAttribute("etatsTries");
%>
<html>
<head>
    <title>Détails de la demande</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/detail.css">
</head>
<body>
<h2>Détails de la demande</h2>

<p><strong>Numéro de la demande:</strong> <%= demande.getNumero() %>
</p>
<p><strong>Projet:</strong> <%= demande.getProjet() %>
</p>
<p><strong>Montant:</strong> <%= demande.getMontant() %> DH </p>
<p><strong>Durée:</strong> <%= demande.getDuree() %> mois</p>
<p><strong>Nom du client:</strong> <%= demande.getNom() %> <%= demande.getPrenom() %>
</p>

<h3>Historique des états</h3>
<table border="1">
    <thead>
    <tr>
        <th>État</th>
        <th>Date de modification</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (etatsTries != null && !etatsTries.isEmpty()) {
            for (CreditDemandeEtat etat : etatsTries) {
    %>
    <tr>
        <td><%= etat.getEtat().getEtat() %>
        </td>
        <td><%= etat.getDateModife() %>
        </td>

        <td><%= etat.getDescription() != null ? etat.getDescription() : "N/A" %>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="3">Aucun état trouvé.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<br>
<a class="" href="<%= request.getContextPath() %>/list">Retour à la liste</a>
</body>
</html>







