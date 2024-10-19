Класс Order управляет заказом: добавляет товары, рассчитывает общую стоимость заказа с учетом скидок, обрабатывает оплату, доставку и уведомления.
SRP: Каждый класс выполняет только свою задачу
Интерфейс IPayment и его реализации (CreditCardPayment, PayPalPayment, BankTransferPayment) позволяют легко добавлять новые способы оплаты.
OCP: Легко добавлять новые способы оплаты, доставки и уведомлений без изменения существующего кода
Интерфейс IDelivery и его реализации (CourierDelivery, PostDelivery, PickUpPointDelivery) позволяют добавлять новые способы доставки.
LSP: Все дочерние классы CreditCardPayment могут заменять интерфейсы которые они реализуют
Интерфейс INotification и его реализации (EmailNotification, SmsNotification) отправляют уведомления клиентам.
ISP: Разделение интерфейсов, чтобы классы реализовывали только необходимые методы
Класс DiscountCalculator рассчитывает скидку для заказа.
DIP: Абстракции (IPayment, IDelivery, INotification) используются вместо конкретных реализаций.
В методе main создается пример заказа с товарами, платежами, доставкой и уведомлением клиента.
