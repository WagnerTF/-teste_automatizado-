package magalu;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MagazineLuiza {

	// Driver que comandarar a web
	private static WebDriver driver;

	// Ultilizando o driver do chrome
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Documents\\chrome_driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://sacola.magazineluiza.com.br/#/cliente/login/?next=https%3A//www.magazineluiza.com.br/acompanhamento/&origin=magazineluiza");
		assertTrue("Titulo da página difere do esperado",driver.getTitle().contentEquals("Sacola de compras - Magazine Luiza"));
		Thread.sleep(3000);
	}

	// Esperando 5 segundos e Feichando o navegador
	@After
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}

	// Abrindo o navegador
	@Test
	public void testaLoginMagalu() {
		// esperando 5 segundos para ação
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Instancia um novo objeto do tipo "WebElement", e passa como parâmetro
		// um elemento da tela cujo valor do atributo "name" seja igual a "usuario".

		WebElement element = driver.findElement(By.id("LoginBox-form")).findElement(By.name("login"));

		// Insere dados no elemento "usuario".
		element.sendKeys("teste@gmail.com");

		// Atribui ao objeto “element” o elemento de atributo "name" igual a "senha".
		element = driver.findElement(By.name("password"));

		// Insere dados no elemento "senha".
		element.sendKeys("teste1234");

		// Clica no botão "OK" e submete os dados para concluir o login.
		driver.findElement(By.id("LoginBox-form")).findElement(By.className("LoginBox-form-continue")).click();
		
	}
}
