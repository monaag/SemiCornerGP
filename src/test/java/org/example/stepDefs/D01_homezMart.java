package org.example.stepDefs;
import java.util.Random;
import org.testng.Assert;
import java.util.ArrayList;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.example.pages.P01_homzMart;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class D01_homezMart {
    P01_homzMart element = new P01_homzMart();
    Actions actions = new Actions(Hooks.driver);
    Random random = new Random();
    static ArrayList<Integer> generatedNumbers = new ArrayList<>();
    static ArrayList<String> productTitles = new ArrayList<>();
    static ArrayList<Double> productPrices = new ArrayList<>();
    static ArrayList<String> cartProductTitles = new ArrayList<>();
    static ArrayList<Double> cartProductPrices = new ArrayList<>();

    @Given("open Home Page, Hover On Storage")
    public void openHomePageHoverOnStorage() throws InterruptedException {
        // Hover on Storage
        actions.moveToElement(element.storageBarCategory).perform();
        Thread.sleep(500);
        // Click on kitchen storage
        element.kitchenStorageCategory.click();
        actions.moveByOffset(100, -100).perform();
        Thread.sleep(1000);
    }


    @When("add Two Random Products")
    public void addTwoRandomProducts() throws InterruptedException {
        // Add 2 random products
        for (int i = 0; i < 2; i++) {
            int maxProducts = element.allProducts.size();
            int randomProduct = random.nextInt(maxProducts);
            generatedNumbers.add(randomProduct);
            // Handle the duplicated generated number
            if (generatedNumbers.contains(randomProduct)) {
                ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].scrollIntoView();", element.allProducts.get(generatedNumbers.get(i)));
                Thread.sleep(700);
                element.allProducts.get(randomProduct).click();
                Thread.sleep(2000);
                // Get the product details
                String productTitle = element.productTitle.getText();
                String productPrice = element.productPrice.getText();
                double price = Double.parseDouble(productPrice.replaceAll("[A-Za-z,]",""));
                productTitles.add(productTitle);
                productPrices.add(price);
                Thread.sleep(500);
                // Add to the cart
                actions.moveToElement(element.addToCartButton).perform();
                element.addToCartButton.click();
                Thread.sleep(500);
                Hooks.driver.navigate().back();
                Thread.sleep(1000);
            }
        }
    }

    @Then("compare The Two products And Check The Calculated Total Price")
    public void compareTheTwoProductsAndCheckTheCalculatedTotalPrice() throws InterruptedException {
        // Open the cart
        Thread.sleep(1000);
        element.cartIcon.click();
        Thread.sleep(500);
        int productsCart = element.cartAllProducts.size();
        // Get the cart products details
        for (int i = 0; i < productsCart ; i++) {
            String cartProductTitle = element.cartProductTitle.get(i).getText();
            cartProductTitles.add(cartProductTitle);
            String cartProductPrice = element.cartProductPrice.get(i).getText();
            cartProductPrices.add(Double.valueOf(cartProductPrice));
        }
        // Verify the products
        Assert.assertEquals(cartProductTitles, productTitles);
        Assert.assertEquals(cartProductPrices, productPrices);
        // Verify the calculated subtotal
        double cartSubtotal = Double.parseDouble(element.cartSubtotal.getText().replaceAll("[A-Za-z]",""));
        Assert.assertEquals(cartSubtotal, cartProductPrices.get(0)+cartProductPrices.get(1), "Different subtotal price!");
    }
}