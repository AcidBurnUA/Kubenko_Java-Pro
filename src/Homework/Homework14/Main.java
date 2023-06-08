package Homework14;

import Homework14.coffee.CoffeeOrderBoard;
import Homework14.coffee.order.Order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        Order order1 = new Order("Никита");
        Order order2 = new Order("Даня");
        Order order3 = new Order("Кирилл");
        Order order4 = new Order("Ярик");

        orderBoard.add(order1);
        orderBoard.add(order2);
        orderBoard.add(order3);
        orderBoard.add(order4);

        orderBoard.draw();

        Order nextOrder = orderBoard.deliver();
        if (nextOrder != null) {
            System.out.println("Доставленный: " + nextOrder.getCustomerName());
        } else {
            System.out.println("Нет заказов на доставку");
        }

        orderBoard.draw();

        Order specificOrder = orderBoard.deliver(3);
        if (specificOrder != null) {
            System.out.println("Доставили конкретный заказ: " + specificOrder.getCustomerName());
        } else {
            System.out.println("Заказ не найден.");
        }

        orderBoard.draw();
    }
}
