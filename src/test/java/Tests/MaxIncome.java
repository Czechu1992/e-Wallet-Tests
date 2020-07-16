package Tests;

import Config.TestConfig;
import Page.AplicationPage;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxIncome extends TestConfig {

    @Test
    public void maxIncomeTest(){
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
        if (amountsArr[amountsArr.length - 1] % 1 == 0) {
            maxAmount = ((int) amountsArr[amountsArr.length - 1]) + "";
        } else {
            maxAmount = amountsArr[amountsArr.length - 1] + "";
        }


        AplicationPage test = new AplicationPage();
        test.openTransactionForm();
        test.incomeFillNewTransactionForm(name1,amount1,category1);
        test.saveForm();
        test.openTransactionForm();
        test.incomeFillNewTransactionForm(name2,amount2,category2);
        test.saveForm();
        test.openTransactionForm();
        test.incomeFillNewTransactionForm(name3,amount3,category3);
        test.saveForm();
        test.checkMaxIncome(maxAmount);

    }
}
