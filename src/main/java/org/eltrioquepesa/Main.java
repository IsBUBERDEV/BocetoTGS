package org.eltrioquepesa;

import org.eltrioquepesa.model.Canal;
import org.eltrioquepesa.model.Drone;
import org.eltrioquepesa.model.FactorTiempo;
import org.eltrioquepesa.model.HiloMedicion;
import org.eltrioquepesa.model.PlataformaCentral;

public class Main {

    public static void main(String[] args) {

        Canal canalPrincipal = new Canal("Canal Principal", "El Pozón", 50);
        Canal canalMaria = new Canal("Caño La María", "Olaya Herrera", 35);
        Canal canalBocagrande = new Canal("Canal Bocagrande", "Bocagrande", 60);

        Canal[] canales = {canalPrincipal, canalMaria, canalBocagrande};

        Drone drone = new Drone("DR-01");
        PlataformaCentral plataforma = new PlataformaCentral();
        FactorTiempo factorTiempo = new FactorTiempo(30);

        for (int i = 1; i <= 5; i++) {

            factorTiempo.avanzar();

            System.out.println("\n=======================");
            System.out.println("SIMULACION #" + i);
            System.out.println("Tiempo transcurrido: " + factorTiempo.getMinutosTotales() + " min");
            System.out.println("Lluvia actual: " +
                    String.format("%.1f", canalPrincipal.getSensor().medirLluvia()) + " mm");
            System.out.println("=======================");

            Thread[] hilos = new Thread[canales.length];

            for (int j = 0; j < canales.length; j++) {
                canales[j].simularEstado();

                if (drone.inspeccionarCanal(canales[j])) {
                    System.out.println("Drone " + drone.getId() +
                            " confirma anomalía en " + canales[j].getNombre() +
                            " -> " + canales[j].getEstado());
                }

                HiloMedicion medicion = new HiloMedicion(canales[j], plataforma, factorTiempo);
                hilos[j] = new Thread(medicion, "Hilo-" + canales[j].getNombre());
                hilos[j].start();
            }

            for (Thread hilo : hilos) {
                try {
                    hilo.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nFin de la simulación.");
        System.out.println("Resumen final de canales:");
        for (Canal canal : canales) {
            System.out.println(" - " + canal.getNombre() + ": nivel " +
                    String.format("%.2f", canal.getNivelAgua()) + " m, estado " + canal.getEstado());
        }
    }
}
