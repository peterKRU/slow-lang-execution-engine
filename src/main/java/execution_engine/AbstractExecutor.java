package execution_engine;

public abstract class AbstractExecutor {
	
	public abstract boolean checkInstruction(int instruction);

	public abstract void execute(int instruction);

	public abstract void callNext(int instruction);

	public abstract void setNext(AbstractExecutor executor);
}
