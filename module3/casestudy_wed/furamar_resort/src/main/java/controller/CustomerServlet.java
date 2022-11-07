package controller;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    private ICustomerService customerService=new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "add":
                save(request,response);
                break;
            case "edit":
                update(request, response);
                break;
            case "remove":
                remove(request, response);
            case "findByName":
                showfindByName(request,response);
                break;
            default:
        }
    }

    private void showfindByName(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        List<Customer> customerList=customerService.findByName(name);
        request.setAttribute("customerList",customerList);
        try {
            request.getRequestDispatcher("view/customer/list-customers.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        boolean check=customerService.remove(id);
        String mess="Delete Error";
        if (check){
            mess="DELETE WELL DONE";
        }
        request.setAttribute("mess","DELETE WELL DONE");
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));
        String customerTypeId =request.getParameter("customerType");
        String name =request.getParameter("name");
        String birthDay =request.getParameter("birthDay");
        boolean gender=Boolean.parseBoolean(request.getParameter("gender"));
        String getIdCard=request.getParameter("getIdCard");
        String phoneNumber=request.getParameter("phoneNumber");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        Customer customer = new Customer(id,customerTypeId,name,birthDay,gender,getIdCard,phoneNumber,email,address);
        boolean check=customerService.add(customer);
        String mess="Error create";
        if (check){
            mess="Added";
        }

        request.setAttribute("mess","Added");
        try {
            request.getRequestDispatcher("view/customer/create-customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        String customerID=(request.getParameter("idCustomerType"));
        String name=request.getParameter("name");
        String dateOfBirth=request.getParameter("dateOfBirth");
        boolean gender=Boolean.parseBoolean(request.getParameter("gender"));
        String idCard=request.getParameter("idCard");
        String phoneNumber=request.getParameter("phoneNumber");
        String email=request.getParameter("email");
        String address=request.getParameter("address");

        Customer customer=new Customer(id,customerID,name,dateOfBirth,gender,idCard,phoneNumber,email,address);

        customerService.update(id,customer);

        boolean check=customerService.update(id,customer);

        String mess="Error Edit";
        if (check){
            mess="Edit well done";
        }
        request.setAttribute("mess","Edit well done");
        try {
            request.getRequestDispatcher("view/customer/edit-customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "add":
                showAddForm(request,response);
                break;
            case "edit":
            showEditForm(request,response);
                break;
            case "view":
//                remove(request, response);
            case "findProduct":
//                showProductById(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/customer/create-customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));
        List<Customer> customerList=customerService.findAll();
        Customer customer=null;
        String str="";
        for (Customer value:customerList){
            if (value.getId()==id){
                customer=value;
                break;
            }
        }
        request.setAttribute("id",customer.getId());
        request.setAttribute("customerType",customer.getCustomerType());
        request.setAttribute("name",customer.getName());
        request.setAttribute("dateOfBirth",customer.getDateOfBirth());
        request.setAttribute("gender",customer.isGender());
        request.setAttribute("idCard",customer.getIdCard());
        request.setAttribute("phoneNumber",customer.getPhoneNumber());
        request.setAttribute("email",customer.getEmail());
        request.setAttribute("address",customer.getAddress());

        try {
            request.getRequestDispatcher("view/customer/edit-customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList= customerService.findAll();
        request.setAttribute("customerList",customerList);
        try {
            request.getRequestDispatcher("view/customer/list-customers.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
