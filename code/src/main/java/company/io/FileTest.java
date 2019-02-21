package company.io;

import com.sun.imageio.plugins.common.ImageUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

public class FileTest {

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("/Users/didi");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){  //遍历一个文件夹：
            for(Path e : stream){
                System.out.println(e.getFileName());
            }
        }catch(IOException e){

        }

        List<Path> result = new LinkedList<Path>();
        Files.walkFileTree(dir, new FindJavaVisitor(result));
        System.out.println("result.size()=" + result.size());
    }

    private static class FindJavaVisitor extends SimpleFileVisitor<Path>{
        private List<Path> result;
        public FindJavaVisitor(List<Path> result){
            this.result = result;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
            if(file.toString().endsWith(".txt")){
                result.add(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
