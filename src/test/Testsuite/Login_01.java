import PageObjectModel.ObjectRepository;
import PageObjectModel.preCondition;
import Pages.Login;
import org.testng.annotations.Test;


/**
 * created by : Sandeep Duve
 * crated at: 11:42 PM: 30-9-2018
 */

public class Login_01 extends preCondition
{
    @Test(priority = 1, description = "Login Test on FreeCRM.com")
    public void loginTest()
    {
        Login login = new Login(driver); // instantiated of login page.
        login.loginAs(ObjectRepository.username, ObjectRepository.password); // method of login
        login.verifyLogin(); // verification of login via validating logout btn.
    }
}
