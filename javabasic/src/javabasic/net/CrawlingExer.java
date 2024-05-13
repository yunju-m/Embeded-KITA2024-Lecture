package javabasic.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/*
 * 웹 크롤링 실습)
 * 개요 : 쇼핑몰에서 쌀에 대한 상품명, 판매가, 적립포인트를 크롤링해서 assets/rice.txt에 저장
 * 경로 : https://okjmall.com/goods/goods_list.php?cateCd=015
 */
public class CrawlingExer {

	public static void main(String[] args) {

		URI uri = null;
		URL url = null;
		URLConnection conn = null;
		InputStream is = null;

		String readLine = null;
		File file = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			uri = new URI("https://okjmall.com/goods/goods_list.php?cateCd=015");
			url = uri.toURL();
			conn = url.openConnection();
			is = conn.getInputStream();

			br = new BufferedReader(new InputStreamReader(is));
			file = new File("C:\\Users\\Administrator\\git\\Embeded-KITA2024-Lecture\\javabasic\\src\\assets\\rice.txt");
			bw = new BufferedWriter(new FileWriter(file));

			List<ProductInfo> piList = new ArrayList<ProductInfo>();	// 상품명, 판매가, 적립포인트 저장하는 list

			String prodName = null;
			String prodPrice = null;
			String prodPoint = null;

			while((readLine = br.readLine()) != null) {
				// 상품명 추출
				String prodStartStr = "<strong class=\"item_name\">";
				String prodEndtStr = "</strong>";
				int prodStartIndex = readLine.indexOf(prodStartStr);
				int prodEndIndex = readLine.indexOf(prodEndtStr, prodStartIndex);	// .indexOf(str, index) : index부터 str나올 떄까지의 index
				if (prodStartIndex > -1 && prodEndIndex > -1) {
					prodName = readLine.substring(prodStartIndex+ prodStartStr.length(), prodEndIndex);
					bw.write("상품명: ");
					bw.write(prodName + '\n');
				}

				// 가격 추출
				String priceStartStr = "<span  style=\"\">";
				String priceEndtStr = "원";
				int priceStartIndex = readLine.indexOf(priceStartStr);
				int priceEndIndex = readLine.indexOf(priceEndtStr, priceStartIndex);	
				if (priceStartIndex > -1 && priceEndIndex > -1) {
					prodPrice = readLine.substring(priceStartIndex + priceStartStr.length(), priceEndIndex);
					bw.write("가격: ");
					bw.write(prodPrice + '\n');
				}

				// 적립포인트 추출
				String pointStartStr = "alt=\"마일리지\" title=\"마일리지\" /> ";
				String pointEndStr = "원";
				int pointStartIndex = readLine.indexOf(pointStartStr);
				int pointEndIndex = readLine.indexOf(pointEndStr, pointStartIndex);
				if (pointStartIndex > -1 && pointEndIndex > -1) {
					prodPoint = readLine.substring(pointStartIndex + pointStartStr.length(), pointEndIndex);
					bw.write("적립포인트: ");
					bw.write(prodPoint + '\n');
				}
				
				// ProductInfo 객체로 저장
				if (prodName!=null && prodPrice!=null && prodPoint!=null) {
					prodPrice = prodPrice.replace(",", "");
					prodPoint = prodPoint.replace(",", "");
					piList.add(new ProductInfo(
							prodName, 
							Integer.parseInt(prodPrice), 
							Integer.parseInt(prodPoint))
							);		
					prodName = null;
					prodPrice = null;
					prodPoint = null;
				}

			}
			bw.flush();

		} catch (URISyntaxException use) {
			use.printStackTrace();
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main

} // class
