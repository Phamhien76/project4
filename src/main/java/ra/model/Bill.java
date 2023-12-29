package ra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="bills")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bill {
    @Id
    @Column(name = "bill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne

    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date crated;

    @Column(name = "bill_status")
    private int status;

    @OneToMany(mappedBy = "bill",fetch = FetchType.EAGER)
    private List<BillDetail> listBillDetail = new ArrayList<>();
}
