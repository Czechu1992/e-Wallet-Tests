package Tests.mainFunction;

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

        String name4 = "Nagroda";
        String amount4 = "1000";
        String category4 = "nobel";

        double[] amountsArr = {Double.parseDouble(amount1), Double.parseDouble(amount2), Double.parseDouble(amount3)};
        Arrays.sort(amountsArr);
        String maxAmount;
        if (amountsArr[amountsArr.length - 1] % 1 == 0) {
            maxAmount = ((int) amountsArr[amountsArr.length - 1] * -1) + "";
        } else {
            maxAmount = (amountsArr[amountsArr.length - 1] * -1) + "";
        }

        AplicationPage test = new AplicationPage();

        test.openTransactionForm()
                .incomeFillNewTransactionForm(name4, amount4, category4)
                .saveForm()
                .openTransactionForm()
                .expensesFillNewTransactionForm(name2, amount2, category2)
                .saveForm()
                .openTransactionForm()
                .expensesFillNewTransactionForm(name3, amount3, category3)
                .saveForm()
                .openTransactionForm()
                .expensesFillNewTransactionForm(name1, amount1, category1)
                .saveForm()
                .checkMaxExpense(maxAmount);
    }
}
