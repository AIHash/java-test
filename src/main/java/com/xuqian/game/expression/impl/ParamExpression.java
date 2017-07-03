package com.xuqian.game.expression.impl;

import com.xuqian.game.expression.Expression;

/**
 * 参数占位符表达式，直接返回参数。
 */
public class ParamExpression implements Expression {

    private static final long serialVersionUID = -1691851142296564067L;

    public long getValue(long key) {
        return key;
    }

}
