# Mutant Detection App

  Esta aplicacion se encarga de analizar cadenas de ADN y verificar si el sujero es mutante o no,
  Tambien se encarga de persistirla en una base de datos y de dar estadisticas de todos los sujetos ingresados.

# Requisitos

  JDK (Java Development Kit) instalado
  Maven instalado (para construir y ejecutar el proyecto)
  H2 Console
  Postman (Recomendado)

# Configuracion

  1. Clonar el repositorio https://github.com/acappuccio55/mutants
  2. Construir proyecto maven: mvn clean install
  3. Ejecutar la aplicacion spring boot
  4. La aplicación ahora estará disponible en http://localhost:8080

# Uso del servicio 

  1. Correr la aplicacion desde MutantsApplication
  2. Desde postman correr los metodos deseados
  3. Ingresar a http://localhost:8080/h2-console/ (SELECT * FROM MUTANT mostrara todas las entradas)

# Informacion adicional

  1. Dependencias utilizadas: Spring Data JPA, Spring Boot Web, H2, Spring Boot Starter Test, JUnit Jupiter API, JUnit Jupiter Engine, Mockito Core
  2. Version de java utilizada: 17
