package dsa.upc.edu.listapp.store;

public class Faq {
    private String date;
    private String question;
    private String answer;
    private String sender;

    public Faq() {
    }

    // Getters y setters
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }
}

