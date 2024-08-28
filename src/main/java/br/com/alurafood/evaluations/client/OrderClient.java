package br.com.alurafood.evaluations.client;

import br.com.alurafood.evaluations.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("orders-ms")
public interface OrderClient {
    @RequestMapping(method = RequestMethod.GET, value = "/orders/{id}")
    OrderDto getOrderById(@PathVariable Long id);
}
