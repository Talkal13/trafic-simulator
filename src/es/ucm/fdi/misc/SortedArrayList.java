package es.ucm.fdi.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class SortedArrayList<E> extends ArrayList<E> {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SortedArrayList(Comparator<E> comparator) {
		
	}
	
	public SortedArrayList() {
		super();
	}
	
	@Override
	public boolean add(E element) {
		int index = getIndex(element);
		super.add(index, element);
		return true;
		
			
	}
	
	//Por aqui puede romper
	//TODO
	private int getIndex(E e, int a, int b) {
		int mid = (b - a) / 2;
		
		if (b == a) {
			if (e.hashCode() == get(mid).hashCode()) return a + 1;
			else if (e.hashCode() > get(mid).hashCode()) return a;
			else return a + 1;
		}
		
		if (e.hashCode() == get(mid).hashCode()) return getIndex(e, mid, b);
		else if (e.hashCode() > get(mid).hashCode()) return getIndex(e, a, mid);
		else return getIndex(e, mid, b);
	}
	
	private int getIndex(E element) {
		return getIndex(element, 0, size() - 1);
		
	}
	
	@Override
	public boolean addAll(Collection<? extends E> elements) {
		return false;
		
	}
	
	
	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
