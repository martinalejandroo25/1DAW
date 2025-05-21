package Programacion.ProgramacionFuncionalOpenWebinars;
import java.util.List;

public class Developer {

    private String name;
    private Integer age;
    private List<Task> tasks;

    public Developer(String name, Integer age, List<Task> tasks) {
        this.name = name;
        this.age = age;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Developer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", tasks=").append(tasks);
        sb.append('}');
        return sb.toString();
    }
}