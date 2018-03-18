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
			_timeSlice = 0;
			_usedTimeUnits = 0;
		}
		
		protected void advanceFirstVehicle() {
			++_usedTimeUnits;
			
			if(_queue.isEmpty()) {
				_fullyUsed = false;
			}
			else {
				super.advanceFirstVehicle();
				_used = true;
			}
		}
		
		protected void setGreen(boolean green) {
			super.setGreen(green);
			_usedTimeUnits = 0;
			_fullyUsed = true;
			_used = false;
			return;
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
			String st = "";
			st += "(" + _road.getId() + ",";
			if (_green)
				st +=  "green:" + (_timeSlice - _usedTimeUnits) + "," +  _queue + ")";
			else
				st += "red," + _queue + ")";
			return st;
		}
		
		
	}

}
