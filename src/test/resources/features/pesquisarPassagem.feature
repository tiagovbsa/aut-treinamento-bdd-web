# language: pt
Funcionalidade: Registro

  @GRU-SCL
  Cenário: Realizar Pesquisa de Passagens Portal Multiplus
    Dado que esteja na tela de pesquisa
    Quando faço o preenchimento das informações da passagem
      | De              | Para                              | Data da Partida | Data de Retorno |
      | São Paulo (SAO) | Santiago - A Merino Benitez (SCL) | 28/03/2019      | 31/03/2019      |
    Então realizo a busca
    E valido o resultado
