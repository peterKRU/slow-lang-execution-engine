package execution_engine;

import java.util.ArrayList;
import java.util.List;

public class ExecutorChain {

	private AbstractExecutor headExecutor;
	private AbstractExecutor tailExecutor;
	private AbstractExecutor lastRegisteredExecutor;
	private List<List<AbstractExecutor>> executorGroups;

	public ExecutorChain() {

		executorGroups = new ArrayList<List<AbstractExecutor>>();

		assembleExecutorGroups(executorGroups);

		AbstractExecutor firstExecutor = executorGroups.get(0).get(0);
		AbstractExecutor lastExecutor = executorGroups.get(executorGroups.size() - 1).get(executorGroups.get(executorGroups.size() - 1).size() - 1);
		
		assembleChain(firstExecutor, lastExecutor);
	}

	private void assembleChain(AbstractExecutor headExecutor, AbstractExecutor tailExecutor) {

		this.headExecutor = headExecutor;
		this.tailExecutor = tailExecutor;
		this.lastRegisteredExecutor = headExecutor;

		executorGroups.get(0).remove(0);
		executorGroups.get(executorGroups.size() - 1).remove(executorGroups.get(executorGroups.size() - 1).size() - 1);
		
		for (List<AbstractExecutor> executorGroup : executorGroups) {

			for (AbstractExecutor executor : executorGroup) {

				registerExecutor(executor);
			}
		}
	}

	private void assembleExecutorGroups(List<List<AbstractExecutor>> executorGroups) {

		List<AbstractExecutor> arithmeticGroup = new ArithmeticExecutors().getExecutors();
		executorGroups.add(arithmeticGroup);

		List<AbstractExecutor> logicalGroup = new LogicalExecutors().getExecutors();
		executorGroups.add(logicalGroup);

		List<AbstractExecutor> comparatorGroup = new ComparatorExecutors().getExecutors();
		executorGroups.add(comparatorGroup);

		List<AbstractExecutor> memoryHandlerGroup = new MemoryHandlerExecutors().getExecutors();
		executorGroups.add(memoryHandlerGroup);

		List<AbstractExecutor> specialGroup = new SpecialExecutors().getExecutors();
		executorGroups.add(specialGroup);
	}

	public AbstractExecutor getHeadExecutor() {

		return headExecutor;
	}

	public void registerExecutor(AbstractExecutor newExecutor) {

		lastRegisteredExecutor.setNext(newExecutor);
		newExecutor.setNext(tailExecutor);
		lastRegisteredExecutor = newExecutor;
	}

}
