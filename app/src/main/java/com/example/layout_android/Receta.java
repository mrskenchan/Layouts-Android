package com.example.layout_android;

public class Receta {

    private int id;
    private String nombre;
    private String fotoRuta;
    private String preparacion;
    private String nombreAutor;
    private int idAutor;
    private String nombreRegion;
    private int idRegion;

    public Receta() {}

    public Receta(int id, int idAutor, int idRegion, String nombre, String fotoRuta, String preparacion, String nombreAutor, String nombreRegion) {

        this.id = id;
        this.idAutor = idAutor;
        this.idRegion = idRegion;
        this.nombre = nombre;
        this.fotoRuta = fotoRuta;
        this.preparacion = preparacion;
        this.nombreAutor = nombreAutor;
        this.nombreRegion = nombreRegion;

    }

    //getters y setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getIdAutor() {return idAutor;}
    public void setIdAutor(int id) {this.idAutor = idAutor;}

    public int getIdRegion() {return idRegion;}
    public void setIdRegion(int idRegion) {this.idRegion = idRegion;}
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
