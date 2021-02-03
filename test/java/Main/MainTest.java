package Main;

import Resources.Strings;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MainTest {
    private AndroidDriver<AndroidElement> android_driver;       // The Android Driver Instance, for interacting directly with the app
    private MobileElement an_element_on_screen;          // An Element on App´s screen
    
    public MainTest() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();    // First create a "DesiredCapabilities" to target the app we want to test, on the device we want to test
        // Set the Search Infos to locate the app 
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Device has the name "emulator-5554"
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "net.ludeke.calculator");      // The calculator app 
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");  
        // All the Infos of the target are now available --> Start searching for this target through the Appium Server
        // The device is connected with Appium Server
        // 127.0.0.1 = 'localhost' | Port = 4723
        android_driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        
        // Wait a moment for the target to react and for the connection to stabilize!
        android_driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
   
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        delete_screen();
    }
    
    @AfterEach
    public void tearDown() {
        delete_screen();
    }

    private void delete_screen(){
        String what_on_screen = android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText();
        System.out.println(what_on_screen);
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DELETE_BUTTON_PATH);
        for(int i = 0; i < what_on_screen.length(); i++){        
            an_element_on_screen.click();
        }
    }
    
    
    
    // 4.1.1: UI-Test
    
    // 4.1.1.1: Soll: "Die Ziffern + arithmetische Buttons sollten beim Tippen richtig auf der UI angezeigt werden"
    // 4.1.1.1 - Testziel 1: Abdeckung aller vorhandenen Buttons auf der UI

    @Test
    public void test_button_9(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_9_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "9");
    }
    
    @Test
    public void test_button_8(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_8_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "8");
    }
    
    @Test
    public void test_button_7(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_7_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "7");
    }
    
    @Test
    public void test_button_6(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_6_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "6");
    }
    
    @Test
    public void test_button_5(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_5_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "5");
    }
    
    @Test
    public void test_button_4(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_4_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "4");
    }
    
    @Test
    public void test_button_3(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_3_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "3");
    }
    
    @Test
    public void test_button_2(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "2");
    }
    
    @Test
    public void test_button_1(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_1_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "1");
    }
    
    @Test
    public void test_button_0(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_0_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "0");
    }
    
    @Test
    public void test_button_Punkt(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.POINT_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), Strings.TEXT_OF_POINT_BUTTON_ON_UI);
    }
    
    @Test
    public void test_button_Plus(){
        // 6+
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_6_PATH);
        an_element_on_screen.click();   // Digit 6
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.PLUS_BUTTON_PATH);
        an_element_on_screen.click();   // The "+"
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "6" + Strings.TEXT_OF_PLUS_BUTTON_ON_UI);
    }
    
    @Test
    public void test_button_Minus(){
        // 3-
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_3_PATH);
        an_element_on_screen.click();   // Digit 3
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MINUS_BUTTON_PATH);
        an_element_on_screen.click();   // The "-"
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "3" + Strings.MINUS_BUTTON_PATH);
    }
    
    @Test
    public void test_button_Multiply(){
        // 2x
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();   // Digit 2
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MULTIPLY_BUTTON_PATH);
        an_element_on_screen.click();   // The "x"
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "2" + Strings.MULTIPLY_BUTTON_PATH);
    }

    @Test
    public void test_button_Divide(){
        // 2/
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();   // Digit 2
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DIVIDE_BUTTON_PATH);
        an_element_on_screen.click();   // The "/"
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "2" + Strings.TEXT_OF_DIVIDE_BUTTON_ON_UI);
    } 
    
    
    
     
    // 4.1.1.1 - Testziel 2: Testen mit Eingabe von Zahlen mit mehreren Zieffern ( >= 2 )

    @Test
    public void test_2_digits(){
        // Number 92
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_9_PATH);
        an_element_on_screen.click();
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "92");
    }
    
    @Test
    public void test_3_digits(){
        // Number 892
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_8_PATH);
        an_element_on_screen.click();
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_9_PATH);
        an_element_on_screen.click();
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "892");
    }
    
    @Test
    public void test_10_digits(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_7_PATH);
        for(int i = 0; i < 10; i++){
            an_element_on_screen.click();
        }
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "7777777777");
    }
    
    
    
    
    // 4.1.1.2: Soll: ""Delete" Button sollte die Eingaben entfernen"
    
    // 4.1.1.2 - Testziel 1: Testen von einmaliger Wirkung von "Delete"
    @Test
    public void test_delete_with_one_positive_digit(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_6_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "6");
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DELETE_BUTTON_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "");
    }
    
    @Test
    public void test_delete_with_one_negative_digit(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MINUS_BUTTON_PATH);
        an_element_on_screen.click();
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_6_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), Strings.TEXT_OF_MINUS_BUTTON_ON_UI + "6");
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DELETE_BUTTON_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), Strings.TEXT_OF_MINUS_BUTTON_ON_UI);
    }
    
    
    
    // 4.1.1.2 - Testziel 2: Testen von mehrmaliger Wirkung von "Delete"
    
    @Test
    public void test_delete_with_two_digits(){
        for(int i = 0; i < 2; i++){
            an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_6_PATH);
            an_element_on_screen.click();
        }
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "66");
        for(int j = 0; j < 2; j++){
            an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DELETE_BUTTON_PATH);
            an_element_on_screen.click();
        }
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "");
    }
    
    @Test
    public void test_delete_with_more_than_two_digits(){
        int random_number_of_digits = new Random().nextInt(8) + 3; 
        StringBuilder a_string_to_compare = new StringBuilder();
        for(int i = 0; i < random_number_of_digits; i++){
            an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_6_PATH);
            an_element_on_screen.click();
            a_string_to_compare.append(6);
        }
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), a_string_to_compare.toString());
        for(int j = 0; j < random_number_of_digits; j++){
            an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DELETE_BUTTON_PATH);
            an_element_on_screen.click();
        }
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "");
    }
    
    
    

    // 4.1.1.2 - Testziel 3: Testen der Wirkung von "CLR" (nach einer arithmetischen Operation)
    @Test
    public void test_CLR_with_a_math_operation(){
        for(int i = 0; i < 2; i++){
            // The number 66
            an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_6_PATH);
            an_element_on_screen.click();
        }
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.PLUS_BUTTON_PATH);
        an_element_on_screen.click();   // The "+"
        // Another 6
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_6_PATH);
        an_element_on_screen.click();
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        
        // Result should be 72
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "72");
        // The "CLR"
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.CLR_BUTTON_PATH);
        an_element_on_screen.click();
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "");
    }
    
    
    
    
    // 4.1.1.3 - Soll: "Bei Fließkommazahldarstellung: der "." sollte gut sichtbar angezeigt werden"
    // Dieser Test sollte bereits durch Test 4.1.1.1 , Testziel 1 + 2 abgedeckt sein --> entfällt!
    
    
    
    
    
    
    
    
    
    // 4.1.2 "arithmetische Operationen" Test
    // 4.1.2.1 - Testziel 1: Ergebnis von der Addition einer "+" positiven ganzen Zahl mit einer "+" ganzen Zahl
    
    @Test
    public void test_addition_positive_integer_with_positive_integer(){
        for(int i = 0; i < 2; i++){
            // The number 66
            an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_6_PATH);
            an_element_on_screen.click();
        }
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.PLUS_BUTTON_PATH);
        an_element_on_screen.click();   // The "+"
        // Another 6
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_6_PATH);
        an_element_on_screen.click();
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        
        // Result should be 72
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "72");
    }
    

    
    
    // 4.1.2.1 - Testziel 2: Ergebnis von der Addition einer "+" positiven ganzen Zahl mit einer "-" negativen ganzen Zahl
    
    @Test
    public void test_addition_positive_integer_with_negative_integer(){
        for(int i = 0; i < 2; i++){
            // The number 66
            an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_6_PATH);
            an_element_on_screen.click();
        }
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.PLUS_BUTTON_PATH);
        an_element_on_screen.click();   // The "+"
        // Number -6
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MINUS_BUTTON_PATH);
        an_element_on_screen.click();   // The "-"
        
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_6_PATH);
        an_element_on_screen.click();
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        
        // Result should be 60
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "60");
    }
    
    
   
    
    // 4.1.2.1 - Testziel 3: Ergebnis von der Addition einer "-" negativen ganzen Zahl mit einer "-" ganzen Zahl
    
    @Test
    public void test_addition_negative_integer_with_negative_integer(){
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MINUS_BUTTON_PATH);
        an_element_on_screen.click();   // The "-"
        for(int i = 0; i < 2; i++){
            // The number -66
            an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_6_PATH);
            an_element_on_screen.click();
        }
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.PLUS_BUTTON_PATH);
        an_element_on_screen.click();   // The "+"
        // Number -6
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MINUS_BUTTON_PATH);
        an_element_on_screen.click();   // The "-"
        
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_6_PATH);
        an_element_on_screen.click();
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        
        // Result should be -72
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), Strings.TEXT_OF_MINUS_BUTTON_ON_UI + "72");
    }
    

    
    // 4.1.2.1 - Testziel 4: Ergebnis von der Addition einer Fließkommazahl (positiv oder negativ) mit einer ganzen Zahl (positiv oder negativ)
    
    @Test
    public void test_addition_floating_point_with_integer(){
        // 7.5 + 3
        // Number 7.5
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_7_PATH);
        an_element_on_screen.click();   
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.POINT_PATH);
        an_element_on_screen.click();
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_5_PATH);
        an_element_on_screen.click();
        // The "+"
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.PLUS_BUTTON_PATH);
        an_element_on_screen.click();   
        // Number 3
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_3_PATH);
        an_element_on_screen.click();
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        // Result should be 10.5
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "10 " + Strings.TEXT_OF_POINT_BUTTON_ON_UI +" 5");
    }
    
    
    
    
    
    
    // 4.1.2.2 -  Soll: die "-" : es sollte ein richtiges Ergebnis herauskommen nach dem Eingeben der Operation + Tippen des "=" Buttons
    
    @Test
    public void test_subtraction_1(){
        // 5-7
        // Number 5
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_5_PATH);
        an_element_on_screen.click();   
        // The "-"
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MINUS_BUTTON_PATH);
        an_element_on_screen.click();   
        // Number 7
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_7_PATH);
        an_element_on_screen.click();
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        // Result should be -2
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), Strings.TEXT_OF_MINUS_BUTTON_ON_UI + "2");
    }
    

    
    
 
    // 4.1.2.3 Soll: die "x" : es sollte ein richtiges Ergebnis herauskommen nach dem Eingeben der Operation + Tippen des "=" Buttons
    @Test
    public void test_multiplcation_1(){
        // 2.5 * (-2)
        // Number 2.5
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();   
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.POINT_PATH);
        an_element_on_screen.click(); 
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_5_PATH);
        an_element_on_screen.click(); 
        // The "x"
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MULTIPLY_BUTTON_PATH);
        an_element_on_screen.click();   
        // Number -2
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MINUS_BUTTON_PATH);
        an_element_on_screen.click();   
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();  
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        // Result should be -5
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), Strings.MINUS_BUTTON_PATH + "5");
    }
    
    
    
    
    
    
    
    // 4.1.2.4 Soll: die "/" : es sollte ein richtiges Ergebnis herauskommen nach dem Eingeben der Operation + Tippen des "=" Buttons
    
    // 4.1.2.4 - Testziel 1: Dividend positiv, Divisor positiv 
    @Test
    public void test_division_1(){
        // (2 / 5)
        // Number 2
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();   
        // The "/"
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DIVIDE_BUTTON_PATH);
        an_element_on_screen.click();   
        // Number 5 
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_5_PATH);
        an_element_on_screen.click();   
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        // Result should be 0.4
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "0 " + Strings.TEXT_OF_POINT_BUTTON_ON_UI + " 4");
    }
    
    
    
    // 4.1.2.4 - Testziel 2: Dividend positiv, Divisor = 0 
    @Test
    public void test_division_2(){
        // (2 / 0)
        // Number 2
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();     
        // The "/"
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DIVIDE_BUTTON_PATH);
        an_element_on_screen.click();    
        // Number 0
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_0_PATH);
        an_element_on_screen.click();   
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        // Result should be positive infinity 
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), Strings.TEXT_OF_INFINITY_ON_UI);
    }
    
    
    
    
    // 4.1.2.4 - Testziel 3: Dividend positiv, Divisor negativ
    @Test
    public void test_division_3(){
        // (2 / -2)
        // Number 2
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();     
        // The "/"
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DIVIDE_BUTTON_PATH);
        an_element_on_screen.click();     
        // Number -2
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MINUS_BUTTON_PATH);
        an_element_on_screen.click();   
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();     
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        // Result should be -1
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), Strings.TEXT_OF_MINUS_BUTTON_ON_UI + "1");
    }
    
    
      
    
    // 4.1.2.4 - Testziel 4: Dividend = 0, Divisor positiv 
    @Test
    public void test_division_4(){
        // (0 / 2)
        // Number 0
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_0_PATH);
        an_element_on_screen.click();  
        // The "/"
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DIVIDE_BUTTON_PATH);
        an_element_on_screen.click();    
        // Number 2
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();  
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        // Result should be 0
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "0");
    }
    
    

    
    // 4.1.2.4 - Testziel 5: Dividend = 0, Divisor = 0
    @Test
    public void test_division_5(){
        // (0 / 0)
        // Number 0
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_0_PATH);
        an_element_on_screen.click();  
        // The "/"
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DIVIDE_BUTTON_PATH);
        an_element_on_screen.click();   
        // Number 0
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_0_PATH);
        an_element_on_screen.click();  
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        // Result should be NaN
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), Strings.TEXT_OF_NaN_ON_UI);
    }
    
    
    
    
    // 4.1.2.4 - Testziel 6: Dividend = 0, Divisor negativ
    @Test
    public void test_division_6(){
        // (0 / -2)
        // Number 0
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_0_PATH);
        an_element_on_screen.click();    
        // The "/"
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DIVIDE_BUTTON_PATH);
        an_element_on_screen.click();   
        // Number -2
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MINUS_BUTTON_PATH);
        an_element_on_screen.click();   
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();  
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        // Result should be 0
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "0");
    }
    
    
    
    // 4.1.2.4 - Testziel 7: Dividend negativ, Divisor positiv
    @Test
    public void test_division_7(){
        // (-2 / 2)
        // Number -2
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MINUS_BUTTON_PATH);
        an_element_on_screen.click();   
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();     
        // The "/"
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DIVIDE_BUTTON_PATH);
        an_element_on_screen.click();   
        // Number 2
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();   
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        // Result should be -1
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), Strings.TEXT_OF_MINUS_BUTTON_ON_UI + "1");
    }
    
    
    
    // 4.1.2.4 - Testziel 8: Dividend negativ, Divisor = 0
    @Test
    public void test_division_8(){
        // (-2 / 0)
        // Number -2
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MINUS_BUTTON_PATH);
        an_element_on_screen.click();   
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();    
        // The "/"
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DIVIDE_BUTTON_PATH);
        an_element_on_screen.click();   
        // Number 0
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_0_PATH);
        an_element_on_screen.click();  
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        // Result should be - Infinity 
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), Strings.TEXT_OF_MINUS_BUTTON_ON_UI + Strings.TEXT_OF_INFINITY_ON_UI);
    }
    
    
    
    // 4.1.2.4 - Testziel 9: Dividend negativ, Divisor negativ
    @Test
    public void test_division_9(){
        // (-2 / -3)
        // Number -2
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MINUS_BUTTON_PATH);
        an_element_on_screen.click();   
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_2_PATH);
        an_element_on_screen.click();    
        // The "/"
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.DIVIDE_BUTTON_PATH);
        an_element_on_screen.click();  
        // Number -3
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.MINUS_BUTTON_PATH);
        an_element_on_screen.click();  
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.BUTTON_3_PATH);
        an_element_on_screen.click(); 
        // The "="
        an_element_on_screen = (MobileElement) android_driver.findElementByXPath(Strings.EQUAL_BUTTON_PATH);
        an_element_on_screen.click();
        // Result should be 0.666667
        assertEquals(android_driver.findElementByClassName(Strings.DISPLAY_CLASSNAME).getText(), "0 " + Strings.TEXT_OF_POINT_BUTTON_ON_UI + " 666667");
    }
}
