package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.vo.PerroVO;

public class PerroDAO {
    private static List<PerroVO> listaPerros = new ArrayList<>();
    private static int idCounter = 1;

    public void agregarPerro(String nombre, String raza) {
        PerroVO perro = new PerroVO(idCounter++, nombre, raza);
        listaPerros.add(perro);
    }

    public List<PerroVO> listarPerros() {
        return listaPerros;
    }
}