package MovieClip.Tests;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import MovieClip.CommanMethod.AppiumBaseClass;
import MovieClip.CommanMethod.AppiumController;
import org.testng.annotations.Test;

public class BaseTestClass extends AppiumBaseClass{
  // LandingScreen landingscreen;
  // SignUpScreen signupscreen;
   
    @BeforeSuite
    public void setUp() throws Exception {
        AppiumController.instance.start();
        switch (AppiumController.executionOS) {
            case ANDROID:
              System.out.print("Launch is successful");
//              landingscreen = new LandingScreenAndroid(driver());
//              signupscreen=new SignUpScreenAndroid(driver());
//
				break;
            case IOS:
           // 	landingscreen = new LandingScreenIos(driver());
           // 	signupscreen=new SignUpScreenIos(driver());
                System.out.print("Launch successful");
                break;
        }
    }

    @Test
            public void test1(){
        System.out.print("Launch successful");
    }


    @AfterSuite
    public void tearDown() {
        AppiumController.instance.stop();
    }
}
