//package hybernate.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.example.enums.Gender;
//
////Annotation from Hibernate
//@Entity
//@Table(name = "students")
//
////Annotation from lombok
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
//    @SequenceGenerator(name = "student_gen", sequenceName = "student_seq", allocationSize = 1)
//    private Long id;
//    @Column(name = "first_name")
//    private String firstName;
//    @Column(name = "last_name")
//    private String lastName;
//    @Column(unique = true)
//    private String email;
//    @Column(nullable = false)
//    private int age;
//    @Enumerated(EnumType.STRING)
//    private Gender gender;
//
//    public Student(String firstName, String lastName, String email, int age, Gender gender) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.age = age;
//        this.gender = gender;
//    }
//}
