package curso.treinamento.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

public class RegistroSteps {

	WebDriver driver;

	@Dado("^que eu esteja na tela de Registro$")
	public void queEuEstejaNaTelaDeRegistro() throws Throwable {

		// Setando o local onde está o driver do Google Chrome
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");

		// Criando um objeto do Navegador
		driver = new ChromeDriver();

		// Passando a URL que desejamos abrir
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.linkText("REGISTER")).click();

		Assert.assertTrue("Página 'REGISTER' não apresentada com sucesso.",
				driver.findElement(By.xpath("//img[@src='/images/masts/mast_register.gif']")).isDisplayed());

	}

	@Quando("^faço o preenchimento das informações da tela de Register$")
	public void façoOPreenchimentoDasInformaçõesDaTelaDeRegister(DataTable dadosDataTable) throws Throwable {
		/*
		 * for (Map<String, String> list : dadosDataTable.asMaps(String.class,
		 * String.class)) { String firstName = list.get("First Name"); String lastName =
		 * list.get("Last Name"); String phone = list.get("Phone"); String email =
		 * list.get("Mail"); String address = list.get("Address"); String addressCompl =
		 * list.get("Address Complement"); String city = list.get("City"); String
		 * stateProvince = list.get("State Province"); String postalCode =
		 * list.get("Postal Code"); String country = list.get("Country"); String
		 * userName = list.get("User Name"); String password = list.get("Password");
		 * String passwordConfirm = list.get("Confirm Password");
		 * 
		 * driver.findElement(By.name("firstName")).sendKeys(firstName);
		 * driver.findElement(By.name("lastName")).sendKeys(lastName);
		 * driver.findElement(By.name("phone")).sendKeys(phone);
		 * driver.findElement(By.name("userName")).sendKeys(email);
		 * driver.findElement(By.name("address1")).sendKeys(address);
		 * driver.findElement(By.name("address2")).sendKeys(addressCompl);
		 * driver.findElement(By.name("city")).sendKeys(city);
		 * driver.findElement(By.name("state")).sendKeys(stateProvince);
		 * driver.findElement(By.name("postalCode")).sendKeys(postalCode);
		 * 
		 * WebElement comboBoxCountry = driver.findElement(By.name("country")); Select
		 * comboBoxSelecao = new Select(comboBoxCountry);
		 * comboBoxSelecao.selectByVisibleText(country);
		 * comboBoxSelecao.selectByIndex(32);
		 * 
		 * driver.findElement(By.name("email")).sendKeys(userName);
		 * driver.findElement(By.name("password")).sendKeys(password);
		 * driver.findElement(By.name("confirmPassword")).sendKeys(passwordConfirm); }
		 */

		List<Map<String, String>> list = dadosDataTable.asMaps(String.class, String.class);
		driver.findElement(By.name("firstName")).sendKeys(list.get(0).get("First Name"));
		driver.findElement(By.name("lastName")).sendKeys(list.get(0).get("Last Name"));
		driver.findElement(By.name("phone")).sendKeys(list.get(0).get("Phone"));
		driver.findElement(By.name("userName")).sendKeys(list.get(0).get("Mail"));
		driver.findElement(By.name("address1")).sendKeys(list.get(0).get("Address"));
		driver.findElement(By.name("address2")).sendKeys(list.get(0).get("Address Complement"));
		driver.findElement(By.name("city")).sendKeys(list.get(0).get("City"));
		driver.findElement(By.name("state")).sendKeys(list.get(0).get("State Province"));
		driver.findElement(By.name("postalCode")).sendKeys(list.get(0).get("Postal Code"));

		WebElement comboBoxCountry = driver.findElement(By.name("country"));
		Select comboBoxSelecao = new Select(comboBoxCountry);
		comboBoxSelecao.selectByVisibleText(list.get(0).get("Country"));
	//	comboBoxSelecao.selectByIndex(32); Fazendo pelo Indice do elemento. 

		driver.findElement(By.name("email")).sendKeys(list.get(0).get("User Name"));
		driver.findElement(By.name("password")).sendKeys(list.get(0).get("Password"));
		driver.findElement(By.name("confirmPassword")).sendKeys(list.get(0).get("Confirm Password"));
		
		driver.findElement(By.name("register")).click();

	}

	@Então("^sou registrado com sucesso$")
	public void souRegistradoComSucesso() throws Throwable {
		
		Assert.assertTrue("Usuário não foi cadastrado com sucesso.",
				driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b")).isDisplayed());
		
		
		
		

	}
}
