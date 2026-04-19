package logica;

/**
 * La clase `PersonsVO` representa a una persona y contiene información como tipo de persona, nombre, apellidos, ciudad, país, teléfonos, email y contraseña.
 */

public class PersonsVO {

	
	private String id_Persons;
	private String typePerson;
	private String namePerson;
	private String lastName;
	private String city;
	private String country;
	private String [] phones;
	private String emailAdmin;
	private String passwordAdmin;
	
	/**
     * Constructor predeterminado de PersonsVO.
     */
	
	public PersonsVO() {
		
	}
	
	/**
     * Constructor de PersonsVO con información básica de una persona.
     *
     * @param typePerson Tipo de persona.
     * @param namePerson Nombre de la persona.
     * @param lastName   Apellidos de la persona.
     * @param city       Ciudad de residencia de la persona.
     * @param country    País de residencia de la persona.
     * @param phones     Números de teléfono de la persona.
     */

	public PersonsVO(String typePerson, String namePerson, String lastName, String city, String country,
			String[] phones) {
		this.typePerson = typePerson;
		this.namePerson = namePerson;
		this.lastName = lastName;
		this.city = city;
		this.country = country;
		this.phones = phones;
	}
	
	/**
     * Constructor de PersonsVO con información básica de una persona con ID.
     *
     * @param typePerson Tipo de persona.
     * @param namePerson Nombre de la persona.
     * @param lastName   Apellidos de la persona.
     * @param city       Ciudad de residencia de la persona.
     * @param country    País de residencia de la persona.
     * @param phones     Números de teléfono de la persona.
     */
	
	public PersonsVO(String id_Persons, String typePerson, String namePerson, String lastName, String city, String country,
			String[] phones) {
		this.id_Persons = id_Persons;
		this.typePerson = typePerson;
		this.namePerson = namePerson;
		this.lastName = lastName;
		this.city = city;
		this.country = country;
		this.phones = phones;
	}
	
	/**
     * Constructor de PersonsVO con información completa para un ADMIN.
     *
     * @param id_Persons    ID de la persona.
     * @param typePerson    Tipo de persona.
     * @param namePerson    Nombre de la persona.
     * @param lastName      Apellidos de la persona.
     * @param city          Ciudad de residencia de la persona.
     * @param country       País de residencia de la persona.
     * @param phones        Números de teléfono de la persona.
     * @param emailAdmin    Correo electrónico de la persona.
     * @param passwordAdmin Contraseña de la persona.
     */
	
	public PersonsVO(String id_Persons, String typePerson, String namePerson, String lastName, String city, String country,
			String[] phones, String emailAdmin, String passwordAdmin) {
		this.id_Persons = id_Persons;
		this.typePerson = typePerson;
		this.namePerson = namePerson;
		this.lastName = lastName;
		this.city = city;
		this.country = country;
		this.phones = phones;
		this.emailAdmin = emailAdmin;
		this.passwordAdmin = passwordAdmin;
		
	}
	
	/**
     * Constructor de PersonsVO con información para un ADMIN sin ID.
     *
     * @param typePerson    Tipo de persona.
     * @param namePerson    Nombre de la persona.
     * @param lastName      Apellidos de la persona.
     * @param city          Ciudad de residencia de la persona.
     * @param country       País de residencia de la persona.
     * @param phones        Números de teléfono de la persona.
     * @param emailAdmin    Correo electrónico de la persona.
     * @param passwordAdmin Contraseña de la persona.
     */
	
	public PersonsVO(String typePerson, String namePerson, String lastName, String city, String country,
			String[] phones, String emailAdmin, String passwordAdmin) {
		
		this.typePerson = typePerson;
		this.namePerson = namePerson;
		this.lastName = lastName;
		this.city = city;
		this.country = country;
		this.phones = phones;
		this.emailAdmin = emailAdmin;
		this.passwordAdmin = passwordAdmin;
		
	}
	
	

	public String getId_Persons() {
		return id_Persons;
	}

	public void setId_Persons(String id_Persons) {
		this.id_Persons = id_Persons;
	}

	public String getTypePerson() {
		return typePerson;
	}

	public void setTypePerson(String typePerson) {
		this.typePerson = typePerson;
	}

	public String getNamePerson() {
		return namePerson;
	}

	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getPhones() {
		return phones;
	}

	public void setPhones(String[] phones) {
		this.phones = phones;
	}

	public String getEmailAdmin() {
		return emailAdmin;
	}

	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}

	public String getPasswordAdmin() {
		return passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}
	
	
	
	

	
	
	
	
	
}
