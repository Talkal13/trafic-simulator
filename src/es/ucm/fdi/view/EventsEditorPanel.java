package es.ucm.fdi.view;

import java.awt.PopupMenu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventsEditorPanel extends TextAreaPanel{

	public EventsEditorPanel(String title,String text, boolean editable, MainFrame mainWindow ) {
		super(title, editable);
		this.setText(text);
		
		PopupMenu popUp = new PopUpMenu(mainWindow);
		_textArea.add(popUp);
		_textArea.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(e.isPopupTrigger() && _textArea.isEnabled()) {
					popUp.show(e.getComponent(), e.getX(), e.getY());
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
