document.addEventListener('DOMContentLoaded', function () {
    afficherRecapitulatif();

    const block1 = document.getElementById('block1');
    const block2 = document.getElementById('block2');
    const block3 = document.getElementById('block3');
    const buttonForm1 = document.getElementById('button-form1');
    console.log(buttonForm1);


    window.onload = function() {
        if (block1) {
            console.log('im in window function');
            block1.style.marginTop = '-10px';
            block1.style.color = '#292D5A';
            block1.style.backgroundColor = '#FDDF35';

            if (block2) {
                block2.style.marginTop = '0px';
                block2.style.backgroundColor = '#9B9B9B';
                block2.style.color = 'white';
            }

            if (block3) {
                block3.style.marginTop = '0px';
                block3.style.backgroundColor = '#9B9B9B';
                block3.style.color = 'white';
            }
        }
    };

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

    function afficherRecapitulatif() {
        console.log("im in affiche foncton");
        const formData1 = JSON.parse(localStorage.getItem('formData1'));


        if (formData1) {
            console.log(formData1);
            const detailMonCredit = document.getElementById('detait-mon-credit');

            detailMonCredit.children[1].innerHTML = `Vous êtes: <span style="color: #02AFBC;">${formData1.profession}</span>`;
            detailMonCredit.children[2].innerHTML = `Montant: <span style="color: #02AFBC;">${formData1.amount} €</span>`;
            detailMonCredit.children[3].innerHTML = `Durée: <span style="color: #02AFBC;">${formData1.duree} mois</span>`;
            detailMonCredit.children[4].innerHTML = `Mensualité: <span style="color: #02AFBC;">${formData1.mensualite} €</span>`;
        } else {
            console.log('Veuillez remplir tous les champs pour afficher le récapitulatif.');
        }


    }





// Sélection des éléments du DOM
    const slider = document.getElementById('montantRange'); // Montant (range)
    const numberInput = document.getElementById('amount'); // Montant (number input)
    const durationSlider = document.getElementById('dureeRange'); // Durée (range)
    const durationValue = document.getElementById('duree'); // Durée (number input)
    const mensualiteSlider = document.getElementById('mensualiteRange'); // Mensualité (range)
    const mensualiteValue = document.getElementById('mensualite'); // Mensualité (number input)

    const tauxInteretAnnuel = 0.12; // Taux d'intérêt annuel

// Fonction pour calculer la mensualité
    function calculerMensualite(capital, dureeEnMois, tauxAnnuel) {
        const tauxMensuel = tauxAnnuel / 12;
        const mensualite = (capital * tauxMensuel) / (1 - Math.pow(1 + tauxMensuel, -dureeEnMois));
        return mensualite.toFixed(2);
    }

// Fonction pour calculer la durée à partir de la mensualité
    function calculerDuree(capital, mensualite, tauxAnnuel) {
        const tauxMensuel = tauxAnnuel / 12;
        const dureeEnMois = -Math.log(1 - (capital * tauxMensuel) / mensualite) / Math.log(1 + tauxMensuel);
        return Math.round(dureeEnMois);
    }

// Mise à jour de la mensualité
    function updateMensualite() {
        const capital = parseFloat(numberInput.value);
        const dureeEnMois = parseInt(durationValue.value);
        let mensualite = calculerMensualite(capital, dureeEnMois, tauxInteretAnnuel);

        mensualiteValue.value = mensualite;
        mensualiteSlider.value = mensualite;
    }

// Mise à jour de la durée en fonction de la mensualité
    function updateDureeFromMensualite() {
        const capital = parseFloat(numberInput.value);
        const mensualite = parseFloat(mensualiteValue.value);
        const dureeEnMois = calculerDuree(capital, mensualite, tauxInteretAnnuel);

        durationValue.value = dureeEnMois;
        durationSlider.value = dureeEnMois;
    }

// Événements pour synchroniser les sliders et les inputs
    slider.addEventListener('input', function () {
        numberInput.value = slider.value;
        updateMensualite();
    });

    numberInput.addEventListener('input', function () {
        slider.value = numberInput.value;
        updateMensualite();
    });

    durationSlider.addEventListener('input', function () {
        durationValue.value = durationSlider.value;
        updateMensualite();
    });

    durationValue.addEventListener('input', function () {
        durationSlider.value = durationValue.value;
        updateMensualite();
    });

    mensualiteSlider.addEventListener('input', function () {
        mensualiteValue.value = mensualiteSlider.value;
        updateDureeFromMensualite();
    });

    mensualiteValue.addEventListener('input', function () {
        mensualiteSlider.value = mensualiteValue.value;
        updateDureeFromMensualite();
    });

// Initialiser la mensualité
    updateMensualite();




});