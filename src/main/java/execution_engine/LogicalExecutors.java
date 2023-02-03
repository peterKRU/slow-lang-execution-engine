package execution_engine;

import java.util.ArrayList;
import java.util.List;

public class LogicalExecutors implements ExecutorGroup {

	private class OR extends AbstractExecutor {

		private static final int opcode = Bytecodes.OR;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

			} else {
				callNext(instruction);
			}
		}

		@Override
		public void callNext(int instruction) {

			nextExecutor.execute(instruction);
		}

		@Override
		public void setNext(AbstractExecutor executor) {

			nextExecutor = executor;
		}
	}

	private class AND extends AbstractExecutor {

		private static final int opcode = Bytecodes.AND;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

			} else {
				callNext(instruction);
			}
		}

		@Override
		public void callNext(int instruction) {

			nextExecutor.execute(instruction);
		}

		@Override
		public void setNext(AbstractExecutor executor) {

			nextExecutor = executor;
		}
	}

	private class NOT extends AbstractExecutor {

		private static final int opcode = Bytecodes.NOT;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

			} else {
				callNext(instruction);
			}
		}

		@Override
		public void callNext(int instruction) {

			nextExecutor.execute(instruction);
		}

		@Override
		public void setNext(AbstractExecutor executor) {

			nextExecutor = executor;
		}
	}

	@Override
	public List<AbstractExecutor> getExecutors() {

		List<AbstractExecutor> executors = new ArrayList<AbstractExecutor>();

		AbstractExecutor or = new OR();
		executors.add(or);

		AbstractExecutor and = new AND();
		executors.add(and);

		AbstractExecutor not = new NOT();
		executors.add(not);

		return executors;
	}

}
