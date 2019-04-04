package curso.treinamento.steps;

import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import curso.treinamento.pages.CadastroJulioLimaPage;
import curso.treinamento.support.Hooks;


public class CadastroJulioLimaSteps {
	
	private CadastroJulioLimaPage LoginJulioLimaPage = new CadastroJulioLimaPage(Hooks.getNavegador());	
		
	@Dado("^que acessei o site$")
	public void acesseiSiteJulioLima() throws Exception  {
		this.LoginJulioLimaPage.navigateTo("http://www.juliodelima.com.br/taskit/");	
		
	}

	@Dado("^cliquei no botao quero me cadastrar$")
	public void cliqueiNoBotaoCadastrar() throws Exception {
		this.LoginJulioLimaPage.clicarNoBotaoCadastrar();
	}

	@Quando("^digitei os dados$")
	public void preencheOsFormulariosComOsDados(DataTable dados) throws Exception  {
		for (Map<String, String> titulosDataTable : dados.asMaps(String.class, String.class)){
			String name = titulosDataTable.get("Name");
			String login = titulosDataTable.get("Login");
			String password = titulosDataTable.get("Password");
			this.LoginJulioLimaPage.preenchendoOsDados(name, login, password);			
		}
	   
	}

	@Então("^acessarei a tela inicial e validarei meu usuario$")
	public void acessarTelaInicialEValidarAcesso() throws Exception{
	   
	}

}
