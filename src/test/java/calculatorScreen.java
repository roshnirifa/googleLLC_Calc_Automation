import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class calculatorScreen {
    @FindBy(id="com.google.android.calculator:id/digit_1")
    WebElement btn1;
    @FindBy(id="com.google.android.calculator:id/digit_0")
    WebElement btn0;
    @FindBy(id="com.google.android.calculator:id/digit_5")
    WebElement btn5;
    @FindBy(id="com.google.android.calculator:id/digit_6")
    WebElement btn6;
    @FindBy(id="com.google.android.calculator:id/op_add")
    WebElement btnPlus;
    @FindBy(id="com.google.android.calculator:id/op_sub")
    WebElement btnMinus;
    @FindBy(id="com.google.android.calculator:id/op_mul")
    WebElement btnMultiply;
    @FindBy(id="com.google.android.calculator:id/op_div")
    WebElement btnDivision;
    @FindBy(id="com.google.android.calculator:id/eq")
    WebElement btnEqual;

    @FindBy(id="com.google.android.calculator:id/clr")
    WebElement btnAc;

    @FindBy(id = "com.google.android.calculator:id/result_final")
    WebElement textResult;
    AndroidDriver driver;
    public calculatorScreen(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public String calculateSeries(String series){
        for(int i = 0; i < series.length(); i++){
            if(series.charAt(i) == '+'){
                driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
            }
            else if(series.charAt(i) == '-'){
                driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
            }
            else if (series.charAt(i) == '*') {
                driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
            }
            else if (series.charAt(i) == '/') {
                driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
            }
            else {
                driver.findElement(By.id("com.google.android.calculator:id/digit_"+series.charAt(i)+"")).click();
            }
        }
        btnEqual.click();
        return textResult.getText();
    }

    //    public String calculateSeries(){
//        btn1.click();
//        btnPlus.click();
//        btn5.click();
//        btnEqual.click();
//        return  textResult.getText();
//    }


//    public String dosum(int a, int b){
//        driver.findElement(By.id("com.google.android.calculator:id/digit_"+a+"")).click();
//        btnPlus.click();
//        driver.findElement(By.id("com.google.android.calculator:id/digit_"+b+"")).click();
//        btnEqual.click();
//        return  textResult.getText();
//    }


    public void clearScreen(){
        btnAc.click();
    }
}





