<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Recibir los datos del formulario
    $nombre = htmlspecialchars(trim($_POST['nombre']));
    $email = htmlspecialchars(trim($_POST['email']));
    $mensaje = htmlspecialchars(trim($_POST['mensaje']));

    // Validar que los campos no estén vacíos
    if (empty($nombre) || empty($email) || empty($mensaje)) {
        echo "Todos los campos son obligatorios.";
        exit;
    }

    // Validar formato de correo electrónico
    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        echo "Por favor, ingrese un correo electrónico válido.";
        exit;
    }

    // Crear el cuerpo del correo electrónico
    $asunto = "Nuevo mensaje de contacto - Nova Soluciones 7x24";
    $contenido = "Nombre: $nombre\n";
    $contenido .= "Correo: $email\n";
    $contenido .= "Mensaje:\n$mensaje";

    // Dirección de destino (modifica esta dirección por la tuya)
    $destino = "jeperea45@gmail.com"; 

    // Encabezados del correo
    $headers = "From: $email";

    // Enviar el correo
    if (mail($destino, $asunto, $contenido, $headers)) {
        echo "El mensaje ha sido enviado correctamente.";
    } else {
        echo "Hubo un error al enviar el mensaje. Intente de nuevo más tarde.";
    }
} else {
    echo "Método no permitido.";
}
?>
