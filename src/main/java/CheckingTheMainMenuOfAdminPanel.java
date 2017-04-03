import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Admin on 31.03.2017.
 */
public class CheckingTheMainMenuOfAdminPanel {
    public static void main(String[] args) {

        System.getProperty("driver.chrome");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get(" http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement login = chromeDriver.findElement(By.name("email"));
        WebElement password = chromeDriver.findElement(By.id("passwd"));
        WebElement entranceButton = chromeDriver.findElement(By.name("submitLogin"));
        login.sendKeys("webinar.test@gmail.com");
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        entranceButton.click();

        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-submenu = '1']/a[@class = 'title']")));

        // Первый вариант решения задачи - через использования масива и цикла

        String[] TabID = {  "//li[@data-submenu = '1']/a[@class = 'title']",
                "//li[@data-submenu = '3']/a[@class = 'title has_submenu']",
                "//li[@data-submenu = '9']/a[@class = 'title has_submenu']",
                "//li[@data-submenu = '23']/a[@class = 'link']",
                "//li[@data-submenu = '27']/a[@class = 'title has_submenu']",
                "//li[@data-submenu = '31']/a[@class = 'title ']",
                "//li[@data-submenu = '42']/a[@class = 'title has_submenu']",
                "//li[@data-submenu = '46']/a[@class = 'link']",
                "//li[@data-submenu = '52']/a[@class = 'title has_submenu']",
                "//li[@data-submenu = '55']/a[@class = 'title has_submenu']",
                "//li[@data-submenu = '58']/a[@class = 'title has_submenu']",
                "//li[@data-submenu = '73']/a[@class = 'title has_submenu']",
                "//li[@data-submenu = '95']/a[@class = 'title has_submenu']",
        };

        String[] TitleName = {  "Пульт",
                "Заказы",
                "товары",
                "Управление клиентами",
                "Customer Service",
                "Статистика",
                "Выбор модуля",
                "Шаблоны > Шаблон",
                "Перевозчики",
                "Payment Methods",
                "Локализация",
                "General",
                "Information",
        };

        for (int i = 0; i < 13; i++) {

            chromeDriver.findElement(By.xpath(TabID[i])).click();
            System.out.println(chromeDriver.findElement(By.tagName("h2")).getText());
            chromeDriver.navigate().refresh();

            if (!chromeDriver.findElement(By.tagName("h2")).getText().equals(TitleName[i])) {
                System.out.println("Ошибка, не тот раздел!!!");
            }
        }
        chromeDriver.quit();
    }
}

        //Второй вариант - писать отдельно код для проверки каждого елемента

        /*
        //dashboardTab
        WebElement dashboardTab = chromeDriver.findElement(By.xpath("//li[@data-submenu = '1']/a[@class = 'title']"));
        dashboardTab.click();
        WebElement dashboardTitle = chromeDriver.findElement(By.tagName("h2"));
        System.out.println(dashboardTitle.getText());
        chromeDriver.navigate().refresh();

        if (!chromeDriver.findElement(By.className("page-title")).getText().equals("Пульт")) {
            System.out.println("Ошибка, не тот раздел!!!");
        }
        //ordersTab
        WebElement ordersTab = chromeDriver.findElement(By.xpath("//li[@data-submenu = '3']/a[@class = 'title has_submenu']"));
        ordersTab.click();
        WebElement ordersTabTitle = chromeDriver.findElement(By.tagName("h2"));
        System.out.println(ordersTabTitle.getText());
        chromeDriver.navigate().refresh();

        if (!chromeDriver.findElement(By.className("page-title")).getText().equals("Заказы")) {
            System.out.println("Ошибка, не тот раздел!!!");
        }

        //catalogTab
        WebElement catalogTab = chromeDriver.findElement(By.xpath("//li[@data-submenu = '9']/a[@class = 'title has_submenu']"));
        catalogTab.click();
        WebElement catalogTabTitle = chromeDriver.findElement(By.tagName("h2"));
        System.out.println(catalogTabTitle.getText());
        chromeDriver.navigate().refresh();

        if (!chromeDriver.findElement(By.tagName("h2")).getText().equals("товары")) {
            System.out.println("Ошибка, не тот раздел!!!");
        }

        //customersTab
        WebElement customersTab = chromeDriver.findElement(By.xpath("//li[@data-submenu = '23']/a[@class = 'link']"));
        customersTab.click();
        WebElement customersTabTitle = chromeDriver.findElement(By.tagName("h2"));
        System.out.println(customersTabTitle.getText());
        chromeDriver.navigate().refresh();

        if (!chromeDriver.findElement(By.className("page-title")).getText().equals("Управление клиентами")) {
            System.out.println("Ошибка, не тот раздел!!!");
        }

        //supportServiceTab
        WebElement supportServiceTab = chromeDriver.findElement(By.xpath("//li[@data-submenu = '27']/a[@class = 'title has_submenu']"));
        supportServiceTab.click();
        WebElement supportServiceTabTitle = chromeDriver.findElement(By.tagName("h2"));
        System.out.println(supportServiceTabTitle.getText());
        chromeDriver.navigate().refresh();

        if (!chromeDriver.findElement(By.className("page-title")).getText().equals("Customer Service")) {
            System.out.println("Ошибка, не тот раздел!!!");
        }

        //statisticsTab
        WebElement statisticsTab = chromeDriver.findElement(By.xpath("//li[@data-submenu = '31']/a[@class = 'title ']"));
        statisticsTab.click();
        WebElement statisticsTabTitle = chromeDriver.findElement(By.tagName("h2"));
        System.out.println(statisticsTabTitle.getText());
        chromeDriver.navigate().refresh();

        if (!chromeDriver.findElement(By.tagName("h2")).getText().equals("Статистика")) {
            System.out.println("Ошибка, не тот раздел!!!");
        }
        //modulesTab
        WebElement modulesTab = chromeDriver.findElement(By.xpath("//li[@data-submenu = '42']/a[@class = 'title has_submenu']"));
        modulesTab.click();
        WebElement modulesTabTitle = chromeDriver.findElement(By.tagName("h2"));
        System.out.println(modulesTabTitle.getText());
        chromeDriver.navigate().refresh();

        if (!chromeDriver.findElement(By.tagName("h2")).getText().equals("Выбор модуля")) {
            System.out.println("Ошибка, не тот раздел!!!");
        }

        //designTab
        WebElement designTab = chromeDriver.findElement(By.xpath("//li[@data-submenu = '46']/a[@class = 'link']"));
        designTab.click();
        WebElement designTabTitle = chromeDriver.findElement(By.tagName("h2"));
        System.out.println(designTabTitle.getText());
        chromeDriver.navigate().refresh();

        if (!chromeDriver.findElement(By.tagName("h2")).getText().equals("Шаблоны > Шаблон")) {
            System.out.println("Ошибка, не тот раздел!!!");
        }

        //deliveryTab
        WebElement deliveryTab = chromeDriver.findElement(By.xpath("//li[@data-submenu = '52']/a[@class = 'title has_submenu']"));
        deliveryTab.click();
        WebElement deliveryTabTitle = chromeDriver.findElement(By.tagName("h2"));
        System.out.println(deliveryTabTitle.getText());
        chromeDriver.navigate().refresh();

        if (!chromeDriver.findElement(By.tagName("h2")).getText().equals("Перевозчики")) {
            System.out.println("Ошибка, не тот раздел!!!");
        }

        //paymentMethodTab
        WebElement paymentMethodTab = chromeDriver.findElement(By.xpath("//li[@data-submenu = '55']/a[@class = 'title has_submenu']"));
        paymentMethodTab.click();
        WebElement paymentMethodTabTitle = chromeDriver.findElement(By.tagName("h2"));
        System.out.println(paymentMethodTabTitle.getText());
        chromeDriver.navigate().refresh();

        if (!chromeDriver.findElement(By.tagName("h2")).getText().equals("Payment Methods")) {
            System.out.println("Ошибка, не тот раздел!!!");
        }
        //internationalTab
        WebElement internationalTab = chromeDriver.findElement(By.xpath("//li[@data-submenu = '58']/a[@class = 'title has_submenu']"));
        internationalTab.click();
        WebElement internationalTabTitle = chromeDriver.findElement(By.tagName("h2"));
        System.out.println(internationalTabTitle.getText());
        chromeDriver.navigate().refresh();

        if (!chromeDriver.findElement(By.tagName("h2")).getText().equals("Локализация")) {
            System.out.println("Ошибка, не тот раздел!!!");
        }

        //shopParametersTab
        WebElement shopParametersTab = chromeDriver.findElement(By.xpath("//li[@data-submenu = '73']/a[@class = 'title has_submenu']"));
        shopParametersTab.click();
        WebElement shopParametersTabTitle = chromeDriver.findElement(By.tagName("h2"));
        System.out.println(shopParametersTabTitle.getText());
        chromeDriver.navigate().refresh();

        if (!chromeDriver.findElement(By.tagName("h2")).getText().equals("General")) {
            System.out.println("Ошибка, не тот раздел!!!");
        }

        //configurationTab
        WebElement configurationTab = chromeDriver.findElement(By.xpath("//li[@data-submenu = '95']/a[@class = 'title has_submenu']"));
        configurationTab.click();
        WebElement configurationTabTitle = chromeDriver.findElement(By.tagName("h2"));
        System.out.println(configurationTabTitle.getText());
        chromeDriver.navigate().refresh();

        if (!chromeDriver.findElement(By.tagName("h2")).getText().equals("Information")) {
            System.out.println("Ошибка, не тот раздел!!!");
        }
        chromeDriver.quit();
      }
  }
        */
        // Конечно же лучшим вариантом решения этой задачи - использование паттерна Page Object




