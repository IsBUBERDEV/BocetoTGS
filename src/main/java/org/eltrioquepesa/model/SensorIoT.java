package org.eltrioquepesa.model;

public class SensorIoT {

    private Canal canal;
    private static long inicio = System.currentTimeMillis();

    public SensorIoT(Canal canal) {
        this.canal = canal;
    }

    public double medirNivelAgua() {
        return canal.getNivelAgua();
    }

    public double medirLluvia() {
        double segundos = (System.currentTimeMillis() - inicio) / 1000.0;
        double maximo = 150;

        return maximo * (Math.sin(segundos * 0.4) + 1) / 2;
    }

    public Canal getCanal() {
        return canal;
    }
}
