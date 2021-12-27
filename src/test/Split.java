package test;

public class Split {

	public static void main(String[] args) {
		String a = "http://dev.car.co.kr/asdfasdfasdf";
		
		String clientHost = a.substring(a.indexOf("//") + "//".length());
		clientHost = clientHost.substring(0, clientHost.indexOf("/"));
		if(clientHost.indexOf(":") > -1){
			clientHost = clientHost.substring(0, clientHost.indexOf(":"));
		}
		
		System.out.println(clientHost);
	}
}
