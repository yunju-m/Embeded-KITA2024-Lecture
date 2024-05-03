package javabasic.oop.art;

public class ArtMain {

	public static void main(String[] args) {

		IArt drawing = new Drawing("수채화");
		IArt movie = new Movie("범죄도시");
		IArt music = new Music("Magnetic");
		
		drawing.appreciate();
		movie.evaluate();
		music.enjoy(); 
		
		drawing.draw();
		movie.watch();
		music.listen();
		
	}

}
