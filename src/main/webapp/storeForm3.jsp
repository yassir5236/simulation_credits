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
            <div id="block1" class="block"> <span class="numbers">1</span><br> Simuler mon crédit</div>
            <div id="block2" class="block"> <span class="numbers">2</span><br> Mes coordonnées</div>
            <div id="block3" class="block"> <span class="numbers">3</span><br> Mes infos personnelles</div>
        </div>







        <div id="container3"  class="container3">

            <form class="mes-infos-personnelles" action="${pageContext.request.contextPath}/submitForm" method="post">

                <div class="div-mes-infos-personnelles">
                    <h3 class="civilite">Civilité</h3>

                    <div class="input-radio">
                        <input type="radio" id="madame" name="civilite" value="Madame">
                        <label for="madame">Madame</label>
                    </div>

                    <div class="input-radio">
                        <input type="radio" id="mademoiselle" name="civilite" value="Mademoiselle">
                        <label for="mademoiselle">Mademoiselle</label>
                    </div>

                    <div class="input-radio">
                        <input type="radio" id="monsieur" name="civilite" value="Monsieur">
                        <label for="monsieur">Monsieur</label>
                    </div>

                    <div class="div2-mes-infos-personnelles">
                        <input type="text" id="nom" name="nom" placeholder="Nom" required>
                        <input type="text" id="prenom" name="prenom" placeholder="Prénom*" required>
                        <input type="text" id="cin" name="cin" placeholder="Numéro CIN / Carte de séjour*" required>
                        <input type="date" id="date_naissance" name="date_naissance" placeholder="Date de naissance JJ/MM/YYYY*" required>
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
                    <label style="font-size: 14px;" for="accept-terms">J'ai lu et j'accepte les conditions générales d'utilisation figurant sur les informations légales, notamment la mention relative à la protection des données personnelles</label>
                </div>

                <div class="fix-position-button">
                    <button id="button-form31" class="button-form31" type="submit">
                        <span id="span-bouton3" class="span-bouton3">Continuer</span><br> Sans engagement
                    </button>
                </div>

                <div class="footer">
                    <p>Simulation à titre indicatif et non contractuelle. La mensualité minimale est de 180 dirhams. Un client Wafasalaf peut bénéficier d'une tarification plus avantageuse en fonction de ses conditions préférentielles.</p>
                </div>
            </form>

        </div>

    </div>






    <div class="recap">
        <h3 style="display: flex; justify-content: center; color:#30435c ;font-size: 24px;">Mon récapitulatif</h3>

        <div style="background-color: #F1F2F6; width: 100%; color:#30435c; font-size: 16px;padding:10px;">Mon projet</div>
        <p style="color: #02AFBC">Revolving</p>

        <div id="infos-personnelles" class="infos-personnelles">
            <p style="background-color:#F1F2F6; font-size: 16px; color:#30435c; width: 100%; padding:10px;">Coordonnées et infos personnelles</p>
            <p>Email:</p>
            <p>Telephone:</p>
        </div>

        <div id="detait-mon-credit" class="detait-mon-credit">
            <p style="background-color:#F1F2F6; font-size: 16px; color:#30435c; width: 100%; padding:10px;">Détails de mon crédit</p>
            <p>Vous êtes:</p>
            <p>Montant:</p>
            <p>Durée:</p>
            <p>Mensualité:</p>
            <p>Frais de dossier:</p>
        </div>
    </div>


</div>







<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>




