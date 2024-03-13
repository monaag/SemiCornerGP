package org.example.stepDefs;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_wuzzuf;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class D02_wuzzuf {
    P02_wuzzuf register = new P02_wuzzuf();
    Faker faker = new Faker();
    String email = faker.internet().safeEmailAddress();
    @Given("open Home Page, Click On Join Now And Fill The Register Page")
    public void openHomePageClickOnJoinNowAndFillTheRegisterPage() throws InterruptedException {
        // Open the website and click on join now.
        register.joinNowButton.click();
        // Enter valid data and click on sign up.
        register.firstNameField.sendKeys(faker.name().firstName());
        register.lastNameField.sendKeys(faker.name().lastName());
        register.mailField.sendKeys(email);
        register.passwordField.sendKeys(faker.internet().password());
        register.jobTitle.sendKeys(faker.job().title());
        Thread.sleep(500);
        register.signUpButton.click();
    }
    @When("fill Career Interests And General Info Pages")
    public void fillCareerInterestsAndGeneralInfoPages() throws InterruptedException {
        // Enter valid data in the career interests  and general pages.
        register.entryLevelChoice.click();
        register.jobType.click();
        register.jobCategory.sendKeys("Quality");
        register.jobCategory.sendKeys(Keys.ENTER);
        register.minimumSalary.sendKeys(faker.number().digits(5));
        register.saveContinueButton.click();
        register.daySelector.sendKeys("30");
        register.daySelector.sendKeys(Keys.ENTER);
        register.monthSelector.sendKeys("08");
        register.monthSelector.sendKeys(Keys.ENTER);
        register.yearSelector.sendKeys("2000");
        register.yearSelector.sendKeys(Keys.ENTER);
        register.genderChoice.click();
        register.nationalitySelector.sendKeys("Egypt");
        register.nationalitySelector.sendKeys(Keys.ENTER);
        register.citySelector.sendKeys("Giza");
        register.citySelector.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        register.areaSelector.sendKeys("Giza");
        register.areaSelector.sendKeys(Keys.ENTER);
        register.contactInfo.sendKeys("01236547895");
        register.saveContinueButton2.click();
    }

    @Then("fill The Professional Info Page")
    public void fillTheProfessionalInfoPage() throws InterruptedException {
        // Enter valid data in the professional info page.
        register.experienceSelector.sendKeys("Less than 1 year");
        register.experienceSelector.sendKeys(Keys.ENTER);
        register.experienceJobTitle.sendKeys(faker.job().title());
        register.experienceCompanyName.sendKeys(faker.company().name());
        register.experienceJobCategory.sendKeys("Quality");
        register.experienceJobCategory.sendKeys(Keys.ENTER);
        register.experienceJobType.click();
        register.startMonth.sendKeys("May");
        register.startMonth.sendKeys(Keys.ENTER);
        register.endMonth.sendKeys("December");
        register.endMonth.sendKeys(Keys.ENTER);
        register.startYear.sendKeys("2021");
        register.startYear.sendKeys(Keys.ENTER);
        register.endYear.sendKeys("2021");
        register.endYear.sendKeys(Keys.ENTER);
        register.saveExperienceButton.click();
        register.educationLevel.click();
        register.fieldOfStudy.sendKeys(faker.job().field());
        register.university.sendKeys(faker.university().name());
        register.degreeYear.sendKeys("2021");
        register.degreeYear.sendKeys(Keys.ENTER);
        register.gradeSelector.sendKeys("B");
        register.gradeSelector.sendKeys(Keys.ENTER);
        register.languageSelector.sendKeys("English");
        register.languageSelector.sendKeys(Keys.ENTER);
        register.proficiencySelector.sendKeys("Beginner");
        register.proficiencySelector.sendKeys(Keys.ENTER);
        register.addLanguageButton.click();
        register.skillsSelector.sendKeys(faker.job().keySkills());
        register.skillsSelector.sendKeys(Keys.ENTER);
        register.skillsSelector.sendKeys(faker.job().keySkills());
        register.skillsSelector.sendKeys(Keys.ENTER);
        // Add file **Note add your file path.
        register.uploadFile.sendKeys("C:\\Users\\MonaG\\Downloads\\Souq-AlattarahBSReport.pdf");
        Thread.sleep(1000);
        register.getStartedButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(register.registeredEmail.getText(), email, "Register successfully");
    }
}