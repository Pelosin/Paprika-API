<p align="center">
  <img width="100%" src="https://capsule-render.vercel.app/api?type=waving&color=0:6DB33F,1:gradient&height=150&section=header" alt="Paprika API"/>
</p>

<h1 align="center">🌶️ Paprika API</h1>

<p align="center">
  <b>Restaurant kitchen-order backend</b> for the <a href="https://github.com/Pelosin/PAPrika">PAPrika</a> Android app and <a href="https://github.com/Pelosin/React_PAPrika">React_PAPrika</a> web client — my final-year professional course project (PAP).
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/Java_17-ED8B00?style=flat-square&logo=openjdk&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/JWT-000000?style=flat-square&logo=jsonwebtokens&logoColor=white" alt="JWT"/>
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white" alt="MySQL"/>
  <img src="https://img.shields.io/badge/WebSocket-010101?style=flat-square&logo=socketdotio&logoColor=white" alt="WebSocket"/>
  <img src="https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white" alt="Docker"/>
  <img src="https://img.shields.io/badge/License-MIT-e94f5f?style=flat-square" alt="MIT"/>
  <a href="https://github.com/Pelosin/Paprika-API/actions/workflows/ci.yml"><img src="https://github.com/Pelosin/Paprika-API/actions/workflows/ci.yml/badge.svg" alt="CI"/></a>
</p>

---

A stateless REST API that powers a restaurant's order flow: tables get occupied, guests submit orders line by line, the kitchen sees every order, and everything moves in real time over a WebSocket channel.

## ✨ Features

- 🍽️ **Full order flow** — tables (`occupy` / `leave` / `endOrder`), orders with multiple line items and status transitions
- 🔐 **JWT authentication** — custom login/authorization filters (jjwt), token refresh endpoint, role management (`ROLE_ADMIN` / `ROLE_USER`)
- 📡 **Real time** — WebSocket channel (`/ws-order`) so the kitchen sees new orders without polling
- 🗂️ **Menu management** — categories and food CRUD
- 🧾 **Detailed errors** — a `RestExceptionHandler` with structured error payloads (validation, bad request, invalid credentials)
- 🗄️ **Dual database** — H2 for development, MySQL for production (`docker-compose` included)
- 📦 **Mappers layer** — request/response payloads decoupled from JPA entities (FoodMapper, OrderMapper, UserMapper)

## 🔌 API surface

| Controller | Base path | Highlights |
|---|---|---|
| `UserController` | `/api` | `POST /login`, `POST /admin/login`, `GET /token/refresh`, role save/assign |
| `OrderController` | `/api/order` | create, list all, table orders, `PUT /endOrder/{id}` |
| `TableController` | `/api/table` | `PUT /occupy/{id}`, `PUT /leave/{id}`, by table number |
| `FoodController` | `/api/food` | menu CRUD |
| `CategoryController` | `/api/category` | category CRUD |

All endpoints are **stateless** (JWT bearer) — no server-side sessions.

## 🏛 Architecture

```
api/        Controllers (REST)
domain/     JPA entities (User, Role, Order, LineOrder, OrderStatus,
            Food, Category, TbTable)
mapper/     entity <-> payload mappers
payload/    request/response DTOs
config/
 ├── security/   JwtUtil, custom authN/authZ filters, SecurityConfiguration
 ├── socket/     WebSocket configurator + security
 └── audit/      custom JPA auditing
handler/    RestExceptionHandler (structured error responses)
exception/  typed exceptions with details payloads
```

## 🚀 Run it

```bash
# MySQL via Docker
docker compose up -d

# Start the API (H2 works out of the box for a quick try)
./mvnw spring-boot:run
```

Build a jar: `./mvnw clean package`

## ⚙️ Environment variables

| Variable | Description | Default |
|---|---|---|
| `JWT_SECRET` | **Required** — JWT signing key (`openssl rand -base64 48`) | none — the app fails to start without it |
| `JWT_EXPIRATION_MS` | Token lifetime in ms | `86400000` (24h) |
| `DB_URL` | JDBC URL | local MySQL `pap` schema |
| `DB_USERNAME` / `DB_PASSWORD` | Database credentials | `root` / `root` (dev only) |

## 🔗 The Paprika family

| Piece | Repo |
|---|---|
| 🌶️ Android app (Kotlin) | [PAPrika](https://github.com/Pelosin/PAPrika) |
| ⚛️ Web frontend (React) | [React_PAPrika](https://github.com/Pelosin/React_PAPrika) |
| ☕ This backend (Spring Boot) | you are here |

## 📄 License

[MIT](LICENSE) © João Pelosi
