package modelo;

import java.sql.Date;

public class Camion {
    private int id;
    private String patente;
    private String conductor;
    private String ubicacionGps;
    private boolean estado; // Activo o Inactivo
    private Date fechaMantenimiento;

    // Constructor
    public Camion(int id, String patente, String conductor, String ubicacionGps, boolean estado, Date fechaMantenimiento) {
        this.id = id;
        this.patente = patente;
        this.conductor = conductor;
        this.ubicacionGps = ubicacionGps;
        this.estado = estado;
        this.fechaMantenimiento = fechaMantenimiento;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getUbicacionGps() {
        return ubicacionGps;
    }

    public void setUbicacionGps(String ubicacionGps) {
        this.ubicacionGps = ubicacionGps;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }
}
