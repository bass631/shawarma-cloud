package ru.dbastrygin.shawarmacloud.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import ru.dbastrygin.shawarmacloud.model.ShawarmaOrder;
import ru.dbastrygin.shawarmacloud.repository.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("shawarmaOrder")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid ShawarmaOrder shawarmaOrder, Errors errors,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Order submitted: {}", shawarmaOrder);
        orderRepository.save(shawarmaOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
