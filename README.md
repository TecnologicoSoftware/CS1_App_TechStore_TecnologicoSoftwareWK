# 🏪 Class project: inventory management application App TechStore

[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue.svg)](https://maven.apache.org/)


---

## 📚 Información Académica

| Campo | Información |
|-------|-------------|
| **Materia** | Construcción de Software 1 |
| **Profesor** | Ricardo José Montes Barba |
| **Período Académico** | 2025-2 |
| **Universidad** | Tecnologico de Antioquia |

---

## 🏷 Nombre del Proyecto

**App TechStore**

Sistema integral de gestión para tiendas de tecnología

---

## 👥 Equipo de Desarrollo

**Nombre del Equipo:** TecnologicoSoftwareWK

### Integrantes

| Nombre Completo | Rol |
|-----------------|-----|
| Kelly Johana Restrepo Uribe | Estudiante Ingenieria desarrollo de software |
| Wilson Enrique Tapias Posada | Estudiante Ingenieria desarrollo de software |

---

## 📖 Descripción del Proyecto

**App TechStore** es una aplicación de escritorio desarrollada en Java que gestiona integralmente el inventario, ventas y servicios técnicos de una tienda de tecnología. El sistema implementa conceptos avanzados de Programación Orientada a Objetos como herencia, polimorfismo, encapsulación y abstracción.

### Características Principales

- ✅ **Gestión de Inventario:** Control completo de productos con seguimiento de stock, alertas y ubicación física
- ✅ **Sistema de Ventas:** Procesamiento de transacciones con múltiples métodos de pago
- ✅ **Fidelización de Clientes:** Acumulación y canje de puntos por descuentos
- ✅ **Servicios Técnicos:** Asignación automática de técnicos especializados
- ✅ **Interfaz Gráfica Intuitiva:** Desarrollada con Java Swing
- ✅ **Sistema de Autenticación:** Múltiples roles de usuario con permisos diferenciados

### Conceptos de POO Implementados

- **Herencia:** `Producto` → `ProductoFisico` / `ServicioDigital`; `Usuario` → `Tecnico`
- **Polimorfismo:** Múltiples implementaciones de `MetodoPago`
- **Encapsulación:** Protección de datos mediante modificadores de acceso
- **Abstracción:** Clases abstractas (`Producto`, `Usuario`) e interfaces (`MetodoPago`)
- **Patrones de Diseño:** Strategy Pattern (métodos de pago), Singleton Pattern (sistema central)

---

## 🗂️ Estructura del Proyecto

```
ProjectClassAppTechStore/
│
├── src/
│   └── main/
│       └── java/
│           ├── abstractos/
│           │   ├── Producto.java              # Clase abstracta base para productos
│           │   └── Usuario.java               # Clase abstracta base para usuarios
│           │
│           ├── enums/
│           │   ├── Categoria.java             # Enum de categorías de productos
│           │   └── EstadoVenta.java           # Enum de estados de venta
│           │
│           ├── interfaces/
│           │   └── MetodoPago.java            # Interfaz para métodos de pago
│           │
│           ├── modelos/
│           │   ├── SistemaTechStore.java      # Sistema central (Singleton)
│           │   ├── Inventario.java            # Gestión de inventario
│           │   ├── ProductoFisico.java        # Productos tangibles
│           │   ├── ServicioDigital.java       # Servicios técnicos
│           │   ├── Venta.java                 # Gestión de ventas
│           │   ├── ItemVenta.java             # Items individuales de venta
│           │   ├── Cliente.java               # Gestión de clientes
│           │   ├── Tecnico.java               # Gestión de técnicos
│           │   ├── Efectivo.java              # Pago en efectivo
│           │   ├── TarjetaCredito.java        # Pago con tarjeta de crédito
│           │   ├── TarjetaDebito.java         # Pago con tarjeta de débito
│           │   └── TransferenciaBancaria.java # Pago por transferencia
│           │
│           └── formularios/
│               ├── LoginForm.java             # Inicio de sesión
│               ├── MenuPrincipalForm.java     # Menú principal
│               ├── InventarioForm.java        # Gestión de inventario
│               ├── AgregarProductoForm.java   # Agregar productos
│               ├── EditarProductoForm.java    # Editar productos
│               ├── AgregarServicioForm.java   # Agregar servicios
│               ├── EditarServicioForm.java    # Editar servicios
│               ├── VentasForm.java            # Procesamiento de ventas
│               ├── PagoForm.java              # Formulario de pago
│               ├── ClientesForm.java          # Gestión de clientes
│               ├── RegistrarClienteForm.java  # Registro de clientes
│               ├── EditarClienteForm.java     # Edición de clientes
│               ├── GestionarTecnicosForm.java # Gestión de técnicos
│               ├── AsignarTecnicoServicioForm.java # Asignación de técnicos
│               └── ReportesForm.java          # Generación de reportes
│
├── lib/
│   └── jcalendar-1.4/                         # Librería para componentes de fecha
│       └── jcalendar-1.4.jar
│        
│
├── target/                                     # Archivos compilados (generados)
│   └── ProjectClassAppTechStore-1.0-SNAPSHOT.jar
│
├── pom.xml                                     # Configuración de Maven
└── README.md                                   # Este archivo

```

---

## 🚀 Instrucciones de Compilación y Ejecución

### Prerrequisitos

Asegúrate de tener instalado en tu sistema:

| Herramienta | Versión Mínima | Descripción |
|-------------|----------------|-------------|
| **Java JDK** | 11+ | Kit de desarrollo de Java |
| **Apache Maven** | 3.6+ | Gestión de dependencias y construcción |
| **IDE** | Cualquiera | NetBeans (recomendado), IntelliJ IDEA o Eclipse |

### Proceso de Compilación

#### 1. Clonar el Repositorio

```bash
git clone [URL_DEL_REPOSITORIO]
cd ProjectClassAppTechStore
```

#### 2. Compilar el Proyecto desde consola

```bash
mvn clean compile
```

Este comando limpia compilaciones anteriores y compila todo el código fuente.

#### 3. Generar Archivo JAR Ejecutable

```bash
mvn package
```

Esto genera el archivo `ProjectClassAppTechStore-1.0-SNAPSHOT.jar` en la carpeta `target/`.

### Opciones de Ejecución

#### Opción 1: Ejecutar desde Maven

```bash
mvn exec:java -Dexec.mainClass="com.mycompany.techstore.Main"
```

#### Opción 2: Ejecutar el JAR Generado

```bash
java -jar target/ProjectClassAppTechStore-1.0-SNAPSHOT.jar
```

#### Opción 3: Desde un IDE

1. Importa el proyecto como proyecto Maven
2. Localiza la clase principal: `com.mycompany.techstore.Main`
3. Haz clic derecho → "Run" o "Ejecutar"

### Credenciales de Acceso

El sistema incluye usuarios de prueba pre-configurados:

| Usuario | Contraseña | Rol | Permisos |
|---------|------------|-----|----------|
| `admin` | `123` | Administrador | Acceso completo |
| `vendedor` | `123` | Vendedor | Ventas y consultas |

---

## 🧩 Requerimientos Técnicos del Proyecto

### Lenguajes y Tecnologías

| Componente | Tecnología | Versión |
|------------|------------|---------|
| **Lenguaje Principal** | Java | JDK 11+ |
| **Gestión de Dependencias** | Apache Maven | 3.6+ |
| **Interfaz Gráfica** | Java Swing / AWT | Incluido en JDK |
| **Construcción del Proyecto** | Maven | 3.6+ |

### Librerías y Dependencias

#### Librerías Externas (carpeta `lib/`)

- **JCalendar 1.4:** Componente para selección de fechas en formularios
  - Ubicación: `lib/jcalendar-1.4/`
  - Uso: Selección de fechas en formularios de productos y servicios

#### Dependencias de Maven

El proyecto utiliza principalmente las bibliotecas estándar de Java (JDK). No requiere dependencias Maven adicionales en el `pom.xml` más allá de las utilidades de construcción.

### Requisitos del Sistema

| Recurso | Mínimo | Recomendado |
|---------|--------|-------------|
| **Sistema Operativo** | Windows 10, macOS 10.14, Linux Ubuntu 18.04 | Cualquier SO con Java 11+ |
| **Memoria RAM** | 2 GB | 4 GB o más |
| **Espacio en Disco** | 500 MB | 1 GB |


---

## 📋 Descripción Detallada de Componentes

### Paquete `abstractos`

#### `Producto.java`
- **Propósito:** Clase base abstracta para todos los productos
- **Atributos:** `id`, `nombre`, `precio`, `categoria`
- **Métodos clave:** `validarPrecio()`, `validarNombre()`
- **Herencia:** Extendida por `ProductoFisico` y `ServicioDigital`

#### `Usuario.java`
- **Propósito:** Clase base para usuarios del sistema
- **Atributos:** `usuario`, `password`, `nombre`
- **Métodos clave:** `login(String usuario, String password)`
- **Herencia:** Extendida por `Tecnico`

---

### Paquete `enums`

#### `Categoria.java`
**Valores disponibles:**
- `COMPUTADORAS`
- `SMARTPHONES`
- `ACCESORIOS`
- `PERIFERICOS`
- `COMPONENTES`
- `SERVICIOS_TECNICOS`

#### `EstadoVenta.java`
**Estados del ciclo de vida de una venta:**
- `EN_PROCESO` → Venta en construcción
- `PAGADA` → Pago procesado exitosamente
- `ENTREGADA` → Productos entregados al cliente
- `CANCELADA` → Venta cancelada

---

### Paquete `interfaces`

#### `MetodoPago.java`
**Contrato para todos los métodos de pago:**
- `boolean procesarPago(double monto)` → Procesa el pago
- `boolean validar()` → Valida los datos del método de pago

**Implementaciones:**
- `Efectivo.java`
- `TarjetaCredito.java`
- `TarjetaDebito.java`
- `TransferenciaBancaria.java`

---

### Paquete `modelos` (Lógica de Negocio)

#### `SistemaTechStore.java`
**Sistema central del proyecto (Patrón Singleton)**
- **Responsabilidad:** Punto único de acceso a todas las funcionalidades
- **Colecciones en memoria:**
  - `inventario` (Inventario)
  - `clientes` (List<Cliente>)
  - `ventas` (List<Venta>)
  - `usuarios` (List<Usuario>)
  - `servicios` (List<ServicioDigital>)
  - `tecnicos` (List<Tecnico>)
- **Funcionalidades principales:**
  - Login/Logout de usuarios
  - CRUDs completos para todas las entidades
  - Generación de IDs únicos
  - Asignación y liberación de técnicos
  - Registro de ventas

#### `Inventario.java`
**Gestión centralizada del inventario**
- Agregar, editar y eliminar productos
- Búsqueda por nombre, código de barras o ID
- Alertas de stock bajo
- Prevención de códigos de barras duplicados
- Obtención de todos los productos

#### `ProductoFisico.java`
**Productos tangibles de la tienda**
- **Atributos específicos:** `stock`, `codigoBarras`, `ubicacion`, `fechaIngreso`, `enOferta`, `descuento`, `stockReservado`
- **Métodos clave:**
  - `reducirStock(int cantidad)` / `aumentarStock(int cantidad)`
  - `tieneStockSuficiente(int cantidad)`
  - `reservarStock(int cantidad)` / `liberarStockReservado(int cantidad)`
  - `getPrecioConDescuento()`
  - `getEstadoStock()` → "Disponible" / "Stock Bajo" / "Agotado"

#### `ServicioDigital.java`
**Servicios técnicos ofrecidos**
- **Atributos específicos:** `duracionMinutos`, `descripcion`, `tecnicoAsignado`, `requiereTecnico`, `asignado`
- **Métodos clave:**
  - `asignarTecnicoDisponible(List<Tecnico> tecnicos)`
  - `liberarTecnico()`
  - `tieneTecnicoAsignado()`
  - `getInfoTecnico()`

#### `Venta.java`
**Representación de una transacción completa**
- Gestión de items mediante `ItemVenta`
- Cálculo automático de subtotales, IVA (19%) y total
- Procesamiento de pagos con validaciones
- Asignación automática de técnicos para servicios
- Acumulación de puntos de fidelidad
- Generación de facturas por consola
- **Flujo de pago:**
  1. Validar método de pago
  2. Procesar pago
  3. Asignar técnicos a servicios
  4. Acumular puntos al cliente
  5. Marcar venta como PAGADA

#### `ItemVenta.java`
**Item individual dentro de una venta**
- Encapsula un `Producto` con su cantidad
- Calcula subtotal considerando descuentos
- Maneja tanto productos físicos como servicios

#### `Cliente.java`
**Gestión de clientes y programa de fidelidad**
- **Atributos:** `id`, `nombre`, `cedula`, `telefono`, `puntosFidelidad`, `totalCompras`
- **Sistema de puntos:**
  - Acumular puntos: 1 punto por cada $1000 gastados
  - Canje mínimo: 100 puntos = $10 de descuento
  - Descuentos por fidelidad:
    - 5% si total de compras >= $500,000
    - 10% si total de compras >= $1,000,000

#### `Tecnico.java`
**Profesionales técnicos del servicio**
- **Atributos específicos:** `especialidad`, `disponible`, `serviciosAsignados`
- **Métodos:**
  - `asignarServicio(ServicioDigital servicio)`
  - `liberarServicio(ServicioDigital servicio)`
  - Getters/Setters de disponibilidad

#### Implementaciones de `MetodoPago`

**`Efectivo.java`**
- Valida que el monto recibido >= monto a pagar
- Calcula y retorna el cambio

**`TarjetaCredito.java`**
- Valida número de tarjeta (16 dígitos)
- Valida titular
- Calcula recargos por cuotas (no aplicado actualmente al total)

**`TarjetaDebito.java`**
- Valida número de tarjeta
- Valida titular
- Similares validaciones a crédito

**`TransferenciaBancaria.java`**
- Requiere: referencia, banco, monto transferido
- Valida que monto transferido >= monto a pagar

---

### Paquete `formularios` (Interfaz de Usuario)

Todos los formularios son componentes Swing (generados posiblemente con NetBeans GUI Builder). Cada formulario recibe una instancia de `SistemaTechStore` para interactuar con el modelo.

#### Formularios Principales

**`LoginForm.java`**
- Autenticación de usuarios
- Componentes: `txtUsuario`, `txtPassword`, `btnLogin`
- Al autenticar exitosamente abre `MenuPrincipalForm`

**`MenuPrincipalForm.java`**
- Hub central de navegación
- Abre módulos: Ventas, Inventario, Clientes, Técnicos, Reportes
- Carga iconos desde `src/main/java/imagenes/`

**`InventarioForm.java`**
- Tablas: `tblProductos`, `tblServicios`
- Funciones: ver, buscar, agregar, editar, eliminar productos
- Ver stock bajo
- Asignar técnicos a servicios

**`VentasForm.java`**
- Gestión del carrito de compras
- Búsqueda de productos
- Asociación de cliente por cédula
- Canje de puntos de fidelidad
- Procesamiento de pago
- Interacción con `Venta` y `ItemVenta`

**`ClientesForm.java`**
- Listado de clientes
- Crear nuevo cliente (abre `RegistrarClienteForm`)
- Editar cliente (abre `EditarClienteForm`)
- Ver historial de ventas por cliente

#### Formularios Auxiliares

- **Productos:** `AgregarProductoForm`, `EditarProductoForm`
- **Servicios:** `AgregarServicioForm`, `EditarServicioForm`
- **Clientes:** `RegistrarClienteForm`, `EditarClienteForm`
- **Técnicos:** `GestionarTecnicosForm`, `AsignarTecnicoServicioForm`
- **Otros:** `PagoForm`, `ReportesForm`

---

## ✅ Funcionalidades Implementadas

### Módulo de Inventario
- [x] Agregar productos con control de stock
- [x] Editar información de productos existentes
- [x] Eliminar productos del inventario
- [x] Búsqueda avanzada (nombre, código, ID)
- [x] Alertas de stock bajo
- [x] Gestión de ubicación física de productos
- [x] Control de ofertas y descuentos
- [x] Prevención de códigos de barras duplicados

### Módulo de Ventas
- [x] Carrito de compras dinámico
- [x] Agregar/eliminar items del carrito
- [x] Búsqueda rápida de productos
- [x] Múltiples métodos de pago
- [x] Validación de stock en tiempo real
- [x] Cálculo automático de IVA (19%)
- [x] Aplicación de descuentos por fidelidad
- [x] Generación de facturas
- [x] Asignación automática de técnicos para servicios

### Módulo de Clientes
- [x] Registro de nuevos clientes
- [x] Edición de información de clientes
- [x] Sistema de puntos de fidelidad
- [x] Canje de puntos por descuentos
- [x] Descuentos automáticos por nivel de compras
- [x] Historial de compras por cliente
- [x] Búsqueda de clientes por cédula

### Módulo de Técnicos y Servicios
- [x] Gestión de técnicos especializados
- [x] Control de disponibilidad de técnicos
- [x] Asignación automática de técnicos a servicios
- [x] Liberación de técnicos al completar servicios
- [x] Seguimiento de servicios asignados por técnico
- [x] Registro de especialidades

### Sistema de Autenticación
- [x] Login con validación de credenciales
- [x] Gestión de sesiones de usuario
- [x] Diferentes roles (Administrador, Vendedor)
- [x] Logout seguro

---

## 🔄 Flujo de Trabajo del Sistema

### Flujo de Ventas

```
1. Usuario inicia sesión (LoginForm)
   ↓
2. Sistema establece usuarioActual
   ↓
3. Cajero abre VentasForm
   ↓
4. Crea nueva Venta con cajero actual
   ↓
5. Agrega productos al carrito (reducción inmediata de stock)
   ↓
6. Asocia cliente (búsqueda por cédula)
   ↓
7. Aplica canje de puntos (si aplica)
   ↓
8. Selecciona método de pago
   ↓
9. Procesar Pago:
   a. Validar método de pago
   b. Procesar transacción
   c. Asignar técnicos a servicios
   d. Acumular puntos al cliente
   e. Marcar venta como PAGADA
   ↓
10. Registrar venta en sistema
    ↓
11. Generar factura
```

### Flujo de Gestión de Inventario

```
1. Administrador accede a InventarioForm
   ↓
2. Visualiza productos y servicios en tablas
   ↓
3. Opciones disponibles:
   ├── Agregar nuevo producto
   ├── Editar producto existente
   ├── Eliminar producto
   ├── Buscar productos
   ├── Ver stock bajo
   └── Asignar técnicos a servicios
   ↓
4. Sistema actualiza Inventario en memoria
   ↓
5. Cambios reflejados inmediatamente en UI
```

---

### Equipo de Desarrollo

| Integrante |  GitHub |
|------------|---------|
| Kelly Johana Restrepo Uribe |  [@kelly1311] |
| Wilson Enrique Tapias Posada | [@Wilson_Code] |

### Profesor

- **Ricardo José Montes Barba**
- Materia: Construcción de Software 1

---

## 📚 Referencias y Recursos Útiles

### Documentación Oficial
- [Documentación de Java SE](https://docs.oracle.com/en/java/javase/11/)
- [Apache Maven Guide](https://maven.apache.org/guides/)
- [Java Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)


### Herramientas y Bibliotecas
- [JCalendar](https://toedter.com/jcalendar/) - Componente de selección de fechas
- [NetBeans IDE](https://netbeans.apache.org/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

---
**Última actualización:** Noviembre 2025  
**Versión:** 1.0.0  
**Estado:** ✅ Completado (Proyecto Académico)

---

<div align="center">

**Desarrollado como proyecto académico de Construcción de Software 1**

![Universidad](https://img.shields.io/badge/Universidad-Tecnologico%20de%20Anquioquia-blue)
![Materia](https://img.shields.io/badge/Materia-Construcción%20de%20Software%201-green)
![Año](https://img.shields.io/badge/Año-2025-orange)

</div>
