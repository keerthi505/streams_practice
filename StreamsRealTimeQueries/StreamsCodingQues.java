package StreamsRealTimeQueries;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamsCodingQues {
    public static void main(String[] args){
        //find the sum of elements in the list using streams
        List<Integer> li = Arrays.asList(1,2,3,4,5,6,7,8);
        int sum1=li.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum1);

        //given a list of integers,write a program to find the maximum element using streams

     int max = li.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max);

        ////given a list of integers,write a program to find the second largest element using streams

      int second=li.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(second);

        //given a list of strings write a program to count the number of strings starting with special character

        List<String> fruits= Arrays.asList("banana", "apple", "apple","cantaloupe", "orange");
        Long countofFruits=fruits.stream().filter(s->s.equals("apple")).count();
        System.out.println(countofFruits);

        //convert list of strings to uppercase
        fruits.stream().map(String::toUpperCase).forEach(System.out::println);

        //given a list of integers,wap to filter out even numbers in the stream

        li.stream().filter(s->s%2==0).forEach(System.out::println);
        //count the number of elements in a list that satisfy a specific condition
        Long countof=li.stream().filter(s->s%5==0).count();
        System.out.println(countof);

        //wap to find the average of list of floating pouint of numbers

       // Note: avg returns a optional vallue so we can return the getasDouble
        List<Double> d=Arrays.asList(23.4,56.7,89.0,678.98);
        Double avg = d.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println(avg);

        //given a list of strings wap to concate aall the strings usinng strreams

        String concatedString=fruits.stream().collect(Collectors.joining(",","keerthi","rajulapati"));
        System.out.println(concatedString);

        //remove duplicate elements in a list

        li.stream().distinct().forEach(System.out::println);

        //given a list of objects , write a program to sort the objects based on specific attribute

//        List<Person> p =Arrays.asList(
//                new Person(1, "John"),
//                new Person(2, "Johny Company")
//        );

        //p.stream().sorted(Comparator.comparing(Person::getId)).forEach(System.out::println);

        //wap to check if all elements in a list satisfy a given condition

        boolean con=li.stream().allMatch(s->s%2==0);
        System.out.println(con);

        ///wap to check if any elements in a list satisfy a given condition
        //it returns boolean
        //        boolean con=li.stream().anyMatch(s->s%2==0);
        //        System.out.println(con);


    }
}
