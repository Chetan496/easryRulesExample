package learningjeasy;

public class TransactionRequest {
	
	private String srcSystem;
	private String destSystem;
	
	private double amount;
	
	private String srcAccount;
	
	private String destAccount;
	
	private String clientId;

	public TransactionRequest(String srcSystem, String destSystem, double amount, String srcAccount, String destAccount, String clientId) {
		super();
		this.srcSystem = srcSystem;
		this.destSystem = destSystem;
		this.amount = amount;
		this.srcAccount = srcAccount ;
		this.destAccount = destAccount;
		this.clientId = clientId;
	}

	public String getSrcSystem() {
		return srcSystem;
	}

	public void setSrcSystem(String srcSystem) {
		this.srcSystem = srcSystem;
	}

	public String getDestSystem() {
		return destSystem;
	}

	public void setDestSystem(String destSystem) {
		this.destSystem = destSystem;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSrcAccount() {
		return srcAccount;
	}

	public void setSrcAccount(String srcAccount) {
		this.srcAccount = srcAccount;
	}

	public String getDestAccount() {
		return destAccount;
	}

	public void setDestAccount(String destAccount) {
		this.destAccount = destAccount;
	}
	
	

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "TransactionRequest [srcSystem=" + srcSystem + ", destSystem=" + destSystem + ", amount=" + amount
				+ ", srcAccount=" + srcAccount + ", destAccount=" + destAccount + ", clientId=" + clientId + "]";
	}


	
	
	
}
