/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prn315.guia11.ejemplosbd.registrarusuario;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rchicas
 */
public class ProductoTableModel extends AbstractTableModel{

    List<Producto> productos = new ArrayList<Producto>();
    
    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto producto = productos.get(rowIndex);
        Object valor = null;
        
        switch(columnIndex){
            case 0: valor = producto.codigo;
                break;
            case 1: valor = producto.nombre;
                break;
            case 2: valor = producto.cantidadExistencia;
                break;
            case 3: valor = producto.precioUnitario;
        }
        
        return valor;
    }
    
}
