package modelo.dao;

import modelo.vo.EmpleadoVO;
import java.util.ArrayList;

public class EmpleadoDAO {
    private ArrayList<EmpleadoVO> empleados;
    private int nextId;

    public EmpleadoDAO() {
        empleados = new ArrayList<>();
        nextId = 1;

        // Datos de ejemplo para pruebas
        agregarEjemplos();
    }

    private void agregarEjemplos() {
        EmpleadoVO emp1 = new EmpleadoVO();
        emp1.setId(nextId++);
        emp1.setNombre("Ana García");
        emp1.setEmail("ana.garcia@empresa.com");
        emp1.setGenero("femenino");
        emp1.setDepartamento("sistemas");
        emp1.setCargo("desarrolladora");
        emp1.setSalario(75000);
        emp1.setIdiomas(new String[] { "español", "inglés" });
        emp1.setHabilidades(new String[] { "java", "javascript", "sql" });
        emp1.setActivo(true);
        emp1.setTieneVehiculo(true);
        emp1.setDisponibleViajes(false);
        emp1.setNivelEducacion("universitario");
        emp1.setTurno("mañana");
        emp1.setFechaNacimiento("1990-05-15");
        emp1.setComentarios("Excelente desarrolladora con 5 años de experiencia");
        empleados.add(emp1);

        EmpleadoVO emp2 = new EmpleadoVO();
        emp2.setId(nextId++);
        emp2.setNombre("Carlos López");
        emp2.setEmail("carlos.lopez@empresa.com");
        emp2.setGenero("masculino");
        emp2.setDepartamento("ventas");
        emp2.setCargo("gerente");
        emp2.setSalario(95000);
        emp2.setIdiomas(new String[] { "español", "inglés", "portugués" });
        emp2.setHabilidades(new String[] { "negociacion", "liderazgo" });
        emp2.setActivo(true);
        emp2.setTieneVehiculo(true);
        emp2.setDisponibleViajes(true);
        emp2.setNivelEducacion("posgrado");
        emp2.setTurno("completo");
        emp2.setFechaNacimiento("1985-12-03");
        emp2.setComentarios("Líder de equipo con gran experiencia en ventas internacionales");
        empleados.add(emp2);
    }

    public String agregar(EmpleadoVO empleado) {
        empleado.setId(nextId++);
        empleados.add(empleado);
        return "Empleado agregado exitosamente con ID: " + empleado.getId();
    }

    public ArrayList<EmpleadoVO> getLista() {
        return empleados;
    }

    public EmpleadoVO obtenerPorId(int id) {
        for (EmpleadoVO emp : empleados) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public String actualizar(EmpleadoVO empleado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId() == empleado.getId()) {
                empleados.set(i, empleado);
                return "Empleado actualizado exitosamente.";
            }
        }
        return "Empleado no encontrado.";
    }

    public String eliminar(int id) {
        for (EmpleadoVO emp : empleados) {
            if (emp.getId() == id) {
                empleados.remove(emp);
                return "Empleado eliminado exitosamente.";
            }
        }
        return "Empleado no encontrado.";
    }

    public int cantidad() {
        return empleados.size();
    }

    // Métodos útiles para obtener opciones del formulario
    public String[] getDepartamentos() {
        return new String[] { "sistemas", "ventas", "marketing", "rrhh", "finanzas", "operaciones" };
    }

    public String[] getCargos() {
        return new String[] { "desarrolladora", "analista", "gerente", "coordinadora", "especialista", "directora" };
    }

    public String[] getIdiomas() {
        return new String[] { "español", "inglés", "francés", "alemán", "portugués", "italiano", "japonés" };
    }

    public String[] getHabilidades() {
        return new String[] { "java", "javascript", "python", "sql", "html", "css", "react", "angular",
                "negociacion", "liderazgo", "comunicacion", "analisis", "creatividad" };
    }
}