package es.ucm.fdi.model;

public class JunctionWithTimeSlice extends Junction {

	public JunctionWithTimeSlice(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public class IncomingRoadWithTimeSlice extends IncomingRoad{
		
		private int _timeSlice;
		private int _ticksUsed;
		private boolean _complete;
		private boolean _used;

		protected IncomingRoadWithTimeSlice(Road road) {
			super(road);
			// TODO Auto-generated constructor stub
		}
		
		protected void advanceFirstVehicle() {
			++_ticksUsed;
			
			if(_queue.isEmpty()) {
				_complete = false;
			}
			else {
				//TODO saca el primer vehiculo de de la cola de vehiculos y le mueve a la siguiente carretera
				_used = true;
			}
		}
		
		public Road getRoad() {
			return null;
		}
		
		public int getTimeSlice() {
			return _timeSlice;
		}
		
		protected void setTimeSlice(int newTime) {
			_timeSlice = newTime;
		}
		
		public int getUsedTimeUnits() {
			return _ticksUsed;
		}
		
		protected void setUsedTimeUnits(int newTimeUnits) {
			_ticksUsed = newTimeUnits;
		}
		
		public boolean isFullyUsed() {
			return _complete;
		}
		
		protected void setFullyUsed(boolean fully) {
			_complete = fully;
		}
		
		public boolean isUsed() {
			return _used;
		}
		
		protected void setUsed(boolean used) {
			_used  = used;
		}
		
		public String toString() {
			return null;
		}
		
		
	}

}
