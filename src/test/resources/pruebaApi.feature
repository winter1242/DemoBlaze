Feature: Pruebas de API

  @API
  Scenario: Prueba Get del endpoint
    Given Envio un GET al endpoint
    Then Obtengo un codigo de status 200