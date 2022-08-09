import java.io.*;
import java.util.*;

public class Main {
	int memory[] = new int[1000];
	int register[] = new int[32];
	String path;

	public Main(String path) {
		this.path = path;
		initializeEmpty(memory);
		initializeEmpty(register);
	}

	public void initializeEmpty(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = -100;
		}
	}

	public void printNonEmpty(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != -100)
				System.out.println("At index " + i + " Value: " + array[i]);
		}
	}

	public int getRegisterIndex(String registerName) {
		int result = 0;

		if (registerName == "$zero")
			return 0;
		if (registerName == "$at")
			return 1;

		if (registerName == "$v0")
			return 2;

		if (registerName == "$v1")
			return 3;

		if (registerName == "$a0")
			return 4;

		if (registerName == "$a1")
			return 5;

		if (registerName == "$a2")
			return 6;

		if (registerName == "$a3")
			return 7;

		if (registerName == "$t0")
			return 8;

		if (registerName == "$t1")
			return 9;

		if (registerName == "$t2")
			return 10;

		if (registerName == "$t3")
			return 11;

		if (registerName == "$t4")
			return 12;

		if (registerName == "$t5")
			return 13;

		if (registerName == "$t6")
			return 14;

		if (registerName == "$t7")
			return 15;

		if (registerName == "$s0")
			return 16;

		if (registerName == "$s1")
			return 17;

		if (registerName == "$s2")
			return 18;

		if (registerName == "$s3")
			return 19;

		if (registerName == "$s4")
			return 20;

		if (registerName == "$s5")
			return 21;

		if (registerName == "$s6")
			return 22;

		if (registerName == "$s7")
			return 23;

		if (registerName == "$t8")
			return 24;

		if (registerName == "$t9")
			return 25;

		return result;
	}

	public void runInstruction(String instruction) {
		String[] parts = instruction.split(" ");
		if (parts[0].equals("ADD")) {
			String[] operands = parts[1].split(",");
			int indexOutput = getRegisterIndex(operands[0]);
			int indexOp1 = getRegisterIndex(operands[1]);
			int indexOp2 = getRegisterIndex(operands[2]);

			register[indexOutput] = register[indexOp1] + register[indexOp2];
			printNonEmpty(register);
			System.out.println("--------Instruction Done---------");
		} else if (parts[0].equals("ADDI")) {

			String[] operands = parts[1].split(",");
			int indexOutput = getRegisterIndex(operands[0]);
			int indexOp1 = getRegisterIndex(operands[1]);
			int immediate = Integer.parseInt(operands[2]);

			register[indexOutput] = register[indexOp1] + immediate;
			printNonEmpty(register);
			System.out.println("--------Instruction Done---------");
		}
	}

	public void runProgram() {
		try {
			File myObj = new File(path);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				runInstruction(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Main run = new Main("program.txt");

		run.runProgram();

	}
}
