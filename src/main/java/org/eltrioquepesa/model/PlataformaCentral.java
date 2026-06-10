package org.eltrioquepesa.model;

public class PlataformaCentral {

    private IAAnalizador analizador;
    private Alerta alerta;

    public PlataformaCentral() {
        analizador = new IAAnalizador();
        alerta = new Alerta();
    }

    public synchronized void procesar(DatosMonitoreo datos) {

        System.out.println("\n===== DATOS RECIBIDOS [" + Thread.currentThread().getName() + "] =====");
        System.out.println(datos);

        String riesgo = analizador.predecirRiesgo(datos);

        System.out.println("Riesgo calculado: " + riesgo);

        alerta.emitir(riesgo, datos);
    }
}
