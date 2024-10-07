<%--<%@ page import="org.example.credit.model.CreditDemande" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="fr">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>Filtrer les Demandes de Crédit</title>--%>
<%--    <link rel="stylesheet" href="styles.css"> <!-- Incluez ici votre fichier CSS si nécessaire -->--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Filtrer les Demandes de Crédit</h1>--%>
<%--<form action="filtrerDemandes" method="GET">--%>
<%--    <div>--%>
<%--        <label for="date">Date de Demande :</label>--%>
<%--        <input type="date" id="date" name="date">--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <label for="etat">État :</label>--%>
<%--        <select id="etat" name="etat">--%>
<%--            <option value="">--Sélectionner un État--</option>--%>
<%--            <option value="EN_COURS">En Cours</option>--%>
<%--            <option value="ACCEPTE">Accepté</option>--%>
<%--            <option value="REFUSE">Refusé</option>--%>
<%--            <!-- Ajoutez d'autres états si nécessaire -->--%>
<%--        </select>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <button type="submit">Filtrer</button>--%>
<%--    </div>--%>
<%--&lt;%&ndash;    <div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <a href="demandeCreditPage">Afficher Toutes les Demandes</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
<%--</form>--%>

<%--<div>--%>
<%--    <h2>Résultats :</h2>--%>
<%--    <!-- Cette section peut être remplie dynamiquement avec les résultats de la recherche -->--%>
<%--    <%--%>
<%--        List<CreditDemande> demandes = (List<CreditDemande>) request.getAttribute("demandes");--%>
<%--        if (demandes != null && !demandes.isEmpty()) {--%>
<%--    %>--%>
<%--    <table>--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Date</th>--%>
<%--            <th>État</th>--%>
<%--            <th>Montant</th>--%>
<%--            <th>Autres Détails</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <% for (CreditDemande demande : demandes) { %>--%>
<%--        <tr>--%>
<%--            <td><%= demande.getNumero() %></td>--%>
<%--&lt;%&ndash;            <td><%= demande.getDateDemande() %></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><%= demande.getEtat() %></td>&ndash;%&gt;--%>
<%--            <td><%= demande.getMontant() %></td>--%>
<%--            <td><a href="detailsDemande?id=<%= demande.getNumero() %>">Détails</a></td>--%>
<%--        </tr>--%>
<%--        <% } %>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--    <% } else { %>--%>
<%--    <p>Aucune demande trouvée.</p>--%>
<%--    <% } %>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
