package dominio;

public class Usuario {
	
	private int id;
	private String nombre;
	private String apellido;
	private String username;
	private String imagen;
	private String clave;
	private String estado;
	

	public Usuario(int id, String username) {
		this.id = id;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Usuario(int id, String nombre, String apellido, String username, String clave, String estado, String imagen) 
	{
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.imagen = imagen;
		this.clave = clave;
		this.estado = estado;
	}
	
	
}
