package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import static Config.WebDriverSingledon.getInstance;

public class AplicationPage {


    // ADD Transaction form elements
    @FindBy(className = "add-transaction")
    private WebElement addTransactionBtn;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "label-income")
    private WebElement incomeRadio;

    @FindBy(id = "label-expenses")
    private WebElement expensesRadio;

    @FindBy(id = "amount")
    private WebElement amountInput;

    @FindBy(id = "income-category")
    private WebElement incomeCategorySelect;

    @FindBy(id = "expenses-category")
    private WebElement expensesCategorySelect;

    @FindBy(className = "save")
    private WebElement saveBtn;

    @FindBy(className = "cancel")
    private WebElement cancelBtn;

    // Transaction list elements
    @FindBy(className = "transaction-name")
    private WebElement transactionName;

    //Interface elements
    @FindBy(className = "available-money")
    private WebElement availableMoney;

    // Info brick Elements
    @FindBy(className = "average-income")
    private WebElement averageIncome;

    @FindBy(className = "average-expenses")
    private WebElement averageExpenses;

    @FindBy(className = "credit-amount")
    private WebElement creditAmount;

    @FindBy(className = "max-income-transaction-amount")
    private WebElement maxIncomeTransaction;

    @FindBy(className = "max-expenses-transaction-amount")
    private WebElement maxExpenseTransaction;

    @FindBy(className = "min-income-transaction")
    private WebElement minIncomeTransaction;

    @FindBy(className = "min-expense-transaction")
    private WebElement minExpenseTransaction;

    public AplicationPage() {
        PageFactory.initElements(getInstance(), this);
    }

    public void openTransactionForm() {
        addTransactionBtn.click();
    }


    public void incomeFillNewTransactionForm(String name, String amount, String categoryName) {
        nameInput.sendKeys(name);
        amountInput.sendKeys(amount);
        incomeRadio.click();
        Select category = new Select(incomeCategorySelect);
        category.selectByValue(categoryName);
    }

    public void expensesFillNewTransactionForm(String name, String amount, String categoryName) {
        nameInput.sendKeys(name);
        amountInput.sendKeys(amount);
        expensesRadio.click();
        Select category = new Select(expensesCategorySelect);
        category.selectByValue(categoryName);

    }

    public void checkTransactionName(String name) {
        Assert.assertEquals(transactionName.getText(), name);
    }

    public void chechAvailebleMoney(String amount) {
        Assert.assertEquals(availableMoney.getText(), (amount + " zł"));
    }

    public void checkAverageIncome(String amount) {
        Assert.assertEquals(averageIncome.getText(), (amount + " zł"));
    }

    public void checkAverageExpenses(String amount) {
        Assert.assertEquals(averageExpenses.getText(), (amount + " zł"));
    }

    public void checkMaxIncome(String amount) {
        Assert.assertEquals(maxIncomeTransaction.getText(), (amount + " zł"));
    }

    public void checkMaxExpense(String amount) {
        Assert.assertEquals(maxExpenseTransaction.getText(), (amount + " zł"));
    }

    public void saveForm() {
        saveBtn.click();
    }


}
