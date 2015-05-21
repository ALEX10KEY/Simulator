public class Main {
	private SimCore sim ;
	int queueLen; //persone in coda
	
	public static void main(String[] args) {
		Main m = new Main() ;
		m.run() ;
	}

	private void run() {
		sim = new SimCore() ;
		queueLen = 0;
		
		Event e = new Event();
		e.timeStamp = (long)( Math.random()*100);
		e.eventType = Event.EventType.CUSTOMER_ARRIVES;
		sim.addEvent(e);
		
		while (sim.moreEvents() ) {	
			e = sim.nextEvent();
			System.out.println(e);
			
			switch(e.eventType) {
				case CUSTOMER_ARRIVES:
					++queueLen;
					if (queueLen == 1) {
						Event ne = new Event() ;
						ne.eventType = Event.EventType.CUSTOMER_SERVED;
						ne.timeStamp = e.timeStamp + (long)(Math.random()*100) ;
						sim.addEvent(ne);
					}
					break;
				case CUSTOMER_SERVED:
					--queueLen;
					if (queueLen>0) {
						--queueLen;
						Event ne = new Event() ;
						ne.eventType = Event.EventType.CUSTOMER_SERVED;
						ne.timeStamp = e.timeStamp + (long)(Math.random()*100) ;
						sim.addEvent(ne);
					}
					break;
				default:
					break;
			}
			
		}
		
	}

}
