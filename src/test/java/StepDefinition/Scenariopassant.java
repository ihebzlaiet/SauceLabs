package StepDefinition;

import PageFactory.ChecPage;
import PageFactory.HomePage;
import PageFactory.LoginPage;
import Utils.ConfigReader;
import Utils.ElementUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Scenariopassant {
    WebDriver driver;
    LoginPage Login ;
    HomePage Home ;
    ChecPage Check ;
    ElementUtil Element ;
    Properties prop ;
    ConfigReader site ;
    @Given("Je me rends sur le site SwagLabs")
    public void je_me_rends_sur_le_site_swag_labs() {
        site=new ConfigReader() ;
        prop=site.ConfigurationManager();
        driver= new ChromeDriver();
        driver.get(site.GetURL());
        driver.manage().window().maximize();

    }


    @When("Je saisie le username")
    public void je_saisie_le_username() {

        Login=new LoginPage(driver);
        Login.setUsername(site.Getusername());

    }


    @And("Je saisie le password")
    public void je_saisie_le_password() {
        Login.setPassword(site.GetPassword());

    }


    @And("Je clique sur le bouton Login")
    public void je_clique_sur_le_bouton_login() {

         Login.setLogin();
    }


    @Then("La page des produit s affichent")
    public void la_page_des_produit_s_affichent() {

        Element=new ElementUtil(driver);
        Element.confirmation("https://www.saucedemo.com/inventory.html");

    }


    @When("Je clique sur le bouton Add to cart du produit BackPack")
    public void je_clique_sur_le_bouton_add_to_cart_du_produit_back_pack() {
          Home=new HomePage(driver) ;
          Home.setAddSLback();
    }


    @And("Je clique sur le bouton Add to cart du produit T-Shirt")
    public void je_clique_sur_le_bouton_add_to_cart_du_produit_t_shirt() {
                   Home.setAddSLBSh();
    }


    @Then("Les produit s ajoutent dans le panier")
    public void les_produit_s_ajoutent_dans_le_panier() {
        Element=new ElementUtil(driver);
           Element.validation("Remove");

    }


    @When("Je clique sur l icone panier")
    public void je_clique_sur_l_icone_panier() {

        Home.setChariot();
    }


    @When("Je clique sur le bouton remove")
    public void je_clique_sur_le_bouton_remove() {

        Check= new ChecPage(driver) ;
        Check.setRemove1();
        Check.setRemove2();
    }

    @Then("Le produit sera supprimé du panier")
    public void le_produit_sera_supprimé_du_panier() {
        Element=new ElementUtil(driver);
        Element.validation("Sauce Labs Bolt T-Shirt");
    }


    @When("Je clique sur le bouton checkout")
    public void je_clique_sur_le_bouton_checkout() {
        Check= new ChecPage(driver) ;
        Check.setCheckout();
    }


    @When("Je rempli le username")
    public void je_rempli_le_username() {
     Check.setFname("Iheb");

    }
    @When("Je saisie le lastname")
    public void je_saisie_le_lastname() {

        Check.setLname("Zlaiet");
    }


    @When("Je saisie le code postal")
    public void je_saisie_le_code_postal() {

        Check.setZip("2035");
    }


    @When("je clique sur le bouton continue")
    public void je_clique_sur_le_bouton_continue() {
Check.setContinuee();
    }


    @Then("une page overview s affiche")
    public void une_page_overview_s_affiche() {
        Element=new ElementUtil(driver);
        Element.validation("Checkout: Overview");
    }


    @When("je clique sur le bouton finish")
    public void je_clique_sur_le_bouton_finish() {
Check.setFinish();
    }



    @Then("une page Checkout:Complete s affiche")
    public void une_page_checkout_complete_s_affiche() {

        Element.validation("Checkout: Complete!");
    }


    @When("Je clique sur le menu burger")
    public void je_clique_sur_le_menu_burger() {
        Home=new HomePage(driver) ;
        Home.setMenu();
    }

    @When("Je clique surle bouton Logout")
    public void je_clique_surle_bouton_logout() {
        Home.setLogout();
    }

    @Then("Je me redirige vers la page d authentification Swag Labs")
    public void je_me_redirige_vers_la_page_d_authentification() {

        Element=new ElementUtil(driver);
       Element.validation("Swag Labs");
    }

}
