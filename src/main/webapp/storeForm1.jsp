<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            <div id="block1" class="block"><span class="numbers">1</span><br> Simuler mon crédit</div>
            <div id="block2" class="block"><span class="numbers">2</span><br> Mes coordonnées</div>
            <div id="block3" class="block"><span class="numbers">3</span><br> Mes infos personnelles</div>
        </div>

        <div id="container1" class="container1">


            <form class="simuler-mon-credit" action="${pageContext.request.contextPath}/storeForm1" method="post">
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
                    <input class="input1 " type="number" id="amount" name="montant" value="158000" min="5000"
                           max="400000" required><br>
                    <input class="slider1" type="range" min="5000" max="400000" value="158000" id="montantRange"
                           oninput="updateMontant(this.value);">
                </div>


                <div class="duree_group">
                    <label for="duree">Durée (en mois)</label><br>
                    <input class="input2 " type="number" id="duree" name="duree" value="12"><br>
                    <input class="slider2" type="range" min="1" max="60" value="12" id="dureeRange">
                </div>

                <div class="mensualite-group">
                    <label for="mensualite">Mensualités (en DH)</label><br>
                    <input class="input3 " type="number" id="mensualite" name="mensualite" step="0.01"  value="1580"><br>
                    <input class="slider3" type="range" min="180" max="4000" value="1580" id="mensualiteRange"
                    >
                </div>


                <div class="divBoutton">
                    <button id="button-form1" class="button-form1" type="submit">
                        <span id="span-bouton1" class="span-bouton1">Continuer</span><br> Sans engagement
                    </button>
                </div>

                <div class="footer">
                    <p>Simulation à titre indicatif et non contractuelle. La mensualité minimale est de 180 dirhams. Un
                        client
                        Wafasalaf peut bénéficier d'une tarification plus avantageuse en fonction de ses conditions
                        préférentielles.
                    </p>
                    <br>
                    <p>Simulation à titre indicatif et non contractuelle. La mensualité minimale est de 180 dirhams. Un
                        client
                        Wafasalaf peut bénéficier d'une tarification plus avantageuse en fonction de ses conditions
                        préférentielles.
                    </p>
                </div>


            </form>

        </div>


    </div>


    <div class="recap">
        <h3 style="display: flex; justify-content: center; color:#30435c ;font-size: 24px;">Mon récapitulatif</h3>

        <div style="background-color: #F1F2F6; width: 100%; color:#30435c; font-size: 16px;padding:10px;">Mon projet
        </div>
        <p style="color: #02AFBC">Revolving</p>



        <div id="detait-mon-credit" class="detait-mon-credit" style="display: none">
            <p style="background-color:#F1F2F6; font-size: 16px; color:#30435c; width: 100%; padding:10px;">Détails de
                mon crédit</p>
            <p>Vous êtes:</p>
            <p>Montant:</p>
            <p>Durée:</p>
            <p>Mensualité:</p>
        </div>
    </div>


</div>


<script src="${pageContext.request.contextPath}/js/script1.js"></script>
</body>
</html>







