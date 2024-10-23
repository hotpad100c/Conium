package com.github.cao.awa.conium.parameter;

@FunctionalInterface
public interface ParameterSelective6<R, P1, P2, P3, P4, P5, P6> extends ParameterSelective {
    R arise(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5, P6 p6);
}