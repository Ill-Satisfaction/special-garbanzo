public class Process implements Comparable<Process> {
	
	private int priority;
	private int timeRemaining;
	private int arrivalTime;
	private int timeNotProcessed;
	
	private boolean isFinished;
	
	public Process (int arrivalTime, int processTime, int priority) {
		this.arrivalTime = arrivalTime;
		this.timeRemaining = processTime;
		this.priority  = priority;
		this.timeNotProcessed =0;
	}
	
	public void reduceTimeRemaining () {
		timeRemaining--;
		isFinished = (timeRemaining==0);
	}
	
	public boolean finish () {return isFinished;}
	
	public void increasePriority (int maxLevel) {
		if (this.priority<maxLevel)
			priority++;
	}
	public void increaseTimeNotProcessed () {timeNotProcessed++;}
	public void resetTimeNotProcessed () {this.timeNotProcessed =0;}
	
	public int getArrivalTime () {return this.arrivalTime;}
	public int getTimeRemaining () {return this.timeRemaining;}
	public int getPriority () {return this.priority;}
	public int getTimeNotProcessed () {return this.timeNotProcessed;}

	@Override
	public int compareTo(Process p) {
		if(this.priority==p.getPriority())
			return (arrivalTime<=p.getArrivalTime()) ? 1 : -1 ;
		return (priority>p.getPriority()) ? 1 : -1 ;
	}
}