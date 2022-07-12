import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );

            Stream<Person> streamChildren = persons.stream();

            streamChildren
                    .filter(age -> age.getAge() < 18)
                    .count();


            Stream<Person> streamArmy = persons.stream();

            streamArmy
                    .filter(value -> value.getAge() >= 18 & value.getAge() < 27 & value.getSex() == Sex.MAN)
                    .map(value -> value.getFamily())
                    .collect(Collectors.toList());


            Stream<Person> streamWorking = persons.stream();
            streamWorking
                    .filter(value -> (value.getAge() >= 18 & value.getAge() < 60 & value.getSex() == Sex.WOMAN) |
                            (value.getAge() >= 18 & value.getAge() < 65 & value.getSex() == Sex.MAN))
                    .filter(value -> value.getEducation() == Education.HIGHER)
                    .sorted(Comparator.comparing(family -> family.getFamily()))
                    .map(family -> family.getFamily())
                    .collect(Collectors.toList());
        }
    }
}
