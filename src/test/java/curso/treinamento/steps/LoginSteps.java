package curso.treinamento.steps;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class LoginSteps {

	@Dado("^que eu esteja na tela de login$")
	public void queEuEstejaNaTelaDeLogin() throws InterruptedException {
		
		//Setando o local onde está o driver do Google Chrome 
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		
		// Criando um objeto do Navegador
		WebDriver driver = new ChromeDriver();
		
		// Passando a URL que desejamos abrir 
		driver.get("http://newtours.demoaut.com/");
		
		// Preenchendo o elemendo de User
		driver.manage().window().maximize();	
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		Thread.sleep(10000);	
		JOptionPane.showMessageDialog(null, "Seu tempo acabou", "Sessão Expirada, Clique em OK para encerrar a página", 0);
		driver.quit();
		
	//	WebDriverWait wait = new WebDriverWait(driver, 20);
		
		
			
		
		
	}

	@Quando("^faço login com o usuário \"([^\"]*)\" e senha \"([^\"]*)\" ​$")
	public void façoLoginComOUsuárioESenha​(String arg1, String arg2) {
	}

	@Então("^sou autenticado com sucesso$")
	public void souAutenticadoComSucesso() {
	}

}
