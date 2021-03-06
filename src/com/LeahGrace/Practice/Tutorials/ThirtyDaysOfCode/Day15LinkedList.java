package com.LeahGrace.Practice.Tutorials.ThirtyDaysOfCode;

import java.io.*;
import java.util.*;


public class Day15LinkedList {

        public static  Node insert(Node head,int data) {
            //Why is head null? - - because the list is empty
            if (head == null){
                head = new Node(data);
                return head;
            }

            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(data);

            return head; ///Why does this work?!!

        }


        public static void display(Node head) {
            Node start = head;
            while(start != null) {
                System.out.print(start.data + " ");
                start = start.next;
            }
        }

        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            Node head = null;
            int N = sc.nextInt();

            while(N-- > 0) {
                int ele = sc.nextInt();
                head = insert(head,ele);
            }
            display(head);
            sc.close();
        }
    }