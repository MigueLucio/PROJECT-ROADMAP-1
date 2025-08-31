package com.tuorg.vehiculos.domain;

public class Auto implements Vehiculo, Comparable<Auto>{

    private final String placa;
    private int velocidad;

    public Auto(String placa) {
        this.placa = placa;
    }


    @Override
    public String placa() {
        return placa;
    }

    @Override public int velocidadActual() { return velocidad; }

    @Override public void acelerar(int kmh) {
            if (kmh <= 0) throw new VelocidadInvalidaException("Acelerar > 0");
            velocidad += kmh;
    }

    @Override public void frenar(int kmh) {
            if (kmh <= 0) throw new VelocidadInvalidaException("Frenar > 0");
            velocidad = Math.max(0, velocidad - kmh);
        }


        @Override
    public int compareTo(Auto o){
        // normalizamos para comparación consistente
        return this.placa.trim().toUpperCase().compareTo(o.placa().trim().toUpperCase());
        }

    }

