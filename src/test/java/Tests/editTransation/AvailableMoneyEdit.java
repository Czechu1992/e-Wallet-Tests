package Tests.editTransation;

import Config.TestConfig;
import Page.AplicationPage;
import org.testng.annotations.Test;

public class AvailableMoneyEdit extends TestConfig {

    @Test
    public void availableMoneyEdit(){
        String oldName = "Nagroda";
        String oldAmount = "40";
        String oldCategory = "nobel";

        String name2 = "Na rower";
        String amount2 = "800";
        String category2 = "credit";

        String newName = "Butelki";
        String newAmount = "85";
        String newCategory = "bottle";

        int indexOfEditedTransaction = 0;

        int amountResult = Integer.parseInt(amount2) + Integer.parseInt(newAmount);
        String finalAmount = "" + amountResult;

        AplicationPage test = new AplicationPage();

        test.openTransactionForm()
                .incomeFillNewTransactionForm(oldName, oldAmount, oldCategory)
                .saveForm()
                .openTransactionForm()
                .incomeFillNewTransactionForm(name2, amount2, category2)
                .saveForm()
                .editTransaction(indexOfEditedTransaction)
                .editTransactionFillForm(newName,newAmount,newCategory)
                .editFormAccept()
                .checkAvailableMoney(finalAmount);

    }
}
