package com.example.layout_android;

public class Receta {

    private String nombre;
    private String fotoRuta;
    private String preparacion;
    private String nombreAutor;
    private String nombreRegion;

    public Receta() {}

    public Receta(String nombre, String fotoRuta, String preparacion, String nombreAutor, String nombreRegion) {

        this.nombre = nombre;
        this.fotoRuta = fotoRuta;
        this.preparacion = preparacion;
        this.nombreAutor = nombreAutor;
        this.nombreRegion = nombreRegion;

    }

    //getters y setters
    public String getNombre() { return nombre ;}
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFotoRuta() { return fotoRuta; }
    public void setFotoRuta(String fotoRuta) { this.fotoRuta = fotoRuta; }

    public String getPreparacion() { return preparacion; }
    public void setPreparacion(String preparacion) { this.preparacion = preparacion; }

    public String getNombreAutor() { return nombreAutor; }
    public void setNombreAutor(String nombreAutor) { this.nombreAutor = nombreAutor; }

    public String getNombreRegion() { return nombreRegion; }
    public void setNombreRegion(String nombreRegion) { this.nombreRegion = nombreRegion; }

}
