package school.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Borrowed {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long borrowID;
    private String OutDate;
    private String ReturnDate;
    private String Issue;
}
