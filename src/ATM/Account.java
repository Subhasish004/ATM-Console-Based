package ATM;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Account {
     String accountNumber;
     double balance;
     String accountType;
     List<Transaction> transactions;
     Customer customer;
     Card card;
     Scanner sc = new Scanner(System.in);
    public Account() {
    	this.accountNumber = CreateAccountNumber();
    	this.customer = new Customer();
   	 	this.card = new Card();
        this.transactions = new ArrayList<>();   
   
    }
    // Getters and setters

    public String  CreateAccountNumber() {
    	Random random = new Random();
	    String numbers = "0123456789";
	    StringBuilder sb = new StringBuilder();
	    int length=6;
	    for(int i = 0; i < length; i++) {
	    	int index = random.nextInt(numbers.length());
	        char randomChar = numbers.charAt(index);
	        sb.append(randomChar);
	      }
	    accountNumber = sb.toString();
	    return accountNumber;
		
	}
	public String getAccountNumber() {
        return accountNumber;
    }
	
	public double getBalance() {
        return balance;
    }
    public void setAccountType(String accountType){
    	this.accountType = accountType;
    }
  
    public String getAccountType() {
        return accountType;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Card getCard(){
		return card;
	}
	public void setCard(Card card){
		this.card = card;
	}

	// Methods
	public void balance(){
		System.out.println("Current Balance for Account Number: " + accountNumber+" is Rs"+balance);
	}
	
	public void deposit() {
		System.out.println("Welcome "+getCustomer().getName());
		System.out.println("Enter amount to Deposit - ");
		double deposit_amount = sc.nextDouble();
        balance += deposit_amount;
        transactions.add(new Transaction("Deposit", deposit_amount,balance));
        System.out.println("Deposited Successfully ");
        balance();
    }

    public void withdraw() {
    	System.out.println("Welcome "+ getCustomer().getName());
		System.out.println("Enter amount to Withdraw - ");
		double withdraw_amount = sc.nextDouble();
        if (balance >= withdraw_amount) {
            balance -= withdraw_amount;
            transactions.add(new Transaction("Withdrawal", withdraw_amount,balance));
            System.out.println("Withdraw Successfull ");
            balance();
        } else {
            System.out.println("Insufficient Balance");
            balance();
        }
    }
    
    
   
	public String AccountDetails() {
		return "*****************************************************\n"
				+"AccountNumber ->" + accountNumber + "\nAccountType ->" + accountType
				+"\n"+customer.CustomerDetails()+"\n"+card.CardDetails()+ "\nBalance -> Rs" + balance+
				"\n*****************************************************" ;
	}

	public void CreateAccount(){
		try{
		System.out.println("Input Name");
    	String custname = sc.next();
    	getCustomer().setName(custname);
    	
    	System.out.println("Input Address");
    	String address = sc.next();
    	getCustomer().setAddress(address);
    	
    	System.out.println("Input Contact");
    	String contact = sc.next();
    	getCustomer().setContactInformation(contact);
    	
    	System.out.println("Input Account Type \n1 -> Savings Account \nDefault -> Zerobalance Account");
    	int  AccChoice = sc.nextInt();
    	if (AccChoice == 1 ){
    		setAccountType("Savings Account");
    	}else {
    		setAccountType("Zerobalance Account");
    	}
    	System.out.println("Input Card Expiry date Formart {MM/YYYY}");
    	String expiryDate = sc.next();
    	getCard().setExpirationDate(expiryDate);
    	
    	System.out.println("Enter 4 digit PIN");
    	int pin = sc.nextInt();
    	getCard().setPin(pin);
    	
    	if (getAccountType().equals("Savings Account")){
    		deposit();
    	}
    	System.out.println("Account Created Sucsessfully");
    	System.out.println(AccountDetails());
		}
		catch (NullPointerException n){
			
		}
    	
	}
	public boolean Login(int pass){
		if (getCard().getPin() == pass){
	    	  return true;
	    	}
	      else{return false;}
	}

	public void TransactionStatement() {
        System.out.println("Account Statement for Account Number: " + accountNumber);
        for (Transaction transaction : transactions) {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------\n"+
            		"Type: " + transaction.getType() +
                    "   Amount: Rs" + transaction.getAmount() +
                    "   Balance: Rs"+ transaction.getBal()+
                    "   Timestamp: " + transaction.getTimestamp()
                    +"\n----------------------------------------------------------------------------------------------------------------------------");
        }
    }

	public boolean search(String account_Number) {
		 if (accountNumber.equals(account_Number)) {  
	            //showAccount();  
	            return (true);  
	        } 
		return false;
	}
}

