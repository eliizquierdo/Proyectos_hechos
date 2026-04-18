import java.time.LocalTime;

public class FranjaHoraria {
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String categoria;

    public FranjaHoraria(){}

    public FranjaHoraria(String dia, LocalTime horaInicio, LocalTime horaFin, String categoria) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.categoria = categoria;
    }

    public void setDia(String dia) { this.dia = dia;}
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio;}
    public void setHoraFin(LocalTime horaFin ) { this.horaFin = horaFin;}
    public void setCategoria(String categoria) { this.categoria = categoria;}
    

    public String getDia() { return dia; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public LocalTime getHoraFin() { return horaFin; }
    public String getCategoria() { return categoria; }

    @Override
    public String toString() {
        return "Día: " + dia + ", Horario: [" + horaInicio + " - " + horaFin + "], Categoría: " + categoria;
    }
}