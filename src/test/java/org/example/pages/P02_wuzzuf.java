package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_wuzzuf {
    public P02_wuzzuf (){
        PageFactory.initElements(Hooks.driver, this);
    }
    @FindBy(css = "a[class=\"btn btn-primary btn-small join-now\"]")
    public WebElement joinNowButton;
    @FindBy(id = "firstname")
    public WebElement firstNameField;
    @FindBy(id = "lastname")
    public WebElement lastNameField;
    @FindBy(id = "email")
    public WebElement mailField;
    @FindBy(name = "password")
    public WebElement passwordField;
    @FindBy(css = "input[class=\"css-1a96k50 ek82ord0\"]")
    public WebElement jobTitle;
    @FindBy(css = "button[class=\"css-6lejne ezfki8j0\"]")
    public WebElement signUpButton;
    @FindBy(css = "div[class=\"css-1dy69p2 eequ2uf0\"]:nth-child(2)")
    public WebElement entryLevelChoice;
    @FindBy(css = "button[id=\"2\"]")
    public WebElement jobType;
    @FindBy(css = "input[id=\"react-select-2-input\"]")
    public WebElement jobCategory;
    @FindBy(name = "minimumSalary")
    public WebElement minimumSalary;
    @FindBy(css = ".css-nwhan4 button[class=\"css-1wj05oe ezfki8j0\"]")
    public WebElement saveContinueButton;
    @FindBy(css = "input[id=\"react-select-5-input\"]")
    public WebElement daySelector;
    @FindBy(css = "input[id=\"react-select-6-input\"]")
    public WebElement monthSelector;
    @FindBy(css = "input[id=\"react-select-7-input\"]")
    public WebElement yearSelector;
    @FindBy(css = "div[class=\"css-3pwpkg\"] label:nth-child(2)")
    public WebElement genderChoice;
    @FindBy(css = "input[id=\"react-select-8-input\"]")
    public WebElement nationalitySelector;
    @FindBy(css = "input[id=\"react-select-10-input\"]")
    public WebElement citySelector;
    @FindBy(css = "input[id=\"react-select-11-input\"]")
    public WebElement areaSelector;
    @FindBy(name = "primaryPhone")
    public WebElement contactInfo;
    @FindBy(css = ".css-nwhan4 button[class=\"css-1wj05oe ezfki8j0\"]")
    public WebElement saveContinueButton2;
    @FindBy(css = "input[id=\"react-select-19-input\"]")
    public WebElement experienceSelector;
    @FindBy(name = "jobTitle")
    public WebElement experienceJobTitle;
    @FindBy(name = "companyName")
    public WebElement experienceCompanyName;
    @FindBy(css = "input[id=\"react-select-26-input\"]")
    public WebElement experienceJobCategory;
    @FindBy(css = "div[class=\"css-z0wlgp eequ2uf0\"]:nth-child(1)")
    public WebElement experienceJobType;
    @FindBy(css = "input[id=\"react-select-27-input\"]")
    public WebElement startMonth;
    @FindBy(css = "input[id=\"react-select-29-input\"]")
    public WebElement endMonth;
    @FindBy(css = "input[id=\"react-select-28-input\"]")
    public WebElement startYear;
    @FindBy(css = "input[id=\"react-select-30-input\"]")
    public WebElement endYear;
    @FindBy(name = "Save_Work_Experience")
    public WebElement saveExperienceButton;
    @FindBy(css = "div[class=\"css-1dy69p2 eequ2uf0\"]:nth-child(1)")
    public WebElement educationLevel;
    @FindBy(css = "div[class=\"css-1heugwa ek82ord1\"] input")
    public WebElement fieldOfStudy;
    @FindBy(css = "input[id=\"react-select-20-input\"]")
    public WebElement university;
    @FindBy(css = "input[id=\"react-select-21-input\"]")
    public WebElement degreeYear;
    @FindBy(css = "input[id=\"react-select-22-input\"]")
    public WebElement gradeSelector;
    @FindBy(css = "input[id=\"react-select-23-input\"]")
    public WebElement languageSelector;
    @FindBy(css = "input[id=\"react-select-24-input\"]")
    public WebElement proficiencySelector;
    @FindBy(css = "button[class=\"css-ksyb00 ezfki8j0\"]")
    public WebElement addLanguageButton;
    @FindBy(css = "input[id=\"react-select-25-input\"]")
    public WebElement skillsSelector;
    @FindBy(css = ".css-1u4hpl4 input")
    public WebElement uploadFile;
    @FindBy(css = "div[class=\"css-xdazuk e1eabgs55\"] b")
    public WebElement registeredEmail;

    @FindBy(css = "#work-experience-form div:nth-child(7) button:nth-child(2)")
    public WebElement getStartedButton;
}