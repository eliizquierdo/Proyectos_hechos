/*
 * Descripcion -
 *   Modelo VO abstracto que encapsula propiedades comunes de una actividad.
 *
 * Ultima modificacion -
 *   16/11/2025 2:28 a. m
 *
 * Autores -
 *   David Bellerati
 *   Natan Souza
*/

package com.davidbellerati.vo;

import java.util.List;

public class MaterialVO {
    

    public MaterialVO() {  }
    /*
     * No se define el id por ser AUTO_INCREMENT en la tabla correspondiente.
     */
    public MaterialVO(
        String name, int amount
    ) {
        this.name = name;
        this.amount = amount;
    }


    protected int id;
    protected String name;
    protected int amount;



    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }


    @Override
    public String toString() {
        return "MaterialVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
