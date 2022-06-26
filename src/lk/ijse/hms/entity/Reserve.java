package lk.ijse.hms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity(name = "Reserve")
public class Reserve {  //associate entity created between student and room (Many-to-Many)
    @Id
    private String res_id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Student.class)
    @JoinColumn(name = "student_id")
    private Student student_id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Room.class)
    @JoinColumn(name = "room_id")
    private Room room_id;

    //additional columns
    private LocalDate date;
    private String status;   //paid or not paid

}
