# 🔐 Guía de Seguridad para Publicación

## ✅ Checklist Pre-Publicación

Antes de hacer push al repositorio público, verifica:

### 1. Archivos Sensibles Protegidos

- [x] `application.properties` está en `.gitignore` ✅
- [x] `application.properties` NO está en historial Git ✅
- [x] `.env` está en `.gitignore` ✅
- [x] Archivos de ejemplo creados (`.example`) ✅

### 2. Configuración Externalizada

- [x] JWT Secret usa variables de entorno ✅
- [x] Credenciales DB usan variables de entorno ✅
- [x] CORS configurado con variables de entorno ✅
- [x] Actuator endpoints restringidos ✅

### 3. Documentación

- [x] README.md completo y profesional ✅
- [x] `.env.example` con todas las variables ✅
- [x] `application.properties.example` sin credenciales ✅
- [x] Instrucciones de configuración claras ✅
- [x] LICENSE incluida ✅

### 4. Archivos Excluidos

El `.gitignore` ahora protege:
- Credenciales (`.env`, `application.properties`)
- Build artifacts (`target/`)
- IDE configs (`.idea/`, `.vscode/`)
- Logs (`*.log`)
- System files (`.DS_Store`, `Thumbs.db`)

## 🚀 Pasos para Publicar

### 1. Verificar Estado del Repositorio

```bash
git status
git log --all --full-history -- src/main/resources/application.properties
```

Si `application.properties` aparece en el historial, ejecuta:

```bash
git filter-branch --force --index-filter \
  "git rm --cached --ignore-unmatch src/main/resources/application.properties" \
  --prune-empty --tag-name-filter cat -- --all
```

### 2. Agregar Archivos Nuevos

```bash
git add .gitignore
git add README.md
git add LICENSE
git add .env.example
git add src/main/resources/application.properties.example
git add src/main/java/com/vans/backend/security/SecurityConfig.java
```

### 3. Commit y Push

```bash
git commit -m "feat: Preparar proyecto para repositorio público

- Añadir README.md completo con documentación
- Externalizar configuraciones a variables de entorno
- Agregar .env.example y application.properties.example
- Mejorar .gitignore con más exclusiones
- Configurar CORS parametrizable
- Añadir LICENSE MIT
- Securizar endpoints de Actuator
- Proteger credenciales de base de datos y JWT"

git push origin test
```

### 4. Crear Pull Request (si aplica)

Si trabajas con ramas, crea un PR de `test` a `main`:
1. Ve a GitHub: https://github.com/lmamc/VansMM
2. Click en "Pull requests" → "New pull request"
3. Selecciona `test` → `main`
4. Describe los cambios de seguridad implementados

## 🔍 Verificación Final

Antes del push, ejecuta:

```bash
# 1. Buscar posibles secretos expuestos
git grep -i "password" src/
git grep -i "secret" src/

# 2. Verificar archivos trackeados
git ls-files

# 3. Verificar diferencias
git diff HEAD
```

## ⚠️ Problemas Comunes y Soluciones

### Problema: "application.properties ya está en commits anteriores"

**Solución:**
```bash
# Eliminar del historial
git filter-branch --force --index-filter \
  "git rm --cached --ignore-unmatch src/main/resources/application.properties" \
  --prune-empty --tag-name-filter cat -- --all

# Force push (CUIDADO: solo si estás seguro)
git push origin --force --all
```

### Problema: "JWT Secret está hardcodeado en el código"

**Solución:** Ya está resuelto ✅
- `JwtUtil.java` usa `@Value("${jwt.secret}")`
- `application.properties` usa `${JWT_SECRET:valor_default}`

### Problema: "CORS permite cualquier origen"

**Solución:** Ya está resuelto ✅
- `SecurityConfig.java` usa `@Value("${cors.allowed.origins}")`
- Configurable desde `application.properties` o variables de entorno

## 🛡️ Mejores Prácticas Implementadas

1. ✅ **Separación de Configuración**: 
   - Código en Git
   - Credenciales en variables de entorno

2. ✅ **Documentación de Ejemplo**:
   - `.env.example` muestra estructura sin exponer datos
   - `application.properties.example` con valores placeholder

3. ✅ **Principio de Menor Privilegio**:
   - Solo endpoints necesarios son públicos
   - Actuator expone mínimo necesario

4. ✅ **Tokens Seguros**:
   - JWT firmados con secret robusto
   - BCrypt para contraseñas

5. ✅ **CORS Restrictivo**:
   - Orígenes específicos (no `*`)
   - Configurable por ambiente

## 📊 Estado Actual del Proyecto

| Aspecto | Estado | Comentario |
|---------|--------|------------|
| Credenciales Protegidas | ✅ | En `.gitignore`, no en historial |
| Variables de Entorno | ✅ | Externalizadas correctamente |
| CORS Seguro | ✅ | Configurable y restrictivo |
| Documentación | ✅ | README completo |
| Tests | ✅ | 28/28 passing |
| Licencia | ✅ | MIT License |
| `.gitignore` Robusto | ✅ | Actualizado |

## 🎯 Próximos Pasos Recomendados

Después de publicar:

1. **GitHub Actions**: CI/CD pipeline
2. **Dependabot**: Alertas de seguridad
3. **Code Scanning**: GitHub Security
4. **Branch Protection**: Requerir reviews
5. **Secrets Scanning**: Detectar leaks automáticamente

## 📞 Contacto en Caso de Incidente

Si detectas que credenciales fueron expuestas:

1. **INMEDIATO**: Cambiar TODAS las credenciales
2. **Revocar** tokens JWT comprometidos
3. **Limpiar** historial de Git
4. **Auditar** accesos a la base de datos
5. **Notificar** a los afectados si aplica

---

✅ **Proyecto listo para ser público de forma segura** ✅
