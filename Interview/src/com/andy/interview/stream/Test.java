package com.andy.interview.stream;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


public class Test {
    public static void main(String[] args) {

        List<List<Integer>> g=new ArrayList();

int[] arr=new int[]{ 1 ,2 ,5 ,4 ,3,6,9,8};
//quicksort(arr,0,arr.length-1);
  //      System.out.println(arr);
       // Arrays.stream(arr).forEach(System.out::println);
       // Arrays.stream(arr).forEach(a-> System.out.println(a));
       // Arrays.stream(arr).max().ifPresent(a->System.out.println(a));

     //   List<Integer> list=Arrays.asList( 1,2 ,5 ,4 ,3,6,9,8);
     //  List<Integer> aa= list.stream().filter(a->a>4).collect(Collectors.toList());
     //   System.out.println(aa);

        String ss="helloworld";
        List<Person> people=new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            Person p1=new Person(i,(int)(Math.random()*10),ss.substring(0,i%5));
            people.add(p1);
        }

              /* Map<String, List<Person>> studlistGrouped = people.stream().sorted(Comparator.comparing(Person::getSalary))
                .collect(Collectors.groupingBy(Person::getName));

             */
/*
    // List<Integer> listp =people.stream().map(Person::getSalary).collect(Collectors.toList());
        Map<String, List<Person>> listp =people.stream().collect(groupingBy(Person::getName));
        //System.out.println(listp);

        //first, use your function to group students
        Map<String, List<Person>> groupByTeachers =
                people.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getName,
                                        Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                e ->{
                                                    System.out.println(e);return e.stream().sorted(Comparator.comparing(Person::getSalary)).limit(2).collect(Collectors.toList() ); }) ) );
        System.out.println(groupByTeachers);
        List<Person> finallist= groupByTeachers.entrySet().stream().flatMap(e->{  System.out.println(e); return e.getValue().stream().sorted(Comparator.comparing(Person::getSalary).reversed());}).collect(Collectors.toList());
        System.out.println(finallist);
*/


       Map<String, List<Person>> studlistGrouped = people.stream()
                .collect(Collectors.groupingBy(Person::getName));

final int i=0;
//then sort groups by minimum id in each of them
        List<Person> sorted =
                studlistGrouped.entrySet().stream()
               //     .sorted(Comparator.comparing(stringListEntry -> stringListEntry.getValue()))
            //   .sorted(Comparator.comparing(e -> {//i++;
            //      System.out.println(e);
            //       return e.getValue().stream().map(Person::getSalary).min(Comparator.naturalOrder()).orElse(0);}))
              // .forEach(e-> System.out.println(e));//and also sort each group before collecting them in one list
                .flatMap(e ->{
                 //   System.out.println(e);
                    return e.getValue().stream().sorted(Comparator.comparing(Person::getSalary));}).collect(Collectors.toList());
        System.out.println(sorted);
        // Accumulate names into a List
      /*  List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());

        // Accumulate names into a TreeSet
        Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));

        // Convert elements to strings and concatenate them, separated by commas
        String joined = things.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        // Compute sum of salaries of employee
        int total = employees.stream()
                .collect(Collectors.summingInt(Employee::getSalary)));

        // Group employees by department
        Map<Department, List<Employee>> byDept
                = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // Compute sum of salaries by department
        Map<Department, Integer> totalByDept
                = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary)));

        // Partition students into passing and failing
        Map<Boolean, List<Student>> passingFailing =
                students.stream()
                        .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
*/
    }
    /*public static void subset2(List<List<Integer>>res, int[] ast, List<Integer> cur, int index) {
        res.add(new ArrayList<>(cur));
        for (int i = index; i <ast.length ; i++) {
            cur.add(ast[index]);
            subset2(res,  ast,  cur,  i+1);
cur.remove(cur.size()-1);
        }
    }*/
    // 1 2 3 4  5
    //  1 2 3  5 4  nlogn

        /*public static void  quicksort(int[]arr,int low,int high){
            if(low<0|| high>=arr.length||high-low<1)
                return;
            int i=low;
            int stand=arr[low];
            //int pilot=arr[high];
            int j=high;
            while(i!=j){

                while(arr[j]>=stand&&i<j) j--;
                while(arr[i]<=stand &&i<j) i++;
                if(i<j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }


            arr[low]=arr[i];
            arr[i]=stand;

            quicksort(arr,low,i-1);
            quicksort(arr,i+1,high);

        }*/
}
class Person {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;



    public  int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int salary;
    String name;
    public Person(int id,int salary,String name){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }

   /* @Override
    public int compareTo(Object o) {
        return ((Person)o).salary-this.salary;
    }*/
}
