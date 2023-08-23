package io.github.teamgensouspark.kekkai.utils;

import java.util.List;
import java.util.Optional;

import net.katsstuff.teamnightclipse.danmakucore.javastuff.DanCoreJavaHelper;
import scala.Option;
import scala.Some;
import scala.collection.JavaConverters;
import scala.collection.Seq;

public class ScalaJ {
    public static <T> List<T> Seq2List(Seq<T> seq) {
        return JavaConverters.seqAsJavaListConverter(seq).asJava();
    }

    public static <T> Seq<T> List2Seq(List<T> list) {
        return DanCoreJavaHelper.seq(list);
    }

    public static <T> Optional<T> asOptional(Option<T> option) {
        return DanCoreJavaHelper.optional(option);
    }

    public static <T> Option<T> none() {
        return DanCoreJavaHelper.none();
    }

    public static <T> Some<T> some(T obj) {
        return DanCoreJavaHelper.some(obj);
    }

    public static <T> Option<T> option(T obj) {
        return DanCoreJavaHelper.option(obj);
    }

    public static <T> T unwrap(Option<T> option, T defval) {
        if (option.isEmpty()) {
            return defval;
        } else {
            return option.get();
        }
    }
}
