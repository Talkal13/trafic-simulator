package es.ucm.fdi.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import es.ucm.fdi.model.Vehicle;

public class SortedArrayList<E> extends ArrayList<E> {
	
	
	
	Comparator<E> _comparator;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SortedArrayList(Comparator<E> comparator) {
		super();
		_comparator = comparator;
	}
	
	public SortedArrayList() {
		super();
	}
	
	@Override
	public boolean add(E element) {
		super.add(element);
		super.sort(_comparator);
		return true;
		
			
	}
	
	
	@Override
	public boolean addAll(Collection<? extends E> elements) {
		super.addAll(elements);
		super.sort(_comparator);
		return true;
	}
	
	

}
