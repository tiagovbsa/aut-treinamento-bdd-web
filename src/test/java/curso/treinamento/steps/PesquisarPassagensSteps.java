package curso.treinamento.steps;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PesquisarPassagensSteps {

	WebDriver driver;

	@Dado("^que esteja na tela de pesquisa$")
	public void queEstejaNaTelaDePesquisa() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.pontosmultiplus.com.br/home");
		driver.manage().window().maximize();	
		driver.findElement(By.linkText("Passagens aéreas")).click();
		
		Thread.sleep(10000);	
		
	//	Assert.assertTrue("Página 'Quer receber promoções da Multiplus?' não apresentada com sucesso.",
	//			driver.findElement(By.xpath("//*[@id=\"new-search\"]/div[9]/div/div[1]/div/div[2]/span")).isDisplayed());

		boolean validatePage;
		validatePage = driver.findElement(By.xpath("//*[@id=\"new-search\"]/div[9]/div/div[1]/div/div[2]/span")).isDisplayed();
		
		if (validatePage ==true) {
			driver.findElement(By.xpath("//*[@id=\"new-search\"]/div[9]/div/div[1]/div/div[3]/div/button[1]")).click();			
		}
		
	}

	@Quando("^faço o preenchimento das informações da passagem$")
	public void façoOPreenchimentoDasInformaçõesDaPassagem(DataTable dadosDataTable) throws Throwable {
		for (Map<String, String> titulosDataTable : dadosDataTable.asMaps(String.class, String.class)) {
			String origem = titulosDataTable.get("De");
			String destino = titulosDataTable.get("Para");
			String dataPartida = titulosDataTable.get("Data da Partida");
			String dataDestino = titulosDataTable.get("Data de Retorno");

			Thread.sleep(5000);
			driver.findElement(By.id("pts-origin")).sendKeys(origem);
		//	Thread.sleep(5000);
			driver.findElement(By.id("pts-destination")).sendKeys(destino);
		//	Thread.sleep(5000);
			driver.findElement(By.id("pts-departure")).sendKeys(dataPartida);
		//	Thread.sleep(5000);
			driver.findElement(By.id("pts-arrival")).sendKeys(dataDestino);

		}

	}

	@Então("^realizo a busca$")
	public void realizoABusca() throws Throwable {
		
		Thread.sleep(10000);
		driver.findElement(By.id("pts-action-button")).click();

	}

	@Então("^valido o resultado$")
	public void validoOResultado() throws Throwable {
		String pontos, flightSumary;
		
	flightSumary = driver.findElement(By.xpath("//*[@id=\"LA8092\"]/div/div")).getText();
	pontos = driver.findElement(By.xpath("//*[@id=\"LA8092\"]/button/div")).getText();
	
	System.out.println("Dados do Voo: " +flightSumary + "Quantidade de Pontos: " +pontos);

	}

}
