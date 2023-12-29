package ra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "billDetails")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BillDetail {
    @Id
    @Column(name = "bill_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
    private Bill bill;

    @OneToMany(mappedBy = "billDetail", fetch = FetchType.EAGER)
    private List<Product> listProduct = new ArrayList<>();

    @Column(name = "unit_price")
    private float unitPrice;
    private int quantity;
    @Column(name = "total_amount")
    private float totalAmount;

}