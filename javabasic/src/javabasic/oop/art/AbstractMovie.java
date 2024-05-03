package javabasic.oop.art;

public abstract class AbstractMovie extends AbstractArt {

	@Override
	public void watch() {
		System.out.println(genre + " 본다!");
	}

}
