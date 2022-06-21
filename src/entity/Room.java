package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

}
