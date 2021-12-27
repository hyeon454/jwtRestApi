package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistanceTest {

	public static void main(String[] args) {
		List<Map<String, Double>> list = new ArrayList<>();
		setList(list);
		double befLat = 0;
		double befLon = 0;
		double curLat = 0;
		double curLon = 0;
		double sum = 0;
		int idx = 0;
		for(Map<String, Double> map : list){
			curLat = map.get("lat");
			curLon = map.get("lon");
			if(idx > 0){
				sum += distance(befLat, befLon, curLat, curLon);
			}
			idx++;
			
			befLat = curLat;
			befLon = curLon;
		}
		
		System.out.println(sum);
	}
	
	private static double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
         
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
         
        // 미터 단위 처리
        dist = dist * 1609.344;
 
        return (dist);
    }
 
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
     
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
    
    private static void setList(List<Map<String, Double>> list){
    	Map<String, Double> map = null;
    	map = new HashMap<>(); map.put("lat", 37.498671); map.put("lon",	127.034614);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986751); map.put("lon",	127.034613);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986772); map.put("lon",	127.034606);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986755); map.put("lon",	127.034604);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4987138); map.put("lon",	127.034648);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986897); map.put("lon",	127.034627);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986687); map.put("lon",	127.034612);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986722); map.put("lon",	127.034611);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986729); map.put("lon",	127.034611);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986688); map.put("lon",	127.034595);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986669); map.put("lon",	127.034595);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986636); map.put("lon",	127.034592);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986653); map.put("lon",	127.034592);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986784); map.put("lon",	127.03461 );list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4987169); map.put("lon",	127.034624);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986599); map.put("lon",	127.03459 );list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986727); map.put("lon",	127.034611);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986648); map.put("lon",	127.034605);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4988266); map.put("lon",	127.034843);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986014); map.put("lon",	127.034303);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4992539); map.put("lon",	127.034249);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4979174); map.put("lon",	127.033588);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4970417); map.put("lon",	127.031952);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.495113); map.put("lon",	127.032917);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4945284); map.put("lon",	127.03503 );list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4953596); map.put("lon",	127.03777 );list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4969258); map.put("lon",	127.038677);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.499131); map.put("lon",	127.037617);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.5001525); map.put("lon",	127.035958);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4990195); map.put("lon",	127.034423);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986834); map.put("lon",	127.034631);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986926); map.put("lon",	127.034601);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986909); map.put("lon",	127.034609);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986719); map.put("lon",	127.034606);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986656); map.put("lon",	127.03459 );list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986642); map.put("lon",	127.034605);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.49874); map.put("lon",	127.034612);    list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4988945); map.put("lon",	127.034474);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4992019); map.put("lon",	127.034354);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986776); map.put("lon",	127.034603);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.498685); map.put("lon",	127.034616);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986873); map.put("lon",	127.034614);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986944); map.put("lon",	127.034637);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986785); map.put("lon",	127.034615);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986672); map.put("lon",	127.034651);list.add(map);
    	map = new HashMap<>(); map.put("lat", 37.4986404); map.put("lon",	127.034615);list.add(map);
    }

}
