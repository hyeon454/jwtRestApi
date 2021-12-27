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
        // ����¡�� ���� �ȳ����� ������ ������ �˳��� ����
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("50", "UTF-8")); /* �� ������ ��� �� */ 
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* ������ ��ȣ */
        urlBuilder.append("&" + URLEncoder.encode("sidoName","UTF-8") + "=" + URLEncoder.encode("����", "UTF-8")); /* �õ� �̸� (����, �λ�, �뱸, ��õ, ����, ����, ���, ���, ����, ���, �泲, ����, ����, ���, �泲, ����, ����) */
        urlBuilder.append("&" + URLEncoder.encode("searchCondition","UTF-8") + "=" + URLEncoder.encode("HOUR", "UTF-8")); /* ��û �����ͱⰣ (�ð� : HOUR, �Ϸ� : DAILY) */
        
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
		// ù��° ������(���������� ����)�� ���
		for(int i = 0 ; i < childItems.getLength() ; i++ ){
			if(childItems.item(i).getNodeType() == Node.ELEMENT_NODE){
				Element item = (Element)childItems.item(i);
				// ���� ������ ���� item�� ã��
				if("������".equals(item.getElementsByTagName("cityName").item(0).getTextContent())){
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