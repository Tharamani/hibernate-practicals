/**
 * 
 */
package com.hbonetomanybi3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Thara
 * @creation date & time: 1 Dec 2020 2:14:39 pm
 */
@Entity
@Table(name = "review")
public class Review {

	// define fields

	// annotate fields

	// define constructor

	// generate setters/getters

	// override toString()

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "comment")
	private String comment;

	/**
	 * 
	 */
	public Review() {
		System.out.println("no-args constructor");
	}

	/**
	 * @param id
	 * @param comment
	 */
	public Review(String comment) {
		super();
		this.comment = comment;
	}

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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}

}
