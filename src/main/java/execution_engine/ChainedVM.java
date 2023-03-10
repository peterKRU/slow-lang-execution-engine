package execution_engine;

import java.util.HashMap;
import java.util.Map;

public class ChainedVM implements InstructionsLoader, ObjectCache {

	public static int[] instructions;
	public static int[] stack;

	public static Map<Integer, Integer> localVariablesTable;
	public static Map<Integer, Integer> globalVariablesTable;

	public static int[] localStorage;
	public static int nextAvailableIndex = 0;

	public static int ip;
	public static int fp;
	public static int sp = -1;

	private AbstractExecutor headExecutor;
	private ExecutorChain executorChain;

	public static Logger logger;

	private static MemoryManager memoryManager;

	public ChainedVM(MemoryManager memoryManager) {

		ChainedVM.memoryManager = memoryManager;

		ChainedVM.ip = 0;
		ChainedVM.instructions = memoryManager.loadInstructions();
		ChainedVM.stack = new int[ConstantsTable.DEFAULT_STACK_SIZE];
		ChainedVM.localStorage = new int[ConstantsTable.DEFAULT_LOCAL_STORAGE_SIZE];

		ChainedVM.localVariablesTable = new HashMap<Integer, Integer>();
		ChainedVM.globalVariablesTable = new HashMap<Integer, Integer>();

		this.executorChain = new ExecutorChain();
		this.headExecutor = executorChain.getHeadExecutor();

		ChainedVM.logger = new Logger();
	}

	public void executeProgram() {

		while (ip < instructions.length) {

			int instruction = instructions[ip];
			ip++;

			headExecutor.execute(instruction);
		}
	}

	public static void push(int value) {

		stack[++sp] = value;
	}

	public static int pop() {

		return stack[sp--];
	}

	public static int top() {

		return stack[sp];
	}

	public static int getMethodAddress(int methodId) {

		return memoryManager.fetchMethodAddress(methodId);
	}

	@Override
	public int[] loadInstructions() {

		return memoryManager.loadInstructions();
	}

	@Override
	public void store(int[] object) {

		System.out.println("Not implemented.");
	}

	@Override
	public int[] fetch(int objectId) {

		System.out.println("Not implemented.");

		return null;
	}

}
