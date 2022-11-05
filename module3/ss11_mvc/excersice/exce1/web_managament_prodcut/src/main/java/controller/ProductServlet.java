package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductService;

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
                break;
            case "edit":
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
