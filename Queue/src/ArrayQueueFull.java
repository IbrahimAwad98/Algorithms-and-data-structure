public class ArrayQueueFull<E>{
	private int front, rear, size, maxSize;
	private E[] data;
	private final int initialSize; //hjälper att spara mininum

	public ArrayQueueFull(int initialSize){
		this.initialSize = initialSize;
		size = 0;
		front = 0;
		maxSize = initialSize;
		rear = 0;
		data = (E[]) new Object[maxSize];
	}

	public int getSize(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public boolean offer(E element){
		if(size==maxSize){
			reallocate();
		}
		data[rear] = element;
        rear = (rear + 1) % maxSize;
		size++;
		return true;
	}

	public E peek(){
		if(isEmpty()) {
			return null;
		}
		return data[front];
	}

	public E poll(){
		if(isEmpty()){
			return null;
		}else{
			size--;
			E element = data[front];
			front =(front+1) % maxSize;
			//Krymper om size <= 1/4 av maxSize
			if (size <= maxSize / 4 && maxSize > initialSize){
				shrink();
			}
			return element;
		}	
	}

	private void reallocate() {
		int newMaxSize = maxSize * 2;
		resize(newMaxSize);
	}

	private void shrink(){
		int newMaxSize = initialSize/2;
		if (newMaxSize < initialSize){
			newMaxSize = initialSize;
		}
		resize(newMaxSize);
	}

	private void resize(int newMaxSize){
		E[] newData = (E[]) new Object[newMaxSize];

		// vi kopiera cirkulärt från front.
		int j = front;
		for (int i = 0; i < size; i++) {
			newData[i] = data[j];
			j = (j + 1) % maxSize;
		}

		data = newData;
		front = 0;
		rear = size - 1;
		maxSize = newMaxSize;
	}

	public String toString(){
		if (isEmpty()){
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		int j = front;
		for (int i = 0; i < size;i++){
			sb.append(data[j]);
			if (i < size - 1){
				sb.append(", ");
			}
			j = (j + 1) % maxSize;
		}
		sb.append("]");
		return sb.toString();
	}
}