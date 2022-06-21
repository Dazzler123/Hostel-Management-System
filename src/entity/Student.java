package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity(name = "student")
public class Student {
    @Id
    @Column(nullable = false)
    private String student_id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String address;
    private String contact_no;
    private LocalDate dob;
    private String gender;

    @ManyToMany(mappedBy = "studentList")
    private List<Room> roomList = new ArrayList<>();

}
