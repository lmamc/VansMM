# 🚐 Sistema de Reservas de Vans para Conciertos

Sistema backend desarrollado con Spring Boot para gestionar traslados en vans hacia eventos y conciertos. Permite la creación de empresas de transporte, gestión de vehículos, programación de viajes, y reservas de asientos por parte de usuarios.

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Tecnologías](#-tecnologías)
- [Requisitos Previos](#-requisitos-previos)
- [Instalación](#-instalación)
- [Configuración](#-configuración)
- [Ejecución](#-ejecución)
- [API Endpoints](#-api-endpoints)
- [Testing](#-testing)
- [Seguridad](#-seguridad)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Contribuir](#-contribuir)

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

- **Java 24**
- **Spring Boot 3.3.5**
  - Spring Security
  - Spring Data JPA
  - Spring Web
  - Spring Boot Actuator
- **Oracle Database**
- **JWT (JSON Web Tokens)** - Autenticación
- **BCrypt** - Encriptación de contraseñas
- **Maven** - Gestión de dependencias
- **JUnit 5** - Testing

## 📦 Requisitos Previos

Antes de comenzar, asegúrate de tener instalado:

- **Java JDK 24** o superior
- **Maven 3.8+**
- **Oracle Database** (11g o superior)
- **Git**

## 🚀 Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/lmamc/VansMM.git
cd VansMM
```

### 2. Configurar la Base de Datos

Ejecuta el siguiente script SQL en tu base de datos Oracle:

```sql
-- Crear las secuencias
CREATE SEQUENCE SEQ_USUARIO_ID START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_EMPRESA_ID START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_ROLES_ID START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_BANDAS_ID START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_CONCIERTOS_ID START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_VEHICULO_ID START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_VIAJES_ID START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_ASIENTOS_ID START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_RESERVA_ID START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_PAGOS_ID START WITH 1 INCREMENT BY 1;

-- Crear las tablas (ver database_migration.sql para el script completo)
```

### 3. Configurar Variables de Entorno

Crea el archivo `application.properties` basándote en el ejemplo:

```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

Edita `application.properties` con tus credenciales:

```properties
# JWT Secret (genera uno seguro con: openssl rand -base64 64)
jwt.secret=tu-secret-jwt-muy-largo-y-seguro

# Oracle Database
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XEPDB1
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

# CORS (agrega tus dominios frontend)
cors.allowed.origins=http://localhost:8100,http://localhost:4200
```

### 4. Instalar Dependencias

```bash
mvn clean install
```

## ▶️ Ejecución

### Modo Desarrollo

```bash
mvn spring-boot:run
```

### Generar JAR y Ejecutar

```bash
mvn clean package
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

El servidor se iniciará en: `http://localhost:8080`

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

### 💳 Pagos

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| POST | `/pagos` | Crear pago | Sí |
| GET | `/pagos` | Listar pagos | Sí |
| GET | `/pagos/{id}` | Obtener pago por ID | Sí |

**Tipos de Pago**:
- `1` - Efectivo
- `2` - Tarjeta
- `3` - Transferencia

### 🔑 Autenticación en Requests

Para endpoints protegidos, incluye el header:

```
Authorization: Bearer {tu_jwt_token}
```

### 📮 Colección de Postman

Importa la colección incluida en el proyecto: `Vans_Backend_API_Corrected.postman_collection.json`

**Variables de entorno requeridas:**
- `base_url`: `http://localhost:8080`

## 🧪 Testing

El proyecto incluye tests unitarios para todos los servicios.

### Ejecutar Tests

```bash
# Todos los tests
mvn test

# Tests de un servicio específico
mvn test -Dtest=ViajesServiceTest

# Con cobertura
mvn test jacoco:report
```

### Tests Incluidos

- ✅ AsientosServiceTest (3 tests)
- ✅ BandasServiceTest (2 tests)
- ✅ ConciertosServiceTest (3 tests)
- ✅ EmpresaServiceTest (3 tests)
- ✅ PagosServiceTest (3 tests)
- ✅ ReservaServiceTest (4 tests)
- ✅ RolesServiceTest (2 tests)
- ✅ UsuarioServiceTest (3 tests)
- ✅ VehiculoServiceTest (3 tests)
- ✅ ViajesServiceTest (2 tests)

**Total: 28 tests - 100% passing** ✅

## 🔒 Seguridad

### Mejores Prácticas Implementadas

- ✅ **JWT Tokens**: Autenticación stateless con tokens firmados
- ✅ **BCrypt**: Contraseñas hasheadas con algoritmo robusto
- ✅ **CORS Configurable**: Control de orígenes mediante variables de entorno
- ✅ **Variables de Entorno**: Credenciales externalizadas
- ✅ **Endpoints Públicos Limitados**: Solo `/auth/**` y `GET /conciertos` son públicos
- ✅ **Spring Security**: Configuración robusta con filtros JWT
- ✅ **Actuator Seguro**: Solo endpoints de salud e info expuestos

### ⚠️ IMPORTANTE: Antes de Producción

1. **Cambia el JWT Secret**:
   ```bash
   # Genera un secret seguro
   openssl rand -base64 64
   ```

2. **Usa HTTPS**: Nunca expongas la API sin SSL/TLS

3. **Variables de Entorno**: No hardcodees credenciales

4. **Rate Limiting**: Implementa limitación de requests

5. **Actualiza CORS**: Agrega solo tus dominios frontend reales

## 📁 Estructura del Proyecto

```
vans/
├── src/
│   ├── main/
│   │   ├── java/com/vans/backend/
│   │   │   ├── config/            # Configuraciones
│   │   │   ├── controller/        # REST Controllers
│   │   │   ├── dto/                # Data Transfer Objects
│   │   │   ├── entity/             # Entidades JPA
│   │   │   ├── exception/          # Manejo de excepciones
│   │   │   ├── repository/         # Repositorios JPA
│   │   │   ├── security/           # JWT, SecurityConfig, Filters
│   │   │   ├── service/            # Lógica de negocio
│   │   │   └── BackendApplication.java
│   │   └── resources/
│   │       ├── application.properties       # ❌ NO SUBIR A GIT
│   │       └── application.properties.example  # ✅ Ejemplo público
│   └── test/                      # Tests unitarios
├── target/                        # Build artifacts
├── .gitignore
├── pom.xml
├── database_migration.sql         # Script de migración DB
├── Vans_Backend_API_Corrected.postman_collection.json
└── README.md
```

## 🤝 Contribuir

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

### Convenciones de Código

- Sigue las convenciones de Java (CamelCase para clases, camelCase para métodos)
- Documenta métodos públicos con JavaDoc
- Escribe tests para nuevas funcionalidades
- Mantén los commits atómicos y descriptivos

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la [Licencia MIT](LICENSE).

## 👨‍💻 Autor

**Manuel Moya**
- GitHub: [@lmamc](https://github.com/lmamc)
- Repositorio: [VansMM](https://github.com/lmamc/VansMM)

## 🐛 Reportar Problemas

Si encuentras un bug o tienes una sugerencia, por favor [abre un issue](https://github.com/lmamc/VansMM/issues).

## 📞 Soporte

Para preguntas o soporte, contacta a través de:
- GitHub Issues
- Pull Requests
- Discusiones del repositorio

---

⭐ **Si este proyecto te fue útil, considera darle una estrella en GitHub!** ⭐

---

### 🎯 Roadmap Futuro

- [ ] Implementar paginación en endpoints GET
- [ ] Sistema de notificaciones por email
- [ ] Dashboard de administración
- [ ] Integración con pasarelas de pago
- [ ] Sistema de reviews/calificaciones
- [ ] Geolocalización de viajes en tiempo real
- [ ] API de estadísticas y reportes
- [ ] Dockerización del proyecto
- [ ] CI/CD con GitHub Actions

### 🙏 Agradecimientos

- Spring Framework Team
- Oracle Database
- Comunidad de desarrolladores Java
