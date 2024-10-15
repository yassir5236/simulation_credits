<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.credit.model.CreditDemande" %>
<%@ page import="java.util.List" %>

<%
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

                <%
                    List<String> etats = (List<String>) request.getAttribute("etats");

                    if (etats != null) {
                        for (String etat : etats) {
                %>
                <option value="<%= etat %>"><%= etat %></option>
                <%
                        }
                    }
                %>



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
        <td><%= demande.getMontant() %>
        </td>
        <td><%= demande.getDuree() %> mois</td>
        <td><%= demande.getNom() %> <%= demande.getPrenom() %>
        </td>
        <td>


            <div class="divAction">
                <form class="formDetail" action="<%= request.getContextPath() %>/detailDemande" method="get">
                    <input type="hidden" name="demandeId" value="<%= demande.getNumero() %>"/>
                    <button class="buttonDetail" type="submit">Détails</button>
                </form>

                <form class="formEtat" action="<%= request.getContextPath() %>/changerEtatDemande" method="post"
                      style="display:none">
                    <input type="hidden" name="demandeId" value="<%= demande.getNumero() %>"/>
                    <select name="nouvelEtat">
                        <option value="approuve">Approuvé</option>
                        <option value="rejete">Rejeté</option>
                        <option value="en_attente">En attente</option>
                    </select>
                    <input type="text" name="justif" value="" placeholder="Entrez la description" required/>
                    <button class="sendEtat" type="submit">Changer État</button>
                </form>
                <button class="buttonEtat"> État</button>
            </div>
        </td>
    </tr>

    <%
        String successMessage = (String) session.getAttribute("successMessage");
        if (successMessage != null) {
    %>
    <div class="alert alert-success" id="success-alert">
        <%= successMessage %>
    </div>
    <%
            session.removeAttribute("successMessage");
        }
    %>
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
<a  class="retour"   href="<%= request.getContextPath() %>/storeForm3.jsp">Retour à l'accueil</a>
<script src="<%= request.getContextPath()%>/js/scriptListeDemande.js"></script>
</body>
</html>
