package com.tuorg.vehiculos.repo;

import com.tuorg.vehiculos.domain.Vehiculo;

import java.util.Collection;
import java.util.Optional;

public interface VehiculoRepository {
    void guardar(Vehiculo v);
    Optional<Vehiculo> porPlaca(String placa);
    Collection<Vehiculo> todos();

}
