abstract class BankAccount
{
    final long accountNumber;
    String accountHolderName;
    double balance;
    static int accountCount=0;
    BankAccount(long accountNumber,String accountHolderName,double balance)
    {
        this.accountNumber=accountNumber;
        this.accountHolderName=accountHolderName;
        this.balance=balance;
        accountCount++;
        
    }
    void deposit(double d)
    {
        balance+=d;

    }
    void withdraw(double w)
    {
        if(balance>=w)
        {
            System.out.println("Withdraw Successful.");
            balance-=w;
        }

    }
    void display()
    {
        System.out.println("Acc Number: "+accountNumber);
        System.out.println("Acc Holder Name:"+accountHolderName);
        System.out.println("Balance:"+balance);
    }
    abstract void calculateInterest();
    final static void KYC()
    {
        System.out.println("KYC is verified.");
    }
    static void getAccountCount()
    {
       
        System.out.println("Total Accounts Created: "+accountCount);
        
    }


}
class SavingsAccount extends BankAccount
{
    double minimumBalance;
    SavingsAccount(long accountNumber,String accountHolderName,double balance,double minimumBalance)
    {
        super(accountNumber,accountHolderName,balance);
        this.minimumBalance=minimumBalance;
    }
    void withdraw(double w)
    {
        if(balance-w<=minimumBalance)
        {
            System.out.println("Withdraw is rejeccted.");
        }
        else
        {
            System.out.println("Withdraw is successful.");
            balance-=w;
        }
    }
    void calculateInterest()
    {
        double Interest=balance*0.04;
        System.out.println("Interest:"+Interest);
    }
}
class CurrentAccount extends BankAccount
{
    double overdraftLimit;
    CurrentAccount(long accountNumber,String accountHolderName,double balance,double overdraftLimit)
    {
        super(accountNumber,accountHolderName,balance);
        this.overdraftLimit=overdraftLimit;
    }
    void withdraw(double w)
    {
        if (balance-w>= -overdraftLimit)
        {
            System.out.println("Withdrawl is successful.");
            balance-=w;
        }
        else{
            System.out.println("Withdrawl not successful.");
        }
    }
    void calculateInterest()
    {
        System.out.println("No Interest");
    }
} 
class FixedDeposit extends BankAccount
{
    double depositPeriod;
    FixedDeposit(long accountNumber,String accountHolderName,double balance,double depositPeriod)
    {
        super(accountNumber,accountHolderName,balance);
        this.depositPeriod=depositPeriod;
    }
    void calculateInterest()
    {
        double Interest=balance*0.07;
        System.out.println("Interest:"+Interest);
    }
    // void withdraw(double w)
    // {
    //     if()
    // }
}
final class BankPolicy
{
    double MinimumKYCAge;
    double MaxDailyWithdrawl;
    String bankCode;
}
class BankAccountSystem
{
    public static void main(String []args)
    {
        SavingsAccount s=new SavingsAccount(10001,"Rahul",50000,5000);
        CurrentAccount c = new CurrentAccount(10002, "Anita", 30000, 20000);
        FixedDeposit f = new FixedDeposit(10003, "Ramesh", 100000, 3);
        s.deposit(10000);
        s.withdraw(20000);
        s.withdraw(46000);
        c.deposit(5000);
        c.withdraw(40000);
        s.calculateInterest();
        c.calculateInterest();
        f.calculateInterest();
        s.display();
        c.display();
        f.display();
        BankAccount.getAccountCount();
        

    }
}

