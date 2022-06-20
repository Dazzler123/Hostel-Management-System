package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RoomDTO {
    private String roomID;
    private String type;
    private double keyMoney;
    private String qty;
}
