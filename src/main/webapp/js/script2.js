document.addEventListener('DOMContentLoaded', function () {
    afficherRecapitulatif();


    const block1 = document.getElementById('block1');
    const block2 = document.getElementById('block2');
    const block3 = document.getElementById('block3');

    const buttonForm2 = document.getElementById('button-form2');
    console.log(buttonForm2);


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

    window.onload = function(){
        console.log('im in window function');
        if (block2) {
            block2.style.marginTop = '-10px';
            block2.style.backgroundColor = '#FDDF35';
            block2.style.color = '#292D5A';
            if(block1){
                block1.style.backgroundColor = '#02AFBC';
                block1.style.color = 'white';
                block1.style.marginTop = '0px';
            }

            if(block3){
                block3.style.backgroundColor = '#9B9B9B';
                block3.style.color = 'white';
                block3.style.marginTop = '0px';
            }

        }


    };



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
        alert("save page2");

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
