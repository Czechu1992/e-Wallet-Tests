package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.List;

import static Config.WebDriverSingledon.getInstance;

public class AplicationPage {


    // ADD Transaction form elements
    @FindBy(className = "add-transaction")
    private WebElement addTransactionBtn;

    @FindBy(className = "alert1")
    private WebElement alertMsg;

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

    @FindBy(className = "transaction-name")
    private List<WebElement> allTransactionName;

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

    @FindBy(className = "min-income-transaction-amount")
    private WebElement minIncomeTransaction;

    @FindBy(className = "min-expenses-transaction-amount")
    private WebElement minExpenseTransaction;

    //Edit Transaction Elements
    @FindBy(className = "edit-button")
    private WebElement editFormAcceptBtn;

    @FindBy(className = "edit")
    private List<WebElement> editBtnList;

    @FindBy(className = "alert2")
    private WebElement alertMsg2;

    public AplicationPage() {
        PageFactory.initElements(getInstance(), this);
    }

    public AplicationPage openTransactionForm() {
        addTransactionBtn.click();
        return this;
    }


    public AplicationPage incomeFillNewTransactionForm(String name, String amount, String categoryName) {
        nameInput.sendKeys(name);
        amountInput.sendKeys(amount);
        incomeRadio.click();
        Select category = new Select(incomeCategorySelect);
        category.selectByValue(categoryName);
        return this;
    }

    public AplicationPage expensesFillNewTransactionForm(String name, String amount, String categoryName) {
        nameInput.sendKeys(name);
        amountInput.sendKeys(amount);
        expensesRadio.click();
        Select category = new Select(expensesCategorySelect);
        category.selectByValue(categoryName);
        return this;
    }

    public AplicationPage saveForm() {
        saveBtn.click();
        return this;
    }

    public AplicationPage editTransaction(int index) {
        editBtnList.get(index).click();
        return this;
    }

    public AplicationPage editTransactionFillForm(String name, String amount, String categoryName) {
        nameInput.clear();
        nameInput.sendKeys(name);
        amountInput.clear();
        amountInput.sendKeys(amount);
        incomeRadio.click();
        Select category = new Select(incomeCategorySelect);
        category.selectByValue(categoryName);
        return this;
    }

    public AplicationPage editExpensesTransactionFillForm(String name, String amount, String categoryName) {
        nameInput.clear();
        nameInput.sendKeys(name);
        amountInput.clear();
        amountInput.sendKeys(amount);
        expensesRadio.click();
        Select category = new Select(expensesCategorySelect);
        category.selectByValue(categoryName);
        return this;
    }


    public AplicationPage editFormAccept() {
        editFormAcceptBtn.click();
        return this;
    }

    public void checkEditTransactionNewName(String newName, int index) {
        Assert.assertEquals(allTransactionName.get(index).getText(), newName);
    }

    public void checkForAlertMsgDisplay() {
        Assert.assertTrue(alertMsg.isDisplayed());
    }

    public void checkTransactionName(String name) {
        Assert.assertEquals(transactionName.getText(), name);
    }

    public void checkAvailableMoney(String amount) {
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

    public void checkMinIncome(String amount) {
        Assert.assertEquals(minIncomeTransaction.getText(), (amount + " zł"));
    }

    public void checkMaxExpense(String amount) {
        Assert.assertEquals(maxExpenseTransaction.getText(), (amount + " zł"));
    }

    public void checkMinExpense(String amount) {
        Assert.assertEquals(minExpenseTransaction.getText(), (amount + " zł"));
    }


}
