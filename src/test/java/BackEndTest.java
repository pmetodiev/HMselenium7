import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.jvm.hotspot.utilities.soql.JSJavaScriptEngine;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.security.AuthProvider;

public class BackEndTest {


    @BeforeMethod
    public void setUp() throws IOException {
        FileChannel BrowserActions = null;
        BrowserActions.open(Path.of("chrome"));
    }

    @Test
    public void successfullyCanLogInAsAdminUsingValidCredentials() throws LoginException {
        BackEndMain.goTo();
        BackEndMain.login("admin", "parola123!");
        CommonVerifications.verifyTitle("Dashboard", "The expected title is not matching the acutal one!");
        AuthProvider AdminHeaderPage = null;
        AdminHeaderPage.logout();
    }

    @AfterMethod
    public void tearDown() {
        JSJavaScriptEngine BrowserActions = null;
        //BrowserActions.quit();
    }

}
