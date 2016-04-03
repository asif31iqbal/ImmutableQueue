package com.asif.immutable;

/**
 * This class is the concrete class that represents an Immutable Stack.
 * @author asifiqbal
 *
 * @param <T> generic type for the elemets of the stack
 */
public class ImmutableStack<T> implements Stack<T>{
	private final T head;
	private final Stack<T> tail;
	
	private ImmutableStack(T head, Stack<T> tail){
		this.head = head;
		this.tail = tail;
	}
	
	public Stack<T> push(T t){		
		return new ImmutableStack<T>(t, this);
	}
	
	public Stack<T> pop(){
		return tail;
	}
	
	public T head(){
		return head;
	}
	
	public boolean isEmpty(){
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public static Stack getEmptyStack(){
		return EmptyStack.getInstance();
	}
	
	/**
	 * Represents an empty stack. This is a singleton.
	 * @author asifiqbal
	 *
	 * @param <T>
	 */
	private static final class EmptyStack<T> implements Stack<T>{
		
		@SuppressWarnings("rawtypes")
		private static EmptyStack emptyStack = new EmptyStack();
		
		@SuppressWarnings("rawtypes")
		public static EmptyStack getInstance(){
			return emptyStack;
		}
		
		public Stack<T> push(T t){			
			return new ImmutableStack<T>(t, this);
		}
		
		public Stack<T> pop() throws Exception{
			throw new Exception("Stack is empty.");
		}
		
		public T head() throws Exception{
			throw new Exception("Stack is empty.");
		}
		
		public boolean isEmpty(){
			return true;
		}
	}
}

