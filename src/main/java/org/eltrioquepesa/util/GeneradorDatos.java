package org.eltrioquepesa.util;

import org.eltrioquepesa.model.DatosMonitoreo;

public class GeneradorDatos {

    public static DatosMonitoreo crear(
            double nivelAgua,
            double lluvia,
            boolean obstruccion) {

        return new DatosMonitoreo(
                nivelAgua,
                lluvia,
                obstruccion
        );
    }
}
