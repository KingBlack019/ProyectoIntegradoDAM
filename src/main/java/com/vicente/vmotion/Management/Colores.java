package com.vicente.vmotion.Management;

public enum Colores {
    // TODO Consumidores = VERDE | Ofertantes = AZUL

    // COLORES QUE VA A CONTENER EL USUARIO CONSUMIDOR
    CONSUMIDOR_LIGTH("#1abc9c"),
    CONSUMIDOR_NORMAL("#17a589"),
    CONSUMIDOR_DARK("#148f77"),

    // COLORES QUE VA A CONTENER EL USUARIO OFERTANTE
    OFERTANTE_LIGTH("#3498db"),
    OFERTANTE_NORMAL("#2e86c1"),
    OFERTANTE_DARK("#2874a6"),
    ;

    private final String valorHexadecimal;

    Colores(String valorHexadecimal){
        this.valorHexadecimal = valorHexadecimal;
    }

    public String getValorHexadecimal() {
        return valorHexadecimal;
    }

    public static Colores[] getColoresPorRol(String rol) {
        switch (rol.toUpperCase()) {
            case "OFERTANTES":
                return new Colores[] {OFERTANTE_LIGTH, OFERTANTE_NORMAL, OFERTANTE_DARK};
            case "CONSUMIDORES":
                return new Colores[] {CONSUMIDOR_LIGTH, CONSUMIDOR_NORMAL, CONSUMIDOR_DARK};
            default:
                throw new IllegalArgumentException("Rol no reconocido: " + rol);
        }
    }
}
