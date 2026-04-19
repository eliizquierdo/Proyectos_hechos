package logica;

import java.util.Date;

/**
 * La clase `AccountsVO` representa un objeto de valor para almacenar información de cuentas.
 * Esta clase contiene detalles como la dirección de correo electrónico, contraseña, detalles de la tarjeta,
 * nivel de cuenta, número de pantallas, y fecha de suscripción.
 */
public class AccountsVO {

    private String emailAccount;
    private String passwordAccount;
    private String cardName;
    private String cardNumber;
    private String cardCode;
    private String level;
    private String numberScreens;
    private Date suscriptionDate;

    /**
     * Constructor predeterminado de la clase `AccountsVO`.
     * Se utiliza para crear instancias de la clase sin proporcionar detalles específicos.
     */
    public AccountsVO() {

    }

    /**
     * Constructor que inicializa la clase `AccountsVO` con información específica.
     *
     * @param emailAccount     La dirección de correo electrónico asociada a la cuenta.
     * @param passwordAccount  La contraseña asociada a la cuenta.
     * @param cardName         El nombre en la tarjeta asociada a la cuenta.
     * @param cardNumber       El número de la tarjeta asociada a la cuenta.
     * @param cardCode         El código de seguridad de la tarjeta asociada a la cuenta.
     * @param level            El nivel de la cuenta.
     * @param numberScreens    El número de pantallas asociado a la cuenta.
     * @param suscriptionDate  La fecha de suscripción de la cuenta.
     */
    
    public AccountsVO(String emailAccount, String passwordAccount, String cardName, String cardNumber, String cardCode, String level, String numberScreens,
            Date suscriptionDate) {
        this.emailAccount = emailAccount;
        this.passwordAccount = passwordAccount;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardCode = cardCode;
        this.level = level;
        this.numberScreens = numberScreens;
        this.suscriptionDate = suscriptionDate;
    }

	public String getEmailAccount() {
		return emailAccount;
	}

	public void setEmailAccount(String emailAccount) {
		this.emailAccount = emailAccount;
	}

	public String getPasswordAccount() {
		return passwordAccount;
	}

	public void setPasswordAccount(String passwordAccount) {
		this.passwordAccount = passwordAccount;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getNumberScreens() {
		return numberScreens;
	}

	public void setNumberScreens(String numberScreens) {
		this.numberScreens = numberScreens;
	}

	public Date getSuscriptionDate() {
		return suscriptionDate;
	}

	public void setSuscriptionDate(Date suscriptionDate) {
		this.suscriptionDate = suscriptionDate;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}
	
	
	
	
	
	
	
	
	
	
}
