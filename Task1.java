import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Task1 {
    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {
        // FIX: Initialize the list to prevent NullPointerException
        List<LoanAccount> result = new ArrayList<>(); 
        
        for (LoanAccount account : accounts) {
            // FIX: Add null check for dueDate to handle restructured accounts
            if (account.getDueDate() != null && account.getDueDate().before(new Date())) {
                // FIX: Include zero balance accounts (>= 0 instead of > 0)
                if (account.getOutstandingBalance() >= 0) { 
                    result.add(account);
                }
            }
        }
        return result;
    }
}
// LoanAccount fields:
// Date dueDate          — may be null for restructured accounts
// double outstandingBalance
// String accountId      — always non-null