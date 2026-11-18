# API Seguridad — prototipo de tesis ISO/IEC 27034

Proyecto Maven con **Java 21, Quarkus 3.40.1.2, REST Jackson, ArC (CDI) y SmallRye Health**. Diseñado para abrirse en IntelliJ IDEA Community sobre Linux Mint.

> **Procedencia**: este ZIP se ha construido localmente siguiendo la configuración y documentación oficial de Quarkus. **No se ha descargado directamente del generador code.quarkus.io**, porque la conexión de descarga no estuvo disponible. Es un proyecto Maven equivalente, con archivos iniciales personalizados para la tesis.

## 1. Abrir en IntelliJ IDEA Community

1. Descomprimir este ZIP, que contiene la carpeta `api-seguridad/`.
2. Abrir IntelliJ IDEA → **File → Open** → seleccionar `api-seguridad` (o el `pom.xml`).
3. Esperar la sincronización de Maven (requiere conexión a Internet la primera vez).
4. Revisar **File → Project Structure → SDK → Java 21**.

## 2. Ejecutar la API

Abrir la terminal dentro del proyecto:

```bash
mvn quarkus:dev
```

En otra terminal:

```bash
curl http://localhost:8080/api/v1/estado
curl http://localhost:8080/q/health/live
curl http://localhost:8080/q/health/ready
```

Se espera un JSON como este en `/api/v1/estado`:

```json
{"servicio":"api-seguridad","estado":"OPERATIVO","proyecto":"Prototipo ISO/IEC 27034"}
```

## 3. Ejecutar pruebas y construir el artefacto

Detener Quarkus con Ctrl+C y ejecutar:

```bash
mvn test
mvn clean package
```

## 4. Construir y ejecutar en Docker (etapa posterior)

```bash
docker build -f src/main/docker/Dockerfile.jvm -t api-seguridad:1.0 .
docker run --rm -p 8080:8080 api-seguridad:1.0
```

La imagen Docker usa una base Java 21 y un usuario sin privilegios de root. Antes de una demostración de seguridad habrá que analizar la imagen y establecer criterios de aceptación.

## 5. Ruta de implementación de la tesis

1. Confirmar API local y sus pruebas automatizadas.
2. Construir y examinar la imagen Docker.
3. Desplegar la API en el clúster kind.
4. Integrar la API con la arquitectura de Online Boutique (REST y, cuando corresponda, cliente gRPC).
5. Mapear requisitos/riesgos y controles de ISO/IEC 27034 a etapas de DevSecOps.
6. Incorporar SAST, SCA, análisis de contenedores e IaC al pipeline.
7. Demostrar caso conforme, caso bloqueado y caso corregido.
8. Registrar evidencias para el capítulo de resultados.

**Importante:** la API de ejemplo no debe exponerse a Internet como un producto seguro. Todavía no cuenta con autenticación, autorización ni los controles de seguridad de la tesis. Ninguna prueba de seguridad se considera ejecutada hasta que se realice efectivamente.

## Fuente

- Generador oficial: https://code.quarkus.io/
- Guía de inicio: https://quarkus.io/guides/getting-started
- Maven y Quarkus: https://quarkus.io/guides/maven-tooling
