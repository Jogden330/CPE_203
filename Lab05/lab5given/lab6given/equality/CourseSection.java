import java.time.LocalTime;

class CourseSection
{
   private final String prefix;
   private final String number;
   private final int enrollment;
   private final LocalTime startTime;
   private final LocalTime endTime;

   public CourseSection(final String prefix, final String number,
      final int enrollment, final LocalTime startTime, final LocalTime endTime)
   {
      this.prefix = prefix;
      this.number = number;
      this.enrollment = enrollment;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   public int hashCode(){
      int hash = 1;
      hash = hash * 31 + (prefix == null ? 0: prefix.hashCode());
      hash = hash * 31 + (number == null ? 0: number.hashCode());
      hash = hash * 31 + enrollment;
      hash = hash * 31 + (startTime == null ? 0: startTime.hashCode());
      hash = hash * 31 + (endTime == null ? 0: endTime.hashCode());

      return hash;
   }

   public boolean equals(Object other)
   {
      if (other != null)
      {
         if (getClass() == other.getClass())
         {
//
            CourseSection C = (CourseSection) other;
            boolean prefixEq, numberEq, enrollmentEq, startTimeEq, endTimeEq;

            if (prefix == null)
               prefixEq = (C.prefix == null);
            else { prefixEq = (prefix.equals(C.prefix)); }

            if (number == null)
               numberEq = (C.number == null);
            else { numberEq = (number.equals(C.number)); }

            if (startTime == null)
               startTimeEq = (C.startTime== null);
            else { startTimeEq = (startTime.equals(C.startTime)); }

            if (endTime == null)
               endTimeEq = (C.endTime == null);
            else { endTimeEq = (endTime.equals(C.endTime)); }

            enrollmentEq = (enrollment == C.enrollment);

            return prefixEq && numberEq && enrollmentEq && startTimeEq && endTimeEq;
         }
      }
      return false;
   }




}
