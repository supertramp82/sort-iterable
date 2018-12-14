import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

class SortIterable {

    public static class Person {
        public String ssn;
        public Date dateOfBirth;
        public String firstName;
        public String lastName;
        public Double heightIn;
        public Double weightLb;

        public Person(String t_ssn, Date t_dateOfBirth, String t_firstName, String t_lastName, Double t_heightIn,
                Double t_weightLb) {
            ssn = t_ssn;
            dateOfBirth = t_dateOfBirth;
            firstName = t_firstName;
            lastName = t_lastName;
            heightIn = t_heightIn;
            weightLb = t_weightLb;
        }

        public String toString() {
            SimpleDateFormat df = new SimpleDateFormat("mm-dd-yyyy");

            return "    " + ssn + " " + df.format(dateOfBirth) + " " + firstName + " " + lastName + " " + heightIn + " "
                    + weightLb;
        }

        // Comparator
        public static class CompSSN implements Comparator<Person> {
            @Override
            public int compare(Person arg0, Person arg1) {
                return arg0.ssn.compareToIgnoreCase(arg1.ssn);
            }
        }

        public static class CompBirthDate implements Comparator<Person> {
            private int mod = 1;

            public CompDate(boolean desc) {
                if (desc)
                    mod = -1;
            }

            @Override
            public int compare(Person arg0, Person arg1) {
                return mod * arg0.dateOfBirth.compareTo(arg1.dateOfBirth);
            }
        }

        public static class CompFirstName implements Comparator<Person> {
            @Override
            public int compare(Person arg0, Person arg1) {
                return arg0.firstName.compareToIgnoreCase(arg1.firstName);
            }
        }

        public static class CompLastName implements Comparator<Person> {
            @Override
            public int compare(Person arg0, Person arg1) {
                return arg0.lastName.compareToIgnoreCase(arg1.lastName);
            }
        }

        public static class CompHeightIn implements Comparator<Person> {
            @Override
            public int compare(Person arg0, Person arg1) {
                return (int) (arg0.heightIn - arg1.heightIn);
            }
        }

        public static class CompWeightLb implements Comparator<Person> {
            @Override
            public int compare(Person arg0, Person arg1) {
                return (int) (arg0.weightLb - arg1.weightLb);
            }
        }

    }

    static ArrayList<Person> sort(ArrayList<Person> people, String sortField, String ascending) {

        switch (sortField) {
        case "ssn":
            Collections.sort(people, new Person.CompSSN());
            System.out.println("by ssn");
            break;
        case "dateOfBirth":
            Collections.sort(people, new Person.CompBirthDate());
            System.out.println("by Date of Birth");
            break;
        case "firstName":
            Collections.sort(people, new Person.CompFirstName());
            System.out.println("by first name");
            break;
        case "lastName":
            Collections.sort(people, new Person.CompLastName());
            System.out.println("by last name");
            break;
        case "heightIn":
            Collections.sort(people, new Person.CompHeightIn());
            System.out.println("by height");
            break;
        case "weightLb":
            Collections.sort(people, new Person.CompWeightLb());
            System.out.println("by weight");
            break;

        }

        return people;
    }

    public static void main(String[] args) {

        SimpleDateFormat df = new SimpleDateFormat("mm-dd-yyyy");

        ArrayList<Person> people;
        people = new ArrayList<Person>();

        try {
            people.add(new Person("123456789", df.parse("01-01-1980"), "John", "Shapiro", 61.5, 170.2));
            people.add(new Person("456789123", df.parse("01-01-2000"), "Ella", "Windhorst", 51.0, 120.1));
            people.add(new Person("234567891", df.parse("01-01-1990"), "Beverly", "Williams", 75.8, 204.4));
            people.add(new Person("678912345", df.parse("01-01-1985"), "Peter", "Bernal", 72.3, 231.9));
            people.add(new Person("567890123", df.parse("01-01-1995"), "Kathy", "Hershmidt", 55.5, 135.7));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ArrayList<Person> list = sort(people, "ssn", "asc");

        for (Person p : list) {
            System.out.println(p.toString());
        }
        System.out.println();
        System.out.println();

        list = sort(people, "dateOfBirth", "asc");
        for (Person p : list) {
            System.out.println(p.toString());
        }
        System.out.println();
        System.out.println();

        list = sort(people, "firstName", "asc");
        for (Person p : list) {
            System.out.println(p.toString());
        }
        System.out.println();
        System.out.println();

        list = sort(people, "lastName", "asc");
        for (Person p : list) {
            System.out.println(p.toString());
        }
        System.out.println();
        System.out.println();

        list = sort(people, "heightIn", "asc");
        for (Person p : list) {
            System.out.println(p.toString());
        }
        System.out.println();
        System.out.println();

        list = sort(people, "weightLb", "asc");
        for (Person p : list) {
            System.out.println(p.toString());
        }
        System.out.println();
        System.out.println();

    }
}