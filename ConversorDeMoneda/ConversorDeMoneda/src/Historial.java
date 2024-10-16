import java.util.ArrayList;
import java.util.List;

public class Historial {

    private final List<String> historial = new ArrayList<>();

    public void agregarHistorial(String monedaBase, String monedaObjetivo, double cantidad, double cantidadConvertida) {
        String registro = cantidad + " " + monedaBase + " = " + cantidadConvertida + " " + monedaObjetivo;
        historial.add(registro);
    }

    public void mostrarHistorial() {
        System.out.println("Historial de conversiones.");
        if (historial.isEmpty()) {
            System.out.println("No hay historial de conversiones.");
        }  else {
            historial.forEach(System.out::println);
        }
    }
}
