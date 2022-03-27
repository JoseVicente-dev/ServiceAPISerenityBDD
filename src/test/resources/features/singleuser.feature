Feature: consultar usuario
  Como automatizador
  Quiero validar que existe el usuario
  Para validar existencia en plataforma

  Scenario: consultar un usuario
    Given que estoy en el servicio
    When y realizo una peticion
    Then obtendre un status 200

  Scenario: usuario no existente
    Given que estoy en el servicio apropiado
    When y realizo una peticion a una url incorrecta
    Then obtendre un status bad request 404