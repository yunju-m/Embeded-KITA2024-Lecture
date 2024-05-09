package javabasic;

// 출금 쓰레드
public class WithdrawThread extends Thread {

	Account account;
	int amount;

	public WithdrawThread(Account account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				Thread.sleep(1500);
				if (account.getMoney() >= amount) {
					account.withdraw(amount);
					System.out.println(amount + "원 출금됨!");
					System.out.println(account);
				}
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

}
