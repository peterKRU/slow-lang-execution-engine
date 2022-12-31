package execution_engine;

public class ExecutorChain {

	private AbstractExecutor headExecutor;
	private AbstractExecutor tailExecutor;
	private AbstractExecutor lastRegisteredExecutor;

	public ExecutorChain() {

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

				int firstOperand = VM.pop();
				int secondOperand = VM.pop();
				VM.push(firstOperand + secondOperand);
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				int firstOperand = VM.pop();
				int secondOperand = VM.pop();
				VM.push(firstOperand * secondOperand);
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

				int firstOperand = VM.pop();
				int secondOperand = VM.pop();

				VM.push(secondOperand / firstOperand);
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				VM.stack[++VM.sp] = VM.mainExecutionBlock[VM.ip++];
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

				int value = VM.localVariablesMap.get(VM.mainExecutionBlock[VM.ip]);
				VM.push(value);
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				VM.push(VM.mainExecutionBlock[VM.ip]);
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				int value = VM.pop();
				VM.localVariablesMap.put(VM.pop(), value);
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

				if (!VM.localVariablesMap.containsKey(VM.mainExecutionBlock[VM.ip])) {
					VM.localVariablesMap.put(VM.mainExecutionBlock[VM.ip], null);
					VM.push(VM.mainExecutionBlock[VM.ip]);
				} else {
					int value = VM.localVariablesMap.get(VM.mainExecutionBlock[VM.ip]);
					VM.push(value);
				}
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				System.out.println("Process terminated.");
				return;
			} else {

				System.out.println("Unknown instruction");
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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

				System.out.println("NOT IMPLEMENTED " + opcode);
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
