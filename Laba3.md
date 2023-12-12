# Лабораторная работа №3

## Краткое описание варианта использования

Выберем процесс аутентификации в приложении по учёту ПО и КТС с использованием разных ролей пользователя, как один из основных вариантов использования. На диаграмме компонентов, представленной ниже, можно увидеть, как процесс авторизации в приложении связан с системой в целом (с клиентской и серверной частями):

![Общая диаграмма компонентов](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/dd65565c-8e4f-4eba-855a-d5ea99524145)

После этого перейдем к более детальному описанию процесса аутентификации в приложении различными видами пользователей. Построим диаграмму последовательностей, на которой отразим основные моменты авторизации пользователя (администратора, пользователя с расширенным функционалом и пользователя с огранченным функционалом) в приложении:

![Диаграмма последовательностей](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/d8957e42-ad57-4896-b0a7-017d83af20bc)

## Схемы базы данных

В настоящей работе предусмотрено использование двух баз данных (по учёту программного обеспечения и комплекса технических средств), которые существуют независимо друг от друга.

___Схема базы данных по учёту ПО:___

![Схема БД по учёту ПО](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/063a0ba9-b21b-41a8-9033-93f3c2501ef2)

___Схема базы данных по учёту КТС:___

![Схема БД по учёту КТС](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/e73ad181-2264-4ccf-9a89-fd82e7efe067)

Структура базы данных по учёту ПО (описание таблицы):

![POT1](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/4abc914c-00b3-41ea-9458-48ff6badbb6c)

Структура базы данных по учёту КТС (описание таблиц):

![Equip](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/7cc6369f-b13c-46f4-bb0e-89143f0cbb84)

![Status](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/d87483ae-c4a3-43ab-8011-50200eb6e485)

![Users](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/c55e9378-4d58-4c0c-a36e-40cb31826c97)

![Address](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/eafe2ad5-020d-4626-9022-dbbb3d7d2f3c)

![Job](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/0c60a615-b1ea-4097-8816-42c257485a76)

![Offices](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/27b690d3-1acb-4198-8230-84a044b39405)

![Type](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/b6e73d30-0195-4d6a-bc6a-02edb044cd56)

![NaSt](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/5bd9a524-7d56-4b6b-967f-e0b1cecd7b5b)

![NetH](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/84887b24-f464-4e9c-ad02-9c2143815fcb)

![THNB](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/f6eadd1d-2cea-40ab-8c0e-391bdb70c89a)

![THSB](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/7a5b7dda-60c9-4e14-a6fb-4eb1e285f7b3)

Приступим к реализации серверного и клиентского кода с учётом принципов KISS, YAGNI, DRY и SOLID.
Для начала необходимо понять, что означает каждый из этих принципов:
* KISS (Keep It Simple, Stupid / Будь проще) - код должен быть производительным, эффективным и простым;
* YAGNI (You Aren’t Gonna Need It / Вам это не понадобится) - нужно писать только тот код, который понадобится;
* DRY (Don’t Repeat Yourself / Не повторяйтесь) - нужно избегать дублирования кода;
* SOLID (Single-responsibility principle /Принцип единственной ответственности) - Каждый объект, класс и метод должны отвечать только за что-то одно.
Далее представлены фрагменты кода с использованием вышеперечисленных принципов проектирования и реализации модулей.

KISS (названия переменных интуитивно понятны, код является простым, эффективным и в то же время производительным):

![KISS](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/562c886d-7c8c-43b1-8f4f-696c63cf0c7d)

YAGNI (исключаем те методы и функции, которые не пригодятся (закомментируем их) и оставляем только те, которые понадобятся):

![YAGNI](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/ce19269c-6875-48ca-aa3f-41a8fa84dfeb)

DRY (чтобы избежать дублирование кода, было принято решение создать функции):

![DRY](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/bc56e1fc-3cb5-402c-9820-3677b1af60f8)

SOLID (для того, чтобы избежать ситуации, когда какой-либо объект, класс или метод отвечает за разный функционал, было принято решение поделить на классы - каждый класс решает определенную задачу):

![SOLID](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/9a4eebdb-f039-4cf5-be25-3cf0d36b1b6c)

Объекты и методы внутри классов также отвечают только за что-то одно:

![SOLID 2](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/assets/100124384/f029344f-df50-48c3-b7b2-45423ca3654d)
