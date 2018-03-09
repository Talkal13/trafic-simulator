package es.ucm.fdi.model;

public class JunctionWithTimeSlice extends Junction {

	public JunctionWithTimeSlice(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public class IncomingRoadWithTimeSlice extends IncomingRoad{

		protected IncomingRoadWithTimeSlice(Road road) {
			super(road);
			// TODO Auto-generated constructor stub
		}
		
		protected void advanceFirstVehicle() {
			
		}
		
		public Road getRoad() {
			return null;
		}
		
		public int getTimeSlice() {
			return 0;
		}
		
		protected void setTimeSlice(int newTime) {
			
		}
		
		public int getUsedTimeUnits() {
			return 0;
		}
		
		protected void setUsedTimeUnits(int newTimeUnits) {
			
		}
		
		public boolean isFullyUsed() {
			return false;
		}
		
		protected void setFullyUsed(boolean used) {
			
		}
		
		public boolean isUsed() {
			return false;
		}
		
		protected void setUsed(boolean used) {
			
		}
		
		public String toString() {
			return null;
		}
		
		
	}

}
