package ra.demo_webapi.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proId;
    @Column(name = "product_name")
    private String proName;
    @Column(name = "producer")
    private String producer;
    @Column(name = "year_making")
    private Integer yearMaking;
    @Column(name = "expire_date")
    private Date exipreDate;
    @Column(name = "price")
    private Double price;

    public Product() {
    }

    public Product(Integer proId, String proName, String producer, Integer yearMaking, Date exipreDate, Double price) {
        this.proId = proId;
        this.proName = proName;
        this.producer = producer;
        this.yearMaking = yearMaking;
        this.exipreDate = exipreDate;
        this.price = price;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getYearMaking() {
        return yearMaking;
    }

    public void setYearMaking(Integer yearMaking) {
        this.yearMaking = yearMaking;
    }

    public Date getExipreDate() {
        return exipreDate;
    }

    public void setExipreDate(Date exipreDate) {
        this.exipreDate = exipreDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
