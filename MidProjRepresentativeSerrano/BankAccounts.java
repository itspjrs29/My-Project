package MidProjRepresentativeSerrano;



public class BankAccounts{
        private int accountNo;
        private String accountName;
        private double balance;
        private String status;

        public BankAccounts(){
            this.status = "active";
            this.balance = 0.0;
        }

    /**
     *This
     * @param accountNo Post object to initialize AccountNo
     * @param accountName Post object to initialize AccountName
     */


    public BankAccounts(int accountNo, String accountName) {
            this.status = "active";
            this.balance = 0.0;
            this.accountNo = accountNo;
            this.accountName = accountName;
        }

    /**
     * This gets the value of AccountNo
     * @return this returns the AccountNo
     */
    public int getAccountNo () {
            return accountNo;
        }

    /**
     * This gets the AccountName's value
     * @return this object returns the accountName
     */

    public String getAccountName() {
            return accountName;
        }

    /**
     * This gets the getStatus value whether the account its active of inactive
     * @return this returns the status
     */

    public String getStatus() {
            return status;
        }

    /**
     *
     * @param accountNo this post object is to set the AccountNo
     */

    public void setAccountNo(int accountNo) {
            this.accountNo = accountNo;

        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        @Override
        public String toString() {
            return "Account Number: " + accountNo + ", Account Name: " + accountName + ", Balanced: " + balance + "Status: " + status;
        }

        public void deposit(double amount) {
            if (amount > 0){
                balance += amount;
                System.out.println("Deposit successful. New Balance: " + balance);

            }else{
                System.out.println(" Sorry! Invalid Amount.");
            }
        }

        public void withdraw(double amount) {
            if(status.equals("closed")){
                System.out.println("Account is closed. Unable to withdraw");

            } else if (amount > balance) {
                System.out.println("insufficient balance. Withdrawal cancelled");

            }else{
                balance -=amount;
                System.out.println("Withdrawal successful. New balance: " + balance);

            }
        }

        public double inquireBalance() {
            return balance;
        }

        public void transferMoney(BankAccounts[] accounts, int acctNo, double amount) {
            if (status.equals("active")){
                if (amount > 0 && balance >= amount) {
                    boolean accountFound = false;
                    for (BankAccounts account : accounts) {
                        if (account != null && account.getAccountNo() == acctNo && account.getStatus().equals("active")) {
                            this.balance -= amount;
                            account.deposit(amount);
                            System.out.println("Transfer of " + amount + " to account " + acctNo + " successful.");
                            accountFound = true;
                            break;
                        }
                    }
                    if (!accountFound) {
                        System.out.println("Account " + acctNo + " not found or not active.");
                    }
                } else if (amount<=0){
                    System.out.println("Invalid transfer amount");
                }
                else{
                    System.out.println("Insufficient balance for transfer.");
                }
            } else{
                System.out.println("Account is closed");
            }
        }

        public void closeAccount() {
            this.status = "closed";
            System.out.println("Account " + accountNo + " closed. Balance: " + balance + " is available for withdrawal.");
        }

    }


