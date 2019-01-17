# Arquitecturas y Patrones Web | Práctica 2
#### Asignatura: *Arquitectura y Patrones para Aplicaciones Web*
#### [Máster en Ingeniería Web por la U.P.M.](http://miw.etsisi.upm.es)

### Descripción
Este proyecto pretende ser un ejemplo sencillo de arquitectura de un API-Rest simulado para comprender las capas que intervienen
y la organización de los diferentes tipos de test, con integración continua y control de la calidad del código.

### Entidades
* Book `id : String`  `title : String`  `author : String`
* Reader `id : String`  `name : String`  `age : Integer`
* enum Genre `MATHS`  `ARTS`  `DESIGN`
* Publication `id : String`, `signed : Boolean`, `publiDate : LocalDateTime`, `Book : book`,  `List<Reader> : readers`, Genre : genre`
* Feedback id `String`, likes `Integer`

#### Diseño de entidades
![UML DIAGRAM](https://raw.githubusercontent.com/lelepompom/APAW.ECP2.SandraOrtega/develop/docs/UML.png)

#### Arquitectura
![ARCHITECTURE DIAGRAM](https://raw.githubusercontent.com/lelepompom/APAW.ECP2.SandraOrtega/develop/docs/architecture.png)

#### Responsabilidades
##### Dispatcher
* Centraliza las peticiones y hace de repartidor
* Recupera los datos de la petición y los pasa como parámetros de método
* Captura las excepciones y las convierte en errores Http
##### apiControllers
* Define el path del recurso
* Valida la entrada
* Traspasa la petición a los controladores de la capa de negocio
##### businessControllers
* Procesa la petición, apoyándose en los DAO’s
* Crea las entidades a partir de los DTO’s
* Gestiona la respuesta a partir de las entidades. Delega en los DTO’s la creación a partir de la entidad
##### daos
* Destionan la BD
##### entities
* Son las entidades persistentes en la BD

### Requisitos
* Un GET : /publication/{title}
* Un PUT : /reader/{id}
* Un PATCH : /publication/{id}
* Un DELETE : /reader/{id}
* Un POST con relación 0..1 : /publication/genre
* Un POST con relación 0..n : /publication/{id}/reader
* Una búsqueda (query) : /publication/search?q==genre:="DESIGN"
* Realizar dos liberaciones de código para producción, a mitad camino (release-1.0.0) y al final (release-1.1.0)

***

## Documentación de la API

### POST /reader
#### Parámetros del cuerpo
* `name`: String (requerido)
* `age`: Integer
#### Respuesta
* 200 OK
..* `id`: String
* 403 BAD REQUEST


### DELETE /reader/{id}
#### Respuesta
* 200 OK


### PUT /reader/{id}
#### Parámetros del cuerpo
* `name`: String (requerido)
* `age`: Integer
#### Respuesta
* 200 OK
* 403 BAD REQUEST
* 404 NOT FOUND


### POST /publication
#### Parámetros del cuerpo
* `signed`: Boolean (requerido)
* `genre`: Genre
* `title`: String (requerido)
#### Respuesta
* 200 OK
..* `id`: String
* 403 BAD REQUEST


### POST /publication/{id}/author
#### Parámetros del cuerpo
* `author`: String (requerido)
#### Respuesta
* 200 OK
* 403 BAD REQUEST
* 404 NOT FOUND


### GET /publication/{title}
#### Respuesta
* 200 OK
..* {`id`: String, `title`: String, `author`: String}
* 404 NOT FOUND


### PATCH /publication/{id}
#### Parámetros del cuerpo
* `readers`: Reader (requerido)
#### Respuesta
* 200 OK
* 403 BAD REQUEST
* 404 NOT FOUND


### GET /publication/search?q=genre:="DESIGN"
#### Respuesta
* 200 OK
..* {`id`: String, `title`: String, `author`: String}
* 403 BAD REQUEST
