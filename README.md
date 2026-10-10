# ISUCI: Simulador de ciclismo internacional

Aplicación de escritorio en Java que simula la gestión de un sistema de ciclismo internacional, con acceso diferenciado por roles y simulación de carreras.

Proyecto final de **Programación I**, Ingeniería de Sistemas, Universidad El Bosque.

## Funcionalidades

- Registro e inicio de sesión de usuarios.
- Acceso según el rol:
  - **Ciclistas:** consultan y actualizan su información personal.
  - **Directores deportivos:** gestionan su equipo y revisan sus datos.
  - **Masajistas:** consultan su propia información.
  - **Administradores:** ejecutan simulaciones de carreras y consultan reportes.
- Tipos de ciclista según especialidad: escalador, rodador, embalador, gregario, clasicómano y contrarrelojista.
- Creación y gestión de escuadras.
- Simulación de carreras en cuatro tipos de terreno: llano, montaña, plano y semillano.

## Tecnologías

- Java 17
- JavaMail para el envío de correos
- Persistencia en archivos
- Eclipse IDE

## Arquitectura

El proyecto sigue el patrón **Modelo-Vista-Controlador (MVC)**:

- `controller`: coordina la vista y el modelo.
- `model`: clases de dominio (DTO).
- `model/persistence`: acceso a datos (DAO).
- `view`: paneles de la interfaz gráfica.
- `util`: utilidades de correo, excepciones y ordenamiento.

## Documentación

- Acta de constitución
- Diagrama de clases
- Matriz de requerimientos
- Javadoc en la carpeta `doc`

## Cómo ejecutarlo

1. Tener instalado el JDK 17.
2. En Eclipse: **File > Import > Existing Projects into Workspace** y seleccionar la carpeta del proyecto.
3. Ejecutar la clase `co.edu.unbosque.controller.AplMain`.

## Equipo

Proyecto académico desarrollado en equipo.
