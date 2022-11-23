package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static final Map<Integer,Product> products;
    static {
        products=new HashMap<>();
        products.put(1,new Product(1,"yamaha",1200,"của yamaha","yamaha"));
        products.put(2,new Product(2,"honda",1000,"của honda","honda"));
        products.put(3,new Product(3,"suzuki",2000,"của suzuki","suzuki"));
        products.put(4,new Product(4,"sym",1500,"của sym","sym"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        if (products.size() == 0){
            return  productList;
        }

        for (Product product : products.values()){
            if(product.getName().contains(name)){
                productList.add(product);
            }
        }
        return productList;
    }
}
