package es.ucm.fdi.view;

import java.io.File;

public interface GuiViewObserver {

	public void onLoadFile(File file);
	public void onSaveFile(File file);
	
}
