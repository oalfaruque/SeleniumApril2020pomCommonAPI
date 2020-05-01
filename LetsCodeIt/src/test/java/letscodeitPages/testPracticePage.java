package letscodeitPages;

import base.CommonAPI;
import latscodeitPages.PracticePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class testPracticePage extends CommonAPI {

    PracticePage practicePage;

    public void accessToPracticePage(){
        practicePage = PageFactory.initElements(driver, PracticePage.class);
    }

    @Test//Selecting all the radio Buttons and Check Boxes in one method
    public void testSelectAllCarsFromRadioAndCheckBoxInOneMethod() throws InterruptedException {
        accessToPracticePage();
        practicePage.allRadioButtonsAndCheckBoxSelectionInOneMethod();
    }
    @Test//Selecting BMW radio button
    public void testCarSelectionBMWRadioButton(){
        accessToPracticePage();
        practicePage.carSelectionBMWRadioButton();
    }
    @Test//Selecting Benz radio button
    public void testCarSelectionBENZRadioButton(){
        accessToPracticePage();
        practicePage.carSelectionBENZRadioButton();
    }
    @Test//Selecting Honda radio button
    public void testCarSelectionHONDARadioButton(){
        accessToPracticePage();
        practicePage.carSelectionHONDARadioButton();
    }
    @Test//to test all the selecting items from the List
    public void testSelectAllCarsFromTheListInOneMethod() throws InterruptedException {
        accessToPracticePage();
        practicePage.selectAllCarsFromTheListInOneMethod();
    }
    @Test//to test all the selecting items from the List in one method using for loop
    public void testSelectAllCaresFromTheListUsingForLoop() throws InterruptedException {
        accessToPracticePage();
        practicePage.selectAllCarsFromTheListUsingForLoop();
    }
    @Test//Select by visible text from dropdown
    public void testSelectCarsFromTheList1() throws InterruptedException {
        accessToPracticePage();
        practicePage.selectCarsFromTheList1("Honda");
    }
    @Test//Select by value from dropdown
    public void testSelectCarsFromTheList2() throws InterruptedException {
        accessToPracticePage();
        practicePage.selectCarsFromTheList2("bmw");
    }
    @Test//Select by index from dropdown
    public void testSelectCarsFromTheList3() throws InterruptedException {
        accessToPracticePage();
        practicePage.selectCarsFromTheList(1);
    }
    @Test//to choose multiple elements from the dropdown box
    public void testMultipleSelectionInOneMethod() throws InterruptedException {
        accessToPracticePage();
        practicePage.MultipleSelectionInOneMethod();
    }
    @Test//Window handling using for loop
    public void testWindowHandling() throws InterruptedException {
        accessToPracticePage();
        practicePage.windowHandling();
    }
    @Test//Window Handling using Iterator
    public void testWindowHandlingUsingIterator() throws InterruptedException {
        accessToPracticePage();
        practicePage.windowHandlingUsingIterator();

    }
    @Test//TabWindow Handling using for loop
    public void testNewTabHandling() throws InterruptedException {
        accessToPracticePage();
        practicePage.newTabHandling();
    }
    @Test//Alert Handling by accepting the alert
    public void testAlertHandlingByAccepting() throws InterruptedException {
        accessToPracticePage();
        practicePage.alertHandlingByAccepting();
    }
    @Test//Alert Handling by dismissing the alert
    public void testAlertHandlingByDismissing() throws InterruptedException {
        accessToPracticePage();
        practicePage.alertHandlingByDismissing();
    }
    @Test//test Mouse Hovering to reload practice page
    public void testMouseHovering() throws InterruptedException {
        accessToPracticePage();
        practicePage.mouseHovering();
    }
    @Test//test Drag and Drop(in www.jquery.com)
    public void testDragAndDrop() throws InterruptedException {
        accessToPracticePage();
        practicePage.dragAndDrop();
    }
    @Test//test to get Text from Web Table
    public void testGettingTextFromWebTable(){
        accessToPracticePage();
        practicePage.gettingTextFromWebTable();
    }
 }
