package org.rizki.mufrizal.belajar.projections.domain.hql;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCustomHQL implements Serializable {
    private String id;

    private String nama;

    private BigDecimal harga;

    private Integer jumlah;
}