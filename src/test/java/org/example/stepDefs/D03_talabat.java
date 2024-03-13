package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.pages.P03_talabat;
import org.testng.Assert;
import java.util.ArrayList;

public class D03_talabat {
    P03_talabat talabat = new P03_talabat();
    static ArrayList<String> tabs;

    @Given("open Home Page And Check The Navigator")
    public void openHomePageAndCheckTheNavigator() throws InterruptedException {
        // Verify home page.
        Assert.assertTrue(talabat.homePageBanner.isDisplayed(), "Invalid home page!");
        // Navigator --> denotations, offers, partner and languages.
        String[] navUrls = {"https://www.talabat.com/egypt/donations",
                "https://www.talabat.com/egypt/offers",
                "https://eg.partner.talabat.com/s/?language=en_US&_ga",
                "https://www.talabat.com/ar/egypt"};
        for (int i = 0; i < talabat.navigationElements.size()-2; i++) {
            talabat.navigationElements.get(i).click();
            Thread.sleep(800);
            if (i == 2){
                // Switch to the new tab
                tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
                Hooks.driver.switchTo().window(tabs.get(1));
            }
            Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(navUrls[i]), "Incorrect URL!");
            // Switch to the home page.
            tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
            Hooks.driver.switchTo().window(tabs.get(0));
            Hooks.driver.navigate().back();
        }
        // Countries
        String[] countriesUrls = {"https://www.talabat.com/kuwait", "https://www.talabat.com/ar/ksa", "https://www.talabat.com/ar/bahrain", "https://iraq.talabat.com/",
                                  "https://www.talabat.com/uae", "https://www.talabat.com/oman", "https://www.talabat.com/qatar", "https://www.talabat.com/jordan"};
        talabat.switchCountry.click();
        int countriesSize = talabat.countries.size();
        for (int i = 0; i < countriesSize ; i++) {
            Thread.sleep(500);
            talabat.switchCountry.click();
            talabat.countries.get(i).click();
            Assert.assertEquals(Hooks.driver.getCurrentUrl(),countriesUrls[i], "Incorrect country URL!");
            Hooks.driver.get("https://www.talabat.com/egypt");
        }
        // Login
        talabat.login.click();
        Assert.assertTrue(talabat.loginHeading.isDisplayed(), "Incorrect login pop-up!");
        talabat.closeLogin.click();
        Assert.assertTrue(talabat.homePageBanner.isDisplayed(), "Incorrect login pop-up!");
    }

    @And("check The Search Section")
    public void checkTheSearchSection() {
        // Search --> search, location, let's go button, clear search and close map button.
        talabat.searchInput.sendKeys("Dokki");
        Assert.assertEquals(talabat.searchInputSuggestion.getText(), talabat.searchInput.getAttribute("value"), "Unrelated suggestion!");
        talabat.clearSearch.click();
        // Assert that location icon is displayed after clicking on clear search.
        Assert.assertTrue(talabat.locateMeIcon.isDisplayed(), "Unclear search!");
        talabat.letsGoButton.click();
        // Assert that error message appears after clicking on let's go button.
        Assert.assertTrue(talabat.enterFullAddressMsg.isDisplayed(), "Enter full address message");
        talabat.locateMeIcon.click();
        // Assert that map opened after clicking on location icon.
        Assert.assertTrue(talabat.deliveryAddressMap.isDisplayed(), "Incorrect delivery map!");
        talabat.closeMap.click();
        // Assert that location icon appears after clicking on close map.
        Assert.assertTrue(talabat.locateMeIcon.isDisplayed(), "Unclosed map!");
    }
    @And("check The Downloads Section")
    public void checkTheDownloadsSection() {
        // Downloads --> google play, app store, app gallery.
        String[] downloadURL = {"https://play.google.com/store/apps/details?id=com.talabat&referrer=adjust_reftag%3Dc2VDcRfodCSbL%26utm_source%3DCooperations%26utm_campaign%3Dother_campaigns_and_eat_ma_bh_display%26utm_content%3DFooter_download&utm_campaign=other_campaigns_web_eat_ma_bh_display&utm_medium=campaigns&utm_source=Footer_download",
                "https://apps.apple.com/us/app/talabat-food-grocery-order/id451001072?utm_campaign=other_campaigns_web_eat_ma_bh_display&utm_source=Footer_download&utm_medium=campaigns",
                "https://appgallery.huawei.com/#/app/C100450669",
                "https://play.google.com/store/apps/details?id=com.talabat&referrer=adjust_reftag%3Dc2VDcRfodCSbL%26utm_source%3DCooperations%26utm_campaign%3Dother_campaigns_and_eat_ma_bh_display%26utm_content%3DFooter_download&utm_campaign=other_campaigns_web_eat_ma_bh_display&utm_medium=campaigns&utm_source=Footer_download",
                "https://apps.apple.com/us/app/talabat-food-grocery-order/id451001072?utm_campaign=other_campaigns_web_eat_ma_bh_display&utm_source=Footer_download&utm_medium=campaigns",
                "https://appgallery.huawei.com/#/app/C100450669"};
        for (int i = 0; i < talabat.downloadLinks.size(); i++) {
            talabat.downloadLinks.get(i).click();
            // Switch to the new tab.
            tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
            Hooks.driver.switchTo().window(tabs.get(2));
            // Assert that the current link equals the static link.
            Assert.assertEquals(Hooks.driver.getCurrentUrl(), downloadURL[i], "Invalid download link!");
            // Close the new tab
            Hooks.driver.close();
            // Switch to the home page.
            tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
            Hooks.driver.switchTo().window(tabs.get(0));
        }
    }
    @And("check The Categories Section")
    public void checkTheCategoriesSection() {
        // Categories --> food, groceries and health.
        String[] expectedURL = {"https://www.talabat.com/egypt/restaurants", "https://www.talabat.com/egypt/groceries", "https://www.talabat.com/egypt/pharmacies"};
        for (int i = 0; i < talabat.categories.size(); i++) {
            talabat.categories.get(i).click();
            Assert.assertEquals(Hooks.driver.getCurrentUrl(), expectedURL[i], "Invalid category URL!");
            Hooks.driver.navigate().back();
        }
    }
    @And("check The JoinUs Section")
    public void checkTheJoinUsSection() {
        // Join us --> find out more and find jobs.
        String[] expectedURL= {"https://eg.partner.talabat.com/s/?language=en_US&countryIsoCode=EG", "https://deliveryhero.wd3.myworkdayjobs.com/talabat"};
        for (int i = 0; i < talabat.joinUsButtons.size(); i++) {
            talabat.joinUsButtons.get(i).click();
            Assert.assertEquals(Hooks.driver.getCurrentUrl(), expectedURL[i], "Invalid join us link!");
            Hooks.driver.get("https://www.talabat.com/egypt");
        }
    }
    @And("check The Cities Section")
    public void checkTheCitiesSection() {
        // Cities.
        for (int i = 0; i < talabat.cities.size(); i++) {
            String title = talabat.citiesTitles.get(i).getText();
            talabat.cities.get(i).click();
            Assert.assertTrue(talabat.cityHeading.getText().contains(title), "Invalid city title!");
            Hooks.driver.navigate().back();
        }
    }
    @And("check The Footer")
    public void checkTheFooter() throws InterruptedException {
        // Footer home --> careers, Terms, FAQ, privacy policy, contact us and sitemap.
        for (int i = 0; i < talabat.footerHome.size(); i++) {
            talabat.footerHome.get(i).click();
            String expectedURL = talabat.footerHome.get(i).getAttribute("href");
            if (i == 0){
                // Switch to the new tab.
                tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
                Hooks.driver.switchTo().window(tabs.get(2));
            }
            Assert.assertEquals(Hooks.driver.getCurrentUrl(),expectedURL,  "Invalid footer home link!");
            // Switch to the home page.
            tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
            Hooks.driver.switchTo().window(tabs.get(0));
            Hooks.driver.get("https://www.talabat.com/egypt");
        }
        // Footer links --> restaurant, cuisines and areas.
        for (int i = 0; i < talabat.footerLinks.size(); i++) {
            String footerHeading = talabat.footerLinks.get(i).getText();
            talabat.footerLinks.get(i).click();
            Thread.sleep(2000);
            // get the first header on the page.
            String linkHeading = talabat.footerLinkHeading.get(0).getText();
            Assert.assertTrue(linkHeading.contains(footerHeading), "Invalid footer link heading!");
            Hooks.driver.get("https://www.talabat.com/egypt");
        }
        // Footer social --> facebook, twitter, instagram, LinkedIn and YouTube.
        for (int i = 0; i < talabat.footerSocial.size(); i++) {
            talabat.footerSocial.get(i).click();
            String expected = talabat.footerSocial.get(i).getAttribute("aria-label").toLowerCase();
            // Switch to the new tab.
            tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
            Hooks.driver.switchTo().window(tabs.get(3));
            // Assert that link has the website title.
            Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(expected), "Invalid footer social url!");
            // Close the new tab.
            Hooks.driver.close();
            // Switch to the home page.
            tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
            Hooks.driver.switchTo().window(tabs.get(0));
        }
        // Footer contact us button
        talabat.contactUsButton.click();
        Assert.assertTrue(talabat.contactUsHeading.isDisplayed(), "Invalid contact us page!");
    }
}