package controller;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {

    private IProductService productService = new ProductService();
    private IProductRepository productRepository = new ProductRepository();

    private Product product = new Product();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                save(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "remove":
                break;
            case "viewDetail":
                break;
            case "findById":
                break;
            default:
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList=productService.displayAll();
        int id = Integer.parseInt(request.getParameter("id"));

        Product product = productService.findById(id);
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String productDetail = request.getParameter("productDetail");
        String producer = request.getParameter("producer");

        RequestDispatcher dispatcher;
        product.setName(name);
        product.setPrice(price);
        product.setProductDetail(productDetail);
        product.setProducer(producer);
        this.productService.add(product);
        request.setAttribute("productList", productList);
        request.setAttribute("mess", "Thông tin đã được sửa");
        dispatcher = request.getRequestDispatcher("product/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String productDetail = request.getParameter("productDetail");
        String producer = request.getParameter("producer");

        Product product = new Product(id, name, price, productDetail, producer);
        productService.add(product);
        request.setAttribute("mess", "Thêm mới thành công");
        try {
            request.getRequestDispatcher("product/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "display":
                displayListProduct(request, response);
                break;
            case "add":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "remove":
                break;
            case "viewDetail":
                break;
            case "findById":
                break;
            default:
                displayListProduct(request, response);
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product product = this.productRepository.findById(id);
//        RequestDispatcher dispatcher;
//        if (product == null) {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            request.setAttribute("product", product);
//            dispatcher = request.getRequestDispatcher("product/edit.jsp");
//            try {
//                dispatcher.forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        try {
            request.getRequestDispatcher("product/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("product/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void displayListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.displayAll();
        request.setAttribute("productList", productList);
        try {
            request.getRequestDispatcher("product/viewList.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
