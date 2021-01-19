/**
 * 
 */
package com.hbonetomanybi3.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Thara
 * @creation date & time: 26 Nov 2020 12:01:52 am
 */
@Entity
@Table(name = "course")
public class Course {

	// annotate the class as an entity and map class to db table

	// define fields

	// define setter/getters

	// define constructors

	// define toString method
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<Review> reviews;

	/**
	 * @return the reviews
	 */
	public List<Review> getReviews() {
		return reviews;
	}

	/**
	 * @param reviews the reviews to set
	 */
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the instructor
	 */
	public Instructor getInstructor() {
		return instructor;
	}

	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	/**
	 * 
	 */
	public Course() {
		System.out.println("course no-args constructor");
	}

	/**
	 * @param title
	 */
	public Course(String title) {
		super();
		this.title = title;
	}

	/**
	 * @param title
	 * @param instructor
	 */
	public Course(String title, Instructor instructor) {
		super();
		this.title = title;
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}

	/**
	 * add a convenience method
	 */
	public void addReview(Review review) {

		if (reviews == null) {
			reviews = new ArrayList<Review>();
		}

		reviews.add(review);

	}
}
