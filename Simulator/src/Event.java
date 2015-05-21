
public class Event implements Comparable<Event>{
	
	public enum EventType {
		CUSTOMER_ARRIVES, 
		CUSTOMER_SERVED
	}
	
	public long timeStamp ; //istante di tempo in cui accade evento
	EventType eventType ;   // assume solo valori SARA, MARCO
	
	@Override
	public int compareTo(Event arg0) {
		return Long.compare(timeStamp, arg0.timeStamp);
	}

	@Override
	public String toString() {
		return "Event [timeStamp=" + timeStamp + ", eventType=" + eventType
				+ "]";
	}

	

	

	
	
	
	
	
}
