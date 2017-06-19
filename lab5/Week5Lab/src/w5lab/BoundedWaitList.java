package w5lab;

import java.util.Collection;

public class BoundedWaitList<E> extends WaitList<E>{
	
	protected int capacity;
	
	public BoundedWaitList(Collection<E> content, int capacity){
		super(content);
		this.capacity = capacity;
				
	}
	
	public int getCapacity(){
		
		return this.capacity;
		
	}
	
	public void add(E element){
		if(this.content.size() < this.capacity){
			super.add(element);
		}
	}

	@Override
	public String toString() {
		return "BoundedWaitList [capacity=" + capacity + "]";
	}
	


}
