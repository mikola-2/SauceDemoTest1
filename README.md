CheckList
LOGIN PAGE

1.Проверка возможности залогироваться пользователю с данными, существующими в системе.
2. Проверка возможности залогироваться только с помощью логина;
3. Проверка возможности залогироваться только с помощью пароля;
4. Проверка возможности залогироваться пользователю с данными, не существующими в системе;
5. Проверка возможности залогироваться сданными заблокированного пользователя;

INVENTORY PAGE

6. Проверяем возможность просмотреть информацию по конкретному товару;
7. Проверка возможности добавления товара в корзину;
8. Проверка возможности удаления товара из корзины со страницы “Inventory”  с помощью кнопки “REMOVE”;
9.  Проверка работы фильтра товаров
10.  Проверка работы кнопки “Open Menu”;
11. Проверка работы значка “Shopping Cart”;
12. Проверка кликабельности  значков социальных сетей;

SHOPPING CART PAGE

13. Проверка возможности удаления товара из корзины со страницы корзины с помощью кнопки “REMOVE”;	
14. Проверка работы кнопки “CONTINUE SHOPPING ”;
15. Проверка соответствия названия товара в корзине с названием этого же товара на странице “Inventory”.
16. Проверка соответствия стоимости товара в корзине с названием этого же товара на странице “Inventory”.
17. Проверка работы кнопки “ CHECKOUT”;

CHECKOUT PAGE
 
18.  Проверка работы кнопки “CANCEL”;
19. Проверка возможности создать заказ, введя валидные данные имени, фамилии и зип-код.
20. Проверка возможности создать заказ без ввода имени.
21.  Проверка возможности создать заказ без ввода фамилии.
22.  Проверка возможности создать заказ без ввода зип-кода.
23. Проверка возможности создать заказ c вводом в поля имя, фамилия и зип-код несуществующих данных.
24. Проверить правильно ли суммируется сумма заказа;
25. Проверить появилась ли информация о номере заказа и способе доставки.
26. Проверка работы кнопки “Finish ”.
  


Maven. Обновления и запуск тестовю
I.	Просмотр доступных обновлений и обновление версий всех библиотек в проекте
o	Команда mvn versions:display-dependency-updates (просмотр доступных обновлений библиотек)
    -> 
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   io.github.bonigarcia:webdrivermanager ................. 5.0.1 -> 5.0.3
[INFO]   org.seleniumhq.selenium:selenium-java .............. 3.141.59 -> 4.1.1
[INFO]   org.testng:testng ..................................... 7.1.0 -> 7.4.0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  18.992 s
[INFO] Finished at: 2021-12-22T12:54:04+03:00
o	- Команда mvn versions:use-latest-versions (автоматическое обновление всех версий)
  ->
[INFO] Major version changes allowed
[INFO] Updated org.testng:testng:jar:7.1.0 to version 7.4.0
[INFO] Updated org.seleniumhq.selenium:selenium-java:jar:3.141.59 to version 4.1.1
[INFO] Updated io.github.bonigarcia:webdrivermanager:jar:5.0.1 to version 5.0.3
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.751 s
[INFO] Finished at: 2021-12-22T13:12:49+03:00

II.	Запуск тестов
o	Команда mvn clean test
                    ->
              Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 68.327 sec
Results :
Tests run: 10, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:16 min
[INFO] Finished at: 2021-12-22T14:31:14+03:00
o	Команда  mvn -Dtest=LoginPageTest test
   ->
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 31.768 sec
Results :
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  37.791 s
[INFO] Finished at: 2021-12-22T14:38:34+03:00

o	Команда  mvn test -Dtest=SortTest#checkSortByName test
   ->
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 11.968 s - in tests.SortTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
 [INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  18.182 s
[INFO] Finished at: 2021-12-22T15:00:52+03:00

o	Команда mvn -Dtest=SortTest#checkSortByName+checkSortByPrice test
->
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 13.3 s - in tests.SortTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  17.978 s
[INFO] Finished at: 2021-12-22T15:12:34+03:00


o	Команда mvn -Dtest="SortTest,BurgerMenuTest" test
               ->
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 31.988 s - in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  37.493 s
[INFO] Finished at: 2021-12-22T15:35:50+03:00
