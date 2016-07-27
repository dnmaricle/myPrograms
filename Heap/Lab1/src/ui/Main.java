package ui;


import java.time.LocalDate;

import bp.LinkedList;
import bp.Queue;
import bp.Stack;
import bp.SortedList;
import bp.UnsortedList;
import bp.Data;
import bp.Heap;
import bp.Node;

public class Main {

    public static void main(String[] args) {
    Heap mt = new Heap();
    mt.insert(LocalDate.of(2000,1,1));
    
    mt.insert(LocalDate.of(2050,1,1));
    mt.insert(LocalDate.of(2100,1,1));
    mt.insert(LocalDate.of(2200,1,1));
    System.out.println(mt);
    
    
    mt.delete();
    System.out.println(mt);
    mt.delete();
    System.out.println(mt);
   
   
    }
}