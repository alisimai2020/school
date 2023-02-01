package school.school.model;



import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;
import school.school.model.Borrowed;

import javax.persistence.*;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private String SBN;
    private String bookName;

    @OneToMany(cascade= CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name="SBN")
    private List<Borrowed> borrow= new ArrayList<>();
    @OneToOne(cascade= CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name="authorID",referencedColumnName ="authorID")
    private Author author;





}
