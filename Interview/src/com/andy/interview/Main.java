package com.andy.interview;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line="6";
  //  while ((line = in.readLine()) != null) {
      System.out.println(line);
      List ret=new ArrayList();
      List list=new ArrayList();
      for(int i=1;i<=Integer.parseInt(line);i++) {
          Pascal(list, i);
          ret.addAll(list);
      }
      for(int i=0;i<ret.size();i++) {
         System.out.print(ret.get(i)+" ");
      }
    // list.stream().forEach(System.out::print);
      
  //  }
     
  }
  public static void Pascal(List list, int n){
   
    if(n==1) 
    {
       list.add(1);
    // return ret;
  }else if(n==2) {
     // List ret=Pascal(list);
      list.add(1);
     // return ret;
    }else{
     // List tmplist=new ArrayList();

      int[] arr=new int[list.size()];
      for(int i=0;i<list.size();i++)
      {
    arr[i] =(Integer) list.get(i);
      }
      list.clear();

     list.add( arr[0]);
      for(int i=0;i<arr.length-1;i++)
      {
        list.add( arr[i]+ arr[i+1]);
        //tmplist.add(arr[i]);
        
      }
     list.add(1);
     // list=null;
     // list=tmplist;
      // return list;
    }
  }
}