package org.eltrioquepesa.model;

public class HiloMedicion implements Runnable {

    private Canal canal;
    private PlataformaCentral plataforma;
    private FactorTiempo factorTiempo;

    public HiloMedicion(Canal canal, PlataformaCentral plataforma, FactorTiempo factorTiempo) {
        this.canal = canal;
        this.plataforma = plataforma;
        this.factorTiempo = factorTiempo;
    }

    @Override
    public void run() {

        double lluvia = canal.getSensor().medirLluvia();
        double nivelAgua = canal.getSensor().medirNivelAgua();

        double entrada = canal.calcularEntrada(lluvia);
        double deficit = canal.calcularDeficit(entrada);

        canal.actualizarNivel(deficit, factorTiempo.getFactor());

        DatosMonitoreo datos = new DatosMonitoreo(
                canal,
                nivelAgua,
                lluvia,
                entrada,
                deficit,
                factorTiempo.getMinutosCiclo()
        );

        plataforma.procesar(datos);
    }
}
