import java.util.ArrayList;
import java.util.List;

class Order {
    private List<Item> items = new ArrayList<>();
    private IPayment paymentMethod;
    private IDelivery deliveryMethod;
    private INotification notificationMethod;

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateTotal(DiscountCalculator discountCalculator) {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return discountCalculator.applyDiscount(total);
    }

    public void setPaymentMethod(IPayment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDeliveryMethod(IDelivery deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public void setNotificationMethod(INotification notificationMethod) {
        this.notificationMethod = notificationMethod;
    }

    public void processOrder() {
        double total = calculateTotal(new DiscountCalculator());
        paymentMethod.processPayment(total);
        deliveryMethod.deliverOrder(this);
        notificationMethod.sendNotification("order saved ");
    }

    public List<Item> getItems() {
        return items;
    }
}

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

interface IPayment {
    void processPayment(double amount);
}

class CreditCardPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println(" credit card payment of " + amount);
    }
}

class PayPalPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println(" PayPal payment of " + amount);
    }
}

class BankTransferPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println(" bank transfer payment of " + amount);
    }
}

interface IDelivery {
    void deliverOrder(Order order);
}

class CourierDelivery implements IDelivery {
    @Override
    public void deliverOrder(Order order) {
        System.out.println("deliver courier ");
    }
}

class PostDelivery implements IDelivery {
    @Override
    public void deliverOrder(Order order) {
        System.out.println("deliver post ");
    }
}

class PickUpPointDelivery implements IDelivery {
    @Override
    public void deliverOrder(Order order) {
        System.out.println(" pickup at the point ");
    }
}

interface INotification {
    void sendNotification(String message);
}

class EmailNotification implements INotification {
    @Override
    public void sendNotification(String message) {
        System.out.println(" email " + message);
    }
}

class SmsNotification implements INotification {
    @Override
    public void sendNotification(String message) {
        System.out.println(" SMS " + message);
    }
}

class DiscountCalculator {
    public double applyDiscount(double total) {
        return total * 0.9;
    }
}

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new Item("Thunderobot 911", 500));
        order.addItem(new Item("Logitech g102", 10));

        order.setPaymentMethod(new CreditCardPayment());
        order.setDeliveryMethod(new CourierDelivery());
        order.setNotificationMethod(new EmailNotification());

        order.processOrder();
    }
}
