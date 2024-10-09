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





        <div id="container2"  class="container2">

            <form id="form"  class="mes-coordonnées" action="${pageContext.request.contextPath}/storeForm2" method="post">
                <input type="email" id="email" value="" name="email" placeholder="Email*" required>
                <input type="tel" id="tel" value="" name="tel" placeholder="Téléphone mobile*" required>

                <div class="divBoutton">
                    <button id="button-form2" class="button-form1" type="submit">
                        <span id="span-bouton2" class="span-bouton2">Continuer</span><br> Sans engagement
                    </button>
                </div>

                <div class="footer">
                    <p>Simulation à titre indicatif et non contractuelle. La mensualité minimale est de 180 dirhams. Un client
                        Wafasalaf peut bénéficier d'une tarification plus avantageuse en fonction de ses conditions
                        préférentielles.
                    </p>
                    <br>
                    <p>Simulation à titre indicatif et non contractuelle. La mensualité minimale est de 180 dirhams. Un client
                        Wafasalaf peut bénéficier d'une tarification plus avantageuse en fonction de ses conditions
                        préférentielles.
                    </p>
                </div>




            </form>

        </div>




    </div>






    <div class="recap">
        <h3 style="display: flex; justify-content: center; color:#30435c ;font-size: 24px;">Mon récapitulatif</h3>

        <div style="background-color: #F1F2F6; width: 100%; color:#30435c; font-size: 16px;padding:10px;">Mon projet</div>
        <p style="color: #02AFBC">Revolving</p>

<%--        <div id="infos-personnelles" class="infos-personnelles">--%>
<%--            <p style="background-color:#F1F2F6; font-size: 16px; color:#30435c; width: 100%; padding:10px; display: none">Coordonnées et infos personnelles</p>--%>
<%--            <p>Email:</p>--%>
<%--            <p>Telephone:</p>--%>
<%--        </div>--%>

        <div id="detait-mon-credit" class="detait-mon-credit">
            <p style="background-color:#F1F2F6; font-size: 16px; color:#30435c; width: 100%; padding:10px;">Détails de mon crédit</p>
            <p>Vous êtes:</p>
            <p>Montant:</p>
            <p>Durée:</p>
            <p>Mensualité:</p>
        </div>
    </div>


</div>




<div class="popup" id="popup" style="display: none; background-color: rgba(0, 0, 0, 0.7); width: 100%; height: 100%; position: fixed; top: 0; left: 0;  justify-content: center; align-items: center;">
    <div class="popup-content" style="background-color: white; padding: 20px; border-radius: 10px; width: 900px; text-align: center; box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);">
        <p class="popupMessage" id="popupMessage" style="margin: 0; font-size: 16px; color: red;">Message d'erreur ici.</p>
        <button class="closePopup" id="closePopup" style="margin-top: 15px; padding: 10px 15px; border: none; border-radius: 5px; background-color: #02AFBC; color: white; font-size: 16px; cursor: pointer; transition: background-color 0.3s ease;">Fermer</button>
    </div>
</div>




<script src="${pageContext.request.contextPath}/js/script2.js"></script>
</body>
</html>




