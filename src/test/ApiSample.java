package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class ApiSample {
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		String client_key = "031c8926a7d313b6b747837c51a5ac5c785725e4";
        
        StringBuilder urlBuilder = new StringBuilder("http://cntr.iptime.org:7878/api/chassi-location");
        	
        urlBuilder.append("?" + URLEncoder.encode("client_key","UTF-8") + "=" + URLEncoder.encode(client_key, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("api_name","UTF-8") + "=" + URLEncoder.encode("CL", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("number","UTF-8") + "=" + URLEncoder.encode("인천80아1337", "UTF-8"));
//        urlBuilder.append("&" + URLEncoder.encode("tel_num","UTF-8") + "=" + URLEncoder.encode("010-9338-4829", "UTF-8"));
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        BufferedReader rd;
        if(conn.getResponseCode() == 200) {
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
	}
}