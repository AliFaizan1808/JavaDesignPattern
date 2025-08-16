package pattern.behavioural;

import java.util.ArrayList;
import java.util.List;

public class Observer {

}



interface Publisher{

	void register(Subscriber subscriber);

	void deregister(Subscriber subscriber);

	void getEventNotification();

}


class WeatherPublisher implements Publisher{

	List<Subscriber> listOFsubscriber = new ArrayList<>();
	private float temperature;
	
	
	
	 public void setTemperature(float t) {      // data changes here
	        temperature = t;
	        getEventNotification();                     // <= one door-bell
	    }
	

	@Override
	public void register(Subscriber subscriber) {
		listOFsubscriber.add(subscriber);
	}

	@Override
	public void deregister(Subscriber subscriber) {
		listOFsubscriber.remove(subscriber);
	}

	@Override
	public void getEventNotification() {
		for(Subscriber subsc : listOFsubscriber) {
			subsc.update(temperature);
		}
	}


}


interface Subscriber{
	void update(float temp);

}
