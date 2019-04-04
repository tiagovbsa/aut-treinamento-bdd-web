# language: pt
Funcionalidade: Registro

  @Sprint1
  Cenário: Realizar Registro
    Dado que eu esteja na tela de Registro
    Quando faço o preenchimento das informações da tela de Register
      | First Name | Last Name | Phone     | Mail                 | Address  | Address Complement | City        | State Province | Postal Code | Country | User Name | Password | Confirm Password |
      | Tiago      | Ferreira  | 119999444 | tiago.vbsa@gmail.com | Rua Lapa | Casa 2             | Carapicuiba | SP             |    06500000 | BRAZIL  | tiagovbsa |   123456 |           123456 |
    Então sou registrado com sucesso
