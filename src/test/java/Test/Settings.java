package Test;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

public class Settings { //объявление класса Settings
    public ChromeDriver driver; //объявление глобальной переменной driver
    public  WebDriverWait wait; //объявление глобальной переменной wait
    public Faker faker = new Faker();
    //инициализация класса
    public String fakerText = faker.job().keySkills();
    //инициализируем переменную, в которой будет генерироваться рандомная строка текста
    public String selectValue = "meh";
    //объявляем пермененную selectValue, присваиваем ей значение "meh"

    public void applicationLaunch () {

        driver.get("http://91.217.196.36:5000/"); //открытие страницы приложения с помощью команды get
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("level")));
        //веб-драйвер будет ждать элемент level 10 секунд. сразу после загрузки тест продолжится (даже, если раньше 10 сек)
    }

    public void  addingEntity (int i) { //объявление метода addingEntity, который принимает на вход int i

        while (i>0) {

            WebElement level = driver.findElement(By.className("level"));
            //объявляем переменную level, ей присвоится значение класса level
            level.findElement(By.className("is-primary")).click();
            //кликаем по элементу z(класс is-primary) , который находится в level
            //сделанно именно так, чтобы кликнуло именно по нужной мне кнопке (именно по той, которая в классе level)

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-card-body")));
            //веб-драйвер будет ждать элемент modal-card-body 10 секу
            WebElement isСlearfix = driver.findElement(By.className("is-clearfix"));
            //объявляем переменную isСlearfix, ей присвоится значение класса is-clearfix

            isСlearfix.findElement(By.className("input")).sendKeys(fakerText);
            //вписываем в инпут (класс input), который находится в is-clearfix, fakerText
            //сделанно именно так, чтобы вписало именно в нужный мне инпут (именно в тот, которая в классе is-clearfix)

            WebElement select = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/section/div[2]/div/span/select"));
            //объявляем переменную select, ей присвоено значение присвоено значение пути
            Select selectPriority = new Select(select);
            //инициализация переменной selectPriority типа select, которой присвоены значения веб-элемента
            selectPriority.selectByVisibleText(selectValue);
            //выбран вариант, значение которого = переменной selectValue

            WebElement modalCardFoot = driver.findElement(By.className("modal-card-foot"));
            //объявляем переменную modalCardFoot, ей присвоено значение класса modal-card-foot
            modalCardFoot.findElement(By.className("is-primary")).click();
            //кликаем по элементу (класс is-primary), который находив в modalCardFoot
            i--;
        }

    }

    @Before //аннотация джиюнита "бефор" (то, что происходит каждый раз перед @Test)
    public void  set () { //объявление метода set
        System.setProperty("webdriver.chrome.driver", "D://webdriver/v81/chromedriver.exe");
        //указание расположения хром-драйвера
        driver = new ChromeDriver(); //инициализация хром-драйвера
        driver.manage().window().setSize(new Dimension(1366, 768));
        //задаются параметры окна браузера 1366x768, чтобы тест проходил в определенных размерах окна
        wait = new WebDriverWait(driver, 10);
        //инициализация переменной wait (веб-драйвер вейт). веб-драйвер будет ждать 10 секунду загрузку элемента
        //если элемент загрузится раньше - тест моментально продолжится, если не загрузится за 10 сек - упадет
    }

    @After //аннотация джиюнита "эфтер" (то, что происходит каждый раз после @Test)
    public void close () { //объявление метода close
        driver.quit(); //закрытие окна браузера командой quit
    }
}
