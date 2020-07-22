package Tests.mainFunction;

import Config.TestConfig;
import Page.AplicationPage;
import org.testng.annotations.Test;

public class AverageExpensesTest extends TestConfig {

    @Test
    public void averageExpensesTest() {
        String name1 = "Nagroda";
        String amount1 = "4000";
        String category1 = "nobel";

        String name2 = "Zapa";
        String amount2 = "80";
        String category2 = "food";

        String name3 = "rachgunek za prąd";
        String amount3 = "140";
        String category3 = "bills";

        String name4 = "czynsz";
        String amount4 = "700";
        String category4 = "rent";

        double amountResult = ((Double.parseDouble(amount4) + Double.parseDouble(amount2) + Double.parseDouble(amount3)) / -3);
        String finalAmount = "" + Math.round(amountResult * 100.0) / 100.0;

        AplicationPage test = new AplicationPage();
        test.openTransactionForm()
                .incomeFillNewTransactionForm(name1, amount1, category1)
                .saveForm()
                .openTransactionForm()
                .expensesFillNewTransactionForm(name2, amount2, category2)
                .saveForm()
                .openTransactionForm()
                .expensesFillNewTransactionForm(name3, amount3, category3)
                .saveForm()
                .openTransactionForm()
                .expensesFillNewTransactionForm(name4, amount4, category4)
                .saveForm()
                .checkAverageExpenses(finalAmount);
    }
}
