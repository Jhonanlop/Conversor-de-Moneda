CONVERSOR DE MONEDA - JAVA PROJECT

Descripción
Este proyecto es un conversor de monedas desarrollado en Java que utiliza una API externa para obtener tasas de cambio en tiempo real. Los usuarios pueden consultar la tasa de cambio de una moneda específica y convertir entre diferentes monedas. Además, tiene un menú con opciones predefinidas de conversiones rápidas y un historial de las monedas convertidas durante la sesión.

Características
Consulta de tasa de cambio: Permite consultar la tasa de cambio de una moneda base a una moneda objetivo específica.
Conversión de monedas: Convierte una cantidad determinada de una moneda base a una moneda objetivo usando las tasas de cambio actuales.
Opciones predefinidas: El menú incluye opciones predefinidas para convertir monedas comunes como:
Dólar estadounidense (USD) a Peso argentino (ARS)
Peso argentino (ARS) a Dólar estadounidense (USD)
Dólar estadounidense (USD) a Real brasileño (BRL)
Real brasileño (BRL) a Dólar estadounidense (USD)
Dólar estadounidense (USD) a Peso colombiano (COP)
Peso colombiano (COP) a Dólar estadounidense (USD)
Y otras conversiones personalizadas.
Historial de conversiones: Almacena un historial de las conversiones realizadas durante la sesión.

Requisitos
Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes componentes:

Java JDK 8 o superior: Descargar e instalar JDK
Maven (opcional, si usas Maven como herramienta de construcción): Instalar Maven
Conexión a internet (para consultar la API de tasas de cambio).
Instalación y Ejecución
Clona el repositorio:
Clona este repositorio en tu máquina local usando el siguiente comando:

bash
Copiar código
git clone https://github.com/Jhonanlop/Conversor-de-Moneda.git
Configuración de la API:
Este proyecto utiliza la API ExchangeRate-API para obtener las tasas de cambio. Debes obtener una clave de API gratuita y reemplazar la clave de API en la clase ConsultarMoneda en la línea que construye la URL:

java
Copiar código
URI direccion = URI.create("https://v6.exchangerate-api.com/v6/TU_CLAVE_API/pair/" + monedaBase + "/" + monedaObjetivo);
Ejecuta el proyecto:

Si usas un IDE como IntelliJ IDEA o Eclipse, abre el proyecto y ejecuta la clase principal Principal.java directamente.

Si prefieres compilarlo desde la terminal, usa el siguiente comando en el directorio del proyecto:

bash
Copiar código
javac Principal.java
Luego, para ejecutar el programa:

bash
Copiar código
java Principal
Uso
El proyecto presenta un menú interactivo en consola:

Menú principal:
Consultar tasa de cambio: El usuario puede ingresar dos monedas (moneda base y moneda objetivo) y obtener la tasa de cambio actualizada.
Convertir moneda: Permite al usuario convertir una cantidad específica entre dos monedas, eligiendo entre opciones predefinidas o ingresando otras monedas.
Salir: Finaliza el programa.
Submenú de conversiones rápidas:
Al elegir la opción de conversión de moneda, el programa mostrará una serie de conversiones predefinidas, tales como:

Dólar a Peso argentino
Peso argentino a Dólar
Dólar a Real brasileño
Real brasileño a Dólar
Dólar a Peso colombiano
Peso colombiano a Dólar
Convertir otra moneda
Salir
El programa también incluye un historial de conversiones, que muestra todas las conversiones realizadas durante la sesión actual.

Estructura del Proyecto
El proyecto está organizado en las siguientes clases:

Principal.java: Clase principal que contiene el menú principal del programa.
ConsultarMoneda.java: Contiene los métodos que manejan la consulta de tasas de cambio utilizando la API.
ConvertirMoneda.java: Maneja las conversiones entre monedas, incluyendo el cálculo y la interacción con el usuario.
Monedas.java: Define el modelo de datos para las tasas de cambio y monedas.
Historial.java: Contiene los metodos que almacenan el historial de las conversiones.

API Utilizada
ExchangeRate-API: Esta API permite obtener la tasa de conversión entre diferentes monedas. Asegúrate de reemplazar tu clave de API en el código, como se explicó en la sección de instalación.

Posibles Mejoras
Mejor manejo de excepciones: Actualmente, el programa lanza excepciones cuando no encuentra la moneda o la API no responde correctamente. Esto podría mejorarse con mensajes de error más detallados.
Soporte para más monedas: Se podría agregar más monedas y opciones predefinidas en el menú de conversión rápida.
Persistencia del historial: El historial de conversiones se podría almacenar de manera persistente, por ejemplo, en un archivo o base de datos.

Contribuciones
Si deseas contribuir a este proyecto, por favor realiza un fork del repositorio y crea un pull request con tus mejoras o sugerencias.

Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

