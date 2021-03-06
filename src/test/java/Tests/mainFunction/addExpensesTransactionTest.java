package Tests.mainFunction;

import Config.TestConfig;
import Page.AplicationPage;
import org.testng.annotations.Test;

public class addExpensesTransactionTest extends TestConfig {
    // Add single expenses transaction Test
    @Test
    public void addExpensestransactionTest() {
        String name = "Pizza";
        String amount = "40";
        String category = "food";

        AplicationPage addTransaction = new AplicationPage();
        addTransaction.openTransactionForm()
                .expensesFillNewTransactionForm(name, amount, category)
                .saveForm()
                .checkForAlertMsgDisplay();
    }
}
