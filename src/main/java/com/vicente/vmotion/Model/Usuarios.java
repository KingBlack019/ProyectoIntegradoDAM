package com.vicente.vmotion.Model;

import java.util.Date;

public class Usuarios {
    private String idUsuario;
    private String nombre;
    private String contrasena;
    private String email;
    private Date fechaRegistro;

    public Usuarios() {}

    public Usuarios(String idUsuario, String nombre, String contrasena, String email, Date fechaRegistro) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
