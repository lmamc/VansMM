# Contribuir al Proyecto

¡Gracias por tu interés en contribuir al Sistema de Reservas de Vans! 🎉

## 📋 Tabla de Contenidos

- [Código de Conducta](#código-de-conducta)
- [¿Cómo Puedo Contribuir?](#cómo-puedo-contribuir)
- [Guía de Desarrollo](#guía-de-desarrollo)
- [Estándares de Código](#estándares-de-código)
- [Process de Pull Request](#proceso-de-pull-request)

## 📜 Código de Conducta

Este proyecto y todos los participantes están gobernados por nuestro Código de Conducta. Al participar, se espera que respetes este código.

### Nuestros Valores

- **Respeto**: Trata a todos con respeto
- **Colaboración**: Trabaja constructivamente con otros
- **Inclusión**: Da la bienvenida a diferentes perspectivas
- **Profesionalismo**: Mantén las interacciones profesionales

## 🤝 ¿Cómo Puedo Contribuir?

### 🐛 Reportar Bugs

Si encuentras un bug:

1. **Verifica** que no exista un issue similar
2. **Abre un issue** con:
   - Descripción clara del problema
   - Pasos para reproducir
   - Comportamiento esperado vs actual
   - Versiones (Java, Spring Boot, Oracle)
   - Logs relevantes

**Template de Bug Report:**

```markdown
**Descripción del Bug**
[Descripción clara y concisa]

**Para Reproducir**
1. Ir a '...'
2. Hacer click en '...'
3. Ver error

**Comportamiento Esperado**
[Qué debería suceder]

**Screenshots/Logs**
[Si aplica]

**Ambiente:**
- OS: [e.g. Windows 11]
- Java Version: [e.g. 24]
- Oracle Version: [e.g. 11g]
```

### 💡 Sugerir Mejoras

Para sugerencias de features:

1. **Abre un issue** con label `enhancement`
2. Describe:
   - El problema que resuelve
   - La solución propuesta
   - Alternativas consideradas
   - Impacto en el sistema actual

### 📝 Mejorar Documentación

¡La documentación siempre puede mejorar!

- Corregir typos o errores
- Agregar ejemplos
- Mejorar claridad
- Traducir a otros idiomas

## 🛠️ Guía de Desarrollo

### Prerequisitos

- Java JDK 24+
- Maven 3.8+
- Oracle Database
- Git
- IDE (IntelliJ IDEA, Eclipse, VS Code)

### Setup Inicial

1. **Fork el repositorio**

```bash
# Clona tu fork
git clone https://github.com/TU_USUARIO/VansMM.git
cd VansMM

# Agrega el repositorio original como upstream
git remote add upstream https://github.com/lmamc/VansMM.git
```

2. **Crea una rama para tu feature**

```bash
git checkout -b feature/nombre-descriptivo
```

3. **Configura el ambiente**

```bash
# Copia el archivo de ejemplo
cp src/main/resources/application.properties.example src/main/resources/application.properties

# Edita con tus credenciales
nano src/main/resources/application.properties
```

4. **Instala dependencias**

```bash
mvn clean install
```

### Estructura de Ramas

- `main`: Rama principal, siempre estable
- `test`: Rama de testing/desarrollo
- `feature/*`: Nuevas características
- `bugfix/*`: Corrección de bugs
- `hotfix/*`: Fixes urgentes para producción

### Workflow de Desarrollo

1. **Sincroniza con upstream**

```bash
git checkout test
git pull upstream test
```

2. **Crea tu rama**

```bash
git checkout -b feature/mi-feature
```

3. **Desarrolla tu feature**
   - Escribe código
   - Agrega tests
   - Actualiza documentación

4. **Ejecuta tests**

```bash
mvn test
```

5. **Commit tus cambios**

```bash
git add .
git commit -m "feat: Descripción del feature"
```

6. **Push a tu fork**

```bash
git push origin feature/mi-feature
```

## 📏 Estándares de Código

### Convenciones Java

- **Clases**: `PascalCase` (ej: `VehiculoService`)
- **Métodos**: `camelCase` (ej: `createViaje()`)
- **Constantes**: `UPPER_SNAKE_CASE` (ej: `MAX_CAPACITY`)
- **Paquetes**: `lowercase` (ej: `com.vans.backend.service`)

### Estructura de Clases

```java
package com.vans.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Servicio para gestionar [entidad].
 * 
 * @author Tu Nombre
 * @version 1.0
 */
@Service
public class MiService {

    private final MiRepository repository;

    public MiService(MiRepository repository) {
        this.repository = repository;
    }

    /**
     * Descripción del método.
     * 
     * @param parametro descripción del parámetro
     * @return descripción del retorno
     * @throws ExcepcionPersonalizada cuando [condición]
     */
    public ReturnType metodo(ParamType parametro) {
        // Implementación
    }
}
```

### Tests

- **Nombre**: `ClaseTest.java`
- **Ubicación**: `src/test/java/[mismo_paquete]`
- **Estructura**:

```java
@SpringBootTest
class MiServiceTest {

    @Autowired
    private MiService service;

    @MockBean
    private MiRepository repository;

    @Test
    @DisplayName("Debe crear entidad exitosamente")
    void debeCrearEntidadExitosamente() {
        // Given
        MiEntidad entidad = new MiEntidad();
        
        // When
        MiEntidad resultado = service.crear(entidad);
        
        // Then
        assertNotNull(resultado);
        assertEquals(expected, resultado.getPropiedad());
    }
}
```

### Mensajes de Commit

Seguimos [Conventional Commits](https://www.conventionalcommits.org/):

```
<tipo>(<scope>): <descripción>

[cuerpo opcional]

[footer opcional]
```

**Tipos:**
- `feat`: Nueva funcionalidad
- `fix`: Corrección de bug
- `docs`: Cambios en documentación
- `style`: Formato, punto y coma faltante, etc.
- `refactor`: Refactorización de código
- `test`: Agregar o corregir tests
- `chore`: Mantenimiento, dependencias, etc.

**Ejemplos:**

```bash
feat(viajes): agregar filtro por fecha de salida
fix(reservas): corregir validación de asientos disponibles
docs(readme): actualizar instrucciones de instalación
test(usuarios): agregar test para registro con email duplicado
```

## 🔄 Proceso de Pull Request

### Antes de Crear el PR

- [ ] El código compila sin errores
- [ ] Todos los tests pasan (`mvn test`)
- [ ] No hay warnings críticos
- [ ] Código sigue los estándares
- [ ] Documentación actualizada
- [ ] Commits bien estructurados

### Crear el Pull Request

1. **Push a tu fork**

```bash
git push origin feature/mi-feature
```

2. **Abre PR en GitHub**
   - Ve a https://github.com/lmamc/VansMM
   - Click "New Pull Request"
   - Selecciona tu rama

3. **Completa el template:**

```markdown
## Descripción
[Descripción clara de los cambios]

## Tipo de Cambio
- [ ] Bug fix
- [ ] Nueva feature
- [ ] Breaking change
- [ ] Documentación

## ¿Cómo se ha probado?
[Describe las pruebas realizadas]

## Checklist
- [ ] Mi código sigue los estándares del proyecto
- [ ] He comentado el código en áreas difíciles
- [ ] He actualizado la documentación
- [ ] Mis cambios no generan nuevos warnings
- [ ] He agregado tests que prueban mi fix/feature
- [ ] Tests unitarios pasan localmente
```

### Revisión del PR

- El maintainer revisará tu código
- Puede solicitar cambios
- Discusión constructiva es bienvenida
- Una vez aprobado, se hará merge

### Después del Merge

```bash
# Actualiza tu fork
git checkout test
git pull upstream test
git push origin test

# Limpia tu rama local
git branch -d feature/mi-feature
```

## 🎨 Guía de Estilo

### Nombres Significativos

```java
// ❌ Mal
public void proc() { }
public int x;

// ✅ Bien
public void procesarReserva() { }
public int asientosDisponibles;
```

### Métodos Pequeños

- Máximo 20-30 líneas por método
- Una responsabilidad por método
- Nombres descriptivos

### Comentarios

```java
// ❌ Comentarios obvios
int edad = 25; // asignar 25 a edad

// ✅ Comentarios útiles
// Aplicar descuento de 20% para estudiantes menores de 25
if (usuario.isEstudiante() && usuario.getEdad() < 25) {
    aplicarDescuento(0.20);
}
```

### Manejo de Excepciones

```java
// ❌ Mal
try {
    // código
} catch (Exception e) {
    e.printStackTrace();
}

// ✅ Bien
try {
    // código
} catch (EntityNotFoundException e) {
    log.error("Entidad no encontrada: {}", id, e);
    throw new ServiceException("No se pudo procesar la solicitud", e);
}
```

## 🏆 Reconocimiento

Todos los contribuidores serán reconocidos en el README.md del proyecto.

## 📞 ¿Preguntas?

Si tienes dudas:
- Abre un issue con la etiqueta `question`
- Participa en las discusiones de GitHub
- Revisa issues/PRs cerrados similares

## 📄 Licencia

Al contribuir, aceptas que tus contribuciones sean licenciadas bajo la [Licencia MIT](LICENSE).

---

¡Gracias por contribuir! 🎉
