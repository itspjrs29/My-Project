package MidProjRepresentativeSerrano;

public class CheckingAccount extends BankAccounts {
        private double minimumBalance;

        public CheckingAccount() {
            super();
            this.minimumBalance = 0.0;
        }

        public CheckingAccount(int accountNo, String accountName, double minimumBalance) {
            super(accountNo, accountName);
            this.minimumBalance = minimumBalance;
        }

        public double getMinimumBalance() {
            return minimumBalance;
        }

        public void encashCheck(double amount) {
            try {
                if (!getStatus().equals("active")) {
                    throw new IllegalStateException("Account is closed. Cannot encash check.");
                }

                if (amount > inquireBalance() - minimumBalance) {
                    throw new IllegalArgumentException("Insufficient balance. Cannot encash check.");
                }

                withdraw(amount);
                System.out.println("Check encashed successfully. New balance: " + inquireBalance());
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


