package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroJulioLimaPage {
	
	private WebDriver paginaWeb = null; 
	
	public CadastroJulioLimaPage (WebDriver navegador) {
		this.paginaWeb = navegador;
	}
	
	public void navigateTo(String url) {
		this.paginaWeb.get(url);		
	}
	
	// clicando no botão inicial 
	public CadastroJulioLimaPage clicarNoBotaoCadastrar() {
		this.paginaWeb.findElement(By.id("signup")).click();
		return this;
	}
	
	// digitar os dados no formulario 
	public CadastroJulioLimaPage preenchendoOsDados(String nome, String login, String password) {
		this.paginaWeb.findElement(By.name("name")).sendKeys(nome);
		this.paginaWeb.findElement(By.name("login")).sendKeys(login);
		this.paginaWeb.findElement(By.name("password")).sendKeys(password);
		return this;
	}

}
