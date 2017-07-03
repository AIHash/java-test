package com.xuqian.game.expression.impl;

import com.xuqian.game.expression.Expression;

/**
 * 加法操作。
 */
public class AddExpression extends BinaryOperationExpression {

    private static final long serialVersionUID = -5375067912237316734L;

    public AddExpression() {}

    public AddExpression(Expression left) {
        this.left = left;
    }

    public long getValue(long key) {
        return left.getValue(key) + right.getValue(key);
    }

    @Override
    public int getPriority() {
        return 1;
    }

}
