package org.example.DesignSplitwise.Expense;


import org.example.DesignSplitwise.Expense.Split.EqualExpenseSplit;
import org.example.DesignSplitwise.Expense.Split.ExpenseSplit;
import org.example.DesignSplitwise.Expense.Split.PercentageExpenseSplit;
import org.example.DesignSplitwise.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {

    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {

        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
