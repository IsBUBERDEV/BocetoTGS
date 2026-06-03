package org.eltrioquepesa.model;

public class DatosMonitoreo {

    private double nivelAgua;
    private double lluvia;
    private boolean obstruccion;

    public DatosMonitoreo(double nivelAgua, double lluvia, boolean obstruccion) {
        this.nivelAgua = nivelAgua;
        this.lluvia = lluvia;
        this.obstruccion = obstruccion;
    }

    public double getNivelAgua() {
        return nivelAgua;
    }

    public double getLluvia() {
        return lluvia;
    }

    public boolean isObstruccion() {
        return obstruccion;
    }

    @Override
    public String toString() {
        return "Nivel Agua: " + nivelAgua +
                " m | Lluvia: " + lluvia +
                " mm | Obstrucción: " + obstruccion;
    }
}
