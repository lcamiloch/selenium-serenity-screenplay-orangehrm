# Automatización de Pruebas UI para OrangeHRM con Screenplay Pattern

![Banner de Automatización UI](https://i.imgur.com/8a6E3s3.png)

## Descripción

Este proyecto contiene una suite de pruebas de interfaz de usuario (UI) automatizadas para la plataforma de demostración de **OrangeHRM**. El propósito principal es validar de forma continua y confiable las funcionalidades críticas de la aplicación, simulando las interacciones que un usuario real realizaría en el navegador.

La arquitectura del framework está basada en el patrón de diseño **Screenplay**, que promueve la creación de pruebas altamente legibles, mantenibles y escalables, siguiendo los principios de la ingeniería de software SOLID. Las pruebas están escritas utilizando un enfoque de **Desarrollo Guiado por Comportamiento (BDD)** con Gherkin, lo que facilita la colaboración entre desarrolladores, testers y analistas de negocio al describir el comportamiento del sistema en lenguaje natural.

---

## 🚀 Flujos Automatizados (Features)

Actualmente, la suite de pruebas de UI cubre las siguientes funcionalidades:

*   **Autenticación (`login`):**
    *   Verificación de inicio de sesión utilizando diferentes conjuntos de credenciales (demostrando un enfoque de pruebas dirigidas por datos).

*   **Creació de Empleados (`Creación de usuario nuevo`):**
    *   Creación de un nuevo empleado a través de la interfaz de usuario.

*   **Busqueda de Empleados (`Busqueda de usuario`):**
    *   Búsqueda de empleado en el módulo de Directorio.

---

## 🛠️ Tecnologías Utilizadas

Este proyecto fue construido utilizando un stack de tecnologías moderno y robusto, enfocado en la automatización de pruebas de UI en el ecosistema de Java. Las versiones se gestionan a través del `pom.xml`.

| Tecnología | Versión | Descripción | Página Oficial |
| :--- | :--- | :--- | :--- |
| **Lenguaje** | | | |
| Java | 17 | Lenguaje de programación principal para la lógica de las pruebas. | [OpenJDK](https://openjdk.java.net/) |
| **Frameworks y Patrones** | | | |
| Serenity BDD | 4.0.30 | Framework principal que integra todas las herramientas y genera reportes de "documentación viva". | [Serenity BDD](https://serenity-bdd.info/) |
| Screenplay Pattern | - | Patrón de diseño para escribir pruebas de alta calidad centrado en el actor y sus tareas. | [Serenity BDD Docs](https://serenity-bdd.github.io/the-serenity-book/latest/screenplay-pattern.html) |
| Cucumber | (incl. en Serenity) | Herramienta para BDD que permite escribir pruebas en lenguaje natural (Gherkin). | [Cucumber](https://cucumber.io/) |
| **Librerías Principales** | | | |
| Selenium WebDriver | (incl. en Serenity) | Librería fundamental para la interacción y control de navegadores web. | [Selenium](https://www.selenium.dev/) |
| JUnit | (incl. en Serenity) | Framework para la ejecución de las pruebas. | [JUnit 4](https://junit.org/junit4/) |
| **Herramientas de Build** | | | |
| Apache Maven | 3.x | Herramienta para la gestión de dependencias y la construcción del proyecto. | [Apache Maven](https://maven.apache.org/) |
| **Servicios en la Nube** | | | |
| BrowserStack | - | Plataforma en la nube para la ejecución de pruebas cross-browser en múltiples SO. | [BrowserStack](https://www.browserstack.com/) |
| GitHub Actions | - | Plataforma de CI/CD para la ejecución automatizada de los pipelines de pruebas. | [GitHub Actions](https://github.com/features/actions) |

---

## 📋 Guía de Ejecución Local

Sigue estos pasos para configurar y ejecutar el proyecto en tu máquina local.

### Prerrequisitos

1.  **JDK 17** instalado y configurado en las variables de entorno (`JAVA_HOME`).
2.  **Apache Maven** instalado y configurado en las variables de entorno (`MAVEN_HOME`).
3.  Un IDE como **IntelliJ IDEA** o Eclipse.
4.  (Opcional) Credenciales de **BrowserStack** si deseas ejecutar las pruebas en la nube.

### Pasos de Configuración

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/lcamiloch/selenium-serenity-screenplay-orangehrm.git]
    cd [orangeHrmFront]
    ```

2.  **Configurar credenciales (si aplica):**
    *   Abre el archivo `src/test/resources/serenity.conf`.
    *   En la sección `credentials`, ajusta el `username` y `password` para el usuario administrador.
    *   Si vas a ejecutar en BrowserStack, define las variables de entorno `BROWSERSTACK_USERNAME` y `BROWSERSTACK_ACCESS_KEY`.

3.  **Compilar el proyecto e instalar dependencias:**
    Ejecuta el siguiente comando en la raíz del proyecto. La primera vez puede tardar unos minutos mientras Maven descarga todas las librerías.
    ```bash
    mvn clean install
    ```

### Ejecución de las Pruebas

Puedes ejecutar las pruebas de varias maneras desde la terminal.

*   **Ejecutar todas las pruebas (usando el navegador por defecto de `serenity.conf`):**
    ```bash
    mvn clean verify
    ```

*   **Ejecutar un escenario específico usando tags:**
    Usa la propiedad `cucumber.filter.tags`.
    ```bash
    # Ejecuta solo los escenarios de creación de usuario
    # En PowerShell:
    mvn clean verify '-Dcucumber.filter.tags=@VerifyEmployeeCreation'

    # En CMD o Bash:
    mvn clean verify -Dcucumber.filter.tags="@VerifyEmployeeCreation"
    ```

*   **Ejecutar en un entorno específico (local o en la nube):**
    Usa el parámetro `-Denvironment` para activar una configuración de `serenity.conf`.
    ```bash
    # Ejecutar en Firefox local
    mvn clean verify -Denvironment=firefox

    # Ejecutar en BrowserStack (asegúrate de haber configurado tus credenciales)
    mvn clean verify -Denvironment=bs_chrome_win
    ```

### Ver el Reporte de Pruebas

Una vez finalizada la ejecución, el reporte de Serenity BDD se encontrará en la siguiente ruta. Ábrelo con cualquier navegador web.

## 👨‍💻 Creado por

**Camilo Chaparro**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Camilo_Chaparro-0077B5?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/tu-perfil/)
