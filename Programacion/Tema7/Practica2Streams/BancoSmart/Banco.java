package Programacion.Tema7.Practica2Streams.BancoSmart;

import java.time.*;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class Banco {

    List<Cuenta> cuentas;

    public Banco() {
    this.cuentas = new ArrayList<>();
    }

    public void addCuenta(Cuenta c){
        cuentas.add(c);
    }

    public Cuenta getCuentaPorId(UUID id) {
//        cuentas.stream()
//                .filter(c -> c.getId().equals(id))
//                .forEach(System.out::println);
        List<Cuenta> encontrado = cuentas.stream()
                .filter(c -> c.getId().equals(id))
                .toList();
        return encontrado.getFirst();
    }
    public List<Transaccion> getTodasTransacciones(){
        return cuentas.stream()
                .flatMap(cuenta -> cuenta.getTransacciones().stream())
                .toList();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Banco{");
        sb.append("cuentas=").append(cuentas);
        sb.append('}');
        return sb.toString();
    }

    public List<Transaccion> getTransaccionesImporteMinimo(Double valor) {
        return cuentas.stream()
                .flatMap(c -> c.getTransacciones().stream())
                .filter(t -> t.getImporte() > valor)
                .sorted(Comparator.comparing(Transaccion::getFecha))
                .toList();
    }
    public double getIngresosTotales() {
        return cuentas.stream()
                .flatMap(c -> c.getTransacciones().stream())
                .filter(t -> t.getTipoTransaccion().equals(TipoTransaccion.INGRESO))
                .collect(Collectors.summarizingDouble(Transaccion::getImporte))
                .getSum();
    }
    public double getGastosTotales() {
        return cuentas.stream()
                .flatMap(c -> c.getTransacciones().stream())
                .filter(t -> t.getTipoTransaccion().equals(TipoTransaccion.GASTO))
                .collect(Collectors.summarizingDouble(Transaccion::getImporte))
                .getSum();
    }
    public List<Cuenta> getCuentasPorSaldo(){
        return cuentas.stream()
                .sorted(Comparator.comparing(Cuenta::getSaldo))
                .toList();
    }
    public Map<UUID, Long> getNumTransaccionesPorCuenta() {
        Map<UUID, Long> numTransacciones = cuentas.stream()
                .collect(Collectors.groupingBy(Cuenta::getId, counting()));
        numTransacciones.forEach((uuid, Trans) -> System.out.println(" Id -> " + uuid + " Transacciones: " + Trans));
        return numTransacciones;
    }
    public List<Cuenta> getCuentasActivas(){
        Month mesActual = LocalDate.now().getMonth();
        return cuentas.stream()
                .filter(c ->
                        c.getTransacciones().stream()
                                .anyMatch(t -> t.getFecha().getMonth().equals(mesActual))
                ).collect(Collectors.toList());
    }

    public Map<UUID, Set<Transaccion>> getTransaccionesPorDescripcion(String palabra){
        return cuentas.stream()
                .flatMap(c -> c.getTransacciones().stream())
                .filter(t -> t.getDescripcion().contains(palabra))
                .collect(Collectors.groupingBy(t -> t.getCuenta().getId(), Collectors.toSet()));
    }
    public void showAnalisisMensual() {
        // 1. Agrupamos todas las transacciones por Month en un TreeMap para orden de enero a diciembre
        Map<Month, List<Transaccion>> transPorMes = cuentas.stream()
                .flatMap(c -> c.getTransacciones().stream())
                .collect(Collectors.groupingBy(
                        t -> t.getFecha().getMonth(),
                        TreeMap::new,
                        Collectors.toList()
                ));

        // 2. Recorremos cada mes y calculamos totales de ingresos y gastos
        Locale esp = new Locale("es", "ES");
        transPorMes.forEach((mes, lista) -> {
            double ingresos = lista.stream()
                    .filter(t -> t.getTipoTransaccion() == TipoTransaccion.INGRESO)
                    .mapToDouble(Transaccion::getImporte)
                    .sum();
            double gastos = lista.stream()
                    .filter(t -> t.getTipoTransaccion() == TipoTransaccion.GASTO)
                    .mapToDouble(Transaccion::getImporte)
                    .sum();

            String nombreMes = mes.getDisplayName(TextStyle.FULL, esp);  // “enero”, “febrero”, …

            System.out.printf(
                    "%s – ingresos: %.2f€; gastos: %.2f€%n",
                    nombreMes, ingresos, gastos
            );
        });
    }


}