package org.example.data;

import org.example.dto.OrderDTO;
import org.example.dto.OrderItemDTO;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.List;

@Component
public class OrderDataInitializer implements CommandLineRunner {
    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        Yaml yaml = new Yaml(new Constructor(OrderDTO.class));
        InputStream inputStream = getClass().getResourceAsStream("/orders.yml");
        List<OrderDTO> orders = yaml.load(inputStream);

        for (OrderDTO orderDTO : orders) {
            orderService.placeOrder(orderDTO);
        }
    }
}

