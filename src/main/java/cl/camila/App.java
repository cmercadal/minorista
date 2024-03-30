package cl.camila;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main( String[] args )
    {
        // Donde està el driver (tiene que ir antes de instanciar para meterlo a carpeta resources)
        System.setProperty("webdriver.chrome.driver", "/Users/camila/Desktop/M5__Spring/ApiRest1/src/main/resources/static/chromedriver");

        //Crea objeto driver
        WebDriver driver = new ChromeDriver();

        //Implicit wait, espera por default,
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //Obtiene una url, navega al sitio
        driver.get("http://silogismo.com/bolettta/");

        //SELECTORES
        long start = System.currentTimeMillis();
        //Por ID -> recomendada, mas rápida
        String texto = driver.findElement(By.id("valor")).getText();
        System.out.println("Seleccionando valor");
        long stop = System.currentTimeMillis();
        System.out.println(stop-start);

        //Selección por XPath ->
        //texto = driver.findElement(By.xpath("/html/body/div[2]/div[1]/a")).getText();
        //Selector CSS -> Para cualquier elemento
        //texto = driver.findElement(By.cssSelector("#js-link-box-es"));

        //Insertar - buscar id de barra de busqueda
        //buscar texto
        WebElement searchbox = driver.findElement(By.id("valor"));
        String monto = "100200";
        searchbox.sendKeys(monto);


        //validar si funciona



        //Descomenta esto para cerrar el driver apenas concluyan las pruebas
        driver.quit();

    }
}
