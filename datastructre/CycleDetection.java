package datastructre;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
 * A linked list is said to contain a cycle if any node is visited more than once while traversing the list.
 * Complete the function provided for you in your editor.
 * It has one parameter a pointer to a Node object named head that points to the head of a linked list.
 * Your function must return a boolean denoting whether or not there is a cycle in the list.
 * If there is a cycle, return true; otherwise, return false.
 */

public class CycleDetection {

  /*
   * this class is used to declare a single linked list node
   */
  
  static class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }
    
  /*
   * this class declares single linked list
   */

  static class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      }
      else {
        this.tail.next = node;
      }

    this.tail = node;
    }
  }

  public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
    while (node != null) {
       bufferedWriter.write(String.valueOf(node.data));

       node = node.next;

       if (node != null) {
         bufferedWriter.write(sep);
  }
  }
 }
    
    /*
     * In this function we take head of linked list as a parameter and then we check whether list contains a cycle.
     * If the list contains cycle then we return true else we return false.
     */

  
 static boolean hasCycle(SinglyLinkedListNode head) {
   
    SinglyLinkedListNode slowpointer = head;             //slow pointer
    SinglyLinkedListNode fastpointer = head.next;        //fast pointer
    int length=1;
    int power=1;
    while(fastpointer != null && slowpointer != fastpointer){
      if(length==power){
        power*=2;
        length=0;
        slowpointer=fastpointer;         //here we reset slow pointer to faster pointer when we mosve fast pointer in power of 2
      }
      fastpointer=fastpointer.next;      //here we move fast pointer until the pointer with next power is reached
      ++length;
      }
    
    //if fast pointer is equal to null then it means that the cycle does not exist so we return false else we return true
    if(fastpointer==null) {
    return false;
    }
    else {
    return true;
    }
    }
 

    
 //here we declare scanner
  private static final Scanner scanner = new Scanner(System.in);
/*
 * s is main function here we take input and dispay the result
 */
    public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int tests = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int testsItr = 0; testsItr < tests; testsItr++) {
        int index = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
          int llistItem = scanner.nextInt();
          scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

          llist.insertNode(llistItem);
       }
          
       SinglyLinkedListNode extra = new SinglyLinkedListNode(-1);
       SinglyLinkedListNode temp = llist.head;

       for (int i = 0; i < llistCount; i++) {
         if (i == index) {
           extra = temp;
           }

          if (i != llistCount-1) {
             temp = temp.next;
                }
          }
      
         temp.next = extra;

            boolean result = hasCycle(llist.head);

            bufferedWriter.write(String.valueOf(result ? 1 : 0));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
