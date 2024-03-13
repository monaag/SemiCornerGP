package org.example.pages;
import java.util.List;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class P01_homzMart {
    public P01_homzMart (){
        PageFactory.initElements(Hooks.driver, this);
    }
    @FindBy(id = "HEADER_MENU_BAR_CATEGORY_1")
    public WebElement storageBarCategory;
    @FindBy(css = ".siteMenu__menuLinkHead a[href=\"/en/c/storage/kitchen-storage\"]")
    public WebElement kitchenStorageCategory;
    @FindBy(css = "div[class=\"productCard__container card-item\"]")
    public List <WebElement> allProducts;
    @FindBy(css = "button[class=\"button-with-icon default-bg fullWidth\"]")
    public WebElement addToCartButton;
    @FindBy(css = "p[class=\"hz-font-w-bold hz-fs-24 head\"]")
    public WebElement productTitle;
    @FindBy(css = "div[class=\"item-detail\"] div[class=\"productPrices__specialPrice\"] p")
    public WebElement productPrice;
    @FindBy(id = "HEADER_CART_BRIEF_ICON")
    public WebElement cartIcon;
     @FindBy(css = "div[class=\"cartItem__containerr orders-card-items\"]")
    public List <WebElement> cartAllProducts;
    @FindBy(css = "p[class=\"cartItem__title\"]")
    public List <WebElement> cartProductTitle;
    @FindBy(css = "p[class=\"cartItem__price\"] span")
    public List <WebElement> cartProductPrice;
    @FindBy(css = "div[class=\"cart__subtotal hz-mb-20\"] div b")
    public WebElement cartSubtotal;
}