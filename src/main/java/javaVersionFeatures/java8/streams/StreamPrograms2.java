package javaVersionFeatures.java8.streams;

import beans.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamPrograms2 {

    public static void main(String[] args) {
           studentsHavingMaxMarksPerSection();
    }

    static void studentsHavingMaxMarksPerSection() {
        List<Student> students = List.of(
                new Student(90, "A", "1", List.of(12, 8)),
                new Student(80, "B", "1", List.of(11, 9)),
                new Student(75, "C", "1", List.of(10, 6)),
                new Student(93, "P", "2", List.of(6, 8)),
                new Student(70, "Q", "2", List.of(8, 10)),
                new Student(75, "X", "3", List.of(3, 2)),
                new Student(75, "Y", "3", List.of(4, 5))
        );

        Map<String, Student> collect = students.stream()
                .collect(Collectors.groupingBy(Student::getSection,
                        Collectors.collectingAndThen(Collectors.toList(),
                                students1 -> students1.stream().max((stu1, stu2) ->
                                        stu1.getMarks().stream().mapToInt(m -> m).sum() - stu2.getMarks().stream().mapToInt(m -> m).sum()
                                ).get()
                        )
                ));

        Map<String, Student> maxPerSection = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getSection,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(
                                        s -> s.getMarks().stream().mapToInt(Integer::intValue).sum()
                                )),
                                Optional::get
                        )
                ));
        maxPerSection.forEach((section, student) -> {
            int totalMarks = student.getMarks().stream().mapToInt(Integer::intValue).sum();
            System.out.println("Section " + section + " -> " + student.getName() + " (Total: " + totalMarks + ")");
        });


        System.out.println(" maxPerSection = "+ maxPerSection);
        System.out.println(" collect =  "+ collect);

    }
}
