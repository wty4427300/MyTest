package com.concurrent.mysql.command;

public class Statement {
    StatementType type;

    public StatementType getType() {
        return type;
    }

    public void setType(StatementType type) {
        this.type = type;
    }
}
