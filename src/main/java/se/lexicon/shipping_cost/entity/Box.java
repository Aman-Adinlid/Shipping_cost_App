package se.lexicon.shipping_cost.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Box {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(nullable = false, updatable = false)
    private String id;

    @Column(nullable = false, length = 100)
    @NotNull(message = "name should not be null")
    @Size(min = 4,max = 20,message = "name length should be between 4 and 20 ranges")
    private String name;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "country should not be empty")
    private String country;

    @Column(nullable = false, length = 60)
    @NotBlank(message = "type should not be empty")
    private String type;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    @Min(value = 1,message = "weight should not be less than 1 ")
    @Max(value = 200,message = "weight should not be grater than 200 ")
    private double weight;

    @Column(nullable = false, length = 60)
    @NotBlank(message = "weighType should not be empty")
    private String weighType;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDateTime createDate;

    @Column(nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean status;
}
