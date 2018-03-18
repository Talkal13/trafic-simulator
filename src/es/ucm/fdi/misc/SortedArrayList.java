package es.ucm.fdi.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import es.ucm.fdi.model.Vehicle;

/**
 * @author Pablo & Diego
 *
 * Class which implements a sorted Array list which is going to be an extension of the generic ArrayLsit and is going
 * to take care of the list of vehicles contained in the roads and junctions
 */

public class SortedArrayList<E> extends ArrayList<E> {
	
	Comparator<E> _comparator;
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the class, stes the class attribute comparator to the one passed as an argument
	 * @param comparator
	 */
	public SortedArrayList(Comparator<E> comparator) {
		super();
		_comparator = comparator;
	}
	
	public SortedArrayList() {
		super();
	}
	
	public boolean add(E element) {
		super.add(element);
		super.sort(_comparator);
		return true;
	}
	
	public boolean addAll(Collection<? extends E> elements) {
		super.addAll(elements);
		super.sort(_comparator);
		return true;
	}
	
	

}
