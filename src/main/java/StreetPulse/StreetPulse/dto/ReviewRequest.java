package StreetPulse.StreetPulse.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {

    private int rating;
    private String comment;
    private Long businessId;


}
