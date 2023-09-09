**ACTIVIDAD DE APRENDIZAJE DE ACCESO A DATOS - Modificacion de la API de la 1ª Evaluación para esta 2ª Evaluación**

Mejora de la **API Cybershop** para esta segunda evaluación donde se ha incorporado:

* **Documentación OPEN API (3.0.1)**: Se ha creado un .yaml con la documentación de todas
las clases del proyecto, asi como las operaciones (GET, POST, PUT, DELETE, PATCH)
y sus códigos de estado 
* **Campos nuevos para conectar con Android**: En la clase Client, se han creado especificamente
**cuatro** campos nuevos: **latitude**, **longitude**, **image** y **favourite**. Los cuales
se comunican también con la APP android para funcionalidades propias de la APP como localizar en el mapa,
añadir una imagen de perfil o registro, y marcar o descmarcar un cliente como favorito

Según la actividad de aprendizaje de la segunda evaluación, ademas de mejorar la API,
con documentación OPEN API y su conexion a la APP de android, también pide crear
una **API VIRTUAL** y una **API REACTIVA**, tomando como modelo la API de la primera evaluación,
es decir, la clase Client en estas dos últimas APIs no disponen de los campos nuevos que
mencioné antes: 

Dichas api se encuentran por separado en proyectos distintos, que he añadido también
en classroom, y cada uno tiene su repositorio github propio:

* **API VIRTUAL**: API que simula ser la API normal donde se realizan varios casos de uso
para casos de GET, POST, DELETE, UPDATE en casos **OK (200, 201, 204)** 
y casos **KO (400, 404, 500)**. Se hizo una **colección Postman** de cada clase.

https://github.com/Joserra2304/AA_API_VIRTUAL.git

* **API REACTIVA**: API conectada a la base de datos no relacional **MongoDB**, 
que cambia aspectos de la API normal utilizando **Webflux**. Se hizo una **colección Postman** de cada clase.

https://github.com/Joserra2304/AA_API_REACTIVA