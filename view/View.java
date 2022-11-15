package view;

import controller.exestack.ExeStack;
import controller.exestack.MyDeque;
import controller.progstate.ProgramState;
import controller.symtable.SymTable;
import exceptions.DivisionByZero;
import exceptions.StmtException;
import exceptions.SymbolException;
import exceptions.TypeException;
import model.symbol.ISymbol;

public class View implements IView {

    private ProgramState progState;

    public View(String program) {
        this.progState = new ProgramState(new String(program));
    }

    @Override
    public void displayProgState() {
        SymTable<String, ISymbol> table = this.progState.getTable();
        ExeStack stack = this.progState.getStack();
        MyDeque<String> output = this.progState.getOutput();

        String tableStr = table.toString();
        String stackStr = stack.toString();
        String outputStr = "";
        if (output.size() == 0) {
            outputStr = "";
        } else
            for (String s : output) {
                outputStr += s + "| ";
            }
        System.out.println("Table: " + tableStr);
        System.out.println("Stack: " + stackStr);
        System.out.println("Output: " + outputStr);
        System.out.println("\n");
    }

    @Override
    public void execute() {
        try {
            while (true) {
                this.progState.nextStep();
                this.displayProgState();
            }
        } catch (SymbolException s) {
            System.out.println(s.getMessage());
        } catch (TypeException t) {
            System.out.println(t.getMessage());
        } catch (DivisionByZero d) {
            System.out.println(d.getMessage());
        } catch (StmtException st) {
            System.out.println(st.getMessage());
        }
    }

}