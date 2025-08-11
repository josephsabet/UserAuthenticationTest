import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserAuthenticationTest {
    UserAuthentication auth = new UserAuthentication();
    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"admin", "password123", true},      // valid 
                {"admin", "wrongpass", false},       // wrong password
                {"user", "password123", false},      // wrong username
                {"", "password123", false},          // empty username
                {"admin", "", false},                // empty password
                {null, "password123", false},        // null username
                {"admin", null, false},              // null password
                {null, null, false}                   // both null
        };
    }

    @Test(dataProvider = "loginData")
    public void testAuthentication(String username, String password, boolean expected) {
        boolean actual = false;

        try {	
            actual = auth.authenticate(username, password);
        } catch (NullPointerException e) {
            actual = false;
        }

        Assert.assertEquals(actual, expected,
                "Authentication result for [" + username + " / " + password + "] is incorrect.");
    }
}
