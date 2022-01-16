package cucumberJava;

import steps.costChecker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;
import java.util.Map;


public class costsChecker {

    costChecker costchecker = new costChecker();
    @Given("^am a person from Wales$")
    public void openBrowser(DataTable browsers) {
        List<Map<String,String>> data = browsers.asMaps(String.class,String.class);
        String browser = data.get(0).get("Browser");
        costchecker.openBrowser(browser);

    }

    @When("^I put my circumstances into the Checker tool$")
    public void checkForNHSCosts(DataTable circumstances) throws InterruptedException {
        List<Map<String,String>> data = circumstances.asMaps(String.class,String.class);
        String gpReg = data.get(0).get("RegisterGPNotInEngland");
        String dpReg = data.get(0).get("DentalPracticeReg");
        String day = data.get(0).get("Day");
        String mnth = data.get(0).get("Month");
        String yr = data.get(0).get("Year");
        String lPatrner = data.get(0).get("LiveWithPartner");
        String ypcBenefits = data.get(0).get("YouOrYourPernerCLaimBenefits");
        String pregnancy = data.get(0).get("pregnantInLastTwelveMonths");
        String iCaused = data.get(0).get("InjuryOrIllnessCaused");
        String diabetic = data.get(0).get("HaveDiabetes");
        String glaucoma = data.get(0).get("HaveGlaucoma");
        String cHome = data.get(0).get("PermanentlyInCareHome");
        String hpcHome = data.get(0).get("HelpToPayForCareHome");
        String ypguCredit = data.get(0).get("YourPartnerGetUniversalCredit");
        String jpCredit = data.get(0).get("JointUniversalCredit");
        String cthPay = data.get(0).get("CombinedTakeHomePay");
        String hsip = data.get(0).get("HaveSavingsInvestmentsProperty");
        String taxCredits= data.get(0).get("TaxCredits");
        String IncomeSupp= data.get(0).get("IncomeSupp");
        String empSupAll= data.get(0).get("EmployeeSupportAllowance");
        String jbAll= data.get(0).get("JobSeekerAllowance");
        String pensionCredit= data.get(0).get("PersonalCredits");
        String nothing= data.get(0).get("NoWeDontGetAny");
        String wtcCtc= data.get(0).get("WorkTaxAndChildTaxCredit");
        String wtcDe= data.get(0).get("WorkTaxDisabilityElement");
        String wtc= data.get(0).get("WorkTaxCredit");
        String ctc= data.get(0).get("ChildTaxCredit");
        String incomeRelated= data.get(0).get("IncomeRelatedESA");
        String contributionBased= data.get(0).get("ContributionBasedESA");
        String jincomeRelated= data.get(0).get("IncomeRelatedJSA");
        String jcontributionBased= data.get(0).get("ContributionBasedJSA");
        String gc= data.get(0).get("GuaranteeCredit");
        String gcsc= data.get(0).get("GuaranteeAndSavingsCredit");
        String scmax = data.get(0).get("SavingsCreditMax");

        costchecker.clickNext();
        costchecker.clickWales();
        costchecker.clickNext();
        costchecker.registerGPNotInEngland(gpReg);
        costchecker.dentalPracticeReg(dpReg);
        costchecker.enterDOB(day,mnth,yr);
        costchecker.liveWithPartner(lPatrner);
        costchecker.youOrYourPernerCLaimBenefits(ypcBenefits,pregnancy,iCaused,diabetic,glaucoma,cHome,hpcHome,ypguCredit,jpCredit,cthPay,hsip,taxCredits,IncomeSupp,empSupAll,jbAll,pensionCredit,nothing,wtcCtc,wtcDe,wtc,ctc,incomeRelated,contributionBased,jincomeRelated,jcontributionBased,gc,gcsc,scmax);

    }

    @Then("^I should get a result of whether I will get help or not$")
    public void eligibilityResult() throws InterruptedException {
        costchecker.validateResult();
    }
}
