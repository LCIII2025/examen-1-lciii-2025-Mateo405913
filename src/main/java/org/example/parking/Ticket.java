package org.example.parking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Data
@AllArgsConstructor
public class Ticket {
    private final Cliente cliente;
    private final Vehiculo vehiculo;
    private final LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public Ticket(Cliente cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.horaEntrada = LocalDateTime.now();
    }

    public void marcarSalida() {
        Random random = new Random();
        this.horaSalida = LocalDateTime.now().plusMinutes(random.nextInt(200)+1);
    }

    public long calcularMinutos() {
        return Duration.between(horaEntrada, horaSalida).toMinutes();
    }

    public double calcularPrecio() {
        // TODO implementar el metodo para calcular el importe a abonar segun el tipo de vehiculo
        // AUTO -> 100, SUV -> 130, PICKUP -> 180
        // el importe es por hora redondeando el tiempo hacia arriba,
        // por ejemplo si estuvo 45 minutos se le tarifa por 60, si estuvo 80 minutos se le tarifa por 120 minutos, etc...
        // retornar el importe final
        long minutos = 0;
        long importe = 0;
        if (vehiculo.getTipo().equals(Vehiculo.Tipo.AUTO)) {
            minutos = calcularMinutos();
            importe = 100 * Math.round((double) minutos / 60);
            return importe;
        } else if (vehiculo.getTipo().equals(Vehiculo.Tipo.SUV)) {
            minutos = calcularMinutos();
            importe = 130 * Math.round((double) minutos / 60);
            return importe;
        } else if (vehiculo.getTipo().equals(Vehiculo.Tipo.PICKUP)) {
            minutos = calcularMinutos();
            importe = 180 * Math.round((double) minutos / 60);
            return importe;
        }
        return 0;
    }
}