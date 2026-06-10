package org.eltrioquepesa.util;

import org.eltrioquepesa.model.Canal;
import org.eltrioquepesa.model.DatosMonitoreo;

public class GeneradorDatos {

    public static DatosMonitoreo crear(
            Canal canal,
            double nivelAgua,
            double lluvia,
            double entrada,
            double deficit,
            int minutosCiclo) {

        return new DatosMonitoreo(
                canal,
                nivelAgua,
                lluvia,
                entrada,
                deficit,
                minutosCiclo
        );
    }
}
