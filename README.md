1. Реализован на java (spring boot) микросервис для генерации уникального кода табло (a0a0, a0a1, a0a2, ..., a0a9, a0b0, a0b1, ..., a0z9, a1a0...).
- Значения для символов: a-z
- Значение для цифр: 0-9

Функция генерации должна принимать начальное значение кода через входной параметр.
При достижении порога серия должна увеличиваться: (z9z9 -> a0a0a0, z9z9z9 -> a0a0a0a0 и т.д.).

2. Добавлены тесты (jUnit5) на граничные значения функции генерации уникального кода.
 
3. Добавлен entity для хранения последнего значения, начальный код a0a0 загружен используя миграцию. В качестве БД использован PostgreSQL.
 
4. Добавлен API для получения следующего значения (с сохранением нового кода в БД).
