package logica;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

/**
 * La clase `Validaciones` proporciona métodos estáticos para validar diferentes tipos de datos en la aplicación NETXILF.
 */
public class Validaciones {

    /**
     * Verifica si el formato del correo electrónico es válido.
     * @param email El campo de correo electrónico a verificar.
     * @return `true` si el formato es válido, `false` de lo contrario.
     */
    public static boolean verifyEmail(JTextField email) {
        String data = email.getText();
        if (data.isEmpty() || data.length() > 50) {
            return false;
        }

        String regex = "^[^\\s@]+@[^\\s@]+\\.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);

        return matcher.matches();
    }

    /**
     * Verifica si la contraseña cumple con los requisitos.
     * @param pass El campo de contraseña a verificar.
     * @return `true` si la contraseña cumple con los requisitos, `false` de lo contrario.
     */
    public static boolean verifyPassword(JPasswordField pass) {
        String password = pass.getText();
        if (password.isEmpty() || password.length() > 50) {
            return false;
        }

        // No se requiere una restricción especial, ya que se permiten espacios y cualquier caracter.
        return true;
    }

    /**
     * Verifica si el nombre cumple con los requisitos de solo letras.
     * @param text El campo de nombre a verificar.
     * @return `true` si el nombre cumple con los requisitos, `false` de lo contrario.
     */
    public static boolean verifyName(JTextField text) {
        String data = text.getText();
        if (data.isEmpty() || data.length() > 50) {
            return false;
        }

        // Validación de letras solamente
        return data.matches("^[A-Za-z ]+$");
    }

    /**
     * Verifica si el nombre cumple con los requisitos sin restricciones.
     * @param text El campo de nombre a verificar.
     * @return `true` si el nombre cumple con los requisitos, `false` de lo contrario.
     */
    public static boolean verifyNameFull(JTextField text) {
        String data = text.getText();
        if (data.isEmpty() || data.length() > 50) {
            return false;
        }

        // No se aplican restricciones adicionales
        return true;
    }

    /**
     * Verifica si el nombre cumple con los requisitos sin restricciones, permitiendo datos vacíos.
     * @param text El campo de nombre a verificar.
     * @return `true` si el nombre cumple con los requisitos, `false` de lo contrario.
     */
    public static boolean verifyNameNoRestriction(JTextField text) {
        String data = text.getText();
        if (data.isEmpty()) {
            return false;
        }

        // No se aplican restricciones adicionales
        return true;
    }

    /**
     * Verifica si el número de tarjeta cumple con los requisitos.
     * @param text El campo de número de tarjeta a verificar.
     * @return `true` si el número de tarjeta cumple con los requisitos, `false` de lo contrario.
     */
    public static boolean verifyCardNumber(JTextField text) {
        String data = text.getText();
        if (data.isEmpty() || data.length() < 13 || data.length() > 18) {
            return false;
        }

        // Validación de números solamente
        return data.matches("^[0-9]+$");
    }

    /**
     * Verifica si el código de tarjeta cumple con los requisitos.
     * @param text El campo de código de tarjeta a verificar.
     * @return `true` si el código de tarjeta cumple con los requisitos, `false` de lo contrario.
     */
    public static boolean verifyCardCode(JPasswordField text) {
        String data = text.getText();
        if (data.isEmpty() || data.length() != 3) {
            return false;
        }

        // Validación de números solamente
        return data.matches("^[0-9]+$");
    }

    /**
     * Verifica si el número de teléfono cumple con los requisitos.
     * @param phone El campo de número de teléfono a verificar.
     * @return `true` si el número de teléfono cumple con los requisitos, `false` de lo contrario.
     */
    public static boolean verifyPhoneNumber(JTextField phone) {
        String data = phone.getText();
        if (data.isEmpty() || data.length() < 5 || data.length() > 18) {
            return false;
        }

        // Validación de números solamente
        return data.matches("^[0-9]+$");
    }

    /**
     * Verifica si el número de teléfono cumple con los requisitos permitiendo datos vacíos y sin espacios.
     * @param phone El campo de número de teléfono a verificar.
     * @return `true` si el número de teléfono cumple con los requisitos, `false` de lo contrario.
     */
    public static boolean verifyPhoneNumber2(JTextField phone) {
        String data = phone.getText();

        // Validación de números solamente y sin espacios entre ellos
        return data.isEmpty() || (data.matches("^[0-9]+$") && !data.contains(" "));
    }

    /**
     * Verifica si el PIN cumple con los requisitos.
     * @param text El campo de PIN a verificar.
     * @return `true` si el PIN cumple con los requisitos, `false` de lo contrario.
     */
    public static boolean verifyPIN(JPasswordField text) {
        String data = text.getText();

        // Validación de números solamente y sin espacios entre ellos
        return data.isEmpty() || data.length() != 4 || (data.matches("^[0-9]+$") && !data.contains(" "));
    }

}
