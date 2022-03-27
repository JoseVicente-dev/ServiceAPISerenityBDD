# Plan de pruebas Screenplay REST API

# Alcance

Se probarán servicios de la pagina [https://reqres.in/](https://reqres.in/)

- GET SINGLE USER
- GET SINGLE USER NOT FOUND
- PUT CREATE

**Fuera del alcance:** No se probarán otros servicios de la API

# Estrategia de pruebas

Las pruebas se realizarán automatizadas usando el patrón Screenplay con SerenityBDD.

Se emplearán 1 escenario para el primer servicio GET, 1 escenario para el segundo servicio GET y 2 escenarios para el servicio PUT:

**Escenarios de prueba:**

```
GET SINGLE USER
Feature: consultar usuario
  Como administrador
  Quiero consultar un usuario
  Para validar su existencia en la base de datos

  Scenario: consultar un usuario
    Given que estoy en el servicio
    When y realizo una peticion
    Then obtendre un status 200 y una respuesta no nula

GET SINGLE USER NOT FOUND
Feature: consultar usuario
  Como administrador
  Quiero consultar un usuario
  Para validar su existencia en la base de datos

  Scenario: usuario no existente
    Given que estoy en el servicio apropiado
    When y realizo una peticion a una url incorrecta
    Then obtendre un status 400

POST CREATE
Feature: Creacion de usuarios
  As administrador del sistema
  I want to crear perfiles para los usuarios registrados
  So that poder otorgarles permisos y funciones dentro del aplicativo

  Scenario: Crear usuario
    Given que como administrador cree el usuario con nombre "morpheus" y cargo "leader"
    When envie la orden a la base de datos
    Then se creara un nuevo usuario con sus datos y un id

 Scenario: Intentar crear usuario con diferente content-type
    Given que como administrador intente crear el usuario con nombre "morpheus" y cargo "leader"
    When envie la orden a la base de datos, pero con un content-type texto
    Then se creara un nuevo registro que solo contiene el campo id
```

**Estrategia de datos:** los datos se enviarán desde los features dado que los servicios no tienen restricción para su reutilización en las pruebas.

# REQUERIMIENTOS

Acceso a la rest api de prueba. Acceso a ambiente de desarrollo