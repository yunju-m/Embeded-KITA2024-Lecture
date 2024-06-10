package json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//네트워크상의 JSON 데이터(문자열)를 받아서 클래스로 변환 후 출력해보기
public class GsonEx3 {

	public static void main(String[] args) throws Exception {

		String uriStr = "https://jsonplaceholder.typicode.com/posts";
		URL url = new URI(uriStr).toURL();
		URLConnection conn = url.openConnection();
		if (conn!=null) {
			System.out.println("연결됨!");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line = "";
		while((line = br.readLine()) != null) {
			sb.append(line);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<Post> postList = gson.fromJson(sb.toString(), List.class);
		System.out.println(postList);

	}
}
