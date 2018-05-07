package es.ucm.fdi.model;

public class TrafficSimulatorThread extends Thread {
		private TrafficSimulator _sim;
		
		public TrafficSimulatorThread(TrafficSimulator sim) {
			_sim = sim;
		}
		
		public void run(int ticks, int delay) {
			for (int i = 0; i < ticks; i++) {
				run();
				try {
					this.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public void run() {
			_sim.run(1); 
		}
}
