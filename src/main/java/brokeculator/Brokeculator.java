package brokeculator;
import brokeculator.dashboard.Dashboard;
import brokeculator.event.EventExpenseDataIntegrityManager;
import brokeculator.event.EventManager;
import brokeculator.enumerators.Category;
import brokeculator.storage.FileManager;
import brokeculator.expense.ExpenseManager;

public class Brokeculator {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();
        FileManager fileManager = new FileManager();
        EventManager eventManager = EventManager.getInstance();
        EventExpenseDataIntegrityManager dataIntegrityManager
                = new EventExpenseDataIntegrityManager(eventManager, expenseManager);
        Dashboard dashboard
                = new Dashboard(expenseManager, fileManager, eventManager, dataIntegrityManager);
        Logic driverLogic = new Logic(dashboard);
        Category.setDashboard(dashboard);
        driverLogic.run();
    }
}
