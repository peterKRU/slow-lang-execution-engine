package execution_engine;

import java.util.ArrayList;
import java.util.List;

public class SpecialExecutors implements ExecutorGroup {

	private class PRINT extends AbstractExecutor {

		private static final int opcode = Bytecodes.PRINT;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

				Integer integerValue = ChainedVM.pop();
				String stringValue = integerValue.toString();
				System.out.println(stringValue);
				ChainedVM.logger.log(stringValue);

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

	private class HALT extends AbstractExecutor {

		private static final int opcode = Bytecodes.HALT;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

				ChainedVM.ip = ChainedVM.instructions.length;

				return;

			} else {

				return;
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

	private class CALL extends AbstractExecutor {

		private static final int opcode = Bytecodes.CALL;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

				int funcId = ChainedVM.instructions[ChainedVM.ip++];
				int funcAddr = ChainedVM.getMethodAddress(funcId);
				int numArgs = ChainedVM.instructions[++funcAddr];

				for (int i = 0; i < numArgs; i++) {

					int variableId = ChainedVM.instructions[++funcAddr];

					ChainedVM.localVariablesTable.put(variableId, ChainedVM.nextAvailableIndex++);

					int value = ChainedVM.pop();
					int storageIndex = ChainedVM.localVariablesTable.get(variableId);
					ChainedVM.localStorage[storageIndex] = value;
				}

				ChainedVM.push(ChainedVM.fp);
				ChainedVM.push(ChainedVM.ip);
				ChainedVM.fp = ChainedVM.sp;
				ChainedVM.ip = funcAddr;

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

	private class RET extends AbstractExecutor {

		private static final int opcode = Bytecodes.RET;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

				int returnValue = ChainedVM.pop();
				ChainedVM.sp = ChainedVM.fp;

				ChainedVM.ip = ChainedVM.pop();
				ChainedVM.fp = ChainedVM.pop();

				ChainedVM.push(returnValue);

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

	private class BR extends AbstractExecutor {

		private static final int opcode = Bytecodes.BR;
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

	private class BRT extends AbstractExecutor {

		private static final int opcode = Bytecodes.BRT;
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

	private class BRF extends AbstractExecutor {

		private static final int opcode = Bytecodes.BRF;
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

		// PRINT CALL RET BR BRT BRF HALT

		AbstractExecutor print = new PRINT();
		executors.add(print);

		AbstractExecutor call = new CALL();
		executors.add(call);

		AbstractExecutor ret = new RET();
		executors.add(ret);

		AbstractExecutor br = new BR();
		executors.add(br);

		AbstractExecutor brt = new BRT();
		executors.add(brt);

		AbstractExecutor brf = new BRF();
		executors.add(brf);

		AbstractExecutor halt = new HALT();
		executors.add(halt);

		return executors;
	}

}
