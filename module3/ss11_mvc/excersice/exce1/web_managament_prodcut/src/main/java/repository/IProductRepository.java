package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> displayAll();
    void add(Product product);
    void edit(int id,Product product);
    void remove(int id);
    void viewDetail(int id,Product product);
    Product findById(int id);
}
