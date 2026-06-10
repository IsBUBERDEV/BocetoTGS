package org.eltrioquepesa.model;

public class FactorTiempo {

    private int minutosPorCiclo;
    private int minutosTotales;

    public FactorTiempo(int minutosPorCiclo) {
        this.minutosPorCiclo = minutosPorCiclo;
        this.minutosTotales = 0;
    }

    public void avanzar() {
        minutosTotales += minutosPorCiclo;
    }

    public int getMinutosCiclo() {
        return minutosPorCiclo;
    }

    public int getMinutosTotales() {
        return minutosTotales;
    }

    public double getFactor() {
        return minutosPorCiclo / 60.0;
    }
}
