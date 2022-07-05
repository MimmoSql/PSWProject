package code.pswproject.entities;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "buying",schema = "PSWProjectDB")
public class Buying {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Basic
    @Column(name = "purchaseTime")
    private Date purchaseTime;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @OneToMany(mappedBy = "buying", cascade = CascadeType.MERGE)
    private List<Trolley> trolley;

    public Buying() {
    }

    public Buying(Integer id, Date purchaseTime, User buyer, List<Trolley> trolley) {
        this.id = id;
        this.purchaseTime = purchaseTime;
        this.user = buyer;
        this.trolley = trolley;
    }

    public Buying(Date purchaseTime, User buyer, List<Trolley> trolley) {
        this.purchaseTime = purchaseTime;
        this.user = buyer;
        this.trolley = trolley;
    }

    @Override
    public String toString() {
        return "Buying{" +
                "id=" + id +
                ", purchaseTime=" + purchaseTime +
                ", user=" + user +
                ", trolley=" + trolley +
                '}';
    }
}
