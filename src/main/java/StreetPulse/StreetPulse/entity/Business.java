package StreetPulse.StreetPulse.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Business")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int viewCount;
    private String category;
    private String location;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
