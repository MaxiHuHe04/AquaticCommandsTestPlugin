package me.maxih.aquaticcommandstestplugin;

import scala.collection.JavaConverters;
import scala.collection.Seq;

import java.util.Arrays;

class ScalaUtil {

    @SafeVarargs
    static <T> Seq<T> varargs(T... args) {
        return JavaConverters.asScalaBuffer(Arrays.asList(args)).toSeq();
    }

}
