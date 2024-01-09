package ra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Categories {
    @Id
    @Column(name = "catalog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "catalog_name", columnDefinition = "varchar(50)")
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "catalog_status")
    private boolean status;
//    @OneToMany(mappedBy = "catalog", fetch = FetchType.EAGER)
//    private List<Product> listProduct = new ArrayList<>();
    // nội dung dâu chị
}
