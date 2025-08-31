package com.tuorg.vehiculos.repo;

import com.tuorg.vehiculos.domain.Vehiculo;

import java.util.*;

public class InMemoryVehiculoRepository implements VehiculoRepository {

    private final Map<String, Vehiculo> data = new HashMap<>();

    // Normaliza la placa para usarla como clave
    private static String key(String placa) {
        return placa == null ? null : placa.trim().toUpperCase();
    }

    @Override
    public void guardar(Vehiculo v) {
        data.put(key(v.placa()), v);
    }

    @Override
    public Optional<Vehiculo> porPlaca(String placa) {
        return Optional.ofNullable(data.get(key(placa)));
    }

    @Override
    public Collection<Vehiculo> todos() {
        return Collections.unmodifiableCollection(data.values());
    }
}
