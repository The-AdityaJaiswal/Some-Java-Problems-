import java.util.Arrays;
import java.util.Scanner;

public class courseProgramm {

public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int loopCount=scan.nextInt();scan.nextLine();
	Course[] courses=new Course[loopCount];
	for(int i=0;i<loopCount;i++) {
		int inp1 = scan.nextInt();scan.nextLine();
		String inp2=scan.nextLine();
		String inp3=scan.nextLine();
		int inp4=scan.nextInt();scan.nextLine();
		int inp5=scan.nextInt();scan.nextLine();
		courses[i] =new Course(inp1,inp2,inp3,inp4,inp5);		
	}	
	String inp6=scan.nextLine();
	int inp7=scan.nextInt();scan.nextLine();
	scan.close();
	
	int result=findAvgOfQuizByAdmin(courses,inp6);
    if (result==0) 
    	System.out.println("There is no course with given parameter");
    else
    	System.out.println(result); 	
    
	Course[] resultobj=sortCourseByHandsOn(courses,inp7);
    if(resultobj==null)
    	System.out.println("No Course found");
    else
    {
    	for(Course course:resultobj) {
    		System.out.println(course.getCourseName());
    	}
    }
	
}

public static int findAvgOfQuizByAdmin(Course[] courses,String inp6) {
	int count=0,sum=0;
	for(Course course:courses)
	{
		if(course.getCourseAdmin().equalsIgnoreCase(inp6)) {
			count++;
			sum+=course.getQuiz();
		}
	}
	if (sum>0)
		return sum/count;
	return 0;
}
public static Course[] sortCourseByHandsOn(Course[] courses,int inp7) {
	Course[] result=new Course[0];
	for(Course course:courses)
	{
		if(course.getHandson()< inp7)
		{
			result=Arrays.copyOf(result,result.length+1);
			result[result.length-1]=course;
		}
	}

	for(int i=0;i<result.length-1;i++)
	{
		for(int j=0;j<result.length-i-1;j++) {
			if(result[j].getHandson()>result[j+1].getHandson()) {
				Course temp=result[j];
				result[j]=result[j+1];
				result[j+1]=temp;
			}
		}
	}
	if (result.length>0)
		return result;
	return null;
}
}
 class Course{
	 private int courseId;
	 private String courseName;
	 private String courseAdmin;
	 private int quiz;
	 private int handson;
	public Course(int courseId, String courseName, String courseAdmin, int quiz, int handson) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseAdmin = courseAdmin;
		this.quiz = quiz;
		this.handson = handson;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseAdmin() {
		return courseAdmin;
	}
	public void setCourseAdmin(String courseAdmin) {
		this.courseAdmin = courseAdmin;
	}
	public int getQuiz() {
		return quiz;
	}
	public void setQuiz(int quiz) {
		this.quiz = quiz;
	}
	public int getHandson() {
		return handson;
	}
	public void setHandson(int handson) {
		this.handson = handson;
	}	 
 }
 
 
//  Test Case 1
//4 
//111
//kubernetes
//Nisha
//40
//10
//321
//cassandra
//Roshini
//30
//15
//457
//Apache Spark
//Nisha
//30
//12
//987
//site core
//Tirth
//50
//20
//Nisha
//17