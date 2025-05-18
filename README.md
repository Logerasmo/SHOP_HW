<H1>Задача Магазин</H1>
Пример использования Magics:
https://github.com/Logerasmo/SHOP_HW/blob/25277ee8821f809e946d4a37569e6b662b53ce2f/src/main/java/org/example/services/Product.java#L16
Пример использования DRY, сделан один метод для печати списка товаров, используется много раз
https://github.com/Logerasmo/SHOP_HW/blob/25277ee8821f809e946d4a37569e6b662b53ce2f/src/main/java/org/example/services/UserCommunication.java#L81
<H2>SOLID</H2>
<H3>S - принцип единственной ответственности </H3>
https://github.com/Logerasmo/SHOP_HW/blob/25277ee8821f809e946d4a37569e6b662b53ce2f/src/main/java/org/example/services/ConsoleLogger.java#L5
https://github.com/Logerasmo/SHOP_HW/blob/25277ee8821f809e946d4a37569e6b662b53ce2f/src/main/java/org/example/services/FileLogger.java#L7
Оба класса разработаны для логирования, и нигде больше не могут использоваться
<H3>O - принцип открытости/закрытости</H3>
https://github.com/Logerasmo/SHOP_HW/blob/b8ac526319430e177e73cca606021e2de4eb84d2/src/main/java/org/example/services/PredicateBuilder.java#L5
В predicateBuilder можно добавлять новые методы, для этого не требуется изменять уже имеющиеся
<H3>L - принцип замены Барбары Лисков</H3>
https://github.com/Logerasmo/SHOP_HW/blob/25277ee8821f809e946d4a37569e6b662b53ce2f/src/main/java/org/example/services/ConsoleLogger.java#L5
https://github.com/Logerasmo/SHOP_HW/blob/25277ee8821f809e946d4a37569e6b662b53ce2f/src/main/java/org/example/services/FileLogger.java#L7
ConsoleLogger и FileLogger могут взаимозаменяемо использоваться везде, где ожидается Logger

<H3>D - принцип инверсии зависимостей</H3>
https://github.com/Logerasmo/SHOP_HW/blob/b8ac526319430e177e73cca606021e2de4eb84d2/src/main/java/org/example/services/Cart.java#L13
Cart принимает UserCommunication в protected конструкторе, а не создает его сам
