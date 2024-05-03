package javabasic.oop.art;

public abstract class AbstractArt implements IArt {

	String genre;
	
	@Override
	public void appreciate() {
		System.out.println(genre + " 감상한다!");
	}

	@Override
	public void enjoy() {
		System.out.println(genre + " 즐긴다!");
	}
	
	@Override
	public void evaluate() {
		System.out.println(genre + " 평가한다!");
	}
	
	@Override
	public void draw() {
	}
	
	@Override
	public void watch() {
	}
	
	@Override
	public void listen() {
	}

}
