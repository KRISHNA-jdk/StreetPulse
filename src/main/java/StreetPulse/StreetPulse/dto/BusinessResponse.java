package StreetPulse.StreetPulse.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessResponse {

    private Long id;
    private String name;
    private String category;
    private String location;
    private int viewCount;
    private double averageRating;
}
