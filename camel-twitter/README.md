# Twitter, Gmail y Websocket

### Descripción
Lo que hace es tomar tweets con un filtrado de términos en nuestro caso fue "lol",
luego lo mandamos a un socket (que se puede acceder por http://localhost:9090) y
luego mandamos la info por correo

### Ejecutarlo
Para ejecutarlo se corre el comando:

	mvn compile && mvn camel:run

### Observación
Para cambiar los datos del correo ir a archivo "mail.properties"


### Acceso
Una vez compilado y ejecutado, acceder a:

	http://localhost:9090/index.html

