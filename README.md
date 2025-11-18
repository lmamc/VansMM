# 🚐 Sistema de Reservas de Vans para Conciertos

Sistema backend desarrollado con Spring Boot para gestionar traslados en vans hacia eventos y conciertos. Permite la creación de empresas de transporte, gestión de vehículos, programación de viajes, y reservas de asientos por parte de usuarios.


## ✨ Características

- 🔐 **Autenticación JWT**: Sistema de login/registro seguro con tokens JWT
- 👥 **Gestión de Usuarios**: Registro con roles (Usuario/Admin)
- 🏢 **Empresas de Transporte**: CRUD completo para empresas de vans
- 🎸 **Bandas y Conciertos**: Gestión de eventos musicales
- 🚐 **Vehículos**: Administración de flota de vans por empresa
- 🗓️ **Viajes**: Programación de traslados hacia conciertos
- 💺 **Asientos**: Generación automática de asientos por capacidad del vehículo
- 📝 **Reservas**: Sistema de reservas con validación de disponibilidad
- 💳 **Pagos**: Registro de transacciones (efectivo, tarjeta, transferencia)

## 🛠️ Tecnologías
- **Git**
- **Java 24**
- **Spring Boot 3.3.5**
  - Spring Security
  - Spring Data JPA
  - Spring Web
  - Spring Boot Actuator
- **Oracle Database 11g o superior **
- **Maven 3.8+**
- **JWT (JSON Web Tokens)** - Autenticación
- **BCrypt** - Encriptación de contraseñas
- **Maven** - Gestión de dependencias
- **JUnit 5** - Testing


## 📡 API Endpoints

### 🔐 Autenticación

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| POST | `/auth/register` | Registrar nuevo usuario | No |
| POST | `/auth/login` | Iniciar sesión (retorna JWT) | No |

### 👥 Usuarios

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| GET | `/usuarios` | Listar todos los usuarios | Sí |
| GET | `/usuarios/{id}` | Obtener usuario por ID | Sí |

### 🎭 Roles

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| POST | `/roles` | Crear rol | Sí |
| GET | `/roles` | Listar roles | Sí |

### 🏢 Empresas

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| POST | `/empresas` | Crear empresa | Sí |
| GET | `/empresas` | Listar empresas | Sí |
| GET | `/empresas/{id}` | Obtener empresa por ID | Sí |

### 🎸 Bandas

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| POST | `/bandas` | Crear banda | Sí |
| GET | `/bandas` | Listar bandas | Sí |

### 🎤 Conciertos

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| POST | `/conciertos` | Crear concierto | Sí |
| GET | `/conciertos` | Listar conciertos | **No** (público) |
| GET | `/conciertos/{id}` | Obtener concierto por ID | Sí |

### 🚐 Vehículos

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| POST | `/vehiculos` | Crear vehículo | Sí |
| GET | `/vehiculos` | Listar vehículos | Sí |
| GET | `/vehiculos/{id}` | Obtener vehículo por ID | Sí |
| GET | `/vehiculos/empresa/{empresaId}` | Vehículos por empresa | Sí |

### 🗓️ Viajes

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| POST | `/viajes` | Crear viaje (genera asientos) | Sí |
| GET | `/viajes` | Listar viajes | Sí |
| GET | `/viajes/{id}` | Obtener viaje por ID | Sí |

> **Nota**: Al crear un viaje, se generan automáticamente los asientos según la capacidad del vehículo.

### 💺 Asientos

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| GET | `/asientos/{id}` | Obtener asiento por ID | Sí |
| GET | `/asientos/viaje/{viajeId}` | Listar asientos de un viaje | Sí |
| GET | `/asientos/viaje/{viajeId}/disponibles` | Asientos disponibles | Sí |
| PATCH | `/asientos/{id}/estado?estado=reservado` | Actualizar estado | Sí |

### 📝 Reservas

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| POST | `/reservas` | Crear reserva | Sí |
| GET | `/reservas` | Listar reservas | Sí |
| GET | `/reservas/{id}` | Obtener reserva por ID | Sí |
| PATCH | `/reservas/{id}/cancelar` | Cancelar reserva | Sí |

> **Lógica de Negocio**: 
> - Valida que el asiento esté disponible
> - Actualiza estado del asiento a "reservado"
> - Decrementa asientos disponibles del viaje
> - Al cancelar, libera el asiento e incrementa disponibilidad 

### 💳 Pagos (Futura implementación)

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| POST | `/pagos` | Crear pago | Sí |
| GET | `/pagos` | Listar pagos | Sí |
| GET | `/pagos/{id}` | Obtener pago por ID | Sí |

**Tipos de Pago**:
- `1` - Efectivo
- `2` - Tarjeta
- `3` - Transferencia



