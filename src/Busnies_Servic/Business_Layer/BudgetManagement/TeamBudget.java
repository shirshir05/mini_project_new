package Busnies_Servic.Business_Layer.BudgetManagement;

import Busnies_Servic.Business_Layer.ActionStatus;

/**
 * Describes a budget of a team.
 * The budget is initialized to be zero until updated to be otherwise
 */

public class TeamBudget implements IBudget{

    //region Members
    /**
     * keeps the amount left for the team
     */
    private double amount;

    /**
     * the following members keep how much was spent so far.
     */
    private double uniformExpenses;
    private double advertisementExpenses;
    private double maintenanceExpenses;
    private double otherExpenses;

    //endregion


    //region IBudget override

    @Override
    public ActionStatus addExpense(double expense, Expense description) {
        if(expense <= 0)
            return new ActionStatus(false,"Not a valid expense");
        ActionStatus tempAS;
        switch(description){
            case PlayerSalary:
                return statusToReturn(BudgetRegulations.checkPlayerSalary(expense),expense,"Salary is not within limits");
            case CoachSalary:
                return statusToReturn(BudgetRegulations.checkCoachSalary(expense),expense,"Salary is not within limits");
            case Uniform:
                tempAS = statusToReturn(BudgetRegulations.checkUniformExpense(expense,uniformExpenses),expense,"Expense exceeds limits");
                if(tempAS.isActionSuccessful())
                    uniformExpenses += expense;
                return tempAS;
            case Advertisement:
                tempAS = statusToReturn(BudgetRegulations.checkAdvertisementExpense(expense,advertisementExpenses),expense,"Expense exceeds limits");
                if(tempAS.isActionSuccessful())
                    advertisementExpenses += expense;
                return tempAS;
            case Maintenance:
                tempAS = statusToReturn(BudgetRegulations.checkMaintenanceExpense(expense,maintenanceExpenses),expense,"Expense exceeds limits");
                if(tempAS.isActionSuccessful())
                    maintenanceExpenses += expense;
                return tempAS;
            case Other:
                tempAS = statusToReturn(BudgetRegulations.checkOtherExpense(expense,otherExpenses),expense,"Expense exceeds limits");
                if(tempAS.isActionSuccessful())
                    otherExpenses += expense;
                return tempAS;
        }
        return new ActionStatus(false,"Not a valid expense");
    }

    @Override
    public ActionStatus addIncome(double income, Income description) {
        if(income <= 0)
            return new ActionStatus(false,"Not a valid income");
        updateAmount(income);
        return new ActionStatus(true,"Income updated");
    }

    @Override
    public double getCurrentAmount() {
        return amount;
    }

    //endregion

    //region Setters -> requires permission

    public void setUniformExpenses(double uniformExpenses) {
        this.uniformExpenses = uniformExpenses;
    }

    public void setAdvertisementExpenses(double advertisementExpenses) {
        this.advertisementExpenses = advertisementExpenses;
    }

    public void setMaintenanceExpenses(double maintenanceExpenses) {
        this.maintenanceExpenses = maintenanceExpenses;
    }

    public void setOtherExpenses(double otherExpenses) {
        this.otherExpenses = otherExpenses;
    }

    //TODO how to initialize budget?

    public void setAmount(double amount) {
        this.amount = amount;
    }

    //endregion

    //region Private methods

    private ActionStatus statusToReturn(boolean success, double expense, String messageForFail){
        if(success){
            updateAmount((-1)*expense);
            return new ActionStatus(true,"Operation succeeded");
        }
        else {
            return new ActionStatus(false,messageForFail);
        }
    }

    private void updateAmount(double toAddOrReduce){
        amount+=toAddOrReduce;
    }

    //endregion


}
