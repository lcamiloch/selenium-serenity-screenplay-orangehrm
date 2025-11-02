Feature: busqueda de usuarios

  Background:
    Given el administrador se encuentra en la pagina inicial de la empresa

  @SearchUser
  Scenario Outline: Busqueda de usuario de forma exitosa
    When él busca al usuario en el modulo Directory con los datos "<firsName>" y "<LastName>"
    Then él debería ver el perfil del usuario en la tarjeta

    Examples:
      | firsName | LastName |
      | Jhon053  | Due053   |