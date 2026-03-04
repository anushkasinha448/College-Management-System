package students_details;

public class add_student {

    private String studentname;
    private String F_name;
    private String M_name;
    private String Course;
    private String Branch;
    private String year;

    private int studentid;
    private long phone;

    // ===== FULL CONSTRUCTOR =====
    public add_student(int studentid, String studentname,
                       String F_name, String M_name,
                       long phone, String Course,
                       String Branch, String year) {

        this.studentid = studentid;
        this.studentname = studentname;
        this.F_name = F_name;
        this.M_name = M_name;
        this.phone = phone;
        this.Course = Course;
        this.Branch = Branch;
        this.year = year;
    }

    // ===== PARTIAL CONSTRUCTOR =====
    public add_student(int studentid, String studentname,
                       String year, String Course, String Branch) {

        this.studentid = studentid;
        this.studentname = studentname;
        this.year = year;
        this.Course = Course;
        this.Branch = Branch;
    }

    // ===== EMPTY CONSTRUCTOR =====
    public add_student() {
        super();
    }

    // ===== GETTERS & SETTERS =====

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String F_name) {
        this.F_name = F_name;
    }

    public String getM_name() {
        return M_name;
    }

    public void setM_name(String M_name) {
        this.M_name = M_name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String Branch) {
        this.Branch = Branch;   // ✅ FIXED BUG HERE
    }

    // ===== toString METHOD (IMPORTANT FOR DISPLAY) =====
    @Override
    public String toString() {
        return "----------------------------------------\n" +
                "Student ID : " + studentid + "\n" +
                "Name       : " + studentname + "\n" +
                "Father     : " + F_name + "\n" +
                "Mother     : " + M_name + "\n" +
                "Phone      : " + phone + "\n" +
                "Course     : " + Course + "\n" +
                "Branch     : " + Branch + "\n" +
                "Year       : " + year + "\n" +
                "----------------------------------------";
    }
}