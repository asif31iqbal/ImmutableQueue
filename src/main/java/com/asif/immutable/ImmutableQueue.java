package com.asif.immutable;

/**
 * This class is the concrete class that represents an Immutable Queue.
 * <p>
 * This uses two stacks <b>forwards</b> and <b>backwards</b> to keep track of the elements.
 * The <b>backwards</b> stack keeps track of the elements being enQueued (since a queue is like a reverse stack).
 * The <b>forwards</b> stack keeps track of the elements being deQueued.
 * The operations enQueue(), head() and isEmpty() runs in constant, i.e.,O(1) time.
 * The deQueue() operation runs in O(n) time in worst case and O(1) time in best case. The worst case O(n)
 * time arises since that could involve reversing of the full <b>forwards</b> stack. 
 * </p>
 * @author asifiqbal
 *
 * @param <T> generic type for the elemets of the queue
 */
public final class ImmutableQueue<T> implements Queue<T>{
	
	private final Stack<T> backwards;
    private final Stack<T> forwards;
     
    private ImmutableQueue(Stack<T> f, Stack<T> b)
    {
        forwards = f;
        backwards = b;
    }
    
    /**
     * Reverses the provided stack.
     * @param stack
     * @return
     * @throws Exception
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final static Stack reverseStack(Stack stack) throws Exception
    {
        Stack r = ImmutableStack.getEmptyStack();
        while(!stack.isEmpty()){
        	r = r.push(stack.head());   
        	stack = stack.pop();
        }
      
        return r;
    }
	
	@SuppressWarnings({ "rawtypes" })
	public final static Queue getEmptyQueue(){
		return EmptyQueue.getInstance();
	}
	
	public final Queue<T> enQueue(T t){
		return new ImmutableQueue<T>(forwards, backwards.push(t));
	}
	
	@SuppressWarnings("unchecked")
	public final Queue<T> deQueue() throws Exception{
		Stack<T> f = forwards.pop();
        if (!f.isEmpty()){
            return new ImmutableQueue<T>(f, backwards);
        }
        else if (backwards.isEmpty()){
            return ImmutableQueue.getEmptyQueue();
        }
        else {
            return new ImmutableQueue<T>(ImmutableQueue.reverseStack(backwards), ImmutableStack.getEmptyStack());
        }
	}
	
	public final T head() throws Exception{
		return forwards.head();
	}
	
	public final boolean isEmpty(){
		return false;
	}
	
	/**
	 * Represents an empty queue. This is a singleton.
	 * @author asifiqbal
	 *
	 * @param <T>
	 */
	private static final class EmptyQueue<T> implements Queue<T>{
		
		@SuppressWarnings("rawtypes")
		private final static EmptyQueue emptyQueue = new EmptyQueue();
		
		@SuppressWarnings("rawtypes")
		public final static EmptyQueue getInstance(){
			return emptyQueue;
		}
		
		@SuppressWarnings("unchecked")
		public final Queue<T> enQueue(T t){
			return new ImmutableQueue<T>(ImmutableStack.getEmptyStack().push(t), ImmutableStack.getEmptyStack());
		}
		
		public final Queue<T> deQueue() throws Exception{
			throw new Exception("Queue is empty.");
		}
		
		public final T head() throws Exception{
			throw new Exception("Queue is empty.");
		}
		
		public final boolean isEmpty(){
			return true;
		}
	}
}
