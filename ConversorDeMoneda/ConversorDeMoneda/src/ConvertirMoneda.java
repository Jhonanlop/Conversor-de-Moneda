import java.util.Scanner;

public class ConvertirMoneda {

    public static void convertir(String monedaBase, String monedaObjetivo, ConsultarMoneda consultar, Historial historial, Scanner lectura) throws  Exception {
        double cantidad;
        double cantidadConvertida;

        System.out.println("Ingrese la cantidad de " + monedaBase);

        cantidad = Double.parseDouble(lectura.nextLine());

        Monedas monedas = consultar.consultar(monedaBase, monedaObjetivo);

        cantidadConvertida = cantidad * monedas.tasaDeConversion();

        System.out.println(cantidad + " " + monedaBase + " son " + cantidadConvertida + " " + monedaObjetivo);
        System.out.println("****************************************************");

        historial.agregarHistorial(monedaBase, monedaObjetivo, cantidadConvertida, cantidad);
    }


    public static void convertirOtraMoneda(ConsultarMoneda consultar, Historial historial, Scanner lectura) throws Exception {
        System.out.println("Ingresar el código de la moneda base: ");
        String monedaBase = lectura.nextLine().toUpperCase();
        System.out.println("Ingresar el código de la moneda objetivo: ");
        String monedaObjetivo = lectura.nextLine().toUpperCase();

        convertir(monedaBase, monedaObjetivo, consultar, historial, lectura);
    }
}
