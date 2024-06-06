package vn.hoidanit.laptopshop.controllers.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.services.OderService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    private final OderService orderService;

    public OrderController(OderService orderService) {

        this.orderService = orderService;
    }

    @GetMapping("/admin/order")
    public String getAllOder(Model model) {

        List<Order> orders = new ArrayList<Order>();
        orders = this.orderService.getAllOrder();
        model.addAttribute("orders", orders);
        return "admin/order/show";
    }

    @GetMapping("/admin/order/update/{id}")
    public String getUpdateOrder(Model model, @PathVariable Long id) {
        Optional<Order> order = this.orderService.fetchOrderById(id);
        model.addAttribute("newOrder", order.orElse(new Order())); // Nếu không tìm thấy order, trả về một Order mới để
                                                                   // tránh NullPointerException
        model.addAttribute("id", id);
        return "admin/order/update";
    }

    @PostMapping("/admin/order/update")
    public String handleUpdateOrder(@ModelAttribute("newOrder") Order order) {
        this.orderService.updateOrder(order);
        return "redirect:/admin/order";
    }

}
