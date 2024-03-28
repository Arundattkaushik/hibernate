package spring.many2one;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String answers;
	@ManyToOne
	private Ques ques;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	public Ques getQues() {
		return ques;
	}
	public void setQues(Ques ques) {
		this.ques = ques;
	}
}
