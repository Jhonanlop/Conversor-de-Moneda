import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        ConsultarMoneda consultar = new ConsultarMoneda();
        Historial historial = new Historial();
        int opcion = 0;

        String menu = """
                Menú Principal
                *********************************************
                [1] Consultar tasa de cambio de una moneda.
                [2] Convertir moneda.
                [3] Ver historial de conversiones.
                [9] Salir.
                *********************************************
                Seleccione una opción:""";

        Scanner lectura = new Scanner(System.in);
        while (opcion != 9){
            System.out.println(menu);
            opcion = lectura.nextInt();
            lectura.nextLine();

            switch (opcion) {
                case 1 -> consultar.consultarMoneda(lectura);
                case 2 -> submenuConversion(consultar, historial, lectura);
                case 3 -> historial.mostrarHistorial();
                case 9 -> System.out.println("Saliendo del programa......");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }

        }
    }

    public static void submenuConversion(ConsultarMoneda consultar, Historial historial, Scanner lectura) {
        int opcionSubmenu = 0;

        String submenu = """
                Submenú Conversion
                *********************************************
                [1] Dólar a Peso Argentino.
                [2] Peso Argentino a Dólar.
                [3] Dólar a Real Brasileño.
                [4] Real Brasileño a Dólar.
                [5] Peso Colombiano a Dólar.
                [6] Dólar a Peso Colombiano.
                [7] Convertir otra moneda.
                [8] Volver al menú principal.
                *********************************************
                Seleccione una opción: """;

        while (opcionSubmenu!= 8) {
            System.out.println(submenu);
            opcionSubmenu = lectura.nextInt();
            lectura.nextLine();

            switch (opcionSubmenu) {
                case 1 -> consultar.convertir("USD", "ARS", historial, lectura);
                case 2 -> consultar.convertir("ARS", "USD", historial, lectura);
                case 3 -> consultar.convertir("USD", "BRL", historial, lectura);
                case 4 -> consultar.convertir("BRL", "USD", historial, lectura);
                case 5 -> consultar.convertir("USD", "COP", historial, lectura);
                case 6 -> consultar.convertir("COP", "USD", historial, lectura);
                case 7 -> consultar.convertirOtraMoneda(historial, lectura);
                case 8 -> System.out.println("Saliendo del submenú....");
                default -> System.out.println("Opción invalida. Intente nuevamente.");
            }
        }
    }
}