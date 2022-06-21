package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity(name = "room")
public class Room {
    @Id
    @Column(nullable = false)
    private String room_id;
    private String type;
    private double key_money;
    private String qty;

    @ManyToMany
    private List<Student> studentList = new ArrayList<>();

}
