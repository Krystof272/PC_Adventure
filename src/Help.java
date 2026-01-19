import Commands.Command;

public class Help implements Command {
    @Override
    public String execute() {
        return Console.getCommands();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
