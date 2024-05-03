package javabasic.oop.art;

public abstract class AbstractDrawing extends AbstractArt {

	@Override
	public void draw() {
		System.out.println(genre + " 그리다!");
	}

}
