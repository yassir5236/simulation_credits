<%--<%@ page import="org.example.credit.model.CreditDemande" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Liste des Demandes de Crédit</title>--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/liste2.css">--%>
<%--</head>--%>
<%--<body>--%>

<%--<h2>Liste des Demandes de Crédit</h2>--%>
<%--<% if (request.getAttribute("message") != null) { %>--%>
<%--<p><%= request.getAttribute("message") %></p>--%>
<%--<% } %>--%>
<%--<form action="<%= request.getContextPath() %>/list" method="get">--%>
<%--    <button class="filter_button" type="submit">Toutes les Demandes</button>--%>
<%--</form>--%>

<%--<form action="<%= request.getContextPath() %>/list" method="get" class="filter_form">--%>
<%--    <h3 class="filter_title">Filtrer les résultats par :</h3>--%>

<%--    <div class="filter_group">--%>
<%--        <label for="date_filter" class="filter_label">Date :</label>--%>
<%--        <input type="date" id="date_filter" name="date" class="input_date_filter">--%>
<%--    </div>--%>

<%--    <div class="filter_group">--%>
<%--        <label for="etat_filter" class="filter_label">État :</label>--%>
<%--        <select name="etat" id="etat_filter" class="select_filter">--%>
<%--            <option value="">Sélectionnez un état</option>--%>
<%--            <option value="approuve">Approuvé</option>--%>
<%--            <option value="rejete">Rejeté</option>--%>
<%--            <option value="en_attente">En attente</option>--%>
<%--        </select>--%>
<%--    </div>--%>

<%--    <button type="submit" class="filter_button">Rechercher</button>--%>
<%--</form>--%>

<%--<table border="1">--%>
<%--    <%--%>
<%--        List<CreditDemande> demandes = (List<CreditDemande>) request.getAttribute("demandes");--%>
<%--        if (demandes != null && !demandes.isEmpty()) {--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <th>Nom</th>--%>
<%--        <th>Email</th>--%>
<%--        <th>Profession</th>--%>
<%--        <th>Projet</th>--%>
<%--        <th>Actions</th> <!-- Nouvelle colonne pour les boutons -->--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        for (org.example.credit.model.CreditDemande demande : demandes) {--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <td><%= demande.getPrenom() %></td>--%>
<%--        <td><%= demande.getEmail() %></td>--%>
<%--        <td><%= demande.getProfession() %></td>--%>
<%--        <td><%= demande.getProjet() %></td>--%>
<%--        <td>--%>
<%--            <!-- Bouton pour afficher les détails -->--%>
<%--            <form action="<%= request.getContextPath() %>/detailDemande" method="get" style="display:inline;">--%>
<%--                <input type="hidden" name="demandeId" value="<%= demande.getNumero() %>"/>--%>
<%--                <button type="submit">Détails</button>--%>
<%--            </form>--%>

<%--            <!-- Bouton pour changer l'état de la demande -->--%>
<%--            <form action="<%= request.getContextPath() %>/changerEtatDemande" method="post" style="display:inline;">--%>
<%--                <input type="hidden" name="demandeId" value="<%= demande.getNumero() %>"/>--%>
<%--                <select name="nouvelEtat">--%>
<%--                    <option value="approuve">Approuvé</option>--%>
<%--                    <option value="rejete">Rejeté</option>--%>
<%--                    <option value="en_attente">En attente</option>--%>
<%--                </select>--%>
<%--                <input type="text" name="justif" value=""   placeholder="Enter description" required/>--%>

<%--                <button type="submit">Changer État</button>--%>

<%--                <%--%>
<%--                    String successMessage = (String) session.getAttribute("successMessage");--%>
<%--                    if (successMessage != null) {--%>
<%--                %>--%>
<%--                <div class="alert alert-success">--%>
<%--                    <%= successMessage %>--%>
<%--                </div>--%>
<%--                <%--%>
<%--                        // Retirer le message de la session après l'affichage pour éviter qu'il se répète--%>
<%--                        session.removeAttribute("successMessage");--%>
<%--                    }--%>
<%--                %>--%>
<%--            </form>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>
<%--    <%--%>
<%--    } else {--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <td colspan="5">Aucune demande trouvée.</td>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>
<%--</table>--%>


<%--</body>--%>
<%--</html>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.credit.model.CreditDemande" %>
<%@ page import="java.util.List" %>

<%
    // Récupérer la liste des demandes depuis la requête
    List<CreditDemande> demandes = (List<CreditDemande>) request.getAttribute("demandes");
    String message = (String) request.getAttribute("message");
%>

<html>
<head>
    <title>Liste des demandes de crédit</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/liste2.css">
</head>
<body>
<h2>Liste des demandes de crédit</h2>
<form action="<%= request.getContextPath() %>/list" method="get" class="filter_form">
    <h3 class="filter_title">Filtrer les résultats par :</h3>

    <div class="filter_group">
        <label for="date_filter" class="filter_label">Date :</label>
        <input type="date" id="date_filter" name="date" class="input_date_filter">
    </div>

    <div class="filter_group">
        <label for="etat_filter" class="filter_label">État :</label>
        <select name="etat" id="etat_filter" class="select_filter">
            <option value="">Sélectionnez un état</option>
            <option value="approuve">Approuvé</option>
            <option value="rejete">Rejeté</option>
            <option value="en_attente">En attente</option>
        </select>
    </div>

    <button type="submit" class="filter_button">Rechercher</button>
</form>
<%
    if (demandes != null && !demandes.isEmpty()) {
%>


<table border="1">
    <thead>
    <tr>
        <th>Numéro</th>
        <th>Projet</th>
        <th>Montant</th>
        <th>Durée</th>
        <th>Nom du client</th>
        <th>Actions</th>

    </tr>
    </thead>
    <tbody>
    <%
        for (CreditDemande demande : demandes) {
    %>
    <tr>
        <td><%= demande.getNumero() %>
        </td>
        <td><%= demande.getProjet() %>
        </td>
        <td><%= demande.getMontant() %> </td>
        <td><%= demande.getDuree() %> mois</td>
        <td><%= demande.getNom() %> <%= demande.getPrenom() %>
        </td>
        <td>
            <!-- Bouton pour afficher les détails -->

            <form action="<%= request.getContextPath() %>/detailDemande" method="get" style="display:inline;">
                <input type="hidden" name="demandeId" value="<%= demande.getNumero() %>"/>
                <button type="submit">Détails</button>
            </form>

            <!-- Bouton pour changer l'état de la demande -->
            <form action="<%= request.getContextPath() %>/changerEtatDemande" method="post" style="display:inline;">
                <input type="hidden" name="demandeId" value="<%= demande.getNumero() %>"/>
                <select name="nouvelEtat">
                    <option value="approuve">Approuvé</option>
                    <option value="rejete">Rejeté</option>
                    <option value="en_attente">En attente</option>
                </select>
                <input type="text" name="justif" value="" placeholder="Enter description" required/>

                <button type="submit">Changer État</button>

                <%
                    String successMessage = (String) session.getAttribute("successMessage");
                    if (successMessage != null) {
                %>
                <div class="alert alert-success">
                    <%= successMessage %>
                </div>
                <%
                        // Retirer le message de la session après l'affichage pour éviter qu'il se répète
                        session.removeAttribute("successMessage");
                    }
                %>
            </form>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
} else {
%>
<p>Aucune demande de crédit trouvée.</p>
<%
    }
%>
<br>
<a href="<%= request.getContextPath() %>/index.jsp">Retour à l'accueil</a>
</body>
</html>
