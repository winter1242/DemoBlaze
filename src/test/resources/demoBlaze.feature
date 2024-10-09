Feature: Navigation

  Background:
    Given Estoy en la pagina www.demoblaze.com

  Scenario: Usuario puede realizar el inicio de Sesion
    When  Realizo clic en el log in
    And Ingreso el correo correoPruebaE@corre.com
    And Ingresa la contrasena contra123
    And Realiza clic en el boton LogIn
    Then Se mostrara el mensaje de bienvenida correoPruebaE@corre.com

  Scenario: El usuario puede agregar productos al carro
    When Selecciono la categoia Phone
    And Selecciono el producto en la lista
