import java.time.LocalDate;

public class Question {
    int questionId;
    String content;
    CategoryQuestion category;
    TypeQuestion type;
    Account creatorId;
    LocalDate createDate;
    Exam[] exams;
}
