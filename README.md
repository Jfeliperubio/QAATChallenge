# QAATChallenge

## Descripción
Este es un proyecto que utiliza Java, Docker, Rest Assured, Maven y JUnit para realizar pruebas de integración en un sistema de gestión de usuarios, tiendas y mascotas.

## Tecnologías Utilizadas
- Java
- Docker
- Rest Assured
- Maven
- JUnit

## Tablas de Casos de Prueba

### User Management
| ID  | Descripción del Caso de Prueba                  | Condiciones Previas | Pasos de Prueba                                                        | Resultado Deseado                             | Resultado Real |
|-----|-------------------------------------------------|---------------------|------------------------------------------------------------------------|-----------------------------------------------|----------------|
| 1   | Crea un usuario                                 | -                   | 1. Envía una solicitud POST a /user con los datos del usuario a crear. | El usuario se crea correctamente.             |                |
| 1.1 | Intenta crear un usuario sin proporcionar datos | -                   | 1. Envía una solicitud POST a /user sin datos.                         | Se espera un error indicando datos faltantes. |                |
| ... | ...                                             | ...                 | ...                                                                    | ...                                           | ...            |

### Store Management
| ID  | Descripción del Caso de Prueba              | Condiciones Previas | Pasos de Prueba                                                                    | Resultado Deseado                      | Resultado Real |
|-----|---------------------------------------------|---------------------|------------------------------------------------------------------------------------|----------------------------------------|----------------|
| 8   | Devuelve inventarios de mascotas por estado | -                   | 1. Envía una solicitud GET a /store/inventory.                                     | Se devuelve el inventario de mascotas. |                |
| 9   | Realiza un pedido de una mascota            | -                   | 1. Envía una solicitud POST a /store/order con los datos del pedido de la mascota. | El pedido se realiza correctamente.    |                |
| ... | ...                                         | ...                 | ...                                                                                | ...                                    | ...            |

### Pet Management
| ID   | Descripción del Caso de Prueba               | Condiciones Previas                      | Pasos de Prueba                                                             | Resultado Deseado                                   | Resultado Real |
|------|----------------------------------------------|------------------------------------------|-----------------------------------------------------------------------------|-----------------------------------------------------|----------------|
| 12   | Actualiza una mascota existente              | Debe existir una mascota con el ID dado. | 1. Envía una solicitud PUT a /pet con los nuevos datos de la mascota.       | La mascota se actualiza correctamente.              |                |
| 12.1 | Intenta actualizar una mascota que no existe | -                                        | 1. Envía una solicitud PUT a /pet con datos de mascota y un ID inexistente. | Se espera un error indicando mascota no encontrada. |                |
| ...  | ...                                          | ...                                      | ...                                                                         | ...                                                 | ...            |

## Instalación y Ejecución
Para ejecutar este proyecto, asegúrese de tener Docker instalado en su sistema. Luego, siga los siguientes pasos:

1. Clonar este repositorio.
2. Navegar hasta el directorio del proyecto.
3. Ejecutar el comando `docker-compose up --build`.

Esto iniciará la aplicación y ejecutará todas las pruebas de integración.

## Contribución
Las contribuciones son bienvenidas. Si desea contribuir a este proyecto, abra un problema primero para discutir los cambios propuestos.

