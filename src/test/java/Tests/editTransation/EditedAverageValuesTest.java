package Tests.editTransation;

import Config.TestConfig;
import Page.AplicationPage;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.Arrays;

public class EditedAverageValuesTest extends TestConfig {

    @Test
    public void editedAverageValuesTest() {

        String oldName = "Nagroda";
        String oldAmount = "40";
        String oldCategory = "nobel";

        String newName = "Pizza";
        String newAmount = "90";
        String newCategory = "food";

        String name2 = "Na rower";
        String amount2 = "800";
        String category2 = "credit";

        String name3 = "rachunek za prąd";
        String amount3 = "140";
        String category3 = "bills";

        String name4 = "Bluza";
        String amount4 = "80";
        String category4 = "clothes";

        String name5 = "Z imprezy urodzinowej";
        String amount5 = "40";
        String category5 = "bottle";

        int indexOfEditedTransaction = 0;
        String finalAverageIncome;
        String finalAverageExpenses;
        DecimalFormat df = new DecimalFormat("#.00");

        double averageIncome = (Double.parseDouble(amount2) + Double.parseDouble(amount5)) / 2;
        if (averageIncome % 1 == 0) {
            finalAverageIncome = "" + df.format(averageIncome).replace(",", ".");
        } else {
            finalAverageIncome = "" + Math.round(averageIncome * 100.00) / 100.00;
        }
//        averageIncome = Math.round(averageIncome * 100.00) / 100.00;
//        String finalAverageIncome= "" + df.format(averageIncome).replace(",",".");

        double averageExpenses = ((Double.parseDouble(newAmount) + Double.parseDouble(amount3) + Double.parseDouble(amount4)) / -3);
        if (averageExpenses % 1 == 0) {
            finalAverageExpenses = "" + df.format(averageExpenses).replace(",", ".");
        } else {
            finalAverageExpenses = "" + Math.round(averageExpenses * 100.00) / 100.00;
        }
//        averageExpenses = Math.round(averageExpenses * 100.00) / 100.00;
//        String finalAverageExpenses = "" + df.format(averageExpenses).replace(",", ".");
//        String finalAverageExpenses = "" + Math.round(averageExpenses * 100.00) / 100.00;

        AplicationPage test = new AplicationPage();

        test.openTransactionForm()
                .incomeFillNewTransactionForm(oldName, oldAmount, oldCategory)
                .saveForm()
                .openTransactionForm()
                .incomeFillNewTransactionForm(name2, amount2, category2)
                .saveForm()
                .openTransactionForm()
                .expensesFillNewTransactionForm(name3, amount3, category3)
                .saveForm()
                .openTransactionForm()
                .expensesFillNewTransactionForm(name4, amount4, category4)
                .saveForm()
                .openTransactionForm()
                .incomeFillNewTransactionForm(name5, amount5, category5)
                .saveForm()
                .editTransaction(indexOfEditedTransaction)
                .editExpensesTransactionFillForm(newName, newAmount, newCategory)
                .editFormAccept()
                .checkAverageIncome(finalAverageIncome);
        test.checkAverageExpenses(finalAverageExpenses);
    }

}
