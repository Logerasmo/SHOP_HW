<H1>Задача Магазин</H1>
Пример использования Magics:
https://github.com/Logerasmo/SHOP_HW/blob/25277ee8821f809e946d4a37569e6b662b53ce2f/src/main/java/org/example/services/Product.java#L16
Пример использования DRY, сделан один метод для печати списка товаров, используется много раз
https://github.com/Logerasmo/SHOP_HW/blob/25277ee8821f809e946d4a37569e6b662b53ce2f/src/main/java/org/example/services/UserCommunication.java#L81
<H2>SOLID</H2>
<H3>S - принцип единственной ответственности </H4>
https://github.com/Logerasmo/SHOP_HW/blob/25277ee8821f809e946d4a37569e6b662b53ce2f/src/main/java/org/example/services/ConsoleLogger.java#L5
https://github.com/Logerasmo/SHOP_HW/blob/25277ee8821f809e946d4a37569e6b662b53ce2f/src/main/java/org/example/services/FileLogger.java#L7
Оба класса разработаны для логирования, и нигде больше не могут использоваться
<H3>O - принцип открытости/закрытости</H4>
https://github.com/Logerasmo/SHOP_HW/blob/25277ee8821f809e946d4a37569e6b662b53ce2f/src/main/java/org/example/services/ConsoleLogger.java#L5
https://github.com/Logerasmo/SHOP_HW/blob/25277ee8821f809e946d4a37569e6b662b53ce2f/src/main/java/org/example/services/FileLogger.java#L7
https://github.com/Logerasmo/SHOP_HW/blob/25277ee8821f809e946d4a37569e6b662b53ce2f/src/main/java/org/example/services/Logger.java#L3
Для создания других логгеров не нужно изменять уже имеющийся код, достаточно добавить реализацию этого интерфейса
