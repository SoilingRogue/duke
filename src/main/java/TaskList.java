import java.util.LinkedList;

public class TaskList {
    private LinkedList<Task> lst;

    public TaskList(LinkedList<String> list) throws DukeException {
        lst = new LinkedList<>();
        for (String s : list) {
            String[] arr = s.split("\\|");
            String task = arr[0].trim();
            int done = Integer.parseInt(arr[1].trim());
            String desc = arr[2];
            switch (task) {
                case "D":
                    Deadline deadline = Deadline.of(desc, arr[3]);
                    if (done == 1) {
                        deadline.markAsDone();
                    }
                    lst.addLast(deadline);
                    break;
                case "T":
                    Todo todo = Todo.of(desc);
                    if (done == 1) {
                        todo.markAsDone();
                    }
                    lst.addLast(todo);
                    break;
                case "E":
                    Event event = Event.of(desc, arr[3]);
                    if (done == 1) {
                        event.markAsDone();
                    }
                    lst.addLast(event);
                    break;
            }
        }
    }

    public TaskList() {
        lst = new LinkedList<>();
    }

    public int getNumTasks() {
        return lst.size();
    }

    public void addTask(Task task) {
        lst.addLast(task);
    }

    public String deleteTask(int index) {
        return lst.remove(index).toString();
    }

    public String doneTask(int index) {
        Task task = lst.get(index);
        task.markAsDone();
        return task.toString();
    }

    public LinkedList<String> tasksToStringList(boolean isSaveFormat) {
        LinkedList<String> stringLst = new LinkedList<>();
        int i = 1;
        for (Task task : lst) {
            if (isSaveFormat) {
                stringLst.addLast(task.toSaveFormat());
            } else {
                stringLst.addLast(String.format("%d.%s", i, task.toString().trim()));
                ++i;
            }
        }
        return stringLst;
    }
}
