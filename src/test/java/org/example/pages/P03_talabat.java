package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_talabat {
    public P03_talabat (){
        PageFactory.initElements(Hooks.driver, this);
    }
    @FindBy(css = "h1[data-testid=\"banner-title\"]")
    public WebElement homePageBanner;
    @FindBy(css = "ul[class=\"navbar-nav d-none d-sm-flex\"] li")
    public List <WebElement> navigationElements;
    @FindBy(css = "ul[class=\"navbar-nav d-none d-sm-flex\"] li:nth-child(5)")
    public WebElement switchCountry;
    @FindBy(css = "div[class=\"popover-heading\"] div")
    public List <WebElement> countries;
    @FindBy(css = "ul[class=\"navbar-nav d-none d-sm-flex\"] li:nth-child(6)")
    public WebElement login;
    @FindBy(css = "p[data-test=\"login-heading\"]")
    public WebElement loginHeading;
    @FindBy(css = "img[src=\"/assets/images/search-close.svg\"]")
    public WebElement closeLogin;
    @FindBy(css = "input[data-test=\"input-search-box-map-first\"]")
    public WebElement searchInput;
    @FindBy(css = "li:nth-child(1) div[class=\"f-14 text-truncate\"]")
    public WebElement searchInputSuggestion;
    @FindBy(css = "img[data-testid=\"btn-clear\"]")
    public WebElement clearSearch;
    @FindBy(css = "button[data-testid=\"letsgo-btn\"]")
    public WebElement letsGoButton;
    @FindBy(css = "div[class=\"sc-9ebbca0c-3 cMkjOp arrow p-2\"]")
    public WebElement enterFullAddressMsg;
    @FindBy(css = "img[data-testid=\"btn-locate-me\"]")
    public WebElement locateMeIcon;
    @FindBy(css = "div[data-testid=\"map-first-title\"]")
    public WebElement deliveryAddressMap;
    @FindBy(css = "img[src=\"/assets/images/search-close.svg\"]")
    public WebElement closeMap;
    // Downloads
    @FindBy(css = "div[class=\"d-block d-sm-flex links-list justify-content-center\"] a")
    public List <WebElement> downloadLinks;
    // Categories
    @FindBy(css = "a[class=\"sc-8ac93b4f-2 sc-8ac93b4f-5 bQjKPS jLUfOf\"]")
    public List <WebElement> categories;
    // Join us
    @FindBy(css = "div[class=\"col-md-8 col-16\"] a")
    public List <WebElement> joinUsButtons;
    // Cities
    @FindBy(css = "a[class=\"sc-8ac93b4f-2 sc-8ac93b4f-8 bQjKPS hbKJhv\"]")
    public List <WebElement> cities;
    @FindBy(css = ".cities-tiles div[class=\"markdown-rich-text-block\"] h3")
    public List <WebElement> citiesTitles;
    @FindBy(css = "div[class=\"sc-4c444eaa-0 gznvkJ\"] div[class=\"markdown-rich-text-block\"] h1")
    public WebElement cityHeading;
    // Footer links
    @FindBy(css = "div[class=\"section footer-links py-6 f-13 d-flex\"] a")
    public List <WebElement> footerHome;
    @FindBy(css = "a[class=\"sc-d0a74368-1 jajQZj pl-m-6 pt-m-3 undefined\"]")
    public List <WebElement> footerLinks;
    @FindBy(tagName = "h1")
    public List <WebElement> footerLinkHeading;
    @FindBy(css = "div[class=\"col-sm-4 d-none d-sm-block\"] a")
    public List <WebElement> footerSocial;
    @FindBy(css = ".contact-us-snapIn a")
    public WebElement contactUsButton;
    @FindBy(css = "div[data-testid=\"app-component\"] h1")
    public WebElement contactUsHeading;
}
