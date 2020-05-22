package Test;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

public class Name1 extends Settings { //объвление класса Name1, который наследуется от Settings

    @Test //аннотация джиюнита "тест" (то, что происходит в тесте)
    public void testOne_applicationLaunch() { //объявление метода testOne_applicationLaunch

        applicationLaunch ();
        //вызов метода applicationLaunch для открытия страницы http://91.217.196.36:5000/
        String title = driver.getTitle(); //в переменную title попадает значение тайтла с http://91.217.196.36:5000/
        Assert.assertTrue(title.equals("todo-list"));
        //сравнение переменной title с определенным текстом, который точно должен быть в тайтле тестируемого сайта
        //для того, чтобы понимать, что пользователь видит именно тот интерфейс, который должен видеть
    };

    @Test
    public void  testTwo_addingEntity () { //объявление метода testTwo_addingEntity

        int j = 1;
        //инициализация переменной, присвоение значения = 1
        int i = 1;
        //инициализация переменной, присвоение значения = 1
        applicationLaunch ();
        //вызов метода applicationLaunch для открытия страницы http://91.217.196.36:5000/
        addingEntity (j);
        //вызов метода addingEntity для создание сущности

        while (i<=j) {
            //создаем цикл, который будет выполняться до тех пор, пока не обработаются все созданные сущности
            WebElement titleTodo = driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/div/div[2]/div[2]/table/tbody/tr[" + i + "]/td[2]"));
            //объявляем пермененную titleTodo, присваиваем ей значение элемента, к которому ведет путь
            String todoTitleValue = titleTodo.getText();
            //объявляем переменную todoValue, присваиваем ей значение titleTodo, из которого получаем текст
            WebElement priorityTodo = driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/div/div[2]/div[2]/table/tbody/tr[" + i + "]/td[3]"));
            //объявляем пермененную priorityTodo, присваиваем ей значение элемента, к которому ведет путь
            String todoPriorityValue = priorityTodo.getText();
            //объявляем переменную todoPriorityValue, присваиваем ей значение priorityTodo, из которого получаем текст

            if (todoTitleValue.equals(fakerText) && todoPriorityValue.equals(selectValue)) {
                //задаем условие: если переменная todoTitleValue равна переменной fakerText И
                //переменная todoPriorityValue равна переменной selectValue
                //то выполнится тело условия (оно пустое => тест просто продолжится)
            } else {
                throw new AssertionError();
                //если условие не выполнится, то тест упадет
            }
            i++;
            //в конце каждой итерации цикла i увеличивается на 1
        }
    }

    @Test
    public void testThree_entityСhange () { //объявление метода testThree_entityСhange

        int j = 1;
        //инициализация переменной, присвоение значения = 1
        int i = 1;
        //инициализация переменной, присвоение значения = 1

        applicationLaunch ();
        //вызов метода applicationLaunch для открытия страницы http://91.217.196.36:5000/
        addingEntity (j);
        //вызов метода addingEntity для создание сущности

        while (i<=j) {
            //создаем цикл, который будет выполняться до тех пор, пока не обработаются все созданные сущности
         WebElement entityСhangeButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/div/div[2]/div[2]/table/tbody/tr["+ i +"]/td[4]/button/span/i"));
        //объявляем переменную entityСhangeButton, ей присвоится значение класса по пути
        entityСhangeButton.click();
        //клик на элемент

        WebElement isСlearfix = driver.findElement(By.className("is-clearfix"));
        //объявляем переменную isСlearfix, ей присвоится значение класса is-clearfix
        String fakerTextChange = faker.job().keySkills();
        //инициализируем переменную, в которой будет генерироваться рандомная строка текста

        isСlearfix.findElement(By.className("input")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        //выделяем и удаляем текст в инпуте
        isСlearfix.findElement(By.className("input")).sendKeys(fakerTextChange);
        //вписываем в инпут (класс input), который находится в is-clearfix, fakerText
        //сделанно именно так, чтобы вписало именно в нужный мне инпут (именно в тот, которая в классе is-clearfix)
        String selectValueСhange = "secondary";
        //объявляем пермененную selectValue, присваиваем ей значение "secondary"


        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/section/div[2]/div/span/select/option[1]")).click();
        //кликаем на элемент по пути (на secondary)

        WebElement modalCardFoot = driver.findElement(By.className("modal-card-foot"));
        //объявляем переменную modalCardFoot, ей присвоено значение класса modal-card-foot
        modalCardFoot.findElement(By.className("is-primary")).click();
        //кликаем по элементу (класс is-primary), который находив в modalCardFoot


        WebElement titleTodo = driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/div/div[2]/div[2]/table/tbody/tr[" + i + "]/td[2]"));
        //объявляем пермененную titleTodo, присваиваем ей значение элемента, к которому ведет путь
        String todoTitleValue = titleTodo.getText();
        //объявляем переменную todoValue, присваиваем ей значение titleTodo, из которого получаем текст
        WebElement priorityTodo = driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/div/div[2]/div[2]/table/tbody/tr[" + i + "]/td[3]"));
        //объявляем пермененную priorityTodo, присваиваем ей значение элемента, к которому ведет путь
        String todoPriorityValue = priorityTodo.getText();
        //объявляем переменную todoPriorityValue, присваиваем ей значение priorityTodo, из которого получаем текст

        if (todoTitleValue.equals(fakerTextChange) && todoPriorityValue.equals(selectValueСhange)) {
            //задаем условие: если переменная todoTitleValue равна переменной fakerText И
            //переменная todoPriorityValue равна переменной selectValue
            //то выполнится тело условия (оно пустое => тест просто продолжится)
        } else {
            throw new AssertionError();
            //если условие не выполнится, то тест упадет
        }

        i++;
            //в конце каждой итерации цикла i увеличивается на 1
        }
    }

    @Test
    public void testFour_entityDeletion () { //объявление метода testFour_entityDeletion

        int j = 1;
        //инициализация переменной, присвоение значения = 1
        int i = 1;
        //инициализация переменной, присвоение значения = 1
        int k = j;
        //инициализация переменной, присвоение значения = j

        applicationLaunch ();
        //вызов метода applicationLaunch для открытия страницы http://91.217.196.36:5000/
        addingEntity (j);
        //вызов метода testTwo_addingEntity для создание сущности

        while (i<=j) {
            WebElement entityDeletionButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/div/div[2]/div[2]/table/tbody/tr[1]/td[5]/button/span/i"));
            //объявляем переменную entityDeletionButton, ей присвоится значение класса по пути
            entityDeletionButton.click();
            //клик на элемент
            WebElement deleteTodoButton = driver.findElement(By.className("is-danger"));
            //объявляем переменную deleteTodoButton, ей присвоится значение класса is-danger
            deleteTodoButton.click();
            //клик на элемент

            String itemExists = "";
            //инициализация переменной itemExists

            try {
                driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/div/div[2]/div[2]/table/tbody/tr[" + k + "]/td[2]"));
                //поиск элемента по пути (ищется вторая колонка таблицы)
                //если данный поиск выдает исключение (элемент не нашелся)
            } catch (NoSuchElementException e) {
                itemExists = null;
                //то переменной itemExists присваивается значение null
            }

            Assert.assertNull(itemExists);
            //проверка на null. если null (т.е. элемента нет) - тест проходит
            //если не null - тест падает
            //вообще, все вот это лютый костыль и по сути, жизнь иметь не должен
            //так сделано, так как сам функционал  сайта работает некорректно - таблица не удаляется из дома при удалении последней сущности
            //по правильному было бы проверять наличие таблицы, а не колонки
        i++;
        //в конце каждой итерации цикла i увеличивается на 1
        k--;
        //в конце каждой итерации цикла k уменьшается на 1
        }
    }

    @Test
    public void testFive_massRemovalOfEntities () { //объявление метода testFive_massRemovalOfEntities

        int j = 5;
        //инициализация переменной, присвоение значения = 1
        int i = 1;
        //инициализация переменной, присвоение значения = 1
        int k = j;
        //инициализация переменной, присвоение значения = j


        applicationLaunch ();
        //вызов метода applicationLaunch для открытия страницы http://91.217.196.36:5000/
        addingEntity (j);
        //вызов метода testTwo_addingEntity для создание сущности

        WebElement deleteAllButton = driver.findElement(By.className("is-warning"));
        //объявляем переменную deleteAllButton, ей присвоится значение класса is-warning
        deleteAllButton.click();
        //кликаем на элемент

        WebElement deleteTodoButton = driver.findElement(By.className("is-danger"));
        //объявляем переменную deleteTodoButton, ей присвоится значение класса is-danger
        deleteTodoButton.click();
        //клик на элемент

        while (i<=j) {

        String itemExists = "";
        //инициализация переменной itemExists

        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/div/div[2]/div[2]/table/tbody/tr[" + k + "]/td[2]"));
            //поиск элемента по пути (ищется вторая колонка таблицы)
            //если данный поиск выдает исключение (элемент не нашелся)
        } catch (NoSuchElementException e) {
            itemExists = null;
            //то переменной itemExists присваивается значение null
        }

        Assert.assertNull(itemExists);
        //проверка на null. если null (т.е. элемента нет) - тест проходит
        //если не null - тест падает
        //вообще, все вот это лютый костыль и по сути, жизнь иметь не должен
        //так сделано, так как сам функционал  сайта работает некорректно - таблица не удаляется из дома при удалении последней сущности
        //по правильному было бы проверять наличие таблицы, а не колонки
            i++;
            //в конце каждой итерации цикла i увеличивается на 1
            k--;
            //в конце каждой итерации цикла k уменьшается на 1
}


    }
}
