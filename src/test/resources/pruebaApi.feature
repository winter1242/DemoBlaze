@API
Feature: Pruebas de API


  Scenario: Prueba Get del endpoint
    Given Envio un GET al endpoint
    Then Obtengo un codigo de status 200
    And Obtengo el nombre Janet y el apellido Weaver
    And Obtengo la imagen


  Scenario: Prueba Post del endpoint
    Given Envio el post al endpoint con el nombre jean y trabajo qa
    Then Obtengo un codigo de status 201
    And  Obtengo el nombre y trabajo

  Scenario: Pruebas Put del endpoint
    Given Envio el put al endpoint con el nombre juan y trabajo automation
    Then Obtengo un codigo de status 200

  Scenario: Pruebas Delete del endpoint
    Given Envio el delete del endpoint
    Then Obtengo un codigo de status 204
