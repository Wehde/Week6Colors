/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Oct 1, 2022
 */
package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Names")
public class ColorName {
	//Variables
	@Id
	@GeneratedValue
	private int id;
	@JoinColumn
	@ManyToOne (cascade= {CascadeType.MERGE})
	private HexColor hexColor;
	@Column
	private String name;
	
	//Getters and Setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the hexColor
	 */
	public HexColor getHexColor() {
		return hexColor;
	}
	/**
	 * @param hexColor the hexColor to set
	 */
	public void setHexColor(HexColor hexColor) {
		this.hexColor = hexColor;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	//Constructors
	/**
	 * Default no-arg constructor
	 */
	public ColorName() {
		super();
	}	
	/**
	 * @param hexColor
	 * @param name
	 */
	public ColorName(HexColor hexColor, String name) {
		super();
		this.hexColor = hexColor;
		this.name = name;
	}
	/**
	 * @param id
	 * @param hexColor
	 * @param name
	 */
	public ColorName(int id, HexColor hexColor, String name) {
		super();
		this.id = id;
		this.hexColor = hexColor;
		this.name = name;
	}
	
	//Method
	@Override
	public String toString() {
		return "ColorName [id=" + id + ", hexColor=" + hexColor.getHexColor() + ", name=" + name + "]";
	}
	
	
	
	
	
}
