package spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CourseCertificate {
	
	private String course;
	@Column(name = "course_duration")
	private String courseDuration;
	
	public CourseCertificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseCertificate(String course, String courseDuration) {
		super();
		this.course = course;
		this.courseDuration = courseDuration;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	
	
}
