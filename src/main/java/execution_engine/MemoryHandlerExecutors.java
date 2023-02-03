package execution_engine;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandlerExecutors implements ExecutorGroup {

	private class ICONST extends AbstractExecutor {

		private static final int opcode = Bytecodes.ICONST;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

				int value = ChainedVM.instructions[ChainedVM.ip++];
				ChainedVM.push(value);

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

	private class LLOAD extends AbstractExecutor {

		private static final int opcode = Bytecodes.LLOAD;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

				int value = ChainedVM.localVariablesTable.get(ChainedVM.instructions[ChainedVM.ip]);
				ChainedVM.push(value);
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

	private class GLOAD extends AbstractExecutor {

		private static final int opcode = Bytecodes.GLOAD;
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

	private class LSTORE extends AbstractExecutor {

		private static final int opcode = Bytecodes.LSTORE;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

				ChainedVM.push(ChainedVM.instructions[ChainedVM.ip]);
				return;
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

	private class GSTORE extends AbstractExecutor {

		private static final int opcode = Bytecodes.GSTORE;
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

	private class ASS extends AbstractExecutor {

		private static final int opcode = Bytecodes.ASS;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

				int value = ChainedVM.pop();
				int storageIndex = ChainedVM.pop();
				ChainedVM.localStorage[storageIndex] = value;

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

	private class LREF extends AbstractExecutor {

		private static final int opcode = Bytecodes.LREF;
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

	private class GREF extends AbstractExecutor {

		private static final int opcode = Bytecodes.GREF;
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

	private class VSTORE extends AbstractExecutor {

		private static final int opcode = Bytecodes.VSTORE;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

				int variableId = ChainedVM.instructions[ChainedVM.ip++];

				if (!ChainedVM.localVariablesTable.containsKey(variableId)) {
					ChainedVM.localVariablesTable.put(variableId, ChainedVM.nextAvailableIndex++);
				}

				ChainedVM.push(ChainedVM.localVariablesTable.get(variableId));

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

	private class VLOAD extends AbstractExecutor {

		private static final int opcode = Bytecodes.VLOAD;
		private static AbstractExecutor nextExecutor;

		@Override
		public boolean checkInstruction(int instruction) {

			return opcode == instruction;
		}

		@Override
		public void execute(int instruction) {

			if (checkInstruction(instruction)) {

				int variableId = ChainedVM.instructions[ChainedVM.ip++];
				int index = ChainedVM.localVariablesTable.get(variableId);
				ChainedVM.push(ChainedVM.localStorage[index]);

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

		AbstractExecutor iconst = new ICONST();
		executors.add(iconst);

		AbstractExecutor lload = new LLOAD();
		executors.add(lload);

		AbstractExecutor gload = new GLOAD();
		executors.add(gload);

		AbstractExecutor lstore = new LSTORE();
		executors.add(lstore);

		AbstractExecutor gstore = new GSTORE();
		executors.add(gstore);

		AbstractExecutor ass = new ASS();
		executors.add(ass);

		AbstractExecutor lref = new LREF();
		executors.add(lref);

		AbstractExecutor gref = new GREF();
		executors.add(gref);

		AbstractExecutor vstore = new VSTORE();
		executors.add(vstore);

		AbstractExecutor vload = new VLOAD();
		executors.add(vload);

		return executors;
	}

}
