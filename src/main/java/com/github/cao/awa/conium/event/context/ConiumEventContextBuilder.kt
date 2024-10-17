package com.github.cao.awa.conium.event.context

import com.github.cao.awa.conium.event.type.ConiumEventArgType
import com.github.cao.awa.conium.parameter.*

object ConiumEventContextBuilder {
    @JvmStatic
    @SuppressWarnings("UNCHECKED_CAST")
    fun <P1> requires(
        arg1: ConiumEventArgType<P1>
    ): ConiumEventContext<ParameterSelective2<Any, P1>> {
        return ConiumEventContext({ identity, args, p ->
            val p1 = args[arg1.key] as P1

            if (p1 == null) {
                false
            } else {
                p.trigger(
                    identity,
                    p1
                )
            }
        }, arg1.key)
    }

    @JvmStatic
    @SuppressWarnings("UNCHECKED_CAST")
    fun <X, P1, P2> requires(
        arg1: ConiumEventArgType<P1>,
        arg2: ConiumEventArgType<P2>
    ): ConiumEventContext<ParameterSelective3<Any, P1, P2>> {
        return ConiumEventContext({ identity, args, p ->
            val p1 = args[arg1.key] as P1
            val p2 = args[arg2.key] as P2

            if (p1 == null || p2 == null) {
                false
            } else {
                p.trigger(
                    identity,
                    p1,
                    p2
                )
            }
        }, arg1.key, arg2.key)
    }

    @JvmStatic
    @SuppressWarnings("UNCHECKED_CAST")
    fun <P1, P2, P3> requires(
        arg1: ConiumEventArgType<P1>,
        arg2: ConiumEventArgType<P2>,
        arg3: ConiumEventArgType<P3>
    ): ConiumEventContext<ParameterSelective4<Any, P1, P2, P3>> {
        return ConiumEventContext({ identity, args, p ->
            val p1 = args[arg1.key] as P1
            val p2 = args[arg2.key] as P2
            val p3 = args[arg3.key] as P3

            if (p1 == null || p2 == null || p3 == null) {
                false
            } else {
                p.trigger(
                    identity,
                    p1,
                    p2,
                    p3
                )
            }
        }, arg1.key, arg2.key, arg3.key)
    }

    @JvmStatic
    @SuppressWarnings("UNCHECKED_CAST")
    fun <P1, P2, P3, P4> requires(
        arg1: ConiumEventArgType<P1>,
        arg2: ConiumEventArgType<P2>,
        arg3: ConiumEventArgType<P3>,
        arg4: ConiumEventArgType<P4>
    ): ConiumEventContext<ParameterSelective5<Any, P1, P2, P3, P4>> {
        return ConiumEventContext({ identity, args, p ->
            val p1 = args[arg1.key] as P1
            val p2 = args[arg2.key] as P2
            val p3 = args[arg3.key] as P3
            val p4 = args[arg4.key] as P4

            if (p1 == null || p2 == null || p3 == null || p4 == null) {
                false
            } else {
                p.trigger(
                    identity,
                    p1,
                    p2,
                    p3,
                    p4
                )
            }
        }, arg1.key, arg2.key, arg3.key, arg4.key)
    }

    @JvmStatic
    @SuppressWarnings("UNCHECKED_CAST")
    fun <P1, P2, P3, P4, P5> requires(
        arg1: ConiumEventArgType<P1>,
        arg2: ConiumEventArgType<P2>,
        arg3: ConiumEventArgType<P3>,
        arg4: ConiumEventArgType<P4>,
        arg5: ConiumEventArgType<P5>
    ): ConiumEventContext<ParameterSelective6<Any, P1, P2, P3, P4, P5>> {
        return ConiumEventContext({ identity, args, p ->
            val p1 = args[arg1.key] as P1
            val p2 = args[arg2.key] as P2
            val p3 = args[arg3.key] as P3
            val p4 = args[arg4.key] as P4
            val p5 = args[arg5.key] as P5

            if (p1 == null || p2 == null || p3 == null || p4 == null || p5 == null) {
                false
            } else {
                p.trigger(
                    identity,
                    p1,
                    p2,
                    p3,
                    p4,
                    p5
                )
            }
        }, arg1.key, arg2.key, arg3.key, arg4.key, arg5.key)
    }

    @JvmStatic
    @SuppressWarnings("UNCHECKED_CAST")
    fun <P1, P2, P3, P4, P5, P6> requires(
        arg1: ConiumEventArgType<P1>,
        arg2: ConiumEventArgType<P2>,
        arg3: ConiumEventArgType<P3>,
        arg4: ConiumEventArgType<P4>,
        arg5: ConiumEventArgType<P5>,
        arg6: ConiumEventArgType<P6>
    ): ConiumEventContext<ParameterSelective7<Any, P1, P2, P3, P4, P5, P6>> {
        return ConiumEventContext({ identity, args, p ->
            val p1 = args[arg1.key] as P1
            val p2 = args[arg2.key] as P2
            val p3 = args[arg3.key] as P3
            val p4 = args[arg4.key] as P4
            val p5 = args[arg5.key] as P5
            val p6 = args[arg6.key] as P6

            if (p1 == null || p2 == null || p3 == null || p4 == null || p5 == null || p6 == null) {
                false
            } else {
                p.trigger(
                    identity,
                    p1,
                    p2,
                    p3,
                    p4,
                    p5,
                    p6
                )
            }
        }, arg1.key, arg2.key, arg3.key, arg4.key, arg5.key, arg6.key)
    }

    @JvmStatic
    @SuppressWarnings("UNCHECKED_CAST")
    fun <P1, P2, P3, P4, P5, P6, P7> requires(
        arg1: ConiumEventArgType<P1>,
        arg2: ConiumEventArgType<P2>,
        arg3: ConiumEventArgType<P3>,
        arg4: ConiumEventArgType<P4>,
        arg5: ConiumEventArgType<P5>,
        arg6: ConiumEventArgType<P6>,
        arg7: ConiumEventArgType<P7>
    ): ConiumEventContext<ParameterSelective8<Any, P1, P2, P3, P4, P5, P6, P7>> {
        return ConiumEventContext({ identity, args, p ->
            val p1 = args[arg1.key] as P1
            val p2 = args[arg2.key] as P2
            val p3 = args[arg3.key] as P3
            val p4 = args[arg4.key] as P4
            val p5 = args[arg5.key] as P5
            val p6 = args[arg6.key] as P6
            val p7 = args[arg7.key] as P7

            if (p1 == null || p2 == null || p3 == null || p4 == null || p5 == null || p6 == null || p7 == null) {
                false
            } else {
                p.trigger(
                    identity,
                    p1,
                    p2,
                    p3,
                    p4,
                    p5,
                    p6,
                    p7
                )
            }
        }, arg1.key, arg2.key, arg3.key, arg4.key, arg5.key, arg6.key, arg7.key)
    }
}
