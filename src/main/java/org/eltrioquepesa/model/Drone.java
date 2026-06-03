package org.eltrioquepesa.model;

import java.util.Random;

public class Drone {

    private String id;
    private Random random;

    public Drone(String id) {
        this.id = id;
        this.random = new Random();
    }

    public boolean detectarObstruccion() {
        return random.nextBoolean();
    }

    public String getId() {
        return id;
    }
}
