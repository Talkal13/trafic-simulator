package templates;

import java.awt.TextArea;

import javax.swing.JMenu;
import javax.swing.JTextArea;

import es.ucm.fdi.control.eventBuilders.EventBuilder;
import es.ucm.fdi.control.eventBuilders.MakeVehicleFaultyEventBuilder;
import es.ucm.fdi.control.eventBuilders.NewBikeEventBuilder;
import es.ucm.fdi.control.eventBuilders.NewCarEventBuilder;
import es.ucm.fdi.control.eventBuilders.NewDirtRoadEventBuilder;
import es.ucm.fdi.control.eventBuilders.NewJunctionEventBuilder;
import es.ucm.fdi.control.eventBuilders.NewLanesRoadEventBuilder;
import es.ucm.fdi.control.eventBuilders.NewMostCrowdedJunctionEventBuilder;
import es.ucm.fdi.control.eventBuilders.NewRoadEventBuilder;
import es.ucm.fdi.control.eventBuilders.NewRoundRobinJunctionEventBuilder;
import es.ucm.fdi.control.eventBuilders.NewVehicleEventBuilder;
import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.Event;

public class TemplatesInvoker {
	
	private static Template[] _templates = {
			new TempNewRRJunction(),
			new TempNewMCJunction(),
			//new TempNewJunction(),
			//new TempNewDirtRoad(),
			//new TempNewLanesRoad(),
			//new TempNewRoad(),
			new TempNewBike(),
			new TempNewCar(),
			new TempNewVehicle(),
			//new TempMakeVehicleFaulty()
	};
	

	
	public void addTemplates(JMenu j, JTextArea _textArea) {
		for (Template t : _templates) {
			j.add(t.generateMenuItem(_textArea));
		}
	}
}
