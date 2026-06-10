package org.eltrioquepesa.model;

public class Alerta {

    public void emitir(String riesgo, DatosMonitoreo datos) {

        if (datos.getDeficit() > 0) {
            System.out.println("Déficit de drenaje detectado en " + datos.getCanal().getNombre());
        }

        if (datos.getCanal().getEstado() == EstadoCanal.OBSTRUIDO) {
            System.out.println("Canal obstruido: " + datos.getCanal().getNombre());
        }

        if (datos.getCanal().getEstado() == EstadoCanal.ROTO) {
            System.out.println("Canal roto/dañado: " + datos.getCanal().getNombre());
        }

        switch (riesgo) {

            case "ALTO":
                System.out.println("\nALERTA ROJA");
                System.out.println("Posible inundación inminente");
                System.out.println("Activando motobombas...");
                System.out.println("Notificando autoridades...");
                break;

            case "MEDIO":
                System.out.println("\nALERTA AMARILLA");
                System.out.println("Condiciones de riesgo detectadas");
                break;

            default:
                System.out.println("\nCondiciones normales");
        }
    }
}
