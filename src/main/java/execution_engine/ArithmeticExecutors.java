package execution_engine;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticExecutors implements ExecutorGroup {

	private class IADD extends AbstractExecutor {

		private static final int opcode = Bytecodes.IADD;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

				int secondOperand = ChainedVM.pop();
				int firstOperand = ChainedVM.pop();
				ChainedVM.push(firstOperand + secondOperand);

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

	private class ISUB extends AbstractExecutor {

		private static final int opcode = Bytecodes.ISUB;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

				int secondOperand = ChainedVM.pop();
				int firstOperand = ChainedVM.pop();
				ChainedVM.push(firstOperand - secondOperand);

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

	private class IMUL extends AbstractExecutor {

		private static final int opcode = Bytecodes.IMUL;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

				int firstOperand = ChainedVM.pop();
				int secondOperand = ChainedVM.pop();
				ChainedVM.push(firstOperand * secondOperand);
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

	private class IDIV extends AbstractExecutor {

		private static final int opcode = Bytecodes.IDIV;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

				int firstOperand = ChainedVM.pop();
				int secondOperand = ChainedVM.pop();

				ChainedVM.push(secondOperand / firstOperand);
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
		
		AbstractExecutor iadd = new IADD();
		executors.add(iadd);
		
		AbstractExecutor isub = new ISUB();
		executors.add(isub);
		
		AbstractExecutor imul = new IMUL();
		executors.add(imul);
		
		AbstractExecutor idiv = new IDIV();
		executors.add(idiv);
		
		return executors;
	}

}
