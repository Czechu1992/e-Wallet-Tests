package Tests.editTransation;

import Config.TestConfig;
import Page.AplicationPage;
import org.testng.annotations.Test;

public class EditTransaction extends TestConfig {

    @Test
    public void editTransaction(){
        String oldName = "Nagroda";
        String oldAmount = "40";
        String oldCategory = "nobel";

        String name2 = "Na rower";
        String amount2 = "800";
        String category2 = "credit";

        String newName = "Butelki";
        String NewAmount = "85";
        String NewCategory = "bottle";

        int indexOfEditedTransaction = 0;

        AplicationPage test = new AplicationPage();

        test.openTransactionForm()
                .incomeFillNewTransactionForm(oldName, oldAmount, oldCategory)
                .saveForm()
                .openTransactionForm()
                .incomeFillNewTransactionForm(name2, amount2, category2)
                .saveForm()
                .editTransaction(indexOfEditedTransaction)
                .editTransactionFillForm(newName,NewAmount,NewCategory)
                .editFormAccept()
                .checkEditTransactionNewName(newName,indexOfEditedTransaction);
    }

    }

