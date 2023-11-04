package org.rizki.mufrizal.belajar.projections.repository;

import org.rizki.mufrizal.belajar.projections.domain.Product;
import org.rizki.mufrizal.belajar.projections.domain.hql.ProductCustomHQL;
import org.rizki.mufrizal.belajar.projections.domain.hql.ProductHQL;
import org.rizki.mufrizal.belajar.projections.domain.hql.ProductPriceHQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<ProductHQL> findAllBy();

    @Query("select p.name as name, p.price as price from Product p")
    List<ProductHQL> findAllCustomQuery();

    @Query("select new org.rizki.mufrizal.belajar.projections.domain.hql.ProductPriceHQL(sum(p.price)) from Product p")
    ProductPriceHQL getAllPrice();

    @Query(name = "findAllProduct", nativeQuery = true)
    List<ProductCustomHQL> findAllProduct();

    <T> T findByName(String name, Class<T> type);
}