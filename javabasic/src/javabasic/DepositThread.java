package javabasic;

// 입금 쓰레드
public class DepositThread extends Thread {

	Account account;
	int amount;

	public DepositThread(Account account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			account.deposite(amount);
			System.out.println(amount + "원 입금됨!");
			System.out.println(account);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

}
