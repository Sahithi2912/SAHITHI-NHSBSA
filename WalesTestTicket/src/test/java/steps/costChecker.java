package steps;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class costChecker {
    WebDriver driver = null;
    @Test
    public void openBrowser(String browser){
        if (browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "src//test//resources//geckodriver-v0.30.0-win64//geckodriver.exe");
            System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            driver = new FirefoxDriver();
        }
        if(browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver_win32//chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.navigate().to("https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next-button")));
    }
    public void clickNext(){
        driver.findElement(By.id("next-button")).click();
    }
    public void clickWales(){
        driver.findElement(By.id("radio-wales")).click();
    }
    public void clickYes(){
        driver.findElement(By.id("radio-yes")).click();
    }

    public void clickNo(){
        driver.findElement(By.id("radio-no")).click();
    }

    public void clickYesOrNo(String ans){
        if(ans.equals("Yes")){
            clickYes();
        }
        if(ans.equals("No")){
            clickNo();
        }
        clickNext();
    }

    public void registerGPNotInEngland(String gpReg){
        clickYesOrNo(gpReg);
    }

    public void dentalPracticeReg(String dpReg){
        if(dpReg.equals("Wales")){
            driver.findElement(By.id("radio-wales")).click();
        }
        if(dpReg.equals("Scotland")){
            driver.findElement(By.id("radio-scotland")).click();
        }
        if(dpReg.equals("England")){
            driver.findElement(By.id("radio-england")).click();
        }
        if(dpReg.equals("Northern Ireland")){
            driver.findElement(By.id("radio-ni")).click();
        }
        if(dpReg.equals("I am not registered")){
            driver.findElement(By.id("radio-not-registered")).click();
        }
        clickNext();
    }

    public void enterDOB(String day,String mnth,String yr){
        driver.findElement(By.id("dob-day")).sendKeys(day);
        driver.findElement(By.id("dob-month")).sendKeys(mnth);
        driver.findElement(By.id("dob-year")).sendKeys(yr);
        clickNext();
    }

    public void liveWithPartner(String lPartner){
        clickYesOrNo(lPartner);
    }

    public void youOrYourPernerCLaimBenefits(String ypcBenefits,String pregnancy,String iCaused,String diabetic,String glaucoma,String cHome, String hpcHome,String ypguCredit,String jpCredit,String cthPay,String hsip,String taxCredits,String IncomeSupp,String empSupAll,String jbAll,String pensionCredit,String nothing,String wtcCtc,String wtcDe,String wtc,String ctc,String incomeRelated,String contributionBased,String jincomeRelated,String jcontributionBased,String gc,String gcsc,String scmax){
        clickYesOrNo(ypcBenefits);
        if(ypcBenefits.equals("No")){
            pregnantInLastTwelveMonths(pregnancy);
            injuryOrIllnessCaused(iCaused);
            haveDiabetes(diabetic);
            haveGlaucoma(glaucoma);
            permanentlyInCareHome(cHome,hpcHome,hsip);
        }
        if(ypcBenefits.equals("Yes")){
            yourPartnerGetPaidUniversalCredit(ypguCredit,jpCredit,cthPay,pregnancy,iCaused,diabetic,glaucoma,cHome,hpcHome,hsip,taxCredits,IncomeSupp,empSupAll,jbAll,pensionCredit,nothing,wtcCtc,wtcDe,wtc,ctc,incomeRelated,contributionBased,jincomeRelated,jcontributionBased,gc,gcsc,scmax);
        }
    }

    public void yourPartnerGetPaidUniversalCredit(String ypguCredit,String jpCredit,String cthPay,String pregnancy,String iCaused,String diabetic,String glaucoma,String cHome,String hpcHome,String hsip,String taxCredits,String IncomeSupp,String empSupAll,String jbAll,String pensionCredit,String nothing,String wtcCtc,String wtcDe,String wtc,String ctc,String incomeRelated,String contributionBased,String jincomeRelated,String jcontributionBased,String gc,String gcsc,String scmax){
        if(ypguCredit.equals("Yes")){
            driver.findElement(By.id("yes-universal")).click();
            clickNext();
            jointUniversalCredit(jpCredit);
            combinedTakeHomePay(cthPay,pregnancy,iCaused,diabetic,glaucoma,cHome,hpcHome,hsip);
        }
        if(ypguCredit.equals("Applied")){
            driver.findElement(By.id("not-yet")).click();
            clickNext();
            clickNext();
            youOrYourPartnerGetBenefits(taxCredits,IncomeSupp,empSupAll,jbAll,pensionCredit,nothing,pregnancy,iCaused,diabetic,glaucoma,cHome,hpcHome,hsip,wtcCtc,wtcDe,wtc,ctc,cthPay,incomeRelated,contributionBased,jincomeRelated,jcontributionBased,gc,gcsc,scmax);
        }
        if(ypguCredit.equals("No")){
            driver.findElement(By.id("different-benefit")).click();
            clickNext();
            youOrYourPartnerGetBenefits(taxCredits,IncomeSupp,empSupAll,jbAll,pensionCredit,nothing,pregnancy,iCaused,diabetic,glaucoma,cHome,hpcHome,hsip,wtcCtc,wtcDe,wtc,ctc,cthPay,incomeRelated,contributionBased,jincomeRelated,jcontributionBased,gc,gcsc,scmax);

        }

    }

    public void jointUniversalCredit(String jpCredit){
        clickYesOrNo(jpCredit);
    }

    public void combinedTakeHomePay(String cthPay,String pregnancy,String iCaused,String diabetic,String glaucoma,String cHome,String hpcHome,String hsip){
        clickYesOrNo(cthPay);
        if(cthPay.equals("No")){
            pregnantInLastTwelveMonths(pregnancy);
            injuryOrIllnessCaused(iCaused);
            haveDiabetes(diabetic);
            haveGlaucoma(glaucoma);
            permanentlyInCareHome(cHome,hpcHome,hsip);
        }
    }

    public void pregnantInLastTwelveMonths(String pregnancy){
        clickYesOrNo(pregnancy);
    }

    public void injuryOrIllnessCaused(String iCaused){
        clickYesOrNo(iCaused);
    }

    public void haveDiabetes(String diabetic){
        clickYesOrNo(diabetic);
    }

    public void haveGlaucoma(String glaucoma){
        clickYesOrNo(glaucoma);
    }

    public void permanentlyInCareHome(String cHome,String hpcHome,String hsip){
        clickYesOrNo(cHome);
        if(cHome.equals("Yes")){
            helpToPayForCareHome(hpcHome,hsip);
        }
        if(cHome.equals("No")){
            haveSavingsInvestmentsProperty(hsip);
        }
    }

    public void helpToPayForCareHome(String hpcHome,String hsip){
        clickYesOrNo(hpcHome);
        if(hpcHome.equals("No")){
            haveSavingsInvestmentsProperty(hsip);
        }
    }

    public void haveSavingsInvestmentsProperty(String hsip){
        clickYesOrNo(hsip);
    }

    public void youOrYourPartnerGetBenefits(String taxCredits,String IncomeSupp,String empSupAll,String jbAll,String pensionCredit,String nothing,String pregnancy,String iCaused,String diabetic,String glaucoma,String cHome,String hpcHome,String hsip,String wtcCtc,String wtcDe,String wtc,String ctc,String cthPay,String incomeRelated,String contributionBased,String jincomeRelated,String jcontributionBased,String gc,String gcsc,String scmax){
        if(nothing.equals("Yes")){
            driver.findElement(By.id("continue")).click();
            clickNext();
            pregnantInLastTwelveMonths(pregnancy);
            injuryOrIllnessCaused(iCaused);
            haveDiabetes(diabetic);
            haveGlaucoma(glaucoma);
            permanentlyInCareHome(cHome,hpcHome,hsip);
        }
        if(IncomeSupp.equals("Yes")){
            driver.findElement(By.id("incSupport")).click();
            clickNext();
        }
        if(taxCredits.equals("Yes")){
            driver.findElement(By.id("taxCredit")).click();
            clickNext();
            typeOfTaxCreditsYouGet(wtcCtc,wtcDe,wtc,ctc,cthPay,pregnancy,iCaused,diabetic,glaucoma,cHome,hpcHome,hsip);
        }
        if(empSupAll.equals("Yes")){
            driver.findElement(By.id("esa")).click();
            clickNext();
            esaYouGet(incomeRelated,contributionBased,pregnancy,iCaused,diabetic,glaucoma,cHome,hpcHome,hsip);
        }
        if(jbAll.equals("Yes")) {
            driver.findElement(By.id("jsa")).click();
            clickNext();
            jsaYouGet(jincomeRelated,jcontributionBased,pregnancy,iCaused,diabetic,glaucoma,cHome,hpcHome,hsip);
        }
        if (pensionCredit.equals("Yes")) {
            driver.findElement(By.id("penCredit")).click();
            clickNext();
            pcYouGet(gc,gcsc,scmax,pregnancy,iCaused,diabetic,glaucoma,cHome,hpcHome,hsip);
        }
    }

    public void typeOfTaxCreditsYouGet(String wtcCtc,String wtcDe,String wtc,String ctc,String cthPay,String pregnancy,String iCaused,String diabetic,String glaucoma,String cHome,String hpcHome,String hsip){
        if (wtcCtc.equals("Yes")) {
            driver.findElement(By.id("workingChildTaxCredit")).click();
            clickNext();
            combinedTakeHomePay(cthPay, pregnancy, iCaused, diabetic, glaucoma, cHome, hpcHome, hsip);
        }
        if (wtcDe.equals("Yes")) {
            driver.findElement(By.id("workingDisabilityTaxCredit")).click();
            clickNext();
            combinedTakeHomePay(cthPay, pregnancy, iCaused, diabetic, glaucoma, cHome, hpcHome, hsip);
        }
        if (ctc.equals("Yes")) {
            driver.findElement(By.id("childTaxCredit")).click();
            clickNext();
            combinedTakeHomePay(cthPay, pregnancy, iCaused, diabetic, glaucoma, cHome, hpcHome, hsip);
        }
        if (wtc.equals("Yes")) {
            driver.findElement(By.id("workingTaxCredit")).click();
            clickNext();
            pregnantInLastTwelveMonths(pregnancy);
            injuryOrIllnessCaused(iCaused);
            haveDiabetes(diabetic);
            haveGlaucoma(glaucoma);
            permanentlyInCareHome(cHome, hpcHome, hsip);
        }
    }

    public void esaYouGet(String incomeRelated,String contributionBased,String pregnancy,String iCaused,String diabetic,String glaucoma,String cHome,String hpcHome,String hsip) {
        if (incomeRelated.equals("Yes")) {
            driver.findElement(By.id("income-esa")).click();
            clickNext();
        }
        if (contributionBased.equals("Yes")) {
            driver.findElement(By.id("contribution-esa")).click();
            clickNext();
            pregnantInLastTwelveMonths(pregnancy);
            injuryOrIllnessCaused(iCaused);
            haveDiabetes(diabetic);
            haveGlaucoma(glaucoma);
            permanentlyInCareHome(cHome, hpcHome, hsip);
        }
    }
        public void jsaYouGet (String jincomeRelated, String jcontributionBased, String pregnancy, String
        iCaused, String diabetic, String glaucoma, String cHome, String hpcHome, String hsip){
            if (jincomeRelated.equals("Yes")) {
                driver.findElement(By.id("income-jsa")).click();
                clickNext();
            }
            if (jcontributionBased.equals("Yes")) {
                driver.findElement(By.id("contbasejsa")).click();
                clickNext();
                pregnantInLastTwelveMonths(pregnancy);
                injuryOrIllnessCaused(iCaused);
                haveDiabetes(diabetic);
                haveGlaucoma(glaucoma);
                permanentlyInCareHome(cHome, hpcHome, hsip);
            }
        }

        public void pcYouGet (String gc, String gcsc, String scmax, String pregnancy, String iCaused, String
        diabetic, String glaucoma, String cHome, String hpcHome, String hsip){
            if (gc.equals("Yes")) {
                driver.findElement(By.id("guaranteecreditonly")).click();
                clickNext();
            }
            if (gcsc.equals("Yes")) {
                driver.findElement(By.id("guaranteecreditwithsavingcredit")).click();
                clickNext();
            }
            if (scmax.equals("Yes")) {
                driver.findElement(By.id("savingcredit")).click();
                clickNext();
                pregnantInLastTwelveMonths(pregnancy);
                injuryOrIllnessCaused(iCaused);
                haveDiabetes(diabetic);
                haveGlaucoma(glaucoma);
                permanentlyInCareHome(cHome, hpcHome, hsip);
            }
        }
    public void validateResult() throws InterruptedException{
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        if(driver.findElement(By.xpath("//span[@class='heading-secondary']")).isDisplayed()) {
            String result =  driver.findElement(By.xpath("//h1[@class='heading-large']")).getText();
            System.out.println(result);
        }
        //driver.close();
        driver.quit();
    }
}
