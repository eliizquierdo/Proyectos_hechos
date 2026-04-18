import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class Actividad {
    private String nombre;
    private List<FranjaHoraria> franjasHorarias;

    public Actividad() {
        this.franjasHorarias = new ArrayList<>();
    }

    public Actividad(String nombre) {
        this.nombre = nombre;
        this.franjasHorarias = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<FranjaHoraria> getFranjasHorarias() { return franjasHorarias; }

    public void agregarFranjaHoraria(FranjaHoraria franja) {
        this.franjasHorarias.add(franja);
    }

    @Override
    public String toString() {
        String resultado = "Actividad [Nombre=" + nombre + ", Horario Detallado:\n";
        if (franjasHorarias.isEmpty()) {
            resultado += "  No hay horario definido.";
        } else {
            for (FranjaHoraria franja : franjasHorarias) {
                resultado += "  - " + franja.toString() + "\n";
            }
        }
        resultado += "]";
        return resultado;
    }

    public void ingresarDatosActividad(Scanner scanner) {
        System.out.println("_________Configurar_Horario_de_Actividad________");
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int opcionDia;

        do {
            System.out.println("\n________Seleccione_un_Día_________");
            for (int i = 0; i < diasSemana.length; i++) System.out.println((i + 1) + "- " + diasSemana[i]);
            System.out.println("0- Terminar");
            System.out.print("Opción: ");
            opcionDia = scanner.nextInt();
            scanner.nextLine();

            if (opcionDia > 0 && opcionDia <= diasSemana.length) {
                String diaSeleccionado = diasSemana[opcionDia - 1];
                int opcionFranja;
                do {
                    System.out.println("\n_____Franjas_para_" + diaSeleccionado + "______");
                    System.out.println("1- Añadir");
                    System.out.println("0- Terminar franjas para " + diaSeleccionado);
                    System.out.print("Opción: ");
                    opcionFranja = scanner.nextInt();
                    scanner.nextLine();

                    if (opcionFranja == 1) {
                        LocalTime horaInicio = obtenerHora(scanner, "inicio");
                        LocalTime horaFin;
                        do {
                            horaFin = obtenerHora(scanner, "finalización");
                            if (horaFin.isBefore(horaInicio)) System.out.println("Hora fin debe ser posterior a inicio.");
                        } while (horaFin.isBefore(horaInicio));

                        System.out.print("Categoría: ");
                        String categoriaFranja = scanner.nextLine();

                        this.agregarFranjaHoraria(new FranjaHoraria(diaSeleccionado, horaInicio, horaFin, categoriaFranja));
                    } else if (opcionFranja != 0) {
                        System.out.println("Opción no válida.");
                    }
                } while (opcionFranja != 0);
            } else if (opcionDia != 0) {
                System.out.println("Opción de día no válida.");
            }
        } while (opcionDia != 0);
        System.out.println("Configuración de horario finalizada.");
    }

    private LocalTime obtenerHora(Scanner scanner, String tipoHora) {
        LocalTime hora = null;
        while (hora == null) {
            System.out.print("Ingrese la hora de " + tipoHora + " (HH:mm,): ");
            String horaStr = scanner.nextLine();
            hora = LocalTime.parse(horaStr);
        }
        return hora;
    }
}