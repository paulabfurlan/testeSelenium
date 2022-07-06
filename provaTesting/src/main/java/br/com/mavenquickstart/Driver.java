package br.com.mavenquickstart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

	public static void main(String[] args) {
		Boolean[] controleTestes = new Boolean[5];
		controleTestes[0] = false;
		controleTestes[1] = false;
		controleTestes[2] = false;
		controleTestes[3] = false;
		controleTestes[4] = false;
		
		//---------------------------------------------CASO DE TESTE 1----------------------------------------------------------
		boolean cond1 = false;
		boolean cond2 = false;
		System.out.println("Começando o Caso de Teste 1");
		
		// Setando o Chrome Beta como navegador deste teste
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
        // Entrando na URL do teste
        driver.get("https://chicorei.com/");

        // Aceitando os Cookies
        WebElement cookies = driver.findElement(By.id("confirmPolicyButton"));
        cookies.click();

        // Pesquisando a camisa
        WebElement pesquisa = driver.findElement(By.id("header-search-input-desktop"));
        pesquisa.sendKeys("Vira Lata Caramelo");
        pesquisa.sendKeys(Keys.ENTER);
        
        // Selecionando a primeira camisa da lista
        try { Thread.sleep (400); } catch (InterruptedException ex) {}
        WebElement camisa = driver.findElements(By.className("product-list-item-title")).get(0);
        Actions actions = new Actions(driver);
        actions.moveToElement(camisa).click().build().perform();
        
        // Procurando e validando o preço da camisa
        List<WebElement> lista = driver.findElements(By.className("flex-child-fixed"));
        for(WebElement p: lista)
        {
        	if(p.getText().equals("R$ 69,99"))
        	{
        		System.out.println("Passou no teste do preço!");
        		cond1 = true;
        	}    	
        }
    	if(!cond1)
    		System.out.println("Não passou no teste do preço!");
        
        // Selecionando o gênero da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		WebElement genero = driver.findElement(By.xpath("//nav[contains(.,'Masculina Gola Olímpica')]"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", genero); 
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[contains(.,'Masculina Gola Olímpica')]")));
		jse2.executeScript("arguments[0].click();", genero);

		// Selecionando o tamanho da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		WebElement tam = driver.findElement(By.xpath("//div[3]/nav/div"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", tam); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/nav/div")));
		jse2.executeScript("arguments[0].click();", tam);
		
		// Selecionando a cor da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		WebElement cor = driver.findElement(By.xpath("//nav/div/div"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", cor); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav/div/div")));
		jse2.executeScript("arguments[0].click();", cor);
		
		// Apertando em comprar a camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		WebElement comprar = driver.findElement(By.xpath("//button/span[2]"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", comprar); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[2]")));
		jse2.executeScript("arguments[0].click();", comprar);
		
		// Indo para o carrinho de compras
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		WebElement carrinho = driver.findElement(By.xpath("(//a[contains(@href, '/carrinho')])[4]"));
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href, '/carrinho')])[4]")));
		jse2.executeScript("arguments[0].click();", carrinho);

		// Validando a mensagem "Você está acumulando 1 ponto no cartão fidelidade!" na tela
		try { Thread.sleep (500); } catch (InterruptedException ex) {}
		if(driver.getPageSource().contains("Você está acumulando 1 ponto no cartão fidelidade!"))
		{
    		System.out.println("Passou no teste da mensagem!");
    		cond2 = true;
		}
		else
		{
			System.out.println("Não passou no teste da mensagem!");
		}
				
		// Fechando a compra
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		WebElement fechar = driver.findElement(By.xpath("//button[2]"));
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[2]")));
		jse2.executeScript("arguments[0].click();", fechar);

		driver.close();
		
		controleTestes[0] = cond1 && cond2;
		
		try { Thread.sleep (2000); } catch (InterruptedException ex) {}
		
		
		
		//---------------------------------------------CASO DE TESTE 2----------------------------------------------------------
		cond1 = false;
		cond2 = false;
		System.out.println("\n\nComeçando o Caso de Teste 2");
		
		// Setando o Chrome Beta como navegador deste teste
		options = new ChromeOptions();
		options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		
        // Entrando na URL do teste
        driver.get("https://chicorei.com/");

        // Aceitando os Cookies
        cookies = driver.findElement(By.id("confirmPolicyButton"));
        cookies.click();

        // Pesquisando a camisa
        pesquisa = driver.findElement(By.id("header-search-input-desktop"));
        pesquisa.sendKeys("Amarelo é desespero");
        pesquisa.sendKeys(Keys.ENTER);
        
        // Selecionando a primeira camisa da lista
        try { Thread.sleep (400); } catch (InterruptedException ex) {}
        camisa = driver.findElements(By.className("product-list-item-title")).get(0);
        actions = new Actions(driver);
        actions.moveToElement(camisa).click().build().perform();
        
        // Procurando e validando o preço da camisa
        lista = driver.findElements(By.className("flex-child-fixed"));
        for(WebElement p: lista)
        {
        	if(p.getText().equals("R$ 69,99"))
        	{
        		System.out.println("Passou no teste do preço!");
        		cond1 = true;
        	}    	
        }
    	if(!cond1)
    		System.out.println("Não passou no teste do preço!");
        
        // Selecionando o gênero da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		genero = driver.findElement(By.xpath("//nav[contains(.,'Feminina Gola U')]"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", genero); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[contains(.,'Feminina Gola U')]")));
		jse2.executeScript("arguments[0].click();", genero);

		// Selecionando o tamanho da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		tam = driver.findElement(By.xpath("//div[3]/nav/div[2]"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", tam); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/nav/div[2]")));
		jse2.executeScript("arguments[0].click();", tam);
		
		// Selecionando a cor da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		cor = driver.findElement(By.xpath("//nav/div/div"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", cor); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav/div/div")));
		jse2.executeScript("arguments[0].click();", cor);
        
		// Apertando em comprar a camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		comprar = driver.findElement(By.xpath("//button/span[2]"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", comprar); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[2]")));
		jse2.executeScript("arguments[0].click();", comprar);
		
		// Indo para o carrinho de compras
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		carrinho = driver.findElement(By.xpath("(//a[contains(@href, '/carrinho')])[4]"));
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href, '/carrinho')])[4]")));
		jse2.executeScript("arguments[0].click();", carrinho);

		// Validando a mensagem "Adquira o Chico Rei Prime para desfrutar de frete grátis por 1 ano em todos os pedidos, sem valor mínimo." na tela
		try { Thread.sleep (500); } catch (InterruptedException ex) {}
		if(driver.getPageSource().contains("Adquira o Chico Rei Prime para desfrutar de frete grátis por 1 ano em todos os pedidos, sem valor mínimo."))
		{
    		System.out.println("Passou no teste da mensagem!");
    		cond2 = true;
		}
		else
		{
			System.out.println("Não passou no teste da mensagem!");
		}
				
		// Fechando a compra
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		fechar = driver.findElement(By.xpath("//button[2]"));
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[2]")));
		jse2.executeScript("arguments[0].click();", fechar);

		driver.close();
		
		controleTestes[1] = cond1 && cond2;
		
		try { Thread.sleep (2000); } catch (InterruptedException ex) {}
		
		
		
		//---------------------------------------------CASO DE TESTE 3----------------------------------------------------------
		cond1 = false;
		cond2 = false;
		System.out.println("\n\nComeçando o Caso de Teste 3");
		
		// Setando o Chrome Beta como navegador deste teste
		options = new ChromeOptions();
		options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		
        // Entrando na URL do teste
        driver.get("https://chicorei.com/");
        
        // Aceitando os Cookies
        cookies = driver.findElement(By.id("confirmPolicyButton"));
        cookies.click();

        // Pesquisando a camisa
        pesquisa = driver.findElement(By.id("header-search-input-desktop"));
        pesquisa.sendKeys("Erarr");
        pesquisa.sendKeys(Keys.ENTER);
        
        // Selecionando a primeira camisa da lista
        try { Thread.sleep (400); } catch (InterruptedException ex) {}
        camisa = driver.findElements(By.className("product-list-item-title")).get(0);
        actions = new Actions(driver);
        actions.moveToElement(camisa).click().build().perform();
        
        // Procurando e validando o preço da camisa
        lista = driver.findElements(By.className("flex-child-fixed"));
        for(WebElement p: lista)
        {
        	if(p.getText().equals("R$ 69,99"))
        	{
        		System.out.println("Passou no teste do preço!");
        		cond1 = true;
        	}    	
        }
    	if(!cond1)
    		System.out.println("Não passou no teste do preço!");
        
        // Selecionando o gênero da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		genero = driver.findElement(By.xpath("//nav[contains(.,'Feminina Gola U')]"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", genero); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[contains(.,'Feminina Gola U')]")));
		jse2.executeScript("arguments[0].click();", genero);

		// Selecionando o tamanho da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		tam = driver.findElement(By.xpath("//div[3]/nav/div[2]"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", tam); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/nav/div[2]")));
		jse2.executeScript("arguments[0].click();", tam);
        
		// Selecionando a cor da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		cor = driver.findElement(By.xpath("//nav/div/div"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", cor); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav/div/div")));
		jse2.executeScript("arguments[0].click();", cor);
		
		// Apertando em comprar a camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		comprar = driver.findElement(By.xpath("//button/span[2]"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", comprar); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[2]")));
		jse2.executeScript("arguments[0].click();", comprar);
		
		// Indo para o carrinho de compras
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		carrinho = driver.findElement(By.xpath("(//a[contains(@href, '/carrinho')])[4]"));
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href, '/carrinho')])[4]")));
		jse2.executeScript("arguments[0].click();", carrinho);

		// Validando a mensagem "De segunda a sexta, das 8h às 20h." na tela
		try { Thread.sleep (500); } catch (InterruptedException ex) {}
		if(driver.getPageSource().contains("De segunda a sexta, das 8h às 20h."))
		{
    		System.out.println("Passou no teste da mensagem!");
    		cond2 = true;
		}
		else
		{
			System.out.println("Não passou no teste da mensagem!");
		}
				
		// Fechando a compra
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		fechar = driver.findElement(By.xpath("//button[2]"));
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[2]")));
		jse2.executeScript("arguments[0].click();", fechar);

		driver.close();
		
		controleTestes[2] = cond1 && cond2;
		
		try { Thread.sleep (2000); } catch (InterruptedException ex) {}
		
		
		
		//---------------------------------------------CASO DE TESTE 4----------------------------------------------------------
		cond1 = false;
		cond2 = false;
		System.out.println("\n\nComeçando o Caso de Teste 4");
		
		// Setando o Chrome Beta como navegador deste teste
		options = new ChromeOptions();
		options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		
        // Entrando na URL do teste
        driver.get("https://chicorei.com/");
        
        // Aceitando os Cookies
        cookies = driver.findElement(By.id("confirmPolicyButton"));
        cookies.click();

        // Pesquisando a camisa
        pesquisa = driver.findElement(By.id("header-search-input-desktop"));
        pesquisa.sendKeys("Nem Te Vi");
        pesquisa.sendKeys(Keys.ENTER);
        
        // Selecionando a primeira camisa da lista
        try { Thread.sleep (400); } catch (InterruptedException ex) {}
        camisa = driver.findElements(By.className("product-list-item-title")).get(0);
        actions = new Actions(driver);
        actions.moveToElement(camisa).click().build().perform();
        
        // Procurando e validando o preço da camisa
        lista = driver.findElements(By.className("flex-child-fixed"));
        for(WebElement p: lista)
        {
        	if(p.getText().equals("R$ 69,99"))
        	{
        		System.out.println("Passou no teste do preço!");
        		cond1 = true;
        	}    	
        }
    	if(!cond1)
    		System.out.println("Não passou no teste do preço!");
        
        // Selecionando o gênero da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		genero = driver.findElement(By.xpath("//nav[contains(.,'Masculina Gola Olímpica')]"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", genero); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[contains(.,'Masculina Gola Olímpica')]")));
		jse2.executeScript("arguments[0].click();", genero);

		// Selecionando o tamanho da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		tam = driver.findElement(By.xpath("//div[3]/nav/div"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", tam); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/nav/div")));
		jse2.executeScript("arguments[0].click();", tam);
		
		// Selecionando a cor da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		cor = driver.findElement(By.xpath("//nav/div[2]/div"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", cor); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav/div[2]/div")));
		jse2.executeScript("arguments[0].click();", cor);
        
		// Apertando em comprar a camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		comprar = driver.findElement(By.xpath("//button/span[2]"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", comprar); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[2]")));
		jse2.executeScript("arguments[0].click();", comprar);
		
		// Indo para o carrinho de compras
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		carrinho = driver.findElement(By.xpath("(//a[contains(@href, '/carrinho')])[4]"));
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href, '/carrinho')])[4]")));
		jse2.executeScript("arguments[0].click();", carrinho);

		// Validando a mensagem "Compre parcelado com cartão ou a vista com boleto ou depósito" na tela
		try { Thread.sleep (500); } catch (InterruptedException ex) {}
		if(driver.getPageSource().contains("Compre parcelado com cartão ou a vista com boleto ou depósito"))
		{
    		System.out.println("Passou no teste da mensagem!");
    		cond2 = true;
		}
		else
		{
			System.out.println("Não passou no teste da mensagem!");
		}
				
		// Fechando a compra
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		fechar = driver.findElement(By.xpath("//button[2]"));
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[2]")));
		jse2.executeScript("arguments[0].click();", fechar);

		driver.close();
		
		controleTestes[3] = cond1 && cond2;
		
		try { Thread.sleep (2000); } catch (InterruptedException ex) {}
		
		
		
		//---------------------------------------------CASO DE TESTE 5----------------------------------------------------------
		cond1 = false;
		cond2 = false;
		System.out.println("\n\nComeçando o Caso de Teste 5");
		
		// Setando o Chrome Beta como navegador deste teste
		options = new ChromeOptions();
		options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		
        // Entrando na URL do teste
        driver.get("https://chicorei.com/");
        
        // Aceitando os Cookies
        cookies = driver.findElement(By.id("confirmPolicyButton"));
        cookies.click();

        // Pesquisando a camisa
        pesquisa = driver.findElement(By.id("header-search-input-desktop"));
        pesquisa.sendKeys("Alceu Dispor");
        pesquisa.sendKeys(Keys.ENTER);
        
        // Selecionando a primeira camisa da lista
        try { Thread.sleep (400); } catch (InterruptedException ex) {}
        camisa = driver.findElements(By.className("product-list-item-title")).get(0);
        actions = new Actions(driver);
        actions.moveToElement(camisa).click().build().perform();
        
        // Procurando e validando o preço da camisa
        lista = driver.findElements(By.className("flex-child-fixed"));
        for(WebElement p: lista)
        {
        	if(p.getText().equals("R$ 69,99"))
        	{
        		System.out.println("Passou no teste do preço!");
        		cond1 = true;
        	}    	
        }
    	if(!cond1)
    		System.out.println("Não passou no teste do preço!");
        
        // Selecionando o gênero da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		genero = driver.findElement(By.xpath("//nav[contains(.,'Masculina Gola Olímpica')]"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", genero); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[contains(.,'Masculina Gola Olímpica')]")));
		jse2.executeScript("arguments[0].click();", genero);

		// Selecionando o tamanho da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		tam = driver.findElement(By.xpath("//div[3]/nav/div"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", tam); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/nav/div")));
		jse2.executeScript("arguments[0].click();", tam);
		
		// Selecionando a cor da camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		cor = driver.findElement(By.xpath("//nav/div/div"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", cor); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav/div/div")));
		jse2.executeScript("arguments[0].click();", cor);
        
		// Apertando em comprar a camisa
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		comprar = driver.findElement(By.xpath("//button/span[2]"));
		jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", comprar); 
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[2]")));
		jse2.executeScript("arguments[0].click();", comprar);
		
		// Indo para o carrinho de compras
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		carrinho = driver.findElement(By.xpath("(//a[contains(@href, '/carrinho')])[4]"));
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href, '/carrinho')])[4]")));
		jse2.executeScript("arguments[0].click();", carrinho);

		// Validando a mensagem "Sua primeira troca na Chico Rei é por nossa conta!" na tela
		try { Thread.sleep (500); } catch (InterruptedException ex) {}
		if(driver.getPageSource().contains("Sua primeira troca na Chico Rei é por nossa conta!"))
		{
    		System.out.println("Passou no teste da mensagem!");
    		cond2 = true;
		}
		else
		{
			System.out.println("Não passou no teste da mensagem!");
		}
				
		// Fechando a compra
		try { Thread.sleep (400); } catch (InterruptedException ex) {}
		fechar = driver.findElement(By.xpath("//button[2]"));
		wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[2]")));
		jse2.executeScript("arguments[0].click();", fechar);

		driver.close();
		
		controleTestes[4] = cond1 && cond2;
		
        

		//---------------------------------------------SITUAÇÂO DOS TESTES----------------------------------------------------------
		System.out.println("\n\nStatus do Caso de Teste 1: " + (controleTestes[0] ? "Passou" : "Falhou"));
		System.out.println("Status do Caso de Teste 2: " + (controleTestes[1] ? "Passou" : "Falhou"));
		System.out.println("Status do Caso de Teste 3: " + (controleTestes[2] ? "Passou" : "Falhou"));
		System.out.println("Status do Caso de Teste 4: " + (controleTestes[3] ? "Passou" : "Falhou"));
		System.out.println("Status do Caso de Teste 5: " + (controleTestes[4] ? "Passou" : "Falhou"));
	}

}
