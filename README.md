Класс Order управляет заказом: добавляет товары, рассчитывает общую стоимость заказа с учетом скидок, обрабатывает оплату, доставку и уведомления.
Интерфейс IPayment и его реализации (CreditCardPayment, PayPalPayment, BankTransferPayment) позволяют легко добавлять новые способы оплаты.
Интерфейс IDelivery и его реализации (CourierDelivery, PostDelivery, PickUpPointDelivery) позволяют добавлять новые способы доставки.
Интерфейс INotification и его реализации (EmailNotification, SmsNotification) отправляют уведомления клиентам.
Класс DiscountCalculator рассчитывает скидку для заказа.
В методе main создается пример заказа с товарами, платежами, доставкой и уведомлением клиента.
