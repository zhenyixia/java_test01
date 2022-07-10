package com.juc.function;

import com.juc.function.Employee.Gender;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IdentityTest{
  public static void main(String[] args){
    Map<Gender, Employee> highestEarnerByGender = Employee.persons().stream().collect(Collectors
        .toMap(Employee::getGender, Function.identity(),
            (oldPerson, newPerson) -> newPerson.getIncome() > oldPerson.getIncome()? newPerson: oldPerson));
    System.out.println(highestEarnerByGender);
  }
}

