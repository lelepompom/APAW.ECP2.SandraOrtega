# Patrones de Diseño | Práctica 1
#### Asignatura: *Arquitectura y Patrones para Aplicaciones Web*
#### [Máster en Ingeniería Web por la U.P.M.](http://miw.etsisi.upm.es)

### Descripción
Dado el diagrama de entidades, realizar al menos 8 peticiones a una API.
Realizar dos liberaciones de código para producción, a mitad camino (release-1.0.0) y al final (release-1.1.0)

### Entidades
* Book `id : String`  `title : String`  `author : String`
* Reader `id : String`  `name : String`  `age : Integer`
* enum Genre `MATHS`  `ARTS`  `DESIGN`
* Publication `id : String`, `signed : Boolean`, `publiDate : LocalDateTime`, `Book : book`,  `List<Reader> : readers`, Genre : genre`
* Feedback id `String`, likes `Integer`
#### Diseño de entidades
![UML DIAGRAM](http://https://github.com/lelepompom/APAW.ECP1.SandraOrtega/blob/master/UML.png)

### Peticiones
* Un GET, PUT, PATCH  y DELETE
* Un POST con relación 0..1
* Un POST con relación 0..n
* Una búsqueda (query)

