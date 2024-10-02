<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nombre = $_POST['nombre'];
    $email = $_POST['email'];
    $asunto = $_POST['asunto'];
    $mensaje = $_POST['mensaje'];

    echo "<h1>Mensaje Recibido (POST)</h1>";
    echo "<p>Nombre: $nombre</p>";
    echo "<p>Email: $email</p>";
    echo "<p>Asunto: $asunto</p>";
    echo "<p>Mensaje: $mensaje</p>";
} elseif ($_SERVER["REQUEST_METHOD"] == "GET") {
    $nombre = $_GET['nombre'] ?? '';
    $email = $_GET['email'] ?? '';
    $asunto = $_GET['asunto'] ?? '';
    $mensaje = $_GET['mensaje'] ?? '';

    echo "<h1>Mensaje Recibido (GET)</h1>";
    echo "<p>Nombre: $nombre</p>";
    echo "<p>Email: $email</p>";
    echo "<p>Asunto: $asunto</p>";
    echo "<p>Mensaje: $mensaje</p>";
}
?>
