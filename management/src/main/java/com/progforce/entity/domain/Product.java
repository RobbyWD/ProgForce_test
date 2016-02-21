package com.progforce.entity.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
@XmlRootElement
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 700)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    private long price;
    
    private Status status; 
    
    
    
    public Product(){}
    
	public Product(String[]values){
		this.name=values[0];
		this.description = values[1];
		this.price=Integer.parseInt(values[2]);
		this.status = Status.AVAILIABLE;
	}
	
	public Product(String name,String description,long price ){
		this.name=name;
		this.description=description;
		this.price=price;
		this.status = Status.AVAILIABLE;
	}
    
	@JsonIgnore @XmlTransient
	public Category getCategory() {
        return this.category;
    }

	@Override
	public String toString() {
        return this.getName();
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

		
}
