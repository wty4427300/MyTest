package com.ftest.mysql;

import com.ftest.mysql.command.PrepareResult;
import com.ftest.mysql.command.Statement;
import com.ftest.mysql.command.StatementType;

import java.util.Scanner;

public class SimpleREPL {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            boolean result = doMateCommand(command);
            if (result){
                break;
            }else {
                Statement statement=new Statement();

            }
        }
    }

    //sql识别
    public static PrepareResult prepareStatement(String command,Statement statement){
        if (command.equals("insert")){
            statement.setType(StatementType.STATEMENT_INSERT);
            return PrepareResult.PREPARE_SUCCESS;
        }
        if(command.equals("select")){
            statement.setType(StatementType.STATEMENT_SELECT);
            return PrepareResult.PREPARE_SUCCESS;
        }
        return  PrepareResult.PREPARE_UNRECOGNIZED_STATEMENT;
    }

    //
    public static boolean doMateCommand(String command){
        if (command.equals(".exit")){
            return true;
        }else {
            return false;
        }
    }
}
