package com.vicente.vmotion.Model;

public class Favoritos {
    private String idActividad;
    private String idUsuario;

    public Favoritos(String idActividad, String idUsuario) {
        this.idActividad = idActividad;
        this.idUsuario = idUsuario;
    }

    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
