package javabasic;

public class GoodByeThread extends Thread {

	@Override
	public void run() {

		while(true) {
			System.out.println("Good bye!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

		}

	}
}
