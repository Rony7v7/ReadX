# ReadX
 Rony Farid Ordoñez García
 
 A00397968

![image](https://user-images.githubusercontent.com/115596440/236879905-b5e02478-1267-40fa-986f-bcf790452e3d.png)

# Enunciado


Debido a su basta experiencia como programador, usted ha sido contratado por ReadX, un conglomerado egipcio, para desarrollar un prototipo de software que les permita gestionar su negocio de publicaciones a nivel mundial. A continuación se presentan las funcionalidades a desarrollar:

## Gestión de productos bibliográficos
El modelo de negocio de la empresa se basa, por ahora, en la venta de dos tipos de productos bibliográficos: libros y revistas. 

Cada libro tiene un identificador único (3 caracteres hexadecimales), un nombre, un número de páginas, una reseña corta, una fecha de publicación, un género, una URL que lleva a un repositorio con la portada del libro, el valor de venta (en dólares), el número de ejemplares vendidos y el acumulado de páginas leídas. Los posibles géneros existentes en el prototipo son: Ciencia Ficción, Fantasía y Novela Histórica. 

Cada revista tiene un identificador único (3 caracteres alfanuméricos), un nombre, un número de páginas, una fecha de publicación, una categoría, una URL que lleva a un repositorio con la portada de la revista, el valor de la suscripción (en dólares), la periodicidad de emisión, el número de suscripciones activas y el acumulado de páginas leídas. Las posibles categorías existentes en el prototipo son: Variedades, Diseño y Científica. 

ReadX anticipa cambios en la industria de la publicación por lo que le solicita que el diseño del prototipo contemple la creación futura de otros tipos de productos bibliográficos.
![image](https://user-images.githubusercontent.com/115596440/236877995-5f5e4a0f-f0e3-40a5-a650-6c185eea96a7.png)

El prototipo debe permitir registrar, borrar y modificar productos bibliográficos en el sistema.

## Gestión de usuarios
El prototipo debe contar, por ahora, con dos tipos de usuario: regular y premium. El usuario Regular podrá comprar 5 libros, suscribirse hasta a 2 revistas y durante su uso de la plataforma, se le presentarán anuncios publicitarios. Por su parte, el usuario Premium podrá adquirir libros y suscribirse a tantas revistas como desee y pueda pagar. Para realizar el registro de usuarios en la plataforma se necesitan los siguientes datos: nombre, cédula y fecha de vinculación. ReadX anticipa la evolución y crecimiento dinámico de su plataforma por lo que le solicita que el diseño del prototipo contemple la creación futura de otros tipos de usuario.

## Compra de libros o suscripción a revistas
Cuando los usuarios adquieren un libro o se suscriben a una revista, se debe almacenar la fecha de la operación y el monto pagado en una factura, así como también actualizarse el número de ejemplares vendidos o las suscripciones activas, según corresponda al tipo de producto bibliográfico. Adicionalmente, se debe permitir al usuario cancelar la suscripción a una revista en cualquier momento.

## Presentación de la Biblioteca
ReadX requiere que su prototipo cuente con un menú que le permita al usuario visualizar su colección de productos bibliográficos, de manera rápida, semejando a una biblioteca. La Biblioteca deberá representarse a través de matrices 5x5 que gráficamente presenten el código de los productos bibliográficos asociados a la cuenta del usuario. Los productos deberán estar ordenados por fecha de publicación, de la más antigua a la más nueva. Conforme el usuario amplíe su colección, se deberá permitir al usuario navegar en la misma (anterior o siguiente página). El usuario deberá poder seleccionar un producto bibliográfico ya sea por su coordenada x,y en la matriz presentada o el identificador de 3 caracteres del producto con el fin de iniciar una sesión de lectura. A continuación se presenta un ejemplo de interfaz gráfica de la Biblioteca.

![image](https://user-images.githubusercontent.com/115596440/236879611-fd074593-106c-4450-b125-196be94302b7.png)

Simulación de una sesión de lectura: La simulación de la sesión de lectura no es más que presentar por consola el nombre del producto bibliográfico, la página actual que se está leyendo y unas opciones de navegación para leer la página anterior, la página siguiente y para volver a la Biblioteca. A continuación se presenta un ejemplo de la simulación.

![image](https://user-images.githubusercontent.com/115596440/236879713-4111e7a2-b024-4606-8f3d-282119ecd675.png)

Cada página leída en la simulación incrementa el número de páginas leídas del producto bibliográfico correspondiente en la plataforma. Finalmente, se debe tener en cuenta que durante la sesión de lectura, para el caso de los usuarios regulares, se deben presentar anuncios publicitarios en dos momentos: al iniciar la sesión de lectura y luego de cada 20 páginas leídas de un libro o 5 páginas leídas de una revista. 

## Generación de reportes
Con el fin de generar contenidos dirigidos, ReadX solicita que el prototipo pueda generar los siguientes reportes en tiempo real: 

- Para cada tipo de producto bibliográfico, libro y revista, informar el acumulado total de páginas leídas en toda la plataforma (tipo de producto y número de páginas leídas).
- Informar el género de libro y categoría de revista más leídas para toda la plataforma (nombre del género o categoría y número de páginas leídas).
- Informar el Top 5 de libros y el Top 5 de revistas más leídas en la plataforma (nombre del libro, nombre del género o categoría y número de páginas leídas).
- De cada género, informar el número de libros vendidos y el valor total de ventas ($). 
- De cada categoría, informar el número de suscripciones activas y el valor total pagado por suscripciones.

## Gestión de pruebas
Con el fin de facilitar al usuario final la realización de pruebas, el prototipo debe contener al menos una funcionalidad que se encargue de generar automáticamente en el sistema, cuando el usuario lo solicite, al menos un objeto para cada tipo de usuario y producto bibliográfico.

---

## En resumen, el prototipo a desarrollar debe ofrecer las siguientes funcionalidades: 
- Registrar usuarios, regulares y premium.
- Gestionar productos bibliográficos: registrar, modificar y borrar libros y revistas.
- Generar automáticamente objetos en el sistema para cada tipo de usuario y producto bibliográfico.
- Permitir a un usuario comprar un libro.
- Permitir a un usuario suscribirse a una revista.
- Permitir a un usuario simular una sesión de lectura (regular y premium).
- Presentar al usuario su Biblioteca de Productos Bibliográficos.

### Generar informes con los datos registrados
- Para cada tipo de producto bibliográfico, libro y revista, informar el acumulado total de páginas leídas en toda la plataforma (tipo de producto y número de páginas leídas).
- Informar el género de libro y categoría de revista más leídas en la plataforma (nombre del género o categoría y número de páginas leídas).
- Informar el Top 5 de libros y el Top 5 de revistas más leídas en la plataforma (nombre del libro o revista, nombre del género o categoría y número de páginas leídas).
- De cada género, informar el número de libros vendidos y el valor total de ventas ($). 
- De cada categoría, informar el número de suscripciones activas y el valor total pagado por suscripciones ($).
