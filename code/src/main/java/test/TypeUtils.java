package test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TypeUtils {

    public static Type getParameterizedType(final Class raw, final Class...classes) {
        return new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                List<Type> typeList = new ArrayList<>();
                Collections.addAll(typeList, classes);
                return typeList.toArray(new Type[typeList.size()]);
            }

            @Override
            public Type getRawType() {
                return raw;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }
}
