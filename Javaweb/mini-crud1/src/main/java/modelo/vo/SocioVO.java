package modelo.vo;

public class SocioVO extends PersonaVO {
    private String medicacion;
    private String carnetSalud;
    private String sociedadMedica;

    public SocioVO() {
    }

    public SocioVO(int cedula, String nombre, String medicacion, String carnetSalud, String sociedadMedica) {
        super(cedula, nombre);
        this.medicacion = medicacion;
        this.carnetSalud = carnetSalud;
        this.sociedadMedica = sociedadMedica;
    }

    public String getMedicacion() {
        return medicacion;
    }

    public void setMedicacion(String medicacion) {
        this.medicacion = medicacion;
    }

    public String getCarnetSalud() {
        return carnetSalud;
    }

    public void setCarnetSalud(String carnetSalud) {
        this.carnetSalud = carnetSalud;
    }

    public String getSociedadMedica() {
        return sociedadMedica;
    }

    public void setSociedadMedica(String sociedadMedica) {
        this.sociedadMedica = sociedadMedica;
    }

    @Override
    public String toString() {
        return "SocioVO" + super.toString() + ", medicacion: " + medicacion + ", carnetSalud:" + carnetSalud +  ", sociedadMedica: " + sociedadMedica;
    }
}
