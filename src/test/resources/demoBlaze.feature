Feature: Navigation

  Scenario: Usuario puede realizar el inicio de Sesion
    Given Estoy en la pagina www.demoblaze.com
    When  Realizo clic en el log in
    And Ingreso el correo correoPruebaE@corre.com
    And Ingresa la contrasena contra123
    And Realiza clic en el boton LogIn
    Then Se mostrara el mensaje de bienvenida correoPruebaE@corre.com

  Scenario Outline: El usuario puede agregar productos al carro
    Given Estoy en la pagina www.demoblaze.com
    When Selecciono el <producto> en la lista
    Examples:
      | producto          |
      | Samsung galaxy s6 |
