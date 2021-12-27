package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ApiSample2 {
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		StringBuilder urlBuilder = new StringBuilder("http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureSidoLIst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + "7%2BiMCWBbAaFn2NS36JPMXDFngzpeQa3NDCcL2%2FJhGDtNLIAEXSCdC5dKATOdK46%2FAsTxyJehQBHfx7Kj6haqPA%3D%3D"); /*Service Key*/
        // 페이징에 의해 안나오는 군구가 없도록 넉넉히 잡음
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("50", "UTF-8")); /* 한 페이지 결과 수 */ 
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지 번호 */
        urlBuilder.append("&" + URLEncoder.encode("sidoName","UTF-8") + "=" + URLEncoder.encode("서울", "UTF-8")); /* 시도 이름 (서울, 부산, 대구, 인천, 광주, 대전, 울산, 경기, 강원, 충북, 충남, 전북, 전남, 경북, 경남, 제주, 세종) */
        urlBuilder.append("&" + URLEncoder.encode("searchCondition","UTF-8") + "=" + URLEncoder.encode("HOUR", "UTF-8")); /* 요청 데이터기간 (시간 : HOUR, 하루 : DAILY) */
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        
        System.out.println(sb.toString());
        
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(sb.toString())));
		document.getDocumentElement().normalize();
		
		Element root = document.getDocumentElement(); 
		Node items = root.getElementsByTagName("items").item(0);
		NodeList childItems = items.getChildNodes();
		
		Map<String,String> result = new HashMap<>();
		// 첫번째 데이터(최종측정된 정보)만 사용
		for(int i = 0 ; i < childItems.getLength() ; i++ ){
			if(childItems.item(i).getNodeType() == Node.ELEMENT_NODE){
				Element item = (Element)childItems.item(i);
				// 같은 군구를 가진 item을 찾음
				if("강남구".equals(item.getElementsByTagName("cityName").item(0).getTextContent())){
					result.put("pm10Value", item.getElementsByTagName("pm10Value").item(0).getTextContent());
					result.put("pm25Value", item.getElementsByTagName("pm25Value").item(0).getTextContent());
					result.put("time", item.getElementsByTagName("dataTime").item(0).getTextContent());
					
					break;
				}
			}
		}
		
		System.out.println(result);
	}
}