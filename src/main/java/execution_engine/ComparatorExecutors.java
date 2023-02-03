package execution_engine;

import java.util.ArrayList;
import java.util.List;

import execution_engine.ArithmeticExecutors.IADD;
import execution_engine.ArithmeticExecutors.IDIV;
import execution_engine.ArithmeticExecutors.IMUL;
import execution_engine.ArithmeticExecutors.ISUB;

public class ComparatorExecutors implements ExecutorGroup {

	private class IEQ extends AbstractExecutor {

		private static final int opcode = Bytecodes.IEQ;
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

	private class ILT extends AbstractExecutor {

		private static final int opcode = Bytecodes.ILT;
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

	private class IGT extends AbstractExecutor {

		private static final int opcode = Bytecodes.IGT;
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

		AbstractExecutor ieq = new IEQ();
		executors.add(ieq);

		AbstractExecutor ilt = new ILT();
		executors.add(ilt);

		AbstractExecutor igt = new IGT();
		executors.add(igt);
		
		return executors;
	}

}
