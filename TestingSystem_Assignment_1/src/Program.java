import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        Department department1 = new Department();
        department1.departmentId = 1;
        department1.departmentName ="Trainee";

        Department department2 = new Department();
        department2.departmentId = 2;
        department2.departmentName ="Sale";

        Department department3 = new Department();
        department3.departmentId = 3;
        department3.departmentName ="Security";

        System.out.println(department1);
        System.out.println(department2);
        System.out.println(department3);

        Position position1 = new Position();
        position1.positionId = 1;
        position1.positionName = Position.PositionName.DEV;

        Position position2 = new Position();
        position2.positionId = 2;
        position2.positionName = Position.PositionName.TEST;

        Position position3 = new Position();
        position3.positionId = 3;
        position3.positionName = Position.PositionName.PM;

        Account account1 = new Account();
        account1.accountId = 1;
        account1.email = "nguyenvana@gmail.com";
        account1.userName = "A";
        account1.fullName = "Nguyen Van A";
        account1.department = department1;
        account1.position = position1;
        account1.createDate = LocalDate.now();

        Account account3 = new Account();
        account3.accountId = 3;
        account3.email = "nguyenvanc@gmail.com";
        account3.userName = "A";
        account3.fullName = "Nguyen Van C";
        account3.department = department1;
        account3.position = position1;
        account3.createDate = LocalDate.now();

        Account account2 = new Account();
        account2.accountId = 2;
        account2.email = "nguyenvanb@gmail.com";
        account2.userName = "A";
        account2.fullName = "Nguyen Van B";
        account2.department = department1;
        account2.position = position1;
        account2.createDate = LocalDate.now();


        Group group1 = new Group();
        group1.groupId = 1;
        group1.groupName = "Group 1";
        group1.creator = account1;
        group1.createDate = LocalDate.now();

        Group group2 = new Group();
        group2.groupId = 2;
        group2.groupName = "Group 2";
        group2.creator = account2;
        group2.createDate = LocalDate.now();

        Group group3 = new Group();
        group3.groupId = 3;
        group3.groupName = "Group 3";
        group3.creator = account3;
        group3.createDate = LocalDate.now();

        Group[] groups1 = {group1, group2};
        account1.groups = groups1;
        Group[] groups2 = {group2, group3};
        account2.groups = groups2;
        Group[] groups3 = {group3};
        account3.groups = groups3;

        Account[] accounts1 = {account1,account2};
        group2.accounts = accounts1;
        Account[] accounts2 = {account2,account3};
        group3.accounts = accounts2;
        Account[] accounts3 = {account1};
        group1.accounts = accounts3;


        TypeQuestion typeQuestion1 = new TypeQuestion();
        typeQuestion1.typeId = 1;
        typeQuestion1.typeName = TypeQuestion.TypeName.MULTIPLE_CHOICE;

        TypeQuestion typeQuestion2 = new TypeQuestion();
        typeQuestion2.typeId = 2;
        typeQuestion2.typeName = TypeQuestion.TypeName.ESSAY;

        CategoryQuestion categoryQuestion1 = new CategoryQuestion();
        categoryQuestion1.categoryId = 1;
        categoryQuestion1.categoryName = "Question SQL";

        CategoryQuestion categoryQuestion2 = new CategoryQuestion();
        categoryQuestion2.categoryId = 2;
        categoryQuestion2.categoryName = "Question JAVA";

        CategoryQuestion categoryQuestion3 = new CategoryQuestion();
        categoryQuestion3.categoryId = 3;
        categoryQuestion3.categoryName = "Question C+";

        Question question1 = new Question();
        question1.questionId = 1;
        question1.content = "content 1";
        question1.category = categoryQuestion1;
        question1.type = typeQuestion1;
        question1.creatorId = account1;
        question1.createDate = LocalDate.now();

        Question question2 = new Question();
        question2.questionId = 2;
        question2.content = "content 2";
        question2.category = categoryQuestion2;
        question2.type = typeQuestion1;
        question2.creatorId = account2;
        question2.createDate = LocalDate.now();

        Question question3 = new Question();
        question3.questionId = 3;
        question3.content = "content 3";
        question3.category = categoryQuestion3;
        question3.type = typeQuestion2;
        question3.creatorId = account3;
        question3.createDate = LocalDate.now();

        Answer answer1 = new Answer();
        answer1.answerId = 1;
        answer1.content = "Answer 1";
        answer1.question = question1;
        answer1.isCorrect = true;

        Answer answer2 = new Answer();
        answer2.answerId = 2;
        answer2.content = "Answer 2";
        answer2.question = question2;
        answer2.isCorrect = true;

        Answer answer3 = new Answer();
        answer3.answerId = 3;
        answer3.content = "Answer 3";
        answer3.question = question3;
        answer3.isCorrect = false;

        Exam exam1 = new Exam();
        exam1.examId = 1;
        exam1.code = "VTI1";
        exam1.title = "title1";
        exam1.category = categoryQuestion1;
        exam1.duration = 90;
        exam1.creator = account1;
        exam1.createDate = LocalDate.now();

        Exam exam2 = new Exam();
        exam2.examId = 2;
        exam2.code = "VTI2";
        exam2.title = "title2";
        exam2.category = categoryQuestion2;
        exam2.duration = 90;
        exam2.creator = account2;
        exam2.createDate = LocalDate.now();

        Exam exam3 = new Exam();
        exam3.examId = 3;
        exam3.code = "VTI3";
        exam3.title = "title3";
        exam3.category = categoryQuestion3;
        exam3.duration = 60;
        exam3.creator = account3;
        exam3.createDate = LocalDate.now();

        Exam[] exams1 = {exam1, exam2 };
        question1.exams = exams1;
        Exam[] exams2 = {exam2, exam3};
        question2.exams = exams2;
        Exam[] exams3 = {exam3};
        question3.exams = exams3;

        Question[] questions1 = {question1};
        exam1.questions = questions1;
        Question[] questions2 = {question1, question2};
        exam2.questions = questions2;
        Question[] questions3 = {question2, question3};
        exam3.questions = questions3;

        System.out.println("Acc1 Id: " + account1.accountId + " UserName: " + account1.fullName + " Email: " + account1.email + " DepartName: " + account1.department.departmentName + " Position: " + account1.position.positionName);
    }
}