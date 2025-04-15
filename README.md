# Farm Simulator 🐮🧺
---
* Este juego permite a los jugadores crear y gestionar su propia granja con animales de manera interactiva. Los usuarios tienen la capacidad de poder comprar diversos animales para poder generar dinero.
* Los usuarios pueden seleccionar entre diferentes tipos de animales y colocarlos en hábitats. Cada tipo de animal tiene un cierto tipo de comida de la que puede alimentarse.
* Los usuarios pueden colocar animales de forma manual (desde un menú). También pueden colocar comida e interactuar con los depósitos de comida de cada hábitat para saber cuánta comida hay guardada en ese depósito.
* Los animales se mueven de manera aleatoria por su hábitat y también el jugador puede colocar su mouse sobre los animales para ver las estadísticas de dicho animal y venderlo a un precio que cambia según el tiempo de compra del animal.
* Los animales deben ser constantemente alimentados, para ello se debe comprar comida en el menú de comida del juego sino ellos morirán. (No hay aviso cuando los habitats tienen poca comida, tener precaución porque los animales comen rapido!).
* Los hábitats tienen mejoras en donde se puede aumentar la capacidad máxima de cierto hábitat y aumentar la capacidad máxima de comida de cierto hábitat.
* En el menú hay una pestaña de "Cheats" en donde el jugador puede cambiar ciertos parámetros del juego, como añadir más dinero, hacer un reset de los hábitats y hacer un reset completo del juego.
* El software garantiza que los animales no puedan ser ubicados en hábitats inadecuados, que se intenten colocar más animales de lo que el hábitat puede soportar y también que se coloque comida de un tipo de animal inadecuado en cierto hábitat.


## Profesor 

* [Geoffrey Hecht](https://github.com/GeoffreyHecht)

## Contribuyentes (Grupo número 15) ✨ 
* [Juan Felipe Raysz Muñoz](https://github.com/Kingsephir)
* [Manuel Isaac Núñez Larenas](https://github.com/sshiro0)
* [Matias Felipe Yener Valdebenito Valenzuela](https://github.com/Mazulini)

## Patrones de diseño utilizados en el proyecto
* Patrón Singleton: se utilizó este patrón en la mayor parte del código para el uso de las clases como variables estáticas, las cuales nos sirvieron como "conexión" entre las clases de la aplicación.
* Patrón Command: se utilizó este patrón para las "mejoras" del juego, más que nada para organizar de mejor manera la forma de gestionar mejoras.
* Patrón Observer: se utilizó este patrón en el sistema de logros para permitir que los logro sean notificados y actualizados automáticamente cuando se produce algún cambio.

 ## Decisiones del proyecto
 * La selección de patrones de diseño: La mayor parte del trabajo no pudimos seleccionar bien qué patrones utilizar.
 * El cambio de dirección del proyecto: En un principio el proyecto tenía la intención de ser un "Simulador de zoo" y decidimos cambiar eso a un juego que simula una granja, en donde se tiene un sistema de economía, mejoras, logros, alimentación, etc...  
 
 ## Problemas en el proyecto
 * Problemas con Git: hubo momentos de desorganización en el equipo, lo que nos llevó a que algunos commits tuviesen mensajes incompletos o erróneos, por lo que se creó otro repositorio y se hicieron todos los commits correspondientes.
 * Mala gestión del tiempo: se desaprovechó el uso de tiempo que teníamos para realizar ciertas tareas en el proyecto.
 * Desafíos en el codigo: tareas como el posicionamiento de los animales, mostrar las estadisticas de un animal, comprar animales, entre otros... fueron desafíos relativamente complejos que necesitaron bastante tiempo para ser programados en lo que es actualmente en el proyecto.

 ## Diagrama de casos
 ![Diagrama](https://github.com/Kingsephir/Farm-Simulator/blob/main/CaseDiagram.png)


 ## Diagrama UML
 ![Diagrama](https://github.com/Kingsephir/Farm-Simulator/blob/main/FarmSimulatorUML.png)


 ## Interfaz Grafica
 ![Imagen](https://github.com/Kingsephir/Farm-Simulator/blob/main/ImagenInterfaz.png)
