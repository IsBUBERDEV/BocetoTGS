package org.eltrioquepesa.model;

public class Alerta {

    public void emitir(String riesgo) {

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
