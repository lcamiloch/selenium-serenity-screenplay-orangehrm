Feature: Autenticación en OrangeHRM

  @LoginSuccess
  Scenario: Inicio de sesión con diferentes credenciales
    Given el usuario abre la página de inicio de sesión de OrangeHRM
    When él ingresa las credenciales validas
    Then él debería ver el panel principal de la pagina