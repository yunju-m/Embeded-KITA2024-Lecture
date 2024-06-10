package json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// 네트워크상의 JSON 데이터(문자열)를 받아서 객체로 변환 후 출력해보기
public class GsonEx4 {

	public static void main(String[] args) throws Exception {

		URL url = new URI("https://jsonplaceholder.typicode.com/posts/1").toURL();
		URLConnection conn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String line = "";
		String jsonStr = "";
		while ((line = br.readLine()) != null) {
			jsonStr += line;
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Post post = gson.fromJson(jsonStr, Post.class);
		System.out.println(post);
	}

}
