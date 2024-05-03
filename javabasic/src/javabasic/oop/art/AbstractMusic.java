package javabasic.oop.art;

public abstract class AbstractMusic extends AbstractArt {

	@Override
	public void listen() {
		System.out.println(genre + " 듣는다!");
	}

}
