package com.nure.lab2.nomer4;

public class CutSeat {
    Visitor visitor;

    public synchronized void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public synchronized Visitor getVisitor() {
        return visitor;
    }
}
