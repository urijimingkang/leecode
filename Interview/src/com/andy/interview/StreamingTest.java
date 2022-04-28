package com.andy.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import java.util.Optional;
import java.util.stream.Collectors;

public class StreamingTest {
    public static void main(String[] args) {
        Person p1=new Person("jimmy",12);
        Person p2=new Person("jimmy",13);
        Person p3=new Person("jimmy",14);

        Person p4=new Person("kaka",12);
        Person p5=new Person("kaka",13);
        Person p6=new Person("kaka",14);
        List<Person> list= Arrays.asList(p1,p2,p3,p4,p5,p6);

        //test1
      // Map<String,Person> map= list.stream().collect(Collectors.groupingBy(Person::getName),Collectors.collectingAndThen(Collectors.reducing()));
        //       Collectors.collectingAndThen(Collectors.reducing(( c1,  c2) -> (c1.getAge() > c2.getAge()) ? c1 : c2), Optional::get)
      //  System.out.print(map);

        //test2
        // Map<String, List<Object>> configMap = list.stream().collect(Collectors.groupingBy(Person::getName, Collectors.mapping(p->p.getAge(),Collectors.toList())));


        //test3: get the max age person in each group
        Map<String, Person> configMap = list.stream().collect(Collectors.groupingBy(Person::getName,
Collectors.collectingAndThen(Collectors.reducing(( c1,  c2) -> (c1.getAge() > c2.getAge()) ? c1 : c2), Optional::get)));

         //test4:
        entrysetStream(list);




    }

    public static  Map<String, List<Integer>> entrysetStream(List<Person> list){
        Map<String, List<Person>> configMap2 = list.stream().collect(Collectors.groupingBy(Person::getName,
                Collectors.toList()));


        Map<String, List<Integer>> resultMap = configMap2.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().stream().sorted().map(Person::getAge).collect(Collectors.toList()))
                );
        System.out.println(resultMap);
        return resultMap;
    }





}
class Person implements Comparable{
    Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;
    String phone;
    List<String> emails;

    @Override
    public int compareTo(Object o) {
        if(this.age>((Person)o).age)
        return 1;
        else if(this.age<((Person)o).age)
            return -1;
        else
            return 0;
    }
}
