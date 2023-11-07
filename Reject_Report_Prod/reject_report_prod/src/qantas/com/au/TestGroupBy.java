package qantas.com.au;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestGroupBy {
  public static void main(String[] args) throws IOException {
    List<Person> people = new ArrayList<Person>();
    people.add(new Person("John", "London", 21));
    people.add(new Person("Swann", "London", 21));
    people.add(new Person("Kevin", "London", 23));
    people.add(new Person("Monobo", "Tokyo", 23));
    people.add(new Person("Sam", "Paris", 23));
    people.add(new Person("Nadal", "Paris", 31));
    Map<String, List<Person>> personByCity = new HashMap<String, List<Person>>();
    for (Person p : people) {
      if (!personByCity.containsKey(p.getCity()))
        personByCity.put(p.getCity(), new ArrayList<Person>()); 
      ((List<Person>)personByCity.get(p.getCity())).add(p);
    } 
    System.out.println("Person grouped by cities : " + personByCity);
  }
}
