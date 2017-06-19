package w5lab;

import java.util.Collection;

public class UnfairWaitList<E> extends WaitList<E> {
	
	public UnfairWaitList(Collection<E> content){
		super(content);
	}
	
	public void remove(E element){
		
		this.content.remove(element);
		
	}
	public void moveToBack(E element){
		E e = element;
		if(content.remove(element)==true){
			this.content.add(e);
		}
	}
}
