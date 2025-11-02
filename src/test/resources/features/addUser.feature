Feature: Creacion de un nuevo usuario

  Background:
    Given el administrador se encuentra en la pagina inicial de la empresa

  @AddNewUser
  Scenario Outline: Creacion y verificacion de usuario de forma exitosa
    When el administrador crea un nuevo usuario con los datos "<firsName>" y "<LastName>"
    Then el deberia ver una mensaje de creacion exitosa

    Examples:
      | firsName | LastName |
      | Jhon053  | Due053   |
