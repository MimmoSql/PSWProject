package code.pswproject.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "buying", schema = "orders")
public class Buying {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "buying_time")
    private Date purchaseTime;


    @ManyToOne
    @JoinColumn(name = "buyer")
    private User buyer;


    @OneToMany(mappedBy = "buying", cascade = CascadeType.MERGE)
    private List<Trolley> trolley;
}
