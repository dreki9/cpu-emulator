import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Hüseyin Emre ÜĞDÜL
 * @since 24.05.2022
 */
public class Midterm_20190808029 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> instructions = getInstructions(args[0]);
        int AC = 0;
        int[] M = new int[256];
        int F = 0;
        boolean isStart = false;
        for (int pc = 0; pc < instructions.size(); pc++) {
            String instruction = instructions.get(pc);
            int instructionNum = 0;
            if (instructions.get(pc).contains(" ")) {
                instruction = instructions.get(pc).substring(0,
                        instructions.get(pc).indexOf(" "));
                instructionNum = Integer.parseInt(instructions.get(pc)
                        .substring(instructions.get(pc).indexOf(" ") + 1));
            }
            if (isStart || instruction.equals("START"))
                switch (instruction) {
                    case "START":
                        isStart = true;
                        break;
                    case "LOAD":
                        AC = instructionNum;
                        break;
                    case "LOADM":
                        AC = M[instructionNum];
                        break;
                    case "STORE":
                        M[instructionNum] = AC;
                        break;
                    case "JMP":
                        pc = instructionNum - 1;
                        break;
                    case "CMPM":
                        F = Integer.compare(AC, M[instructionNum]);
                        break;
                    case "CJMP":
                        if (F > 0) pc = instructionNum - 1;
                        break;
                    case "ADD":
                        AC = AC + instructionNum;
                        break;
                    case "ADDM":
                        AC = AC + M[instructionNum];
                        break;
                    case "SUB":
                        AC -= instructionNum;
                        break;
                    case "SUBM":
                        AC -= M[instructionNum];
                        break;
                    case "MUL":
                        AC *= instructionNum;
                        break;
                    case "MULM":
                        AC *= M[instructionNum];
                        break;
                    case "DISP":
                        System.out.println(AC);
                        break;
                    case "HALT":
                        isStart = false;
                        break;
                }
        }
    }

    public static ArrayList<String> getInstructions(String text) throws FileNotFoundException {
        ArrayList<String> instructions = new ArrayList<>();
        File file = new File(text);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine().trim();
            str = str.substring(str.indexOf(" ") + 1);
            if (!str.equals("")) {
                instructions.add(str);
            }
        }
        return instructions;
    }
}
