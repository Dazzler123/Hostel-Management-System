package lk.ijse.hms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity(name = "room")
public class Room {
    @Id
    @Column(name = "room_id", nullable = false)
    private String room_id;
    private String type;
    private double key_money;
    private String qty;

    @OneToMany(mappedBy = "room_id", targetEntity = Reserve.class)
    private List<Reserve> reserveList = new ArrayList<>();

}

