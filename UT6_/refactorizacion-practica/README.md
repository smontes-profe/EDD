# Práctica de refactorización

Proyecto de consola para practicar refactorizaciones habituales en Java. El código funciona, pero contiene nombres poco claros, responsabilidades mezcladas y otras oportunidades de mejora. La idea es cambiar su estructura sin cambiar el resultado que obtiene el usuario.

## Requisitos

- JDK 11 o superior
- Maven

## Ejecutar

Desde esta carpeta:

```bash
mvn compile
java -cp target/classes edd.Aplicacion
```

## Ejercicios

Trabaja sobre el código de `src/main/java/edd` y aplica cada refactorización de forma gradual. Después de cada cambio, vuelve a ejecutar el programa y comprueba que el resultado sigue siendo correcto.

1. **Rename Symbol**: cambia los nombres genéricos de `procesar` y de sus variables para que expliquen su propósito.
2. **Extract Method**: separa de `procesar` el bloque que recorre los productos y suma sus precios.
3. **Extract Variable**: pon nombre a las expresiones de cálculo del IVA que aparecen más de una vez.
4. **Encapsulate Field**: convierte los campos públicos de `Pedido` en privados y controla el acceso desde el resto del programa.
5. **Inline Method**: elimina `calcularEnvio` sustituyendo su llamada por el contenido del método.
6. **Replace Conditional with Guard Clauses**: simplifica las condiciones anidadas de `calcularDescuento` usando retornos anticipados.

No es necesario cambiar las reglas del pedido ni añadir funcionalidades. El objetivo es que el código resulte más fácil de entender y modificar conservando su comportamiento.
