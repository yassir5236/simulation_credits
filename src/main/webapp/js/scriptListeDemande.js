document.addEventListener('DOMContentLoaded', function () {
    const buttonEtats = document.querySelectorAll(".buttonEtat");
    const formEtats = document.querySelectorAll(".formEtat");
    const sendEtats = document.querySelectorAll(".sendEtat");

    buttonEtats.forEach((buttonEtat, index) => {
        buttonEtat.addEventListener("click", function () {
            formEtats[index].style.display = "block";
            buttonEtat.style.display = "none";
            sendEtats[index].style.display = "block";
        });
    });

    sendEtats.forEach((sendEtat, index) => {
        sendEtat.addEventListener("click", function () {
            formEtats[index].style.display = "none";
            buttonEtats[index].style.display = "block";
        });
    });



    window.onload = function () {
        const alertBox = document.getElementById('success-alert');

        if (alertBox) {
            // Show the alert after page loads
            setTimeout(() => {
                alertBox.classList.add('show-alert');
            }, 100); // Delay to make sure everything is loaded before showing

            // Automatically hide the alert after 5 seconds
            setTimeout(() => {
                alertBox.classList.remove('show-alert');
            }, 5000); // Adjust the timing if needed
        }
    };





});