package org.eltrioquepesa.model;

public class IAAnalizador {

    public String predecirRiesgo(DatosMonitoreo datos) {

        int puntaje = 0;

        if (datos.getNivelAgua() > 3.5)
            puntaje += 40;

        if (datos.getLluvia() > 80)
            puntaje += 40;

        if (datos.isObstruccion())
            puntaje += 20;

        if (puntaje >= 80)
            return "ALTO";

        if (puntaje >= 50)
            return "MEDIO";

        return "BAJO";
    }
}
