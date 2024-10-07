





<%@ page import="org.example.credit.model.CreditDemande" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Liste des Demandes de Crédit</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/liste2.css">
</head>
<body>

<h2>Liste des Demandes de Crédit</h2>


<form action="<%= request.getContextPath() %>/submitForm" method="get">
    <button class="filter_button" type="submit"> Toutes  les Demandes</button>
</form>


<form action="<%= request.getContextPath() %>/" method="get" class="filter_form">
    <h3 class="filter_title">Filtrer les résultats par :</h3>

    <!-- Filtrage par date -->
    <div class="filter_group">
        <label for="date_filter" class="filter_label">Date :</label>
        <input type="date" id="date_filter" name="date" class="input_date_filter">
    </div>

    <!-- Filtrage par état -->
    <div class="filter_group">
        <label for="etat_filter" class="filter_label">État :</label>
        <select name="etat" id="etat_filter" class="select_filter">
            <option value="">Sélectionnez un état</option>
            <option value="approuve">Approuvé</option>
            <option value="rejete">Rejeté</option>
            <option value="en_attente">En attente</option>
        </select>
    </div>

    <!-- Bouton de soumission -->
    <button type="submit" class="filter_button">Rechercher</button>
</form>

<table border="1">
    <%
        List<CreditDemande> demandes = (List<org.example.credit.model.CreditDemande>) request.getAttribute("demandes");
        if (demandes != null && !demandes.isEmpty()) {
    %>
    <tr>
        <th>Nom</th>
        <th>Email</th>
        <th>Profession</th>
        <th>Projet</th>
        <th>Actions</th> <!-- Nouvelle colonne pour les boutons -->
    </tr>
    <%
        for (org.example.credit.model.CreditDemande demande : demandes) {
    %>
    <tr>
        <td><%= demande.getPrenom() %></td>
        <td><%= demande.getEmail() %></td>
        <td><%= demande.getProfession() %></td>
        <td><%= demande.getProjet() %></td>
        <td>
            <!-- Bouton pour afficher les détails -->
            <form action="<%= request.getContextPath() %>/detailDemande" method="get" style="display:inline;">
                <input type="hidden" name="demandeId" value="<%= demande.getNumero() %>" />
                <button type="submit">Détails</button>
            </form>

            <!-- Bouton pour changer l'état de la demande -->
            <form action="<%= request.getContextPath() %>/changerEtatDemande" method="post" style="display:inline;">
                <input type="hidden" name="demandeId" value="<%= demande.getNumero() %>" />
                <button type="submit">Changer État</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
    <%
    } else {
    %>
    <tr>
        <td colspan="5">Aucune demande trouvée.</td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
