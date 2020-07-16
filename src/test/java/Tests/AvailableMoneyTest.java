package Tests;

import Config.TestConfig;
import Page.AplicationPage;
import org.testng.annotations.Test;

public class AvailableMoneyTest extends TestConfig {

    @Test
    public void availableMoneyTest() {
        String name1 = "Nagroda";
        String amount1 = "400";
        String category1 = "nobel";

        String name2 = "Pizza na impreze";
        String amount2 = "80";
        String category2 = "food";

        String name3 = "Z imprezy xD";
        String amount3 = "20";
        String category3 = "bottle";

        int amountResult = Integer.parseInt(amount1) - Integer.parseInt(amount2) + Integer.parseInt(amount3);
        String finalAmount = "" + amountResult;

        AplicationPage test = new AplicationPage();
        test.openTransactionForm();
        test.incomeFillNewTransactionForm(name1, amount1, category1);
        test.saveForm();
        test.openTransactionForm();
        test.expensesFillNewTransactionForm(name2, amount2, category2);
        test.saveForm();
        test.openTransactionForm();
        test.incomeFillNewTransactionForm(name3, amount3, category3);
        test.saveForm();
        test.chechAvailebleMoney(finalAmount);
    }
}