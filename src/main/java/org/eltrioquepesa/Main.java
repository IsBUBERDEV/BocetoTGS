package org.eltrioquepesa;

import org.eltrioquepesa.model.DatosMonitoreo;
import org.eltrioquepesa.model.Drone;
import org.eltrioquepesa.model.PlataformaCentral;
import org.eltrioquepesa.model.SensorIoT;

public class Main {

    public static void main(String[] args) {

        SensorIoT sensor = new SensorIoT("Canal Principal");
        Drone drone = new Drone("DR-01");

        PlataformaCentral plataforma =
                new PlataformaCentral();

        for (int i = 1; i <= 5; i++) {

            System.out.println("\n=======================");
            System.out.println("SIMULACION #" + i);
            System.out.println("=======================");

            double nivelAgua =
                    sensor.medirNivelAgua();

            double lluvia =
                    sensor.medirLluvia();

            boolean obstruccion =
                    drone.detectarObstruccion();

            DatosMonitoreo datos =
                    new DatosMonitoreo(
                            nivelAgua,
                            lluvia,
                            obstruccion
                    );

            plataforma.procesar(datos);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nFin de la simulación.");
    }
}
