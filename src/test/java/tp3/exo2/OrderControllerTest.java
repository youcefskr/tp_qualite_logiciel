package tp3.exo2;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Test
    public void testCreateOrder() {

        OrderService orderServiceMock = mock(OrderService.class);
        OrderDao orderDaoMock = mock(OrderDao.class);
        OrderService orderService = new OrderService(orderDaoMock);
        OrderController orderController = new OrderController(orderServiceMock);
        Order order = new Order(1L, "Test Order");
        orderController.createOrder(order);
        verify(orderServiceMock).createOrder(order);
        OrderController orderControllerWithRealService = new OrderController(orderService);
        orderControllerWithRealService.createOrder(order);
        verify(orderDaoMock).saveOrder(order);
    }
}