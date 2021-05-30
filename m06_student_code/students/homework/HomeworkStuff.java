package com.olympic.cis143.m06.students.homework;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * This lab uses the java Stream API.
 */
public class HomeworkStuff {

    /**
     * This method will:
     * 1. sort the names
     * 2. convert the names to uppercase.
     * @param names The list of unsorted names in lowercase.
     * @return The sorted list in uppercase.
     */
    public List<String> orderNamesAndConvertToUppercase(final List<String> names) {

      List<String> result=new ArrayList<String>();

      //sorting it
      List<String> sorted = names.stream().sorted().collect(Collectors.toList());
      System.out.println(sorted);


      // changing each element to upper case
      sorted.stream().map(name -> name.toUpperCase()).forEach
        (name -> result.add(name));

      return result;
    }

    /**
     * This adds all the integers in a list together.
     * @param integrers A list of integers
     * @return The total.
     */
    public Integer calculateAddListValues(final List<Integer> integrers) {



      Integer sum = integrers.stream()
  .reduce(0, (a, b) -> a + b);

      return sum;


    }

    /**
     * From the list, filter and find the oldest person.
     *
     * @param people A list of people.
     * @return The oldest person.
     */
    public Optional<Person> findTheOldestPerson(final List<Person> people) {



      Optional<Person> maxByAge = people
      .stream()
      .max(Comparator.comparing(Person::getAge));
      //.orElseThrow(NoSuchElementException::new);

      return maxByAge;


    }

    /**
     * Filters out anyone under 21.
     * @param people A list of people.
     * @return Only people 21 or over.
     */
    public List<Person> findPeople21OrOver(final List<Person> people) {


        List<Person> result =new ArrayList<Person>();

        people.stream()
          .filter(i -> i.getAge() >= 21)
          .forEach(i -> result.add(i));
       System.out.println(result);

        return result;
    }

    /**
     * Orders the people by age.
     * @param people A list of people to order by age.
     * @return The ordered list of people by age.
     */
    public List<Person> orderByAge(final List<Person> people){

      List<Person> sortedList = people.stream()
        .sorted(Comparator.comparingInt(Person::getAge))
        .collect(Collectors.toList());

      return sortedList;

    }
}
