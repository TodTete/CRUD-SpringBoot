
# 📘 CRUD Básico con Spring Boot

Proyecto sencillo que implementa un **CRUD (Create, Read, Update, Delete)** usando **Spring Boot, Spring Data JPA y MySQL**. Permite gestionar productos mediante una API REST.

---

## 🧩 Tecnologías

* Java 17+
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

---

## ⚙️ Configuración

Archivo `application.properties`:

```properties
spring.application.name=Semana1

spring.datasource.url=jdbc:mysql://localhost:3306/academia
spring.datasource.username=root
spring.datasource.password=123

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

server.port=8080
```

---

## 📂 Estructura del Proyecto

```
src/main/java/com/example/demo
│
├── controller   → Controladores REST (Endpoints)
├── entity       → Entidades JPA (Modelo / Tabla)
├── repository   → Acceso a datos (JPA Repository)
└── service      → Lógica de negocio
```

### Explicación

* **Entity**: Representa la tabla `Producto` en la base de datos.
* **Repository**: Interfaz que extiende `JpaRepository` para operaciones CRUD automáticas.
* **Service**: Contiene la lógica de negocio.
* **Controller**: Expone los endpoints REST.

---

## ▶️ Ejecutar el Proyecto

### 1. Clonar repositorio

```bash
git clone https://github.com/usuario/demo.git
cd demo
```

### 2. Compilar

```bash
mvn clean install
```

### 3. Ejecutar

```bash
mvn spring-boot:run
```

Servidor disponible en:

```
http://localhost:8080
```
---

## 🗄️ Base de Datos

Este proyecto utiliza **MySQL**. Debe crear la base de datos antes de ejecutar la aplicación.

### 1. Crear base de datos

```sql
CREATE DATABASE academia;
USE academia;
```

---

### 2. Tabla Producto

Si desea crearla manualmente:

```sql
CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DOUBLE NOT NULL,
    stock INT NOT NULL,
    categoria VARCHAR(100)
);
```

> Nota: Si mantiene la configuración
> `spring.jpa.hibernate.ddl-auto=update`
> Spring Boot creará la tabla automáticamente a partir de la entidad.

---

### 3. Verificar conexión

Asegúrese de que MySQL esté activo y que los datos coincidan con `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/academia
spring.datasource.username=root
spring.datasource.password=123
```
---

## 🔌 Endpoints

### 📥 Crear producto

**POST** `/api/productos`

```json
{
  "nombre": "Laptop",
  "precio": 15000,
  "stock": 5,
  "categoria": "Tecnologia"
}
```

---

### 📄 Obtener todos

**GET** `/api/productos`

```
http://localhost:8080/api/productos
```

---

### ✏️ Actualizar

**PUT** `/api/productos/{id}`

```json
{
  "nombre": "Laptop",
  "precio": 10000,
  "stock": 5,
  "categoria": "Tecnologia"
}
```

Ejemplo:

```
http://localhost:8080/api/productos/1
```

---

### ❌ Eliminar

**DELETE** `/api/productos/{id}`

```
http://localhost:8080/api/productos/1
```

---

## 🧠 Flujo del CRUD

1. El **Controller** recibe la petición HTTP.
2. Llama al **Service**.
3. El **Service** usa el **Repository**.
4. El **Repository** interactúa con la base de datos.
5. Se retorna la respuesta JSON.

---

## 📌 Notas

* JPA genera automáticamente las consultas SQL.
* `show-sql=true` permite visualizar las consultas en consola.
* `ddl-auto=update` mantiene sincronizada la tabla con la entidad.

---

Autor: Ricardo Vallejo Sanchez 
