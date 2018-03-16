package es.ucm.fdi.model;

public class JunctionWithTimeSlice extends Junction {

	public JunctionWithTimeSlice(String id) {
		super(id);
	}
	
	public class IncomingRoadWithTimeSlice extends IncomingRoad {
		
		private int _timeSlice;
		private int _usedTimeUnits;
		private boolean _fullyUsed;
		private boolean _used;

		protected IncomingRoadWithTimeSlice(Road road) {
			super(road);
			// TODO Auto-generated constructor stub
		}
		
		protected void advanceFirstVehicle() {
			++_usedTimeUnits;
			
			if(_queue.isEmpty()) {
				_fullyUsed = false;
			}
			else {
				//TODO saca el primer vehiculo de de la cola de vehiculos y le mueve a la siguiente carretera
				//advance the first vehicle if any
				super.advanceFirstVehicle();
				_used = true;
			}
		}
		
		public Road getRoad() {
			return super.getRoad();
		}
		
		public int getTimeSlice() {
			return _timeSlice;
		}
		
		protected void setTimeSlice(int newTime) {
			_timeSlice = newTime;
		}
		
		public int getUsedTimeUnits() {
			return _usedTimeUnits;
		}
		
		protected void setUsedTimeUnits(int newTimeUnits) {
			_usedTimeUnits = newTimeUnits;
		}
		
		public boolean isFullyUsed() {
			return _fullyUsed;
		}
		
		protected void setFullyUsed(boolean fully) {
			_fullyUsed = fully;
		}
		
		public boolean isUsed() {
			return _used;
		}
		
		protected void setUsed(boolean used) {
			_used  = used;
		}
		
		public boolean timeConsumed() {
			return _usedTimeUnits >= _timeSlice;
		}
		
		public String toString() {
			return null;
		}
		
		
	}

}
