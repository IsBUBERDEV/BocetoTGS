package org.eltrioquepesa.model;

public class DatosMonitoreo {

    private Canal canal;
    private double nivelAgua;
    private double lluvia;
    private double entrada;
    private double deficit;
    private int minutosCiclo;

    public DatosMonitoreo(Canal canal, double nivelAgua, double lluvia,
                          double entrada, double deficit, int minutosCiclo) {
        this.canal = canal;
        this.nivelAgua = nivelAgua;
        this.lluvia = lluvia;
        this.entrada = entrada;
        this.deficit = deficit;
        this.minutosCiclo = minutosCiclo;
    }

    public Canal getCanal() {
        return canal;
    }

    public double getNivelAgua() {
        return nivelAgua;
    }

    public double getLluvia() {
        return lluvia;
    }

    public double getEntrada() {
        return entrada;
    }

    public double getDeficit() {
        return deficit;
    }

    public int getMinutosCiclo() {
        return minutosCiclo;
    }

    @Override
    public String toString() {
        return "Canal: " + canal.getNombre() +
                " (" + canal.getZona() + ")" +
                " | Estado: " + canal.getEstado() +
                " | Nivel Agua: " + String.format("%.2f", nivelAgua) + " m" +
                " | Lluvia: " + String.format("%.1f", lluvia) + " mm" +
                " | Entrada: " + String.format("%.1f", entrada) +
                " | Cap. drenaje: " + String.format("%.1f", canal.getCapacidadEfectiva()) +
                " | Déficit: " + String.format("%.1f", deficit) +
                " | Factor tiempo: " + minutosCiclo + " min";
    }
}
