# README #

Gestor de usuarios basico (CRUD) con acceso controlado via JWT.

@Autor: Ing. Christhian Lugo Govea.
@Fecha: 03/05/2024

### Contenido

5 Proyectos para distribuir los componentes del sistema:

	- Entities       -> Proyecto para empaquetar las entidades mapeadas a la base de datos.
	- Authentication -> Proyecto para empaquetar las clases comunes para la autenticacion de los JWT.
	- Definitions    -> Otras definiciones comunes.
	- Ms-Auth        -> Microservicio para antenticar al usuario.
	- Ms-Users       -> Microservicios para la gestion de los usuarios (CRUD)

### Recursos de los microservicios REST:

	- Ms-Auth
		/auth/login          -> Recurso POST para la autenticion del usuario.

	- Ms-Users
		/user/list           -> Recurso GET para la busqueda de la lista de los usuarios registrados.
		/user/{id}           -> Recurso GET para la consulta de un usuario en especifico.
		/user/add            -> Recurso POST para registrar nuevos usuarios.
		/user/update"        -> Recurso PUT para actualizar la informacion de los usuarios registrados.
		/user/updatePassword -> Recurso PUT para actualizar la contraseña de los usuarios registrados.
		/user/{id}           -> Recurso DELETE para la eliminacion de un usuarios en especifico.
