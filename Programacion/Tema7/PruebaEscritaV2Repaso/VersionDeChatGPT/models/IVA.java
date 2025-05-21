package Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.models;

public enum IVA {
    GENERAL(21), REDUCIDO(10), SUPERREDUCIDO(4);

    private final int porcentaje;

    IVA(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getPorcentaje() {
        return porcentaje;
    }
}