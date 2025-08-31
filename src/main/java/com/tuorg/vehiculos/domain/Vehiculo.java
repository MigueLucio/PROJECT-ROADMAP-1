package com.tuorg.vehiculos.domain;

public interface Vehiculo {
    String placa();
    int velocidadActual();
    void acelerar(int kmh);
    void frenar(int kmh);

}
