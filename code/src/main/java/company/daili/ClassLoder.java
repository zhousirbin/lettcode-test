package company.daili;

import java.io.File;
import java.util.StringTokenizer;

public class ClassLoder {

    public static void main(String[] args){

        for (File file:
                getExtDirs()) {
            System.out.println(file);
        }
    }

    private static File[] getExtDirs() {
        //加载<JAVA_HOME>/lib/ext目录中的类库
        String s = System.getProperty("java.ext.dirs");
        System.out.println(s);
        File[] dirs;
        if (s != null) {
            StringTokenizer st =
                    new StringTokenizer(s, File.pathSeparator);
            int count = st.countTokens();
            dirs = new File[count];
            for (int i = 0; i < count; i++) {
                dirs[i] = new File(st.nextToken());
            }
        } else {
            dirs = new File[0];
        }
        return dirs;
    }

}
