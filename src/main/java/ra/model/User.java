package ra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name",columnDefinition = "varchar(50)",nullable = false)
    private String name;
    @Column(columnDefinition = "varchar(100)",nullable = false)
    private String email;
   @Column(columnDefinition = "varchar(200)")
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    //Mặc định có quyền user (user:0 - admin:1)
    private boolean permission =false;
    @Column(name = "user_status")
    private boolean status = true;
//    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
//    private List<Bill> listBill = new ArrayList<>();
}
