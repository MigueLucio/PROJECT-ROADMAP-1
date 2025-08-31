package com.tuorg.vehiculos.service;

import com.tuorg.vehiculos.domain.Vehiculo;
import com.tuorg.vehiculos.repo.VehiculoRepository;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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

    /*sort sirve para crear un nuevo flujo de elementos diferente al original
    según el orden de natural o de un Comparator */

    public List<Vehiculo> listarOrdenadoPorPlaca(){
        //si mas adelante se añade moto usar Comparator.comparing

        return repo.todos().stream()
                .sorted(Comparator.comparing(v -> v.placa().trim().toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Vehiculo> listarOrdenadoPorVelocidadDesc(){
        return repo.todos().stream()
                .sorted(Comparator.comparingInt(Vehiculo::velocidadActual).reversed())
                .collect(Collectors.toList());
    }

}
