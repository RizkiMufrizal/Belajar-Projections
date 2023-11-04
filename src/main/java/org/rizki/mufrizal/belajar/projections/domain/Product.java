package org.rizki.mufrizal.belajar.projections.domain;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.rizki.mufrizal.belajar.projections.domain.hql.ProductCustomHQL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
@NamedNativeQuery(
        name = "findAllProduct",
        query = "select id as id, name as nama, price as harga, quantity as jumlah " +
                "from tb_product",
        resultSetMapping = "ProductCustomHQL"
)
@SqlResultSetMapping(
        name = "ProductCustomHQL",
        classes = @ConstructorResult(
                targetClass = ProductCustomHQL.class,
                columns = {
                        @ColumnResult(name = "id", type = String.class),
                        @ColumnResult(name = "nama", type = String.class),
                        @ColumnResult(name = "harga", type = BigDecimal.class),
                        @ColumnResult(name = "jumlah", type = Integer.class)
                }
        )
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product implements Serializable {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @GeneratedValue
    private UUID id;

    private String name;

    private BigDecimal price;

    private Integer quantity;
}