document.addEventListener('DOMContentLoaded', function () {
    afficherRecapitulatif();

    const block1 = document.getElementById('block1');
    const block2 = document.getElementById('block2');
    const block3 = document.getElementById('block3');
    const form = document.getElementById('form');
    const email = document.getElementById('email');
    const tel = document.getElementById('tel');
    const buttonForm2 = document.getElementById('button-form2');
    const popup = document.getElementById('popup');
    const popupMessage = document.getElementById('popupMessage');


    const validateEmailInput = () => {
        const emailValue = email.value.trim();
        if (validateEmail(emailValue)) {
            email.style.color = '#02AFBC';
            email.style.fontSize = "16px";
            return true;
        } else {
            email.style.color = 'red';
            return false;
        }
    };

    const validateTelInput = () => {
        const telValue = tel.value.trim();
        if (validateTel(telValue)) {
            tel.style.color = '#02AFBC';
            tel.style.fontSize = "16px";
            return true;
        } else {
            tel.style.color = 'red';
            return false;
        }
    };
    email.addEventListener('input', validateEmailInput);
    tel.addEventListener('input', validateTelInput);

    form.addEventListener('submit', function (e) {
        let errorMessage = '';

        if (!validateEmailInput()) {
            errorMessage += '.Veuillez saisir un email valide.<br>';
        }
        if (!validateTelInput()) {
            errorMessage += '.Veuillez saisir un numéro de téléphone mobile valide.';
        }

        if (errorMessage) {
            e.preventDefault();
            showPopup(errorMessage);
        }
    });


    const validateEmail = (email) => {
        const re = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
        return re.test(email);
    }


    const validateTel = (tel) => {
        const re = /^06[0-9]{8}$/;
        return re.test(tel);
    }

    function showPopup(message) {
        const popupMessage = document.getElementById('popupMessage');
        const popup = document.getElementById('popup');

        popupMessage.innerHTML = message;
        popup.style.display = 'flex';
    }

    document.getElementById('closePopup').addEventListener('click', function () {
        popup.style.display = 'none';
    });


    block1.addEventListener('click', () => {
        block1.style.marginTop = '-10px';
        block1.style.color = '#292D5A';
        block1.style.backgroundColor = '#FDDF35';
        block2.style.marginTop = '0px';
        block2.style.backgroundColor = '#9B9B9B';
        block2.style.color = 'white';
        block3.style.backgroundColor = '#9B9B9B';
        block3.style.color = 'white';
    });

    // Bloc 2
    block2.addEventListener('click', () => {
        block2.style.marginTop = '-10px';
        block2.style.backgroundColor = '#FDDF35';
        block2.style.color = '#292D5A';
        block1.style.marginTop = '0px';
        block1.style.backgroundColor = '#02AFBC';
        block1.style.color = 'white';
        block3.style.backgroundColor = '#9B9B9B';
        block3.style.color = 'white';
    });

    // Bloc 3
    block3.addEventListener('click', () => {
        block3.style.marginTop = '-10px';
        block3.style.backgroundColor = '#FDDF35';
        block3.style.color = '#292D5A';
        block1.style.marginTop = '0px';
        block1.style.backgroundColor = '#02AFBC';
        block1.style.color = 'white';
        block2.style.backgroundColor = '#02AFBC';
        block2.style.color = 'white';
    });

    buttonForm2.addEventListener('click', (e) => {
        const email = document.getElementById('email').value;
        const tel = document.getElementById('tel').value;
        const infos2 = {
            'email': email,
            'tel': tel
        };
        console.log(infos2);
        localStorage.setItem('formData2', JSON.stringify(infos2));
        afficherRecapitulatif();
    });

    function afficherRecapitulatif() {
        console.log("Affichage du récapitulatif");
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

    window.onload = function () {
        console.log('Chargement de la fenêtre');
        if (block2) {
            block2.style.marginTop = '-10px';
            block2.style.backgroundColor = '#FDDF35';
            block2.style.color = '#292D5A';
            if (block1) {
                block1.style.backgroundColor = '#02AFBC';
                block1.style.color = 'white';
            }
            if (block3) {
                block3.style.backgroundColor = '#9B9B9B';
                block3.style.color = 'white';
            }
        }
    };
});
