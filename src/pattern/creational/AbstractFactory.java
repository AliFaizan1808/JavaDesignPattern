package pattern.creational;

public class AbstractFactory {
	
	public static void main(String[] args) {
		VehicleAbstractFactory vehicle = new CarFactory();
		vehicle.createTyre().useTyreOf();
		vehicle.createEngine().runEngine();
	}

}


interface UpgradedEngine{
	public void runEngine();
}

interface Tyre{
	public void useTyreOf();
}

class CarEngines implements UpgradedEngine{
	
	@Override
	public void runEngine() {
		// TODO Auto-generated method stub
		System.out.println("Run engine for the car");
	}
}

class CarTyre implements Tyre{
	
	@Override
	public void useTyreOf() {
		// TODO Auto-generated method stub
		System.out.println("Use Tyre for the car");
	}
}


interface VehicleAbstractFactory{
	UpgradedEngine createEngine();
	Tyre createTyre();
}


class CarFactory implements VehicleAbstractFactory{
	
	public UpgradedEngine createEngine() {
       return new CarEngines();
	}
	
	@Override
	public Tyre createTyre() {
		return new CarTyre();
	}
}