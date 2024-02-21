import java.time.LocalTime;

public class StopWatch {

	private long startTime;
	private long endTime;
	
	public void start() {
		LocalTime T = LocalTime.now();
		startTime = T.getSecond();
	}
	
	public void stop() {
		LocalTime T = LocalTime.now();
		endTime = T.getSecond(); 
	}
	
	public long getElapsedTime() {
		return endTime - startTime;
	}
	
}
