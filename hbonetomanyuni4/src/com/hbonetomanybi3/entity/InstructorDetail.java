/**
 * 
 */
package com.hbonetomanybi3.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Thara
 * @creation date & time: 25 Nov 2020 1:14:06 pm
 */
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	// annotate the class as an entity & map to db table

	// define fields

	// annotate the fields with db column names

	// create constructors

	// generate setter/getters methods

	// generate toString method

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "youtube_channel")
	private String youtubeChannel;

	@Column(name = "hobby")
	private String hobby;
	
	//NOTE: bi-directional mapping
	//add instructor field and map it to instructor detail in instructor class
//	@OneToOne(mappedBy = "instructorDetail" , cascade = CascadeType.ALL)
	@OneToOne(mappedBy = "instructorDetail" , 
			cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH })
	private Instructor instructor;

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
	 * @param youtubeChannel
	 * @param hobby
	 */
	public InstructorDetail(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	/**
	 * 
	 */
	public InstructorDetail() {
		System.out.println("no-args constructor");
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
	 * @return the youtubeChannel
	 */
	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	/**
	 * @param youtubeChannel the youtubeChannel to set
	 */
	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	/**
	 * @return the hobby
	 */
	public String getHobby() {
		return hobby;
	}

	/**
	 * @param hobby the hobby to set
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}

}
