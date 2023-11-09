# PromassBlog


Prueba: Promass 

El presente proyecto tiene como finalidad el poder realizar un proyecto que de la posibilidad de consumir un servicio o bien, obtener datos de firebase y tener un modo offline.
## Requisitos de la prueba

1. Alta de entradas
  - El usuario podrá guardar entradas en la aplicación. Una entrada deberá estar compuesta por los siguientes elementos:
    - Título: enuncia el contenido de la entrada.
    - Autor: el nombre de quien publica la entrada
    - Fecha de publicación: la fecha en que la entrada fue guardada.
    - Contenido: un escrito breve.
(Todos los campos son obligatorios)
2. Mostrar un listado de entradas
  - Deberá de mostrar un listado con todas las entradas en el blog, pero del campo contenido, sólo se mostrarán los primeros setenta caracteres.

3. Búsquedas
  - La aplicación debe permitir realizar búsquedas de entradas permitiendo filtrar por título, contenido o autor.
4. Mostrar detalle de una entrada.
  - Al seleccionar una entrada del listado, deberá mostrarse el contenido de la entrada. Es decir, deberá ser visible todo el texto del contenido.
5. Obtención de recursos
  - La obtención de los datos se hará por medio de un servicio REST que la aplicación debe consumir. Este proporcionará los métodos necesarios para consultar y guardar las entradas del sitio a través de internet en un servidor.
6. Extra - Modo offline
  - En caso de que el dispositivo no cuente con conexión a internet, el sistema web deberá de tomar los siguientes puntos:
      - La aplicación permitirá ver las entradas que se hayan descargado previamente.
      - Se bloqueará la opción de dar alta entradas.
      - Se mostrará un mensaje de que no se tiene conexión a internet.

7. Servicio Web
  - Como servicio web, puedes utilizar la plataforma de Firebase para guardar la información en la nube.
  - Si deseas, puedes desarrollar el servicio en cualquier tecnología backend.
  - Es importante que la aplicación obtenga y guarde información en la nube.

## Requisitos mínimos para el funcionamiento del proyecto

### Entorno de desarrollo

- Version: Android Studio Giraffe | 2022.3.1 Patch 2
- Runtime version: 17.0.6+0-17.0.6b829.9-10027231

### Lenguaje de programación y bibliotecas

- Kotlin Version 1.7.10
- JDK Version 17
- JVM Version 17
- Java Version 17
- Compile SDK 34
- Version mínima de SDK Android para funcionar 28
- Bibliotecas
  - Lifecycle 2.6.1


### Herramientas

Las herramientas necesarias para poder hacer funcionar este proyecto son las siguientes:
- Equipo de cómputo con requisitos mínimos como
  - RAM 16 Gb
  - Almacenamiento 256 GB
  - Procesador
    - Intel 7/9 décima generación o superior
    - Apple M1
  - Tarjeta gráfica dedicada para poder correr simulador en caso de requerirse
- Dispositivo móvil con Android 11 o superior para correr la aplicación.


## Requisitos para obtener el código del proyecto
Dirigirse al botón de verde denominado "Code" y descargar el proyecto o bien, clonar con el siguiente comando.
  - git clone https://github.com/charBot21/PromassBlog.git

Para clonar el proyecto, requieres tener instalado Git en tu equipo de cómputo y dirigirte a la terminal de Mac o bien, abrir la terminal Bash de Git en Windows.
