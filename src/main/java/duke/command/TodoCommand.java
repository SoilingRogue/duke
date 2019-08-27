package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Todo;

public class TodoCommand extends AddCommand {
    public TodoCommand(String desc) {
        super(desc);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        Todo todoTask = Todo.of(getDesc());
        taskList.addTask(todoTask);
//        storage.store(todoTask);
        ui.showAddedTask(todoTask.toString(), taskList.getNumTasks());
    }
}