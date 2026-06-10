package org.eltrioquepesa.model;

public class IAAnalizador {

    public String predecirRiesgo(DatosMonitoreo datos) {

        int puntaje = 0;

        if (datos.getNivelAgua() > 3.5)
            puntaje += 30;

        if (datos.getLluvia() > 80)
            puntaje += 30;

        if (datos.getDeficit() > 10)
            puntaje += 25;

        if (datos.getCanal().getEstado() == EstadoCanal.OBSTRUIDO)
            puntaje += 15;

        if (datos.getCanal().getEstado() == EstadoCanal.ROTO)
            puntaje += 25;

        if (puntaje >= 80)
            return "ALTO";

        if (puntaje >= 50)
            return "MEDIO";

        return "BAJO";
    }
}
