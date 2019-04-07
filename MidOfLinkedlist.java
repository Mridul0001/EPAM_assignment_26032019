package mridul;

import java.util.Scanner;

public class MidOfLinkedlist {
	static int count=0;
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int a){
			data=a;
			next=null;
		}
	}
	
	public static MidOfLinkedlist insert(MidOfLinkedlist list, int d) {
		Node newNode = new Node(d);
		newNode.next=null;
		
		 if (list.head == null) { 
	            list.head = newNode; 
	        } 
	        else { 
	            Node last = list.head; 
	            while (last.next != null) { 
	                last = last.next; 
	            } 
	            last.next = newNode; 
	        } 
		count++;
		return list;
	}
	
	public static void findMid(MidOfLinkedlist list) {
		Node traverse = list.head;
		if(count%2==0) {
			for(int i=0;i<count/2;i++) {
				traverse=traverse.next;
			}
		}else {
			for(int i=0;i<count/2;i++) {
				traverse=traverse.next;
			}
		}
		System.out.println("Mid element is::" + traverse.data);
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int numberOfElements,d;
		MidOfLinkedlist list = new MidOfLinkedlist();
		System.out.println("Enter number of elements to be inserted");
		numberOfElements=s.nextInt();
		System.out.println("Enter elements into the list");
		for(int i=0;i<numberOfElements;i++) {
			d=s.nextInt();
			list = insert(list, d);
		}
		System.out.println("List created successfully");
		findMid(list);
	}
}
