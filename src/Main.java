import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {              //TODO
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long underAge18 = persons.stream()
                .filter(age -> age.getAge() < 18)
                .count();

        List<String> list1 = persons.stream()
                .filter(age -> age.getAge() >= 18)
                .filter(age -> age.getAge() <= 27)
                .map(Person::getName)
                .collect(Collectors.toList());

        List<String> list2 = persons.stream()
                .filter(education -> education.getEducation().equals(Education.HIGHER))
                .filter(sex -> sex.getSex().equals(Sex.MAN))
                .filter(age -> age.getAge() >= 18)
                .filter(age -> age.getAge() <= 65)
                .sorted(Comparator.comparing(Person::getName))
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("1. Количество несовершеннолетних: " + underAge18);
        System.out.println("2. Список призывников: "); // + list1 (не выводится т.к. очень длинный)
        System.out.println("3. Список потенциально работоспособных людей: "); // + list2 не выводится т.к. очень длинный
    }
}