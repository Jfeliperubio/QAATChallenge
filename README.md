# QAATChallenge

## Descripción
Este es un proyecto que utiliza Java, Docker, Rest Assured, Maven y JUnit para realizar pruebas automatizadas de una api
de mascotas con gestión de usuarios, tienda y mascotas.

## Tecnologías Utilizadas
- Java
- Docker
- Rest Assured
- Maven
- JUnit

## Tablas de Casos de Prueba

### User Management
| ID  | Descripción del Caso de Prueba                                  | Condiciones Previas                            | Pasos de Prueba                                                                          | Resultado Deseado                                      |
|-----|-----------------------------------------------------------------|------------------------------------------------|------------------------------------------------------------------------------------------|--------------------------------------------------------|
| 1   | Crea un usuario                                                 | -                                              | 1. Envía una solicitud POST a /user con los datos del usuario a crear.                   | El usuario se crea correctamente.                      |
| 1.1 | Intenta crear un usuario sin proporcionar datos                 | -                                              | 1. Envía una solicitud POST a /user sin datos.                                           | Se espera un error indicando datos faltantes.          |
| 1.2 | Intenta crear un usuario con datos incompletos                  | -                                              | 1. Envía una solicitud POST a /user con datos incompletos.                               | Se espera un error indicando datos incorrectos.        |
| 2   | Crea una lista de usuarios con el arreglo dado                  | -                                              | 1. Envía una solicitud POST a /user/createWithList con un arreglo de usuarios.           | La lista de usuarios se crea correctamente.            |
| 2.1 | Intenta crear una lista de usuarios sin proporcionar el arreglo | -                                              | 1. Envía una solicitud POST a /user/createWithList sin el arreglo de usuarios.           | Se espera un error indicando datos faltantes.          |
| 2.2 | Intenta crear una lista de usuarios con un arreglo vacío        | -                                              | 1. Envía una solicitud POST a /user/createWithList con un arreglo vacío.                 | Se espera un error indicando datos incorrectos.        |
| 3   | Inicia sesión del usuario en el sistema                         | El usuario debe estar registrado en el sistema | 1. Envía una solicitud GET a /user/login con las credenciales del usuario.               | El usuario inicia sesión correctamente.                |
| 3.1 | Intenta iniciar sesión con credenciales incorrectas             | El usuario debe estar registrado en el sistema | 1. Envía una solicitud GET a /user/login con credenciales incorrectas.                   | Se espera un error indicando credenciales incorrectas. |
| 3.2 | Intenta iniciar sesión sin proporcionar credenciales            | -                                              | 1. Envía una solicitud GET a /user/login sin credenciales.                               | Se espera un error indicando credenciales faltantes.   |
| 4   | Cierra la sesión del usuario actualmente conectado              | El usuario debe estar actualmente conectado    | 1. Envía una solicitud GET a /user/logout.                                               | El usuario cierra sesión correctamente.                |
| 4.1 | Intenta cerrar sesión sin estar conectado                       | -                                              | 1. Envía una solicitud GET a /user/logout sin estar conectado.                           | Se espera un error indicando que no está conectado.    |
| 5   | Obtiene un usuario por su nombre de usuario                     | Debe existir un usuario con el nombre dado     | 1. Envía una solicitud GET a /user/{username} con el nombre de usuario como parámetro.   | Se devuelve la información del usuario.                |
| 5.1 | Intenta obtener un usuario que no existe                        | -                                              | 1. Envía una solicitud GET a /user/{username} con un nombre de usuario inexistente.      | Se espera un error indicando usuario no encontrado.    |
| 6   | Actualiza un usuario                                            | Debe existir un usuario con el nombre dado     | 1. Envía una solicitud PUT a /user/{username} con los nuevos datos del usuario.          | El usuario se actualiza correctamente.                 |
| 6.1 | Intenta actualizar un usuario que no existe                     | -                                              | 1. Envía una solicitud PUT a /user/{username} con datos de usuario y nombre inexistente. | Se espera un error indicando usuario no encontrado.    |
| 6.2 | Intenta actualizar un usuario con datos incorrectos             | Debe existir un usuario con el nombre dado     | 1. Envía una solicitud PUT a /user/{username} con datos incorrectos.                     | Se espera un error indicando datos incorrectos.        |
| 7   | Elimina un usuario                                              | Debe existir un usuario con el nombre dado     | 1. Envía una solicitud DELETE a /user/{username}.                                        | El usuario se elimina correctamente.                   |
| 7.1 | Intenta eliminar un usuario que no existe                       | -                                              | 1. Envía una solicitud DELETE a /user/{username} con un nombre de usuario inexistente.   | Se espera un error indicando usuario no encontrado.    |


### Store Management
| ID  | Descripción del Caso de Prueba                    | Condiciones Previas                   | Pasos de Prueba                                                                             | Resultado Deseado                                  | Resultado Real |
|-----|---------------------------------------------------|---------------------------------------|---------------------------------------------------------------------------------------------|----------------------------------------------------|----------------|
| 1   | Devuelve inventarios de mascotas por estado       | -                                     | 1. Envía una solicitud GET a /store/inventory.                                              | Se devuelve el inventario de mascotas.             |                |
| 2   | Realiza un pedido de una mascota                  | -                                     | 1. Envía una solicitud POST a /store/order con los datos del pedido de la mascota.          | El pedido se realiza correctamente.                |                |
| 2.1 | Intenta realizar un pedido sin proporcionar datos | -                                     | 1. Envía una solicitud POST a /store/order sin datos.                                       | Se espera un error indicando datos faltantes.      |                |
| 2.2 | Intenta realizar un pedido con datos incorrectos  | -                                     | 1. Envía una solicitud POST a /store/order con datos incorrectos.                           | Se espera un error indicando datos incorrectos.    |                |
| 3   | Encuentra un pedido de compra por su ID           | Debe existir un pedido con el ID dado | 1. Envía una solicitud GET a /store/order/{orderId} con el ID del pedido como parámetro.    | Se devuelve la información del pedido.             |                |
| 3.1 | Intenta encontrar un pedido que no existe         | -                                     | 1. Envía una solicitud GET a /store/order/{orderId} con un ID de pedido inexistente.        | Se espera un error indicando pedido no encontrado. |                |
| 4   | Elimina un pedido de compra por su ID             | Debe existir un pedido con el ID dado | 1. Envía una solicitud DELETE a /store/order/{orderId} con el ID del pedido como parámetro. | El pedido se elimina correctamente.                |                |
| 4.1 | Intenta eliminar un pedido que no existe          | -                                     | 1. Envía una solicitud DELETE a /store/order/{orderId} con un ID de pedido inexistente.     | Se espera un error indicando pedido no encontrado. |                |


### Pet Management
| ID  | Descripción del Caso de Prueba                                     | Condiciones Previas                     | Pasos de Prueba                                                                                | Resultado Deseado                                          | Resultado Real |
|-----|--------------------------------------------------------------------|-----------------------------------------|------------------------------------------------------------------------------------------------|------------------------------------------------------------|----------------|
| 1   | Actualiza una mascota existente                                    | Debe existir una mascota con el ID dado | 1. Envía una solicitud PUT a /pet con los nuevos datos de la mascota.                          | La mascota se actualiza correctamente.                     |                |
| 1.1 | Intenta actualizar una mascota que no existe                       | -                                       | 1. Envía una solicitud PUT a /pet con datos de mascota y un ID inexistente.                    | Se espera un error indicando mascota no encontrada.        |                |
| 1.2 | Intenta actualizar una mascota con datos incorrectos               | Debe existir una mascota con el ID dado | 1. Envía una solicitud PUT a /pet con datos incorrectos.                                       | Se espera un error indicando datos incorrectos.            |                |
| 2   | Añade una nueva mascota a la tienda                                | -                                       | 1. Envía una solicitud POST a /pet con los datos de la nueva mascota.                          | La mascota se añade correctamente.                         |                |
| 2.1 | Intenta añadir una mascota sin proporcionar datos                  | -                                       | 1. Envía una solicitud POST a /pet sin datos.                                                  | Se espera un error indicando datos faltantes.              |                |
| 2.2 | Intenta añadir una mascota con datos incorrectos                   | -                                       | 1. Envía una solicitud POST a /pet con datos incorrectos.                                      | Se espera un error indicando datos incorrectos.            |                |
| 3   | Encuentra mascotas por estado                                      | -                                       | 1. Envía una solicitud GET a /pet/findByStatus con el estado de la mascota como parámetro.     | Se devuelven las mascotas con el estado especificado.      |                |
| 3.1 | Intenta encontrar mascotas con un estado inexistente               | -                                       | 1. Envía una solicitud GET a /pet/findByStatus con un estado inexistente como parámetro.       | Se espera un error indicando estado no encontrado.         |                |
| 4   | Encuentra mascotas por etiquetas                                   | -                                       | 1. Envía una solicitud GET a /pet/findByTags con las etiquetas de la mascota como parámetro.   | Se devuelven las mascotas con las etiquetas especificadas. |                |
| 4.1 | Intenta encontrar mascotas con etiquetas inexistentes              | -                                       | 1. Envía una solicitud GET a /pet/findByTags con etiquetas inexistentes como parámetro.        | Se espera un error indicando etiquetas no encontradas.     |                |
| 5   | Encuentra una mascota por su ID                                    | Debe existir una mascota con el ID dado | 1. Envía una solicitud GET a /pet/{petId} con el ID de la mascota como parámetro.              | Se devuelve la información de la mascota.                  |                |
| 5.1 | Intenta encontrar una mascota con un ID inexistente                | -                                       | 1. Envía una solicitud GET a /pet/{petId} con un ID inexistente como parámetro.                | Se espera un error indicando mascota no encontrada.        |                |
| 6   | Actualiza una mascota en la tienda con datos de formulario         | Debe existir una mascota con el ID dado | 1. Envía una solicitud POST a /pet/{petId} con los nuevos datos de la mascota como formulario. | La mascota se actualiza correctamente.                     |                |
| 6.1 | Intenta actualizar una mascota con datos de formulario incorrectos | Debe existir una mascota con el ID dado | 1. Envía una solicitud POST a /pet/{petId} con datos de formulario incorrectos.                | Se espera un error indicando datos incorrectos.            |                |
| 6.2 | Intenta actualizar una mascota con un ID inexistente               | -                                       | 1. Envía una solicitud POST a /pet/{petId} con un ID inexistente como parámetro.               | Se espera un error indicando mascota no encontrada.        |                |
| 7   | Elimina una mascota                                                | Debe existir una mascota con el ID dado | 1. Envía una solicitud DELETE a /pet/{petId} con el ID de la mascota como parámetro.           | La mascota se elimina correctamente.                       |                |
| 7.1 | Intenta eliminar una mascota con un ID inexistente                 | -                                       | 1. Envía una solicitud DELETE a /pet/{petId} con un ID inexistente como parámetro.             | Se espera un error indicando mascota no encontrada.        |                |
| 8   | Sube una imagen                                                    | Debe existir una mascota con el ID dado | 1. Envía una solicitud POST a /pet/{petId}/uploadImage con la imagen de la mascota.            | La imagen se sube correctamente.                           |                |
| 8.1 | Intenta subir una imagen sin proporcionarla                        | Debe existir una mascota con el ID dado | 1. Envía una solicitud POST a /pet/{petId}/uploadImage sin la imagen de la mascota.            | Se espera un error indicando imagen faltante.              |                |
| 8.2 | Intenta subir una imagen a una mascota con un ID inexistente       | -                                       | 1. Envía una solicitud POST a /pet/{petId}/uploadImage con un ID inexistente como parámetro.   | Se espera un error indicando mascota no encontrada.        |                |


# Solucion Implementada
La generación de casos de prueba tanto positivos como negativos es esencial para garantizar que una API funcione correctamente en todas las situaciones esperadas y maneje adecuadamente las situaciones inesperadas o erróneas. Los casos de prueba que has proporcionado parecen seguir varias buenas prácticas en este sentido:

#### 1. Cobertura de Funcionalidades:

Cada operación CURL (crear, leer, actualizar, eliminar) está cubierta por al menos un caso de prueba. Esto asegura que cada funcionalidad de la API se prueba al menos una vez.
Los casos de prueba negativos están diseñados para asegurar que la API maneja los errores, como la entrada de datos incompletos o incorrectos y las solicitudes con identificadores inexistentes.

#### 2. Casos de Prueba Negativos:

Se incluyen casos para realizar operaciones sin proporcionar los datos necesarios o con datos incorrectos. Esto prueba la robustez de la API frente a entradas inválidas y ayuda a garantizar que la API no se comportará de manera inesperada o se bloqueará cuando hay entradas erróneas.
También se prueban situaciones donde se intentan realizar operaciones en recursos que no existen (como usuarios o mascotas).

#### 3. Mensajes de Error Específicos:

Cada caso de prueba negativo tiene un resultado esperado que incluye un mensaje de error específico (400,405,404). Esto es importante no solo para validar que se produce un error, sino que el mensaje es claro y útil para quien consume la API.

#### 4. Validación de Estados y Condiciones Previas:

Algunos casos de prueba requieren de precondiciones, como la necesidad de que un usuario esté registrado y conectado antes de poder cerrar sesión, cabe aclarar que en esta API de pruebas el login y logout funcionan sin las condiciones previas dadas. Estos casos ayudan a confirmar que la lógica de estado de la API funciona como se espera.

#### 5. Verificación de Datos:

Los casos de prueba incluyen validaciones para asegurarse de que los datos devueltos en las respuestas son correctos. Esto es importante para los casos de prueba positivos, donde se espera que la API funcione como de forma positiva.

#### 6. Organización y Estructura:

Los casos de prueba están bien organizados y estructurados, cada uno con un ID y una descripción clara, lo que facilita la comprensión y el mantenimiento de las pruebas.



## Cobertura de Pruebas:
Los casos presentados dan una cobertura amplia de la API al incluir:

Flujos de Usuario Completos: Creación, autenticación, actualización y eliminación de usuarios.
Manejo de Datos de Mascotas: Creación, actualización, consulta y eliminación, así como la gestión de imágenes asociadas.
Gestión de Pedidos: Realización, consulta y eliminación de pedidos de mascotas.

La "cobertura total" es relativa y depende en gran medida de la especificación completa de la API y los requisitos del negocio. Mientras que los casos proporcionados cubren muchas situaciones comunes y críticas, aún hay muchos tipos de pruebas a tener en cuenta si se quiere tener una cobertura total sobre el API.

## Estructura de casos de prueba:

![img.png](img.png)

Todos los casos de prueba cuentan con una estructura simple con el fin de brindar a todo el equipo de pruebas la facilidad de entender y dar mantenimiento a los mismos, se imprime en todos el .log().body para ver en consola la respuesta que da cada operación de la API.
Se intenta todo el tiempo usar buenas prácticas de código y comentar las líneas que sean necesarias, además de brindar flexibilidad para cambiar los datos a ingresar.

## Funciones:

La creación de generadores de datos como OrderDataGenerator, PetGenerator, UserDataGenerator, y UserListDataGenerator es una excelente práctica. Estos generadores pueden mejorar la calidad y la eficiencia de las pruebas por varias razones:

#### 1. Automatización y Eficiencia:
•	Generar datos de prueba automáticamente ahorra tiempo en comparación con la creación manual de cada conjunto de datos para cada prueba.
•	Permite la ejecución de pruebas más frecuentes sin el costo adicional de preparar los datos.

#### 2. Variedad de Datos:
•	Los generadores pueden crear una amplia gama de datos de prueba, lo que ayuda a garantizar que la API se maneje correctamente bajo diferentes entradas de datos.
•	Pueden simular datos más realistas que reflejen los diversos escenarios que un usuario podría encontrar.

#### 3. Datos Dinámicos y Aleatorios:
•	Al usar datos generados dinámicamente, se reduce la posibilidad de que las pruebas estén atadas a datos estáticos o que se pase por alto los casos límite.
•	Generar datos aleatorios puede descubrir errores que no se habrían encontrado con conjuntos de datos estáticos.

#### 4. Consistencia y Repetibilidad:
•	Los generadores pueden asegurar que los datos de prueba sean consistentes entre las ejecuciones de pruebas, lo que es importante para la repetibilidad.

#### 5. Escalabilidad de Pruebas:
•	Facilitan la escalabilidad de las pruebas. A medida que la API crece y se agregan nuevas funciones, los generadores pueden ser actualizados para incluir nuevos tipos de datos necesarios para las pruebas.
•	Esto es útil en las metodologías de desarrollo ágil y de integración continua donde las pruebas deben mantenerse al día con cambios frecuentes en la API.



