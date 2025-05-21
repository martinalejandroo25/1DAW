package Programacion.ProgramacionFuncionalOpenWebinars;

public class  Task{
     private Long id;
     private String title;
     private Integer hours;

     public Task(Long id, String title, Integer hours) {
          this.id = id;
          this.title = title;
          this.hours = hours;
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public Integer getHours() {
          return hours;
     }

     public void setHours(Integer hours) {
          this.hours = hours;
     }

     @Override
     public String toString() {
          final StringBuilder sb = new StringBuilder("Task{");
          sb.append("id=").append(id);
          sb.append(", title='").append(title).append('\'');
          sb.append(", hours=").append(hours);
          sb.append('}');
          return sb.toString();
     }
}