package com.intecap.libreriaherrera;

public class ModeloProductos {

    String nombre;
    String precio;
    int id;
    int imagen;

    public ModeloProductos(String nombre, String precio, int id, int imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = id;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
