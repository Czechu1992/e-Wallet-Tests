package Tests;

import Config.TestConfig;
import Page.AplicationPage;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MinIncome extends TestConfig {

    @Test
    public void minIncomeTest() {
        String name1 = "Nagroda";
        String amount1 = "400";
        String category1 = "nobel";

        String name2 = "Na rower";
        String amount2 = "800";
        String category2 = "credit";

        String name3 = "Z imprezy urodzinowej";
        String amount3 = "40";
        String category3 = "bottle";

        double[] amountsArr = {Double.parseDouble(amount1), Double.parseDouble(amount2), Double.parseDouble(amount3)};
        Arrays.sort(amountsArr);
        String maxAmount;
        if (amountsArr[0] % 1 == 0) {
            maxAmount = (int) amountsArr[0] + "";
        } else {
            maxAmount = amountsArr[0] + "";
        }

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
                .checkMinIncome(maxAmount);
    }
}
