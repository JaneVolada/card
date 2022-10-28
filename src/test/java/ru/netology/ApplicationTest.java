package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTest {
    private WebDriver driver;

    @BeforeAll
    static void configureWebdriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/win/chromedriver.exe");
    }

    @BeforeEach

    void createBrowser(){
        driver = new ChromeDriver();
    }

    @Test

    void shouldSubmitRequest(){
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[data-test-id = name] input")).sendKeys("Иван Петров");
        driver.findElement(By.cssSelector("[data-test-id = phone] input")).sendKeys("+79990009999");
        driver.findElement(By.cssSelector("[data-test-id = agreement]")).click();
        driver.findElement(By.className("button")).click();
        String text = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());

    }

    @AfterEach

    void tearDown(){
        driver.quit();
        driver = null;
    }


}
