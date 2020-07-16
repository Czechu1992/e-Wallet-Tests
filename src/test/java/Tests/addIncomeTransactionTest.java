package Tests;

import Config.TestConfig;
import Page.AplicationPage;
import org.testng.annotations.Test;

public class addIncomeTransactionTest extends TestConfig {
    // Add single incom transaction Test

    @Test
    public void addIncomeTransaction() {
        String name = "Nagroda";
        String amount = "40";
        String category = "nobel";

        AplicationPage addTransaction = new AplicationPage();

        addTransaction.openTransactionForm();
        addTransaction.incomeFillNewTransactionForm(name, amount, category);
        addTransaction.saveForm();
        addTransaction.checkTransactionName(name);
    }
}
