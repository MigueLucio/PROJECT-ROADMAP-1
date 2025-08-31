package com.tuorg;

import com.tuorg.vehiculos.domain.Auto;
import com.tuorg.vehiculos.repo.InMemoryVehiculoRepository;
import com.tuorg.vehiculos.service.GestionVehiculoService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var repo = new InMemoryVehiculoRepository();
        var service = new GestionVehiculoService(repo);

        service.registrar(new Auto("ABC-123"));
        // service.registrar(new Moto("XYZ-999"));

        service.acelerarTodos(20);
        service.listar().forEach(v -> System.out.println(v.placa() + " -> " + v.velocidadActual() + " kmh "));
    }
}
