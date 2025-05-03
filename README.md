# Conversor-de-monedas  💱
📌 Descripción
El Conversor de Monedas es una aplicación desarrollada en Java que permite realizar conversiones entre distintas monedas utilizando la API de ExchangeRate-API. El programa ofrece un menú interactivo desde la consola, que guía al usuario a seleccionar las monedas de origen y destino, y el monto a convertir. Las tasas de cambio se obtienen en tiempo real, asegurando que las conversiones sean precisas y actualizadas.

Este proyecto está diseñado como una solución backend que puede integrarse con sistemas frontend o utilizarse como una aplicación autónoma para conversiones rápidas.

🛠️ Tecnologías utilizadas
Java (versión 11 o superior)
HttpClient para realizar solicitudes HTTP a la API externa
Google Gson para analizar y manejar datos en formato JSON
Manejo de archivos Properties para almacenar y configurar la clave API
Scanner para la interacción con el usuario desde la consola

🚀 Instalación y ejecución
1️⃣ Clona el repositorio
bash
git clone https://github.com/Cary40/Conversor-de-monedas.git
cd Conversor-de-monedas

2️⃣ Configura tu clave de la API
Regístrate en ExchangeRate-API para obtener una clave de API gratuita.
Ubica el archivo config.properties en la raíz del proyecto (o crea uno si no existe).
Agrega tu clave de API y la URL base en el archivo con el siguiente formato:
properties
API_KEY=aqui_va_tu_clave_api
[API_URL=https://www.exchangerate-api.com/]

🖥️ Uso
Al iniciar el programa, se mostrará un menú interactivo en la consola.
Selecciona la moneda de origen y la moneda de destino de la lista proporcionada.
Ingresa el monto que deseas convertir.
El programa realizará una solicitud a la API externa para obtener la tasa de cambio actual y mostrará el resultado de la conversión.

📂 Estructura del proyecto

```
├── ConversorMonedas/
│   ├── Menu.java        # Clase principal que maneja el flujo del programa
│   ├── Conversor.java   # Lógica principal para realizar conversiones
│   ├── Moneda.java      # Representación de una divisa
│   └── ApiClient.java   # Cliente para interactuar con la API externa
├── config.properties    # Archivo de configuración para la clave y URL de la API
└── README.md            # Documentación del proyecto
```

🧩 Funcionalidades
Interfaz interactiva: Menú basado en consola para una experiencia fácil de usar.
Conversión en tiempo real: Obtención de tasas de cambio actualizadas mediante una API externa.
Soporte para múltiples monedas: Incluye las divisas más utilizadas a nivel global.
Código modular: Fácil de extender y mantener.


