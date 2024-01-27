package ATM;
import java.util.Date;
class Transaction {
     String type;
     double amount;
     Date timestamp;
     double bal;

    public Transaction(String type, double amount,double bal) {
        this.type = type;
        this.amount = amount;
        this.bal = bal;
        this.timestamp = new Date();
    }

    // Getters and setters

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    public double getBal() {
    	return bal;
		
	}
    
}
