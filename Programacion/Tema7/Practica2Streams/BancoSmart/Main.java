package Programacion.Tema7.Practica2Streams.BancoSmart;

import java.util.*;
import java.time.*;
import java.time.format.TextStyle;
import java.util.UUID;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Random rand = new Random();
        String[] descripciones = { "Compra", "Salario", "PagoTest", "Transferencia", "Préstamo" };

        // Crear 10 cuentas con transacciones aleatorias
        for (int i = 1; i <= 10; i++) {
            Cliente cliente = new Cliente("DNI" + i, "Nombre" + i, "email" + i + "@ejemplo.com", "60000000" + i,
                    "Calle Falsa " + i, "Ciudad" + i, "País" + i);
            Cuenta cuenta = new Cuenta(cliente);
            banco.addCuenta(cuenta);
            int nTrans = rand.nextInt(10) + 1; // entre 1 y 10 transacciones

            for (int j = 0; j < nTrans; j++) {
                LocalDate fecha = LocalDate.now().minusDays(rand.nextInt(365));
                TipoTransaccion tipo = rand.nextBoolean() ? TipoTransaccion.INGRESO : TipoTransaccion.GASTO;
                double importe = Math.round(rand.nextDouble() * 10000) / 100.0; // entre 0.00 y 100.00
                String descripcion = descripciones[rand.nextInt(descripciones.length)];

                Transaccion t = new Transaccion(cuenta, importe, fecha, tipo, descripcion);
                cuenta.addTransaccion(t);
            }
        }

        // 1. Transacciones con importe mínimo
        double valorMin = 500.0;
        System.out.println("\nTransacciones con importe > " + valorMin + "€:");
        List<Transaccion> transMin = banco.getTransaccionesImporteMinimo(valorMin);
        transMin.forEach(System.out::println);

        // 2. Total de ingresos
        double totalIngresos = banco.getIngresosTotales();
        System.out.printf("\nIngresos totales: %.2f€\n", totalIngresos);

        // 3. Total de gastos
        double totalGastos = banco.getGastosTotales();
        System.out.printf("Gastos totales: %.2f€\n", totalGastos);

        // 4. Cuentas ordenadas por saldo
        System.out.println("\nCuentas ordenadas por saldo (mayor a menor):");
        List<Cuenta> ordenadas = banco.getCuentasPorSaldo();
        ordenadas.forEach(c -> System.out.printf("%s | Saldo: %.2f€\n", c.getId(), c.getSaldo()));

        // 5. Número de transacciones por cuenta
        System.out.println("\nNúmero de transacciones por cuenta:");
        Map<UUID, Long> numTrans = banco.getNumTransaccionesPorCuenta();
        numTrans.forEach((id, count) ->
                System.out.printf("Cuenta %s: %d transacciones\n", id, count)
        );

        // 6. Cuentas activas este mes
        List<Cuenta> activas = banco.getCuentasActivas();
        System.out.printf("\nCuentas activas este mes: %d\n", activas.size());

        // 7. Transacciones por descripción
        String palabraClave = "Pago";
        Map<UUID, Set<Transaccion>> porDescripcion = banco.getTransaccionesPorDescripcion(palabraClave);
        System.out.println("\nTransacciones que contienen '" + palabraClave + "':");
        porDescripcion.forEach((id, set) ->
                System.out.printf("Cuenta %s: %d transacciones\n", id, set.size())
        );

        // 8. Análisis temporal mensual (ingresos vs gastos)
        System.out.println("\nAnálisis temporal mensual:");
        banco.showAnalisisMensual();
    }
}
