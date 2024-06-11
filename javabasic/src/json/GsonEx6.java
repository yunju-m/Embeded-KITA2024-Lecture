package json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonEx6 {

	public static void main(String[] args) throws Exception {
		// 서울시 공공 자전거 실시간 대여정보 데이터
		String uriStr = "http://openapi.seoul.go.kr:8088/(인증키)/json/bikeList/1/20";
		URL url = new URI(uriStr).toURL();
		URLConnection conn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String line = "";
		String jsonStr = "";
		while ((line = br.readLine()) != null) {
			jsonStr += line;
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Map<String, Object> jsonMap = gson.fromJson(jsonStr, Map.class);
		Map<String, Object> responseMap = (Map<String, Object>) jsonMap.get("rentBikeStatus");
		List<Object> rowList = (List<Object>) responseMap.get("row");
		for (int i = 0; i < rowList.size(); i++) {
			Map<String, Object> bikeMap = (Map<String, Object>) rowList.get(i);
			System.out.println("거치대 개수: " + bikeMap.get("rackTotCnt"));
			System.out.println("대여소 이름: " + bikeMap.get("stationName"));
			System.out.println("자전거주차총건수: " + bikeMap.get("parkingBikeTotCnt"));
			System.out.println("거치율: " + bikeMap.get("shared"));
			System.out.println("위도: " + bikeMap.get("stationLatitude"));
			System.out.println("경도: " + bikeMap.get("stationLongitude"));
			System.out.println("대여소ID: " + bikeMap.get("stationId") + "\n");
		}

	}

}
