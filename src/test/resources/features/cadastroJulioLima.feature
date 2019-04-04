# language: pt
Funcionalidade: Cadastro no site Julio de Lima

  @CadastrarUsuario
  Cenário: Autenticar usuário no site Julio de Lima
    Dado que acessei o site
    E cliquei no botao quero me cadastrar
    Quando digitei os dados
      | Name           | Login     | Password |
      | Tiago Ferreira | tiagovbsa |   123456 |
    Então acessarei a tela inicial e validarei meu usuario
