package com.xuqian.game.expression.impl;


/**
 * 乘法操作。
 */
public class MultipleExpression extends BinaryOperationExpression {

    private static final long serialVersionUID = -5663414391707378304L;

    public long getValue(long key) {
        return left.getValue(key) * right.getValue(key);
    }

    @Override
    public int getPriority() {
        return 2;
    }

}
