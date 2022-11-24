package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList= session.createQuery("FROM Product").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        Session session=null;
        Transaction transaction=null;
        try{
            session=ConnectionUtil.sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.save(product);
            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        Session session=null;
        Product product=null;
        try{
            session=ConnectionUtil.sessionFactory.openSession();
            product= (Product) session.createQuery("from Product p where id =:idx").setParameter("idx",id).getSingleResult();

        }finally {
            if (session!=null){
                session.close();
            }
        }
        return product;
    }

    @Override
    public void update(Product product) {
        Session session=null;
        Transaction transaction=null;
        try{
            session=ConnectionUtil.sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.merge(product);
            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Session session=null;
        Transaction transaction=null;
        Product product=null;
        try{
            session=ConnectionUtil.sessionFactory.openSession();
            transaction=session.beginTransaction();
            product= (Product) session.createQuery("from Product p where id =:idx").setParameter("idx",id).getSingleResult();
            session.remove(product);
            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList=null;
        Session session=null;
        Product product=null;
        try{
            session=ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product p where p.name like:searchName ").setParameter("searchName",'%'+name+'%').getResultList();
        }finally {
            if (session!=null){
                session.close();
            }
        }
        return productList;
    }

    @Override
    public Product saveByPersistAndMerge(Product product) {
        return null;
//        return product.getId() == 0 ? persist(product) : merge(product);
    }

//    private Product persist(Product product) {
//        Product clone = product.clone();
//        clone.setId(autoIncreaseId++);
//        return clone;
//    }
//
//    private Product merge(Product product) {
//        Product origin = findById(product.getId());
//        origin.setName(product.getName());
//        origin.setPrice(product.getPrice());
//        origin.setDescribe(product.getDescribe());
//        origin.setProducer(product.getProducer());
//        return origin;
//    }
}
