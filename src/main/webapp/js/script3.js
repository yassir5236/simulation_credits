document.addEventListener('DOMContentLoaded', function () {
    afficherRecapitulatif();

    function afficherRecapitulatif() {
        console.log("im in affiche foncton");
        const formData1 = JSON.parse(localStorage.getItem('formData1'));
        // const profession= formData1.profession;
        // console.log(profession);
        // console.log(formData1);
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

const buttonForm1 = document.getElementById('button-form1');
console.log(buttonForm1);



const buttonForm2 = document.getElementById('button-form2');
console.log(buttonForm2);
const buttonForm31 = document.getElementById('button-form31');
const buttonForm32 = document.getElementById('button-form32');









block1.addEventListener('click', () => {


    // if(JSON.parse(localStorage.getItem('formData1'))){
    //     alert("data trouver");
    //     localStorage.removeItem('formData1');
    //     alert("data removed");
    // }

    // container1.style.display = 'block';
    // container2.style.display = 'none';
    // container3.style.display = 'none';
    //detailCredit.style.display = 'none';
   // infosPersonnelles.style.display = 'none';
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

    //container1.style.display = 'none';
    //container2.style.display = 'block';
    //container3.style.display = 'none';
    //detailCredit.style.display = 'flex';
    //infosPersonnelles.style.display = 'none';

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

 //   container1.style.display = 'none';
   // container2.style.display = 'none';
    //container3.style.display = 'block';
    //detailCredit.style.display = 'flex';
    //infosPersonnelles.style.display = 'flex';

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






buttonForm1.addEventListener('click', (e) => {
    //e.preventDefault();
    // console.log('Bouton cliqué');

    // if(JSON.parse(localStorage.getItem('formData1'))){M
    //     alert("data trouver");
    //     localStorage.removeItem('formData1');
    // }


    const selectedProject = document.getElementById('project').value;
    const selectedProfession = document.getElementById('profession').value;
    const amount = document.getElementById('amount').value;
    const duree = document.getElementById('duree').value;
    const mensualite = document.getElementById('mensualite').value;

    const infos1 = {
        'profession': selectedProfession,
        'project': selectedProject,
        'amount': amount,
        'duree': duree,
        'mensualite': mensualite
    };

    console.log(infos1);

 //   container1.style.display = 'none';
   // container2.style.display = 'block';
    //container3.style.display = 'none';
    //detailCredit.style.display = 'flex';
    //infosPersonnelles.style.display = 'none';

    block2.style.marginTop = '-10px';
    block1.style.marginTop = '0px';
    block2.style.backgroundColor = '#FDDF35';
    block2.style.color = '#292D5A';

    block3.style.backgroundColor = '#9B9B9B';
    block3.style.color = 'white';

    block1.style.backgroundColor = '#02AFBC';
    block1.style.color = 'white';


    localStorage.setItem('formData1', JSON.stringify(infos1));
     alert("new stock")
    // console.log(localStorage.getItem('formData1'));  // Vérifiez ici si les données sont correctement sauvegardées

    // console.log("Success");
    afficherRecapitulatif();

});







buttonForm2.addEventListener('click', (e) => {

    //e.preventDefault();
    // console.log('Bouton cliqué');
    // if(JSON.parse(localStorage.getItem('formData2'))){
    //     localStorage.removeItem('formData2');
    // }

    const email = document.getElementById('email').value;
    const tel = document.getElementById('tel').value;

    const infos2 = {
        'email': email,
        'tel': tel
    };

  //  container1.style.display = 'none';
    // container2.style.display = 'none';
    // container3.style.display = 'block';
    // detailCredit.style.display = 'flex';
    // infosPersonnelles.style.display = 'flex';

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

    console.log(infos2);
    localStorage.setItem('formData2', JSON.stringify(infos2));
    console.log("Success");


    afficherRecapitulatif();


});




buttonForm31.addEventListener('click', (e) => {
    // e.preventDefault();
    // if(JSON.parse(localStorage.getItem('formData3'))){
    //     localStorage.removeItem('formData3');
    // }

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




















function syncValue(inputId, rangeId) {
    var input = document.getElementById(inputId);
    var range = document.getElementById(rangeId);
    input.value = range.value;
}

function updateMensualite() {
    const montant = parseFloat(document.getElementById('amount').value);
    const duree = parseInt(document.getElementById('duree').value);
    const mensualite = calculateMensualite(montant, duree);
    document.getElementById('mensualite').value = Math.round(mensualite);
}

function updateMontant() {
    syncValue('amount', 'montantRange');
    updateMensualite();
}

function updateDuree() {
    syncValue('duree', 'dureeRange');
}

function calculateMensualite(montant, duree) {
    const tauxInteret = 0.05;
    const mensualite = (montant * tauxInteret / 12) / (1 - Math.pow(1 + tauxInteret / 12, -duree));
    return mensualite;
}

});
