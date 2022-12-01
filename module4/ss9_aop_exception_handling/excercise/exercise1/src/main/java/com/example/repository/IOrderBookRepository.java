package com.example.repository;

import com.example.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOrderBookRepository extends JpaRepository<OrderBook, Integer> {
    boolean existsByCode(long code);
    Optional<OrderBook> findBorrowedBookByCode(long code);
}
