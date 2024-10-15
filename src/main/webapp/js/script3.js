document.addEventListener('DOMContentLoaded', function () {
    afficherRecapitulatif();

    function afficherRecapitulatif() {
        console.log("im in affiche foncton");
        const formData1 = JSON.parse(localStorage.getItem('formData1'));

        const formData2 = JSON.parse(localStorage.getItem('formData2'));

        const formData3 = JSON.parse(localStorage.getItem('formData3'));
        const civilite = JSON.parse(localStorage.getItem('civilite'));
        const creditEncours = JSON.parse(localStorage.getItem('creditEncours'));
        const acceptTerms = JSON.parse(localStorage.getItem('acceptTerms'));


        if (formData1) {
            console.log(formData1);
            const detailMonCredit = document.getElementById('detait-mon-credit');

            detailMonCredit.children[1].innerHTML = `Vous êtes: <span style="color: #02AFBC;">${formData1.profession}</span>`;
            detailMonCredit.children[2].innerHTML = `Montant: <span style="color: #02AFBC;">${formData1.amount} €</span>`;
            detailMonCredit.children[3].innerHTML = `Durée: <span style="color: #02AFBC;">${formData1.duree} mois</span>`;
            detailMonCredit.children[4].innerHTML = `Mensualité: <span style="color: #02AFBC;">${formData1.mensualite} €</span>`;
            // detailMonCredit.children[5].textContent = `Frais de dossier: ${calculateFraisDossier(formData1.amount)} €`;

        } else {
            console.log('Veuillez remplir tous les champs pour afficher le récapitulatif.');
        }

        if (formData2) {
            const infosPersonnelles = document.getElementById('infos-personnelles');

            infosPersonnelles.children[1].innerHTML = `Email: <span style="color: #02AFBC;">${formData2.email}</span>`;
            infosPersonnelles.children[2].innerHTML = `Téléphone: <span style="color: #02AFBC;">${formData2.tel}</span>`;
        }
    }


    const container1 = document.getElementById('container1');
    const container2 = document.getElementById('container2');
    const container3 = document.getElementById('container3');
    const detailCredit = document.getElementById('detait-mon-credit');
    const infosPersonnelles = document.getElementById('infos-personnelles');

    const block1 = document.getElementById('block1');
    const block2 = document.getElementById('block2');
    const block3 = document.getElementById('block3');

    const spanBouton1 = document.getElementById('span-bouton1');
    const spanBouton2 = document.getElementById('span-bouton2');
    const spanBouton3 = document.getElementById('span-bouton3');


    const buttonForm31 = document.getElementById('button-form31');
    const buttonForm32 = document.getElementById('button-form32');


    const nom = document.getElementById('nom');
    const prenom = document.getElementById('prenom');
    const cin = document.getElementById('cin');
    const dateNaissance = document.getElementById('date_naissance');
    const revenus = document.getElementById('revenus');
    const buttonForm = document.getElementById('button-form31');
    const popup = document.getElementById('popup');
    const popupMessage = document.getElementById('popupMessage');

// Vérifier si la personne a au moins 18 ans
    const isOlderThan18 = (dateString) => {
        const today = new Date();
        const birthDate = new Date(dateString);
        const age = today.getFullYear() - birthDate.getFullYear();
        const m = today.getMonth() - birthDate.getMonth();
        return age > 18 || (age === 18 && m >= 0);
    };

    const validateNomInput = () => {
        const nomValue = nom.value.trim();
        const nomPattern = /^[a-zA-ZÀ-ÖØ-öø-ÿ\s'-]+$/; // Lettres, accents, espaces, apostrophes et tirets autorisés
        if (nomPattern.test(nomValue) && nomValue.length <= 100) {
            nom.style.color = '#02AFBC';
            nom.style.fontSize = "16px";
            return true;
        } else {
            nom.style.color = 'red';
            return false;
        }
    };

    const validatePrenomInput = () => {
        const prenomValue = prenom.value.trim();
        const prenomPattern = /^[a-zA-ZÀ-ÖØ-öø-ÿ\s'-]+$/; // Lettres, accents, espaces, apostrophes et tirets autorisés
        if (prenomPattern.test(prenomValue) && prenomValue.length > 3 && prenomValue.length <= 100) {
            prenom.style.color = '#02AFBC';
            prenom.style.fontSize = "16px";
            return true;
        } else {
            prenom.style.color = 'red';
            return false;
        }
    };

    const validateCinInput = () => {
        const cinValue = cin.value.trim();
        const cinPattern = /^[A-Z]{1,3}\d+$/;
        if (cinPattern.test(cinValue)) {
            cin.style.color = '#02AFBC';
            cin.style.fontSize = "16px";
            return true;
        } else {
            cin.style.color = 'red';
            return false;
        }
    };


    const validateDateNaissanceInput = () => {
        const dateNaissanceValue = dateNaissance.value;
        if (isOlderThan18(dateNaissanceValue)) {
            dateNaissance.style.color = '#02AFBC';
            dateNaissance.style.fontSize = "16px";
            return true;
        } else {
            dateNaissance.style.color = 'red';
            return false;
        }
    };


    const validateRevenusInput = () => {
        const revenusValue = parseFloat(revenus.value.trim());
        if (revenusValue > 10000 && revenusValue <= 1000000000) {
            revenus.style.color = '#02AFBC';
            revenus.style.fontSize = "16px";
            return true;
        } else {
            revenus.style.color = 'red';
            return false;
        }
    };


    cin.addEventListener('input', validateCinInput);
    prenom.addEventListener('input', validatePrenomInput);
    nom.addEventListener('input', validateNomInput);
    dateNaissance.addEventListener('input', validateDateNaissanceInput);
    revenus.addEventListener('input', validateRevenusInput);



    buttonForm.addEventListener('click', function (e) {
        let errorMessage = '';

        if (!validateNomInput()) {
            errorMessage += '.Veuillez saisir un nom valide .<br>';
        }
        if (!validatePrenomInput()) {
            errorMessage += '.Veuillez saisir un prénom valide .<br>';
        }
        if (!validateCinInput()) {
            errorMessage += '.Veuillez saisir un numéro CIN valide .<br>';
        }
        if (!validateDateNaissanceInput()) {
            errorMessage += 'Vous devez avoir au moins 18 ans.<br>';
        }
        if (!validateRevenusInput()) {
            errorMessage += '.Le montant des revenus doit être compris entre 1000 et 1 milliard.<br>';
        }

        if (errorMessage) {
            e.preventDefault();
            showPopup(errorMessage);
        }
    });

    function showPopup(message) {
        popupMessage.innerHTML = message;
        popup.style.display = 'flex';
    }

    document.getElementById('closePopup').addEventListener('click', function () {
        popup.style.display = 'none';
    });


    block1.addEventListener('click', () => {


        block1.style.marginTop = '-10px';
        block3.style.marginTop = '0px';
        block1.style.color = '#292D5A';
        block1.style.backgroundColor = '#FDDF35';


        block2.style.marginTop = '0px';
        block2.style.backgroundColor = '#9B9B9B';
        block2.style.color = 'white';
        block3.style.backgroundColor = '#9B9B9B';
        block3.style.color = 'white';


    })


    block2.addEventListener('click', () => {


        block2.style.marginTop = '-10px';
        block1.style.marginTop = '0px';
        block3.style.marginTop = '0px';
        block2.style.backgroundColor = '#FDDF35';
        block2.style.color = '#292D5A';

        block3.style.backgroundColor = '#9B9B9B';
        block3.style.color = 'white';

        block1.style.backgroundColor = '#02AFBC';
        block1.style.color = 'white';

    })

    block3.addEventListener('click', () => {


        block3.style.marginTop = '-10px';
        block2.style.marginTop = '0px';
        block1.style.marginTop = '0px';
        block2.style.backgroundColor = '#02AFBC';
        block1.style.backgroundColor = '#02AFBC';
        block2.style.color = 'white';
        block1.style.color = 'white';
        block3.style.color = '#292D5A';

        block3.style.backgroundColor = '#FDDF35';

        block1.style.backgroundColor = '#02AFBC';
        block1.style.color = 'white';


    })

    window.onload = function () {
        console.log('im in window function');
        if (block3) {
            block3.style.marginTop = '-10px';
            block3.style.color = '#292D5A';
            block3.style.backgroundColor = '#FDDF35';
            if (block2) {
                block2.style.marginTop = '0px';
                block2.style.backgroundColor = '#02AFBC';
                block2.style.color = 'white';
            }

            if (block1) {
                block1.style.color = 'white';
                block1.style.backgroundColor = '#02AFBC';
                block1.style.marginTop = '0px';
            }
        }
    };


    buttonForm31.addEventListener('click', (e) => {


        const nomInput = document.getElementById('nom').value;
        const prenomInput = document.getElementById('prenom').value;
        const cinInput = document.getElementById('cin').value;
        const dateNaissanceInput = document.getElementById('date_naissance').value;
        const dateEmbaucheInput = document.getElementById('date_embauche').value;
        const revenusInput = document.getElementById('revenus').value;


        const infos3 = {
            'nom': nomInput,
            'prenom': prenomInput,
            'cin': cinInput,
            'date_naissance': dateNaissanceInput,
            'date_embauche': dateEmbaucheInput,
            'revenus': revenusInput
        }

        const radioButtonsCivilite = document.querySelectorAll('input[name="civilite"]');
        const radioCreditsEncours = document.querySelectorAll('input[name="credit-encours"]');
        const checkbox = document.getElementById('accept-terms');


        let selectedCivilite;
        let selectedCreditEncours;

        for (const radioButtonCivilite of radioButtonsCivilite) {
            if (radioButtonCivilite.checked) {
                selectedCivilite = radioButtonCivilite.value;
                break;
            }
        }

        if (selectedCivilite) {
            localStorage.setItem('civilite', JSON.stringify(selectedCivilite));
            console.log('Civilite has been saved to localStorage');
        } else {
            console.log('Please select a civilite before submitting.');
        }

        localStorage.setItem('formData3', JSON.stringify(infos3));
        console.log('Infos personnelles  saved to localStorage');

        for (const radioCreditEncours of radioCreditsEncours) {
            if (radioCreditEncours.checked) {
                selectedCreditEncours = radioCreditEncours.value;
                break;
            }
        }

        if (selectedCreditEncours) {
            localStorage.setItem('creditEncours', JSON.stringify(selectedCreditEncours));
            console.log('Etat du crédit encours a été sauvegardé dans le localStorage.');
        } else {
            console.log('Please select an etat du crédit encours before submitting.');
        }


        localStorage.setItem('acceptTerms', JSON.stringify(checkbox.checked));
        console.log('etat de la case à cocher a été sauvegardé dans le localStorage.');

        afficherRecapitulatif();


    });

});
