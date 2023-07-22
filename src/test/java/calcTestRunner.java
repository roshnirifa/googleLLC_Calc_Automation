import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class calcTestRunner extends setup {
    calculatorScreen calcScreen;
    @Test(priority = 1, description = "Do series 100/10*5-10+60")
    public void doSeries() throws InterruptedException {
        calcScreen = new calculatorScreen(driver);
        Thread.sleep(1000);
        String res = calcScreen.calculateSeries("100/10*5-10+60");
        Assert.assertTrue(res.contains("100"));
    }
    @Test(priority = 2, description = "Do series 50+10-20*2+10/2")
    public void doSeries2() throws InterruptedException {
        calcScreen = new calculatorScreen(driver);
        Thread.sleep(1000);
        String res = calcScreen.calculateSeries("50+10-20*2+10/2");
        Assert.assertTrue(res.contains("25"));
        Thread.sleep(1000);
    }

    //@Test(priority = 1, description = "Do sum")
//    public void doSum() {
//        calcScreen = new calculatorScreen(driver);
//        String res = calcScreen.dosum();
//        Assert.assertTrue(res.contains("6"));
//    }



    @AfterMethod
    public void CalcScreen() {
        calcScreen = new calculatorScreen(driver);
        calcScreen.clearScreen();
    }
}
