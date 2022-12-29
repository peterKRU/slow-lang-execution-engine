package execution_engine;

import java.util.HashMap;
import java.util.Map;

import vm.AbstractExecutor;
import vm.ConstantValuesTable;
import vm.Disassembler;
import vm.ExecutorChain;
import vm.OutputLogger;
import vm.VM;

public class VM {

	public static int[] mainExecutionBlock;
	public static int[] globalStorage;
	public static int[] stack;

	public static Map<Integer, Integer> localVariablesMap = new HashMap<Integer, Integer>();

	public static int ip;
	public static int fp;
	public static int sp = -1;

	private AbstractExecutor headExecutor;
	private ExecutorChain executorChain;

	public VM(int[] mainExecutionBlock, int entryPoint, int storageSize) {

		VM.ip = entryPoint;

		VM.mainExecutionBlock = mainExecutionBlock;
		VM.globalStorage = new int[ConstantValuesTable.DEFAULT_GLOBAL_STORAGE_SIZE];
		VM.stack = new int[ConstantValuesTable.DEFAULT_STACK_SIZE];

		this.executorChain = new ExecutorChain();
		this.headExecutor = executorChain.getHeadExecutor();
	}

	public void fde() {

		while (ip < mainExecutionBlock.length) {

			int instruction = mainExecutionBlock[ip];
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

}
