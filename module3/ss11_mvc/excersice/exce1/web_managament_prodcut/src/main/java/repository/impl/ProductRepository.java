package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private static List<Product> productList=new ArrayList<>();
    static {
        productList.add(new Product(1,"Bút",5000,"Bút bi","Thiên Long"));
        productList.add(new Product(2,"Thước",3000,"20 cm","ABC"));
        productList.add(new Product(3,"vở",4000,"vở mỏng","Tan Vinh"));
        productList.add(new Product(4,"bình nước",10000,"20 lit","Thuý"));
        productList.add(new Product(5,"kẹo",20000,"Kẹo sâm","Korea"));
    }

    @Override
    public List<Product> displayAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void edit(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void viewDetail(int id, Product product) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }
}
