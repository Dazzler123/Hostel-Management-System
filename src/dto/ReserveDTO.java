package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ReserveDTO {
    private String resID;
    private LocalDate date;
    private String studentID;
    private String roomTypeID;
    private String status;
}
