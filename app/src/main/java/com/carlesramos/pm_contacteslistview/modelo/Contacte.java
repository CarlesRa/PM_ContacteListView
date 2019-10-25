package com.carlesramos.pm_contacteslistview.modelo;

import java.io.Serializable;

public class Contacte implements Serializable {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private String empresa;
    private String fechaNac;
    private String telefono1;
    private String telefono2;
    private String email;

    public Contacte(int id, String nombre, String apellido1, String apellido2, String direccion, String empresa, String fechaNac, String telefono1, String telefono2, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.empresa = empresa;
        this.fechaNac = fechaNac;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public String getEmail() {
        return email;
    }
}
