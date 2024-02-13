package com.skmonjurul.product_service.repository;

import com.skmonjurul.product_service.entity.MysqlProductEntity;
import com.skmonjurul.product_service.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MysqlProductRepository extends JpaRepository<MysqlProductEntity, UUID> {
}
