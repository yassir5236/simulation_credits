<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap"
          rel="stylesheet">


    <title>Document</title>
</head>
<body>
<h1>Demander mon crédit en ligne</h1>
<div class="contenaire-global">

    <div class="block-and-container">
        <div class="container-block">
            <div id="block1" class="block"> <span class="numbers">1</span><br> Simuler mon crédit</div>
            <div id="block2" class="block"> <span class="numbers">2</span><br> Mes coordonnées</div>
            <div id="block3" class="block"> <span class="numbers">3</span><br> Mes infos personnelles</div>
        </div>

        <div id="container1" class="container1">
            <form class="simuler-mon-credit" action="<%= createDemande() %>/submitSimulation" method="post">
                <h3>Mon projet</h3>
                <select class="mon_projet" id="project" name="project">
                    <option value="besoin_argent">J'ai besoin d'argent</option>
                    <option value="vehicule_occasion">Je finance mon véhicule d'occasion</option>
                    <option value="gerer_imprevus">Je gère mes imprévus</option>
                    <option value="vehicule_neuf">Je finance mon véhicule neuf</option>
                    <option value="equiper_maison">J'équipe ma maison</option>
                </select>

                <h3>Je suis</h3>
                <select class="je_suis" id="profession" name="profession">
                    <option value="salarie">Salarié du secteur privé</option>
                    <option value="fonctionnaire">Fonctionnaire</option>
                    <option value="profession_liberale">Profession libérale</option>
                    <option value="commercant">Commerçant</option>
                    <option value="retraite">Retraité</option>
                    <option value="autres">Autres professions</option>
                </select><br><br>

                <div class="montant_group">
                    <label for="amount">Montant (en DH)</label><br>
                    <input type="number" id="amount" name="amount" value="158000" oninput="updateMontant()"><br>
                    <input type="range" min="5000" max="400000" value="158000" id="montantRange" oninput="updateMontant()">
                </div>

                <div class="duree_group">
                    <label for="duree">Durée (en mois)</label><br>
                    <input type="number" id="duree" name="duree" value="12" oninput="updateDuree()"><br>
                    <input type="range" min="1" max="60" value="12" id="dureeRange" oninput="updateDuree()">
                </div>

                <div class="mensualite-group">
                    <label for="mensualite">Mensualités (en DH)</label><br>
                    <input type="number" id="mensualite" name="mensualite" value="1580" disabled><br>
                    <input type="range" min="180" max="4000" value="1580" id="mensualiteRange" oninput="updateMensualite()" disabled>
                </div>

                <div class="divBoutton">
                    <button id="button-form1" class="button-form1" type="submit">
                        <span id="span-bouton1" class="span-bouton1">Continuer</span><br> Sans engagement
                    </button>
                </div>

                <div class="footer">
                    <p>Simulation à titre indicatif et non contractuelle. La mensualité minimale est de 180 dirhams. Un client
                        Wafasalaf peut bénéficier d'une tarification plus avantageuse en fonction de ses conditions
                        préférentielles.</p>
                    <br>
                    <p>Simulation à titre indicatif et non contractuelle. La mensualité minimale est de 180 dirhams. Un client
                        Wafasalaf peut bénéficier d'une tarification plus avantageuse en fonction de ses conditions
                        préférentielles.</p>
                </div>
            </form>
        </div>

        <div id="container2" style="display: none;" class="container2">
            <form class="mes-coordonnées" action="<%= request.getContextPath() %>/submitCoordinates" method="post">
                <input type="email" id="email" name="email" placeholder="Email*" required>
                <input type="tel" id="tel" name="tel" placeholder="Téléphone mobile*" required>

                <div class="divBoutton">
                    <button id="button-form2" class="button-form1" type="submit">
                        <span id="span-bouton2" class="span-bouton2">Continuer</span><br> Sans engagement
                    </button>
                </div>

                <div class="footer">
                    <p>Simulation à titre indicatif et non contractuelle. La mensualité minimale est de 180 dirhams. Un client
                        Wafasalaf peut bénéficier d'une tarification plus avantageuse en fonction de ses conditions
                        préférentielles.</p>
                    <br>
                    <p>Simulation à titre indicatif et non contractuelle. La mensualité minimale est de 180 dirhams. Un client
                        Wafasalaf peut bénéficier d'une tarification plus avantageuse en fonction de ses conditions
                        préférentielles.</p>
                </div>
            </form>
        </div>

        <div id="container3" style="display: none;" class="container3">
            <form class="mes-infos-personnelles" action="<%= request.getContextPath() %>/submitPersonalInfo" method="post">
                <div class="div-mes-infos-personnelles">
                    <h3 class="civilite">Civilité</h3>
                    <div class="input-radio">
                        <input type="radio" id="civilite_madame" name="civilite" value="Madame" required>
                        <label for="civilite_madame">Madame</label>
                    </div>
                    <div class="input-radio">
                        <input type="radio" id="civilite_mademoiselle" name="civilite" value="Mademoiselle" required>
                        <label for="civilite_mademoiselle">Mademoiselle</label>
                    </div>
                    <div class="input-radio">
                        <input type="radio" id="civilite_monsieur" name="civilite" value="Monsieur" required>
                        <label for="civilite_monsieur">Monsieur</label>
                    </div>

                    <div class="div2-mes-infos-personnelles">
                        <input type="text" id="nom" name="nom" placeholder="Nom" required>
                        <input type="text" id="prenom" name="prenom" placeholder="Prénom*" required>
                        <input type="number" id="cin" name="cin" placeholder="Numéro CIN / Carte de séjour*" required>
                        <input type="date" id="date_naissance" name="date_naissance" placeholder="Date de naissance JJ/MM/YYYY*" required>
                        <input type="date" id="date_embauche" name="date_embauche" placeholder="Date d'embauche/début de l'activité*" required>
                        <input type="number" id="revenus" name="revenus" placeholder="Total revenus mensuels (net en DH)*" required>
                    </div>
                </div>

                <div class="input-radio2">
                    <p>Avez-vous des crédits en cours ?</p>
                    <div class="input-radio">
                        <input type="radio" id="credits_oui" name="credit-encours" value="oui" required>
                        <label for="credits_oui">Oui</label>
                    </div>
                    <div class="input-radio">
                        <input type="radio" id="credits_non" name="credit-encours" value="non" required>
                        <label for="credits_non">Non</label>
                    </div>
                </div>

                <div style="padding-right: 60px; padding-left: 60px; padding-top: 20px;">
                    <input type="checkbox" id="accept-terms" required>
                    <label style="font-size: 14px;" for="accept-terms">J'ai lu et j'accepte les conditions générales d'utilisation
                        figurant sur les informations légales, notamment la mention relative à la protection des données personnelles.</label>
                </div>

                <div class="divBoutton">
                    <button id="button-form3" class="button-form1" type="submit">
                        <span id="span-bouton3" class="span-bouton3">Soumettre</span><br> Sans engagement
                    </button>
                </div>

                <div class="footer">
                    <p>Simulation à titre indicatif et non contractuelle. La mensualité minimale est de 180 dirhams. Un client
                        Wafasalaf peut bénéficier d'une tarification plus avantageuse en fonction de ses conditions
                        préférentielles.</p>
                    <br>
                    <p>Simulation à titre indicatif et non contractuelle. La mensualité minimale est de 180 dirhams. Un client
                        Wafasalaf peut bénéficier d'une tarification plus avantageuse en fonction de ses conditions
                        préférentielles.</p>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="script.js"></script>
</body>
</html>





