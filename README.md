# Родионова С.Г. студент группы ИПБ-21

Классы:
* Web - класс, в котором описаны все запросы;
* Controller - класс, в котором описаны методы для работы с объектами
* Character - класс, в котором описаны поля персонажа
* CharacterAddDTO - класс, используемый в запросе для добавления персонажа

Реализованные запросы:
* Список из всех персонажей (get http://localhost:8080/characters)
* Получить персонажей по полу (get http://localhost:8080/characters/filter)
* Получить персонажа по id (get http://localhost:8080/characters/{id})
* Добавить персонажа (post http://localhost:8080/characters/{id}/friends body: CharacterAddDTO)
* Изменить персонажа (put http://localhost:8080/characters/{id}/friends body: Character)
* Удалить персонажа по id (delete http://localhost:8080/characters/{id})
* Добавить персонажу друга (post http://localhost:8080/characters/{id}/friends body: String)
* Добавить персонажу несколько друзей (post http://localhost:8080/characters/{id}/friends body: List<String>)
