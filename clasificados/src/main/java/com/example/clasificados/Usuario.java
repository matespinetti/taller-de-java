package com.example.clasificados;

public class Usuario {
    private String nombre;
    private String clave;
    private String perfil;

    public Usuario(String nombre, String clave, String perfil) {
        this.nombre = nombre;
        this.clave = clave;
        this.perfil = perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
