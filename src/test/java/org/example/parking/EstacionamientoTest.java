package org.example.parking;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

import static junit.framework.Assert.*;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO test
        Estacionamiento estacionamiento = new Estacionamiento();
        Cliente cliente = new Cliente("123123123","Hugo");
        Vehiculo vehiculo = new Vehiculo("OO1","NUEVO", Vehiculo.Tipo.AUTO);
        assertTrue(estacionamiento.ingresarVehiculo(cliente.getDni(), cliente.getNombre(), vehiculo));
        Ticket ticket = estacionamiento.retirarVehiculo(vehiculo.getPatente());
        assertNotNull(ticket);
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // TODO test
        Cliente cliente = new Cliente("123123123","Hugo");
        Vehiculo vehiculo = new Vehiculo("OO1","NUEVO", Vehiculo.Tipo.AUTO);
        Ticket ticket = new Ticket(cliente,vehiculo);
        ticket.setHoraSalida(LocalDateTime.now().plusMinutes(60));
        assertNotNull(ticket.calcularPrecio());
        assertEquals(100.0, ticket.calcularPrecio());

        Vehiculo vehiculo2 = new Vehiculo("OO2","NUEVO", Vehiculo.Tipo.SUV);
        Ticket ticket2 = new Ticket(cliente,vehiculo2);
        ticket2.setHoraSalida(LocalDateTime.now().plusMinutes(120));
        assertNotNull(ticket2.calcularPrecio());
        assertEquals(260.0, ticket2.calcularPrecio());

        Vehiculo vehiculo3 = new Vehiculo("OO3","NUEVO", Vehiculo.Tipo.PICKUP);
        Ticket ticket3 = new Ticket(cliente,vehiculo3);
        ticket3.setHoraSalida(LocalDateTime.now().plusMinutes(160));
        assertNotNull(ticket3.calcularPrecio());
        assertEquals(540.0, ticket3.calcularPrecio());
    }

}