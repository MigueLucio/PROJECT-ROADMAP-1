package com.tuorg.vehiculos;

import com.tuorg.vehiculos.domain.Auto;
import com.tuorg.vehiculos.domain.VelocidadInvalidaException;
import com.tuorg.vehiculos.repo.InMemoryVehiculoRepository;
import com.tuorg.vehiculos.service.GestionVehiculoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestionVehiculosServiceTest {

    @Test
    void acelerarYTenerVelocidad() {
        var s = new GestionVehiculoService(new InMemoryVehiculoRepository());
        s.registrar(new Auto("ABC-123"));
        s.acelerarTodos(30);
        assertEquals(30, s.buscarPorPlaca("ABC-123").velocidadActual());
    }

    @Test
    void acelerarExepcionPorAcelerarCero() {
        var auto = new Auto("AAA-111");
        assertThrows(VelocidadInvalidaException.class, () -> auto.acelerar(0));
    }

    @Test
    void frenarAutoPorPlaca() {
        var s = new GestionVehiculoService(new InMemoryVehiculoRepository());
        s.registrar(new Auto("BBB-222"));
        s.buscarPorPlaca("BBB-222").acelerar(50);
        s.frenarPorPlaca("BBB-222", 20);
        assertEquals(30, s.buscarPorPlaca("BBB-222").velocidadActual());
    }

    @Test
    void registrarYBuscar() {
        var s = new GestionVehiculoService(new InMemoryVehiculoRepository());
        s.registrar(new Auto("ABC-123")); // con espacios
        assertEquals("ABC-123", s.buscarPorPlaca("abc-123").placa()); // minúsculas
    }
}