package latscodeitPages;

import base.CommonAPI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PracticePage extends CommonAPI {

    @FindBy(xpath = "//input[@id='bmwradio']")
    WebElement bmwradio;
    @FindBy(id = "benzradio")
    WebElement benzradio;
    @FindBy(id = "hondaradio")
    WebElement hondaradio;

    @FindBy(xpath = "//select[@id='carselect']")
    WebElement selectCars;

    @FindBy(xpath = "//select[@id='multiple-select-example']")
    WebElement multipleSelection;

    @FindBy(xpath = "//button[@id='openwindow']")
    WebElement openWindow;
    @FindBy(id = "search-courses")
    WebElement newWindowSearchBox;

    @FindBy(xpath = "//input[@id='name']")
    WebElement alertEnterName;
    @FindBy(id = "alertbtn")
    WebElement alertButton;

    @FindBy(id = "mousehover")
    WebElement mouseHover;

    @FindBy(xpath = "//a[@id='watchpromo']")
    WebElement watchPromo;
    @FindBy(id = "opentab")
    WebElement openTab;

    @FindBy(xpath = "//option[@value='apple']")
    WebElement apple;
    @FindBy(xpath = "//option[@value='orange']")
    WebElement orange;
    @FindBy(xpath = "//option[@value='peach']")
    WebElement peach;

    @FindBy(xpath = "//div[@class='container']//div[1]//div[1]//div[1]//a[1]//div[1]//div[1]//img[1]")
    WebElement newTabImg1;
    @FindBy(xpath = "//input[@id='search-courses']")
    WebElement newTabSearchBox;

    @FindBy(id = "draggable")
    WebElement draggable;
    @FindBy(id = "droppable")
    WebElement droppable;

    @FindBy(xpath = "//table/tbody/tr[3]/td[2]")
    WebElement tableText;

    @FindBy(xpath = "//a[contains(text(),'Reload')]")
    WebElement reloadPage;

    @FindBy(name = "cars")
    WebElement cars;



    public void carSelectionBMWRadioButton(){
        bmwradio.click();
    }
    public void carSelectionBENZRadioButton(){
        benzradio.click();
    }
    public void carSelectionHONDARadioButton(){
        hondaradio.click();
    }
    public void allRadioButtonsAndCheckBoxSelectionInOneMethod() throws InterruptedException {
        boolean isChecked;
        List<WebElement> carButtons = driver.findElements(By.name("cars"));
        System.out.println("The size of the List is: " +carButtons.size());
        for(int i = 0; i<carButtons.size(); i++){
            isChecked = carButtons.get(i).isSelected();
            if(!isChecked){
                carButtons.get(i).click();
                Thread.sleep(1000);
            }
        }
    }
    public void selectCarsFromTheList1(String car) throws InterruptedException {
        Select select1 = new Select(selectCars);
        select1.selectByVisibleText(car);
        Thread.sleep(2000);
    }
    public void selectCarsFromTheList2(String car) throws InterruptedException {
        Select select2 = new Select(selectCars);
        select2.selectByValue(car);
        Thread.sleep(2000);
    }
    public void selectCarsFromTheList(int index) throws InterruptedException {
        Select select3 = new Select(selectCars);
        select3.selectByIndex(index);
        Thread.sleep(2000);
    }
    public void selectAllCarsFromTheListInOneMethod() throws InterruptedException {
        Select select = new Select(selectCars);
        select.selectByIndex(1);
        Thread.sleep(2000);
        select.selectByValue("bmw");
        Thread.sleep(2000);
        select.selectByVisibleText("Honda");
        Thread.sleep(2000);
    }
    public void selectAllCarsFromTheListUsingForLoop() throws InterruptedException {
        Select select = new Select(selectCars);
        List<WebElement> elementList = select.getOptions();
        for (int i = 0; i<elementList.size(); i++){
            elementList.get(i).click();
            Thread.sleep(2000);
            System.out.println(elementList.get(i).getText());
        }
    }
    public void MultipleSelectionInOneMethod() throws InterruptedException {
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL)
                    .click(apple)
                    .click(orange)
                    .click(peach)
              .keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(2000);
    }
    public void selectMultipleOptionsFromTheList() throws InterruptedException {
        Select select = new Select(multipleSelection);
        select.selectByValue("Orange");
        Thread.sleep(2000);
    }
    public void windowHandling() throws InterruptedException {
        String parentWindow = driver.getWindowHandle();//to get ID of parent Window
        System.out.println("Parent Window ID is: " +parentWindow);//to print parent window ID
        System.out.println("Parent Window Title is: " +driver.getTitle());//to print/assert parent window

        openWindow.sendKeys(Keys.ENTER);//instead of .click method ENTER key is used
        Set<String> windows = driver.getWindowHandles();//to get all windows IDs
        for (String window : windows) {//for each loop to iterate all window IDs
            System.out.println(window);//to print all window IDs
            if(!window.equals(parentWindow)){//checking new window
                driver.switchTo().window(window);//switching to new window
                System.out.println("New Window Title is: " +driver.getTitle());//to get and print new window title
                Thread.sleep(3000);
                newWindowSearchBox.sendKeys
                        ("Selenium WebDriver With Java");//to type in the new window
                driver.close();//to close new window
            }
        }
        driver.switchTo().window(parentWindow);//to get back into parent window
        String title = driver.getTitle();
        Assert.assertEquals("Practice | Let's Kode It", title);
        System.out.println("Returned Parent Window Title is: "+title);//to print/assert returned window
    }
    public void windowHandlingUsingIterator() throws InterruptedException {
        openWindow.click();
        //to store both window IDs in a Set
        Set<String> windowsID = driver.getWindowHandles();
        //to Iterate both window IDs
        Iterator<String> iterator = windowsID.iterator();
        iterator.hasNext();//to check if there has in iterator object/start iterator
        String parentWindow = iterator.next();//to go to the parent window
        String newWindow = iterator.next();//to go to the new window
        System.out.println("Parent WindowID is    : "+parentWindow);
        System.out.println("New WindowID is       : "+ newWindow);

        driver.switchTo().window(newWindow);//to switch to the new window
        System.out.println("New window title is   : "+ driver.getTitle());
        Thread.sleep(2000);
        //to perform any action on the new window
        newWindowSearchBox.sendKeys("java");
        Thread.sleep(2000);
        driver.close();//to close new window
        driver.switchTo().window(parentWindow);//to switch to the parent window
        System.out.println("Parent Window Title is: " +driver.getTitle());
    }
    public void newTabHandling() throws InterruptedException {
        String parentWindowTabID = driver.getWindowHandle();
        System.out.println("Parent window ID is: "+parentWindowTabID);
        System.out.println("The parent tab window ID is: "+driver.getTitle());

        openTab.click();
        Set<String> windows = driver.getWindowHandles();
        for(String window: windows){
            System.out.println(window);
            if(!window.equals(parentWindowTabID)){
                driver.switchTo().window(window);
                newTabImg1.click();
                //newTabSearchBox.sendKeys("java");//to do some action on new Tab
                watchPromo.click();
                Thread.sleep(2000);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindowTabID);
        System.out.println("Returned window ID is: "+parentWindowTabID);
    }
    public void alertHandlingByAccepting() throws InterruptedException {
        alertEnterName.sendKeys("Mike Miller");
        alertButton.click();
        Alert myAlert = driver.switchTo().alert();
        System.out.println("Alert's message: "+ myAlert.getText());
        Thread.sleep(2000);
        myAlert.accept();
    }
    public void alertHandlingByDismissing() throws InterruptedException {
        alertEnterName.sendKeys("Mike Miller");
        alertButton.click();
        Alert myAlert = driver.switchTo().alert();
        System.out.println("Alert message: "+myAlert.getText());
        Thread.sleep(2000);
        myAlert.dismiss();
    }
    public void mouseHovering() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHover).perform();
        Thread.sleep(2000);
        //Example of using Explicit Wait synchronization
        WebDriverWait explicitWait = new WebDriverWait(driver,5);
        explicitWait.until(ExpectedConditions.elementToBeClickable(reloadPage)).click();
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Practice | Let's Kode It",title);
    }
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.dragAndDrop(draggable,droppable).build().perform();
        Thread.sleep(3000);
    }
    public void gettingTextFromWebTable(){
        String strOfTable = tableText.getText();
        System.out.println(strOfTable);
    }
}
