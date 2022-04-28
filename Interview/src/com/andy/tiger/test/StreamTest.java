package com.andy.tiger.test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class StreamTest {
    public static void main(String[] args) {
        String ss="helloworld";
        List<Person> people=new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            Person p1=new Person(i,(int)(Math.random()*10),ss.substring(0,i%5));
            people.add(p1);
        }
/*        Map<String, List<Person>> studlistGrouped = people.stream()
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
        System.out.println(sorted);*/



/*     分组找到每组工资最高前两个
  Map<String, List<Person>> listp =people.stream().collect(groupingBy(Person::getName));
        //first, use your function to group students
        Map<String, List<Person>> groupByTeachers = people.stream().collect(groupingBy(Person::getName,
                                        Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                e ->{
                                                    System.out.println(e);return e.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).limit(2).collect(Collectors.toList() ); }) ) );
       // System.out.println(groupByTeachers);
        List<Person> finallist= groupByTeachers.entrySet().stream().flatMap(e->{  System.out.println(e); return e.getValue().stream().sorted(Comparator.comparing(Person::getSalary));}).collect(Collectors.toList());
        System.out.println(finallist);*/

/*//    分组找到每组工资最高
    Map<String, List<Person>> listp =people.stream().collect(groupingBy(Person::getName));
     Map<String, Optional<Person>> groupByTeachers = people.stream().collect(groupingBy(Person::getName, Collectors.maxBy((o1, o2) -> o1.getSalary().compareTo(o2.getSalary()))) );
     groupByTeachers.entrySet().stream().forEach(e-> System.out.println(e.getValue()));

        Map<String, List<Person>> listp =people.stream().collect(groupingBy(Person::getName));
        Map<String, Optional<Person>> groupByTeachers = people.stream().collect(groupingBy(Person::getName, Collectors.maxBy(Comparator.comparing(Person::getSalary))) );
        groupByTeachers.entrySet().stream().forEach(e-> System.out.println(e.getValue()));*/

//   分组找到每组工资第二高
    Map<String, List<Person>> listp =people.stream().collect(groupingBy(Person::getName));
     Map<String, List<Person>> groupByTeachers = people.stream().collect(groupingBy(Person::getName, Collectors.collectingAndThen(Collectors.toList(),e ->{
         System.out.println(e);return e.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).limit(2).skip(1).collect(Collectors.toList() ); }) ) );
     groupByTeachers.entrySet().stream().forEach(e-> System.out.println(e.getValue()));

    }
}
class Person {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;



    public  Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Integer salary;
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