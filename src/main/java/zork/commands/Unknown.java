package zork.commands;


public class Unknown extends Command {

	@Override
	public String execute() {
		return "That is not a verb I recognize.";
	}

}
