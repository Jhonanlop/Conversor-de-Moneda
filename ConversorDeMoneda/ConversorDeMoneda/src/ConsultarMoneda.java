import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultarMoneda {

    public void consultarMoneda(Scanner lectura) {
        System.out.println("Ingrese el código de la moneda base (ej:USD): ");
        String monedaBase = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese el código de la moneda objetivo (ej:USD): ");
        String monedaObjetivo = lectura.nextLine().toUpperCase();

        try {
            Monedas resultado = consultar(monedaBase, monedaObjetivo);
            if (resultado == null || resultado.tasaDeConversion() == 0) {
                System.out.println("No se pudo obtener la tasa de conversion. Verifica las monedas ingresadas.");
            } else {
                System.out.println("La tasa de conversión para 1 " + monedaBase + " es " + resultado.tasaDeConversion() + " " + monedaObjetivo);
                System.out.println("********************************");
            }
        } catch (Exception e) {
            System.out.println("Error al consultar la tasa de conversión: " + e.getMessage());
        }
    }

    public Monedas consultar(String monedaBase, String monedaObjetivo) throws Exception {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/bd1a07fd41c2fad410c2f196/pair/" + monedaBase + "/" + monedaObjetivo);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();

        if (responseBody.startsWith("{")) {
            try {
                return new Gson().fromJson(responseBody, Monedas.class);
            } catch (JsonSyntaxException e) {
                System.out.println("Error al analizar JSON: " + e.getMessage());
                return null;
            }
        } else {
            System.out.println("Respuesta inesperada de la API: " + responseBody);
            return null;
        }
    }

    public void convertir(String monedaBase, String monedaObjetivo, Historial historial, Scanner lectura) {
        System.out.println("Ingrese la cantidad de " + monedaBase);
        double cantidad = lectura.nextDouble();
        lectura.nextLine();

        try {
            Monedas monedas = consultar(monedaBase, monedaObjetivo);
            double cantidadConvertida = cantidad * monedas.tasaDeConversion();
            System.out.println(cantidad + " " + monedaBase + " son " + cantidadConvertida + " " + monedaObjetivo);
            System.out.println("***************************************");

            historial.agregarHistorial(monedaBase, monedaObjetivo, cantidad, cantidadConvertida);
        } catch (Exception e) {
            System.out.println("Error al convertir la moneda : " + e.getMessage());
        }
    }


    public void convertirOtraMoneda(Historial historial, Scanner lectura) {
        System.out.println("Ingresar el código de la moneda base: ");
        String monedaBase = lectura.nextLine().toUpperCase();
        System.out.println("Ingresar el código de la moneda objetivo: ");
        String monedaObjetivo = lectura.nextLine().toUpperCase();

        convertir(monedaBase, monedaObjetivo, historial, lectura);
    }
}
