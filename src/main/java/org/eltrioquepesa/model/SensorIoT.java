package org.eltrioquepesa.model;

import java.util.Random;

public class SensorIoT {

    private String ubicacion;
    private Random random;

    public SensorIoT(String ubicacion) {
        this.ubicacion = ubicacion;
        this.random = new Random();
    }

    public double medirNivelAgua() {
        return 0.5 + random.nextDouble() * 4.5;
    }

    public double medirLluvia() {
        return random.nextDouble() * 150;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
