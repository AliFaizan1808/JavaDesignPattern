package pattern.creational;

public class Factory {


	public static void main(String[] args) {
		Engine engine = EngineFactory.getEngine("car");
		engine.runEngine();
	}
}

class EngineFactory{

	public static Engine getEngine(String vehiceType) {
		Engine engine;
		if("car".equalsIgnoreCase(vehiceType)) {
			engine = new CarEngine();
		}else if("Schooter".equalsIgnoreCase(vehiceType)) {
			engine = new SchooterEngine();
		}else {
			throw new IllegalArgumentException("Vehicle type in not defined!");
		}
		return engine;
	}
}

class CarEngine implements Engine{

	public void runEngine() {
		System.out.println("We are running car Engine!!");
	}
}

class SchooterEngine implements Engine{

	public void runEngine() {
		System.out.println("We are running Schooter Engine!!");
	}
}

interface Engine{
	public void runEngine();
}





