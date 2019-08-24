package com.java.study.javastudy.javaparser;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.GenericListVisitorAdapter;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import org.checkerframework.checker.units.qual.A;

import java.util.List;

/**
 * @program: java-study
 * @description: 访问器
 * @author: Mr.Xu
 * @create: 2019/7/30 21:46
 */
public class MyVisitor<R> extends VoidVisitorAdapter<R> {

    @Override
    public void visit(FieldDeclaration n, R arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(MethodDeclaration n, R arg) {
        super.visit(n, arg);
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, R arg) {
        super.visit(n, arg);
    }


}
