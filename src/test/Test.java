package test;

public class Test {
	public static void main(String[] args) {
		String data = "1f0225c6d0080ef73f240102";
		
		String trip = data.substring(22, 24);
		String head = data.substring(0, 2);
		String bat = data.substring(18, 20);
		String magnet = data.substring(20, 22);
		
		String lathex = data.substring(2, 10);
		int latint = Integer.parseInt(lathex, 16);
		String lat = String.valueOf(latint);
		lat = lat.substring(0, 2) + "." + lat.substring(2, lat.length());
		String lonhex = data.substring(10, 18);
		int lonint = Integer.parseInt(lonhex, 16);
		String lon = String.valueOf(lonint);
		lon = lon.substring(0, 3) + "." + lon.substring(3, lon.length());
		
		System.out.println(bat);
		System.out.println(magnet);
		System.out.println(trip);
		System.out.println(head);
		System.out.println(lat);
		System.out.println(lon);
		System.out.println(data.length());
		
		System.out.println(data.substring(20, 24));
	}
}
