package ar.edu.unju.fi.tp4.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	private Long id;
	
	@Column(name = "pro_nombre" , length = 50 , nullable = false)
	private String nombre;
	@Column(name = "pro_precio" , nullable = false)
	private double precio;
	@Column(name = "pro_marca" , length = 50 , nullable = false)
	private String marca;
	@Column(name = "pro_stock" , nullable = false)
	private int stock;
	
	
	public Producto() {
		
	}


	/**
	 * @param id
	 * @param nombre
	 * @param precio
	 * @param marca
	 * @param stock
	 */
	public Producto(Long id, String nombre, double precio, String marca, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}



	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", marca=" + marca + ", stock="
				+ stock + "]";
	}


	
}
