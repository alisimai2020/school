package school.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stuId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String course;

    @OneToMany(cascade= CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name="stuId")
    private List<Borrowed> borrow= new ArrayList<>();


}


