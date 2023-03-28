# Cinema

API интерфейс управления кинотеатром.
<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->


<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="src/main/resources/img/CinemaAPI.png">
    <img src="src/main/resources/img/CinemaAPI.png" alt="Logo" width="549" height="">
  </a>
</div>



## Предназначение сервиса

Cinema API это имитация сервиса работы кинотеатра.
С его помощью можно купить билет на фильм, посмотреть список фильмов, узнать актерский состав, а также отсортировать
фильмы по критериям(жанр, актер, режисер).
Кроме того сервис поддерживает работу с заказчиками рекламы.
Перед каждым показом фильма проигрывается реклама, которая привязана к заказчику и обладает некоторыми свойствами(тип
рекламы, продолжительность).

<p align="right">(<a href="#readme-top">Наверх</a>)</p>

### Стэк технологий

* Spring Boot
* Swagger
* Liquibase
* PostgresSql
* Hibernate

<p align="right">(<a href="#readme-top">Наверх</a>)</p>

## Архитектура сервиса

Схема базы данных.
<img src="src/main/resources/img/DBSchema.png">

<!-- GETTING STARTED -->

## OpenApi

Каждая из сущностей бд поддерживает CRUD операции. Кроме того производится автоматический расчет стоимости билета на основании ряда и времени сеанса.
<img src="src/main/resources/img/API1.jpg">

### Данные
Для полноценной работы базы данных, необходимы следующие сущности:

* Film
* Actor
* Director
* Country
* Company
* Session
* Room
* Row
* Ticket
* Advertising
* AdType
* Client
* Booking


