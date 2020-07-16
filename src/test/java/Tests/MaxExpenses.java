package Tests;

import Config.TestConfig;
import Page.AplicationPage;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MaxExpenses extends TestConfig {
    @Test
    public void maxExpensesTest() {

        String name1 = "Zapa";
        String amount1 = "80";
        String category1 = "food";

        String name2 = "rachgunek za prąd";
        String amount2 = "140";
        String category2 = "bills";

        String name3 = "czynsz";
        String amount3 = "700";
        String category3 = "rent";

        double[] amountsArr = {Double.parseDouble(amount1), Double.parseDouble(amount2), Double.parseDouble(amount3)};
        Arrays.sort(amountsArr);
        String maxAmount;
        if (amountsArr[amountsArr.length - 1] % 1 == 0) {
            maxAmount = ((int) amountsArr[amountsArr.length - 1] * -1) + "";
        } else {
            maxAmount = (amountsArr[amountsArr.length - 1] * -1) + "";
        }

        AplicationPage test = new AplicationPage();

        test.openTransactionForm();
        test.expensesFillNewTransactionForm(name2, amount2, category2);
        test.saveForm();
        test.openTransactionForm();
        test.expensesFillNewTransactionForm(name3, amount3, category3);
        test.saveForm();
        test.openTransactionForm();
        test.expensesFillNewTransactionForm(name1, amount1, category1);
        test.saveForm();
        test.checkMaxExpense(maxAmount);
    }
}
