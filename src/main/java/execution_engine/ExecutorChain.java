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
		
		List<AbstractExecutor> arithmeticGroup = new ArithmeticExecutors().getExecutors();
		executorGroups.add(arithmeticGroup);
		
		AbstractExecutor iadd = new IADD();
		AbstractExecutor halt = new HALT();

		assembleChain(iadd, halt);
	}

	private void assembleChain(AbstractExecutor headExecutor, AbstractExecutor tailExecutor) {

		this.headExecutor = headExecutor;
		this.tailExecutor = tailExecutor;
		this.lastRegisteredExecutor = headExecutor;

		AbstractExecutor isub = new ISUB();
		registerExecutor(isub);

		AbstractExecutor imul = new IMUL();
		registerExecutor(imul);

		AbstractExecutor idiv = new IDIV();
		registerExecutor(idiv);

		AbstractExecutor or = new OR();
		registerExecutor(or);

		AbstractExecutor and = new AND();
		registerExecutor(and);

		AbstractExecutor not = new NOT();
		registerExecutor(not);

		AbstractExecutor ieq = new IEQ();
		registerExecutor(ieq);

		AbstractExecutor ilt = new ILT();
		registerExecutor(ilt);

		AbstractExecutor igt = new IGT();
		registerExecutor(igt);

		AbstractExecutor br = new BR();
		registerExecutor(br);

		AbstractExecutor brt = new BRT();
		registerExecutor(brt);

		AbstractExecutor brf = new BRF();
		registerExecutor(brf);

		AbstractExecutor iconst = new ICONST();
		registerExecutor(iconst);

		AbstractExecutor lload = new LLOAD();
		registerExecutor(lload);

		AbstractExecutor gload = new GLOAD();
		registerExecutor(gload);

		AbstractExecutor lstore = new LSTORE();
		registerExecutor(lstore);

		AbstractExecutor gstore = new GSTORE();
		registerExecutor(gstore);

		AbstractExecutor vstore = new VSTORE();
		registerExecutor(vstore);

		AbstractExecutor vload = new VLOAD();
		registerExecutor(vload);

		AbstractExecutor ass = new ASS();
		registerExecutor(ass);

		AbstractExecutor lref = new LREF();
		registerExecutor(lref);

		AbstractExecutor gref = new GREF();
		registerExecutor(gref);

		AbstractExecutor print = new PRINT();
		registerExecutor(print);

		AbstractExecutor call = new CALL();
		registerExecutor(call);

		AbstractExecutor ret = new RET();
		registerExecutor(ret);

	}

	public AbstractExecutor getHeadExecutor() {

		return headExecutor;
	}

	public void registerExecutor(AbstractExecutor newExecutor) {

		lastRegisteredExecutor.setNext(newExecutor);
		newExecutor.setNext(tailExecutor);
		lastRegisteredExecutor = newExecutor;
	}

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
				int numArgs = ChainedVM.instructions[funcAddr++];

				for (int i = 0; i < numArgs; i++) {

					int variableId = ChainedVM.instructions[funcAddr++];

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

}
