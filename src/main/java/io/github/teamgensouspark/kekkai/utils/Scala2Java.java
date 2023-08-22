package io.github.teamgensouspark.kekkai.utils;

import java.util.List;

import scala.collection.JavaConverters;
import scala.collection.Seq;

public class Scala2Java {
    public static <T> List<T> Seq2List(Seq<T> seq) {
        return JavaConverters.seqAsJavaListConverter(seq).asJava();
    }

    public static <T> Seq<T> List2Seq(List<T> list) {
        return JavaConverters.asScalaIteratorConverter(list.iterator()).asScala().toSeq();
    }
}
