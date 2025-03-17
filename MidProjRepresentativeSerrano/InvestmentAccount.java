package MidProjRepresentativeSerrano;

public class InvestmentAccount extends BankAccounts {
    private double minimumBalance;
    private double interest;

    public InvestmentAccount() {
        super();
        this.minimumBalance = 0.0;
        this.interest = 0.0;
    }

    public InvestmentAccount(int accountNo, String accountName, double minimumBalance, double interest) {
        super(accountNo, accountName);
        this.minimumBalance = minimumBalance;
        this.interest = interest;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public double getInterest() {
        return interest;
    }

    public void addInvestment(double amount) {
        if (amount > 0) {
            deposit(amount);
        } else {
            System.out.println("Invalid investment amount.");
        }
    }

    public void inquireInvestmentValue() {
        double currentValue = inquireBalance() * (1 + interest);
        System.out.println("Current investment value: " + currentValue);
    }

    public void closeAccount() {
        if (getStatus().equals("Closed")) {
            System.out.println("Account is already closed.");
            return;
        }

        inquireInvestmentValue();
        withdraw(inquireBalance());
        super.closeAccount();
        System.out.println("Investment account closed. Remaining balance withdrawn.");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawals are not allowed in MidProjRepresentativeSerrano.InvestmentAccount.");
    }

    @Override
    public void transferMoney(BankAccounts[] accounts, int acctno, double amount) {
        System.out.println("Transfers are not allowed in MidProjRepresentativeSerrano.InvestmentAccount.");
    }
}


