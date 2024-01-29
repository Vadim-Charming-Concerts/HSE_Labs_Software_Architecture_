markdown синтаксис

1. Подробное описание методов.

GET
- URL запроса (http://localhost:8080/my-rest)
- обязательные параметры запроса (?param=1)
- обязательные хедеры запроса (Authorization=любое значение)
- тела у запроса нет
- статус код ответа: 200 OK
- header ответа: ("My-Header", "custom/header")
- тело ответа:
  {
  "code": 200,
  "message": "OK",
  "details": "Request completed"
  }

POST
- URL запроса (http://localhost:8080/my-rest)
- обязательных параметров у запроса нет
- обязательные хедеры запроса (Authorization=любое значение)
- обязательное тело запроса:
  {
  "name": "some body"
  }
- статус код ответа: 201 Created
- header ответа ("My-Header", "custom/header") отсутствует
- тело ответа:
  {
  "code": 201,
  "message": "Created",
  "details": "Request completed"
  }

PUT
- URL запроса (http://localhost:8080/my-rest)
- обязательные параметры запроса (?param=1)
- обязательные хедеры запроса (Authorization=любое значение)
- обязательное тело запроса:
  {
  "name": "some body"
  }
- статус код ответа: 201 Created
- header ответа ("My-Header", "custom/header") отсутствует
- тело ответа:
  {
  "code": 201,
  "message": "Created",
  "details": "Request completed"
  }

DELETE
- URL запроса (http://localhost:8080/my-rest)
- обязательная переменная пути: /1
- параметров у запроса нет
- обязательные хедеры запроса (Authorization=любое значение)
- тела у запроса нет
- статус код ответа: 200 OK
- header ответа ("My-Header", "custom/header") отсутствует
- тело ответа:
  {
  "code": 200,
  "message": "OK",
  "details": "Request completed"
  }

Альтернативные сценарии взаимодействия REST (когда будет отображаться ошибка).
<br>
Когда не указаны обязательные характеристики запроса для GET, POST, PUT, DELETE возвращается стандартная ошибка:
<br>
Статус код: 400 Bad Request
<br>
Тело ответа с ошибкой:
<br>

```json
{
  "timestamp": "2024-01-28T17:56:12.142+00:00",
  "status": 400,
  "error": "Bad Request",
  "path": "/my-rest"
}
```
<br>
Когда не указана переменная пути для запроса DELETE, возвращается стандартная ошибка:
<br>
Статус код: 405 Method Not Allowed
<br>
Тело ответа с ошибкой:
<br>

```json
{
  "timestamp": "2024-01-28T17:59:06.576+00:00",
  "status": 405,
  "error": "Method Not Allowed",
  "path": "/my-rest/"
}
```

---

Файлик с отчетом, скриншотами о тестировании

[Отчёт_о_тестировании.md](https://github.com/Vadim-Charming-Concerts/HSE_Labs_Software_Architecture_/blob/LabWork4/%D0%9E%D1%82%D1%87%D0%B5%D1%82_%D0%BE_%D1%82%D0%B5%D1%81%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B8.md)
