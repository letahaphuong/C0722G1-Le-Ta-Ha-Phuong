package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {

    private IProductRepository productRepository=new ProductRepository();

    @Override
    public List<Product> displayAll() {
        return productRepository.displayAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void edit(int id, Product product) {
        productRepository.add(product);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void viewDetail(int id, Product product) {

    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }
}
