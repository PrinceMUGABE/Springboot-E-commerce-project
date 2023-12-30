package com.example.inyange.controller;

import com.example.inyange.model.OrderModel;
import com.example.inyange.model.Product;
import com.example.inyange.serviceImplementation.OrderServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OrderCotroller {
    @Autowired
    OrderServiceImplementation service;

    @GetMapping("/productform")
    public String showOrderForm(Model model){
        OrderModel order = new OrderModel();
        model.addAttribute("order", order);

        return "productForm";
    }

    @PostMapping("/order/save")
    public String saveOrder(Model model, OrderModel order, RedirectAttributes ra){
        try {
            OrderModel savedOrder = service.saveOrder(order);
            model.addAttribute("order", savedOrder);
            ra.addFlashAttribute("message", "order saved successfully");

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/order/list";
    }

    @GetMapping("/order/list")
    public String displayOrders(Model model){
        try {
            List<OrderModel> listOrder = service.displayOrders();
            model.addAttribute("listOrder", listOrder);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "ordercrud";
    }

    @GetMapping("/order/edit/{id}")
    public String editProduct(@PathVariable("id") OrderModel id, Model model, RedirectAttributes ra){
        try{
            OrderModel order = service.findOrderById(id);
            model.addAttribute("order", order);
            model.addAttribute("pageTitle", "edit order (ID: "+id+")");

            return "orderEdit";

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/order/list";
    }

    @GetMapping("order/delete/{id}")
    public String deleteProduct(@PathVariable("id") OrderModel id, Model model, RedirectAttributes ra){
        try {
            service.deleteOrder(id);
            ra.addFlashAttribute("message", "Order successfully deleted");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/order/list";
    }

    @PostMapping("/order/edit")
    public String saveOrderEdition(Model model, OrderModel order, RedirectAttributes ra){
        try {
            OrderModel savedOrder = service.saveOrder(order);
            model.addAttribute("order", savedOrder);
            ra.addFlashAttribute("message", "order saved successfully");

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/order/list";
    }

}
