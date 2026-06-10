package org.eltrioquepesa.model;

import java.util.Random;

public class Canal {

    private String nombre;
    private String zona;
    private double capacidadDrenaje;
    private double nivelAgua;
    private EstadoCanal estado;
    private SensorIoT sensor;
    private Random random;

    public Canal(String nombre, String zona, double capacidadDrenaje) {
        this.nombre = nombre;
        this.zona = zona;
        this.capacidadDrenaje = capacidadDrenaje;
        this.nivelAgua = 1.0;
        this.estado = EstadoCanal.NORMAL;
        this.random = new Random();
        this.sensor = new SensorIoT(this);
    }

    public void simularEstado() {
        int azar = random.nextInt(10);

        if (azar == 0) {
            estado = EstadoCanal.ROTO;
        } else if (azar <= 2) {
            estado = EstadoCanal.OBSTRUIDO;
        } else {
            estado = EstadoCanal.NORMAL;
        }
    }

    public double getCapacidadEfectiva() {
        switch (estado) {
            case OBSTRUIDO:
                return capacidadDrenaje * 0.3;
            case ROTO:
                return 0;
            default:
                return capacidadDrenaje;
        }
    }

    public double calcularEntrada(double lluvia) {
        return (lluvia * 0.05) + (nivelAgua * 0.2);
    }

    public double calcularDeficit(double entrada) {
        double capacidad = getCapacidadEfectiva();
        return Math.max(0, entrada - capacidad);
    }

    public void actualizarNivel(double deficit, double factorTiempo) {
        nivelAgua += deficit * factorTiempo * 0.15;

        if (nivelAgua < 0.5) {
            nivelAgua = 0.5;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getZona() {
        return zona;
    }

    public double getCapacidadDrenaje() {
        return capacidadDrenaje;
    }

    public double getNivelAgua() {
        return nivelAgua;
    }

    public EstadoCanal getEstado() {
        return estado;
    }

    public SensorIoT getSensor() {
        return sensor;
    }
}
