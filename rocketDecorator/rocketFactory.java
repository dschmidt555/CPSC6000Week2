package rocketDecorator;

public class rocketFactory {
	
	public Rocket createRocket(String type) {
		
		Rocket rocket = null;
		
		if (type.equals("Light")) {
			rocket = new Light();
		}else if (type.equals("Medium")) {
			rocket = new Medium();
		}else if (type.equals("Heavy")) {
			rocket = new Heavy();
		}
		return rocket;
		
	}

}
