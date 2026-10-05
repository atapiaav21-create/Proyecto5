<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Alke Wallet</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 40px;
        }

        .wallet {
            max-width: 500px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }

        h1 {
            text-align: center;
        }

        .saldo {
            text-align: center;
            font-size: 32px;
            font-weight: bold;
            margin: 30px 0;
        }

        form {
            margin-top: 20px;
        }

        input {
            width: 100%;
            padding: 12px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        button {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            margin-bottom: 10px;
        }

        .depositar {
            background-color: #198754;
            color: white;
        }

        .retirar {
            background-color: #dc3545;
            color: white;
        }
    </style>
</head>

<body>

<div class="wallet">

    <h1>Alke Wallet</h1>

    <p>Saldo disponible:</p>

    <div class="saldo">
        $<%= String.format("%,.0f", request.getAttribute("saldo")) %>
    </div>

    <form action="wallet" method="post">
        <input type="number"
               name="monto"
               placeholder="Ingresa un monto"
               min="1"
               step="1"
               required>

        <button class="depositar"
                type="submit"
                name="accion"
                value="depositar">
            Depositar
        </button>

        <button class="retirar"
                type="submit"
                name="accion"
                value="retirar">
            Retirar
        </button>
    </form>

</div>

</body>
</html>