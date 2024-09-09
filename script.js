// Validación del formulario de contacto
document.addEventListener('DOMContentLoaded', function () {
    const form = document.querySelector('form');
    
    form.addEventListener('submit', function (event) {
        event.preventDefault(); // Evita el envío del formulario
        
        const nombre = document.getElementById('nombre').value.trim();
        const email = document.getElementById('email').value.trim();
        const asunto = document.getElementById('asunto').value.trim();
        const mensaje = document.getElementById('mensaje').value.trim();
        
        // Validar campos
        if (nombre === "" || email === "" || asunto === "" || mensaje === "") {
            alert("Por favor, complete todos los campos.");
        } else if (!validateEmail(email)) {
            alert("Por favor, ingrese un correo electrónico válido.");
        } else {
            form.submit(); // Envía el formulario si todos los campos son correctos
        }
    });
    
    // Función para validar formato de correo electrónico
    function validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email);
    }
});

// Navegación suave
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        
        document.querySelector(this.getAttribute('href')).scrollIntoView({
            behavior: 'smooth'
        });
    });
});

// Botón "Volver arriba"
window.onscroll = function () {
    const topButton = document.getElementById('topBtn');
    if (document.body.scrollTop > 100 || document.documentElement.scrollTop > 100) {
        topButton.style.display = "block";
    } else {
        topButton.style.display = "none";
    }
};

// Función para volver al inicio de la página
function topFunction() {
    document.body.scrollTop = 0; // Para Safari
    document.documentElement.scrollTop = 0; // Para Chrome, Firefox, IE y Opera
}

// Mostrar año actual en el pie de página
document.getElementById('year').textContent = new Date().getFullYear();
