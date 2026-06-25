2.2. ¿Qué mecanismos de seguridad incluirías en la aplicación para
garantizar la protección del acceso a los datos?
usaria jwt con springsecurity
_________
2.3. ¿Qué estrategia de escalabilidad recomendarías para la aplicación
considerando que el crecimiento proyectado será de 1,000,000 de clientes
por año?
 una arquictetura multiservicio con docker aws y balanceador de cargas
 backend por un  lado y el frontend por el otro
 ________
.2.4 ¿Qué patrón o patrones de diseño recomendarías para esta solución y
cómo se implementarían
el patron dto para que la base de datos no este expuesta cuando se realicen las  peticiones 
______________________
3.1. Explica la diferencia entre un router y un switch. ¿Cuándo usarías cada uno?
el router es el cerebro de una red privada o pulica, dependiendo si esta en dchp
o estatica
_________________________
3.2. Describe las siete capas del modelo OSI y menciona brevemente la
capa  fisica = los cables como rja45 o utp etc
capa enlace= donde se encuentra la mac en nic
capa red = donde se manejan ipv4 = esa es la mas importante
capa de trasporte= tcp / udp
capa de seeison ,aplicacion= donde estan los protocolos de conexion 
 
____________
3.3. Explica las diferencias entre los protocolos TCP y UDP. Dar un ejemplo
de cuándo usarías cada uno?
uno es para streanming -udp y el otro es para conexiones estables Tcp

3.4. ¿Qué es una máscara de subred y cómo se utiliza para dividir una red en
subredes más pequeñas?
la mascara es la que organiza los host en una red bit a bit

3.5. ¿Puedes mencionar algunos protocolos de enrutamiento dinámico y
explicar brevemente cómo funcionan?

dhcp  este se ecuentra configurado en el router y de forma automatica despues de establecer 
un rango de ip, el sistema operativo pide la ip al router el router se la asigna y asi con cada equipo 

____
**refacto mejoras**
**relizare mejoras sugeridas en otra rama para no tocar la de la prueba  en el tiempo propuesto; que se hizo con mis
colegas.**
1)implementacion de los dto en clientes y servicio primer merge desde refactor-mejoras
____

2) pruebas funcionales en carpeta postman

Importar la colección de Postman ubicada en:

/postman/prueba tecnica celsia.postman_collection.json

La colección contiene:

- CRUD Cliente
- CRUD Servicio
- Consulta de servicios por cliente










