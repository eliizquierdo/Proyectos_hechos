<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Pagina JSP de Facturacion</title>
  </head>
  <body>
    <form method="post">
      Digitar precio : <input type="text" name="precio" /><br /><br />
      Digitar cantidad : <input type="text" name="cantidad" /><br /><br />
      <input type="submit" value="Facturar" /><br /><br />
      <textarea rows="10" cols="30">
<% if(request.getParameter("precio") != null && request.getParameter("cantidad") != null)
{
    String sprec = request.getParameter("precio");
    int prec = Integer.parseInt(sprec);
    String scant = request.getParameter("cantidad");
    int cant = Integer.parseInt(scant);
    int monto = prec * cant;
    String linea = "El monto a pagar es : "+ monto;
    out.println(""+linea);
    }
%>
</textarea
      >
    </form>
  </body>
</html>
