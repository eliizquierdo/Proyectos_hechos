<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Conversor</title>
  </head>
  <body>
    <h1>Ejercicio</h1>
    <h2>Conversor de divisas</h2>
    <form method="POST" action="conversor">
      Dolares
      <input type="text" id="txtDolares" name="txtDolares" />
      <br /><br />
      <input type="submit" value="Convertir a Euros" />
      <br /><br />
      Euros
      <input type="text" id="txtEuros" name="txtEuros" />
      <br /><br />
      <input type="submit" value="Convertir a Dolares" />
    </form>
  </body>
</html>
