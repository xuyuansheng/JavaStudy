package com.java.study.javastudy.javaparser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.GenericVisitor;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-study
 * @description: 测试类
 * @author: Mr.Xu
 * @create: 2019/7/30 21:38
 */
public class TestParser {

    @Test
    public void test() throws FileNotFoundException {
        File file = new File("D:\\JavaWorkSpace\\JavaStudy\\src\\main\\java\\com\\java\\study\\javastudy\\javaparser\\TestParserClass.java");


        CompilationUnit compilationUnit = JavaParser.parse(file);

        List<MethodDeclaration> list = new ArrayList<>(16);
        MyVisitor mv = new MyVisitor();
//        compilationUnit.accept(mv, null);
        mv.visit(compilationUnit,null);
    }

}
