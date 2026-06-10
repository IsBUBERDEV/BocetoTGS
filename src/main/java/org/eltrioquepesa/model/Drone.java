package org.eltrioquepesa.model;

public class Drone {

    private String id;

    public Drone(String id) {
        this.id = id;
    }

    public boolean inspeccionarCanal(Canal canal) {
        return canal.getEstado() != EstadoCanal.NORMAL;
    }

    public String getId() {
        return id;
    }
}
