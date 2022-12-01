package com.example.service.impl;

import com.example.model.OrderBook;
import com.example.repository.IOrderBookRepository;
import com.example.service.IOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderBookService implements IOrderBookService {
    @Autowired
    IOrderBookRepository borrowedBookRepository;
    @Override
    public void save(OrderBook orderBook) {
        borrowedBookRepository.save(orderBook);
    }

    @Override
    public boolean exist(long code) {
        return borrowedBookRepository.existsByCode(code);
    }

    @Override
    public Optional<OrderBook> findByCode(long code) {
        return borrowedBookRepository.findBorrowedBookByCode(code);
    }

    @Override
    public List<OrderBook> findAll() {
        return borrowedBookRepository.findAll();
    }

    @Override
    public Optional<OrderBook> findById(Integer id) {
        return borrowedBookRepository.findById(id);
    }
}
