package com.tuorg.vehiculos.service;

import com.tuorg.vehiculos.domain.Vehiculo;
import com.tuorg.vehiculos.repo.VehiculoRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class GestionVehiculoService {

    public final VehiculoRepository repo;

    public GestionVehiculoService(VehiculoRepository repo) {
        this.repo = repo;
    }

    public void registrar(Vehiculo v) { repo.guardar(v);}

    public Vehiculo buscarPorPlaca(String placa) {
        return repo.porPlaca(placa)
            .orElseThrow(() -> new NoSuchElementException(" No existe vehiculo con placa " + placa));
    }

    public List<Vehiculo> listar(){ return List.copyOf(repo.todos());}

    //Polimorfismo : acelera/frena y muestra sin saber el tipo de dato en concreto
    public void acelerarTodos(int kmh) { repo.todos().forEach(v -> v.acelerar(kmh));}

    public void frenarTodos(int kmh) { repo.todos().forEach(v -> v.frenar(kmh));}

    public void frenarPorPlaca(String placa, int kmh) {
        var v = buscarPorPlaca(placa);
                v.frenar(kmh);
    }

}
