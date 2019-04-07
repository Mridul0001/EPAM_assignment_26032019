package interest_calc;

import java.util.Scanner;
import java.util.Stack;

public class Queue2stack {
	static class Queue{
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
	}
	
	static void pushtostack(Stack<Integer> top,int data) {
		top.push(data);
	}
	
	static int popfromstack(Stack<Integer> top) {
		if(top.isEmpty()) {
			System.out.println("Underflow");
			System.exit(0);
		}
		return top.pop();
	}
	
	static void enqueue(Queue q, int data) {
		pushtostack(q.s1, data);
	}
	
	static int dequeue(Queue q) {
		int a;
		if(q.s1.isEmpty() && q.s2.isEmpty()) {
			System.out.println("Queue is empty");
			System.exit(0);
		}else if(q.s2.isEmpty()) {
			while(!q.s1.isEmpty()) {
				a=popfromstack(q.s1);
				pushtostack(q.s2, a);
			}
		}
		a=popfromstack(q.s2);
		return a;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		Queue q=new Queue();
		
		int queries,type,data;
		System.out.println("Enter number of queries");
		queries=s.nextInt();
		
		for(int i=0;i<queries;i++) {
			System.out.println("Enter type of query");
			type=s.nextInt();
			if(type==1) {
				System.out.println("Enter data");
				data=s.nextInt();
				enqueue(q, data);
			}else if(type==2) {
				dequeue(q);
			}
			else {
				if(q.s2.isEmpty()){
				    System.out.println(q.s1.firstElement());
                }
                else{
                    System.out.println(q.s2.peek());
                }
			}
		}
	}
}
