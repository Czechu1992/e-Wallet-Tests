package Tests;

import Config.TestConfig;
import Page.AplicationPage;
import org.testng.annotations.Test;

public class AverageIncomeTest extends TestConfig {

    @Test
    public void averageIncomeTest() {

        String name1 = "Nagroda";
        String amount1 = "400";
        String category1 = "nobel";

        String name2 = "Na rower";
        String amount2 = "800";
        String category2 = "credit";

        String name3 = "Z imprezy urodzinowej";
        String amount3 = "40";
        String category3 = "bottle";


        double amountResult = (Double.parseDouble(amount1) + Double.parseDouble(amount2) + Double.parseDouble(amount3))/3;
        String finalAmount = "" + Math.round(amountResult * 100.0) / 100.0;

        AplicationPage test = new AplicationPage();
        test.openTransactionForm()
        .incomeFillNewTransactionForm(name1, amount1, category1)
        .saveForm()
        .openTransactionForm()
        .incomeFillNewTransactionForm(name2, amount2, category2)
        .saveForm()
        .openTransactionForm()
        .incomeFillNewTransactionForm(name3, amount3, category3)
        .saveForm()
        .checkAverageIncome(finalAmount);
    }
}
