import java.util.List;
import java.util.Objects;

class Student
{
   private final String surname;
   private final String givenName;
   private final int age;
   private final List<CourseSection> currentCourses;

   public Student(final String surname, final String givenName, final int age,
      final List<CourseSection> currentCourses)
   {
      this.surname = surname;
      this.givenName = givenName;
      this.age = age;
      this.currentCourses = currentCourses;
   }

   public int hashCode() {
      return (Objects.hash(surname, givenName, age ,currentCourses));
   }

   public boolean equals(Object other){
      if(other == null){
         return false;
      }
      if(other.getClass() != this.getClass()){
         return false;
      }
      Student S = (Student) other;

      return  (Objects.equals(surname, S.surname) && Objects.equals(givenName, S.givenName) && Objects.equals(currentCourses, S.currentCourses) && age == S.age && this.hashCode() == S.hashCode());

   }
}
